package de.haw.ants.aip.Fertigungskomponente.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Vorgang {

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false, unique = true)
	private String bezeichnnung;



	public Vorgang() {
	}

	public Vorgang(String bezeichnnung) {
		super();
		this.bezeichnnung = bezeichnnung;
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
