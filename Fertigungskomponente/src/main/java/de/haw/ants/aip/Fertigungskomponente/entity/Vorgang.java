package de.haw.ants.aip.Fertigungskomponente.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Vorgang {

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false, unique = true)
	private String bezeichnnung;
	@Column
	Arbeitsplan arbeitsplan;


	public Vorgang() {
	}

	public Vorgang(String bezeichnnung, Arbeitsplan arbeitsplan) {
		super();
		this.bezeichnnung = bezeichnnung;
		this.arbeitsplan = arbeitsplan;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBezeichnnung() {
		return bezeichnnung;
	}

	public void setBezeichnnung(String bezeichnnung) {
		this.bezeichnnung = bezeichnnung;
	}

	public Arbeitsplan getArbeitsplan() {
		return arbeitsplan;
	}

	public void setArbeitsplan(Arbeitsplan arbeitsplan) {
		this.arbeitsplan = arbeitsplan;
	}

	public boolean equals(Object other) {
		if (!(other instanceof Vorgang))
			return false;
		if (id == null)
			throw new RuntimeException("Entity has not been saved.");
		return id.equals(((Vorgang) other).getId());
	}

	@Override
	public int hashCode() {
		if (id == null)
			throw new RuntimeException("Entity has not been saved.");
		return id.hashCode();
	}
}
