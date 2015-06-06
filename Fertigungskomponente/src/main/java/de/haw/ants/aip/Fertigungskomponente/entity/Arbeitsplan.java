package de.haw.ants.aip.Fertigungskomponente.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Arbeitsplan {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String name;
	@Column
	private Date startzeit;
	@Column
	private Date endzeit;
	@ManyToOne(fetch = FetchType.EAGER)
	private Vorgang vorgaenge;

	public Arbeitsplan() {
	}

	public Arbeitsplan(String name, Date startzeit, Date endzeit,
			Vorgang vorgaenge) {
		super();
		this.name = name;
		this.startzeit = startzeit;
		this.endzeit = endzeit;
		this.vorgaenge = vorgaenge;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartzeit() {
		return startzeit;
	}

	public void setStartzeit(Date startzeit) {
		this.startzeit = startzeit;
	}

	public Date getEndzeit() {
		return endzeit;
	}

	public void setEndzeit(Date endzeit) {
		this.endzeit = endzeit;
	}

	public Vorgang getVorgaenge() {
		return vorgaenge;
	}

	public void setVorgaenge(Vorgang vorgaenge) {
		this.vorgaenge = vorgaenge;
	}

	public boolean equals(Object other) {
		if (!(other instanceof Arbeitsplan))
			return false;
		if (id == null)
			throw new RuntimeException("Entity has not been saved.");
		return id.equals(((Arbeitsplan) other).getId());
	}

	@Override
	public int hashCode() {
		if (id == null)
			throw new RuntimeException("Entity has not been saved.");
		return id.hashCode();
	}
}
