package de.haw.ants.aip.Fertigungskomponente.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
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
	@OneToMany(fetch = FetchType.EAGER)
	private List<Vorgang> vorgaenge;

	public Arbeitsplan() {
	}

	public Arbeitsplan(String name, Date startzeit, Date endzeit,
			List<Vorgang> vorgaenge) {
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

	public List<Vorgang> getVorgaenge() {
		return vorgaenge;
	}

	public void setVorgaenge(List<Vorgang> vorgaenge) {
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
