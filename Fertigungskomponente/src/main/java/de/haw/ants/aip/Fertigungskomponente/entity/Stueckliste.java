package de.haw.ants.aip.Fertigungskomponente.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


public class Stueckliste {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private StuecklistePosition pos;
	@OneToOne
	private Bauteil bauteil;

	public Stueckliste() {
	}

	public Stueckliste(StuecklistePosition pos, Bauteil bauteil) {
		super();
		this.pos = pos;
		this.bauteil = bauteil;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StuecklistePosition getPos() {
		return pos;
	}

	public void setPos(StuecklistePosition pos) {
		this.pos = pos;
	}

	public Bauteil getBauteil() {
		return bauteil;
	}

	public void setBauteil(Bauteil bauteil) {
		this.bauteil = bauteil;
	}

	public boolean equals(Object other) {
		if (!(other instanceof Stueckliste))
			return false;
		if (id == null)
			throw new RuntimeException("Entity has not been saved.");
		return id.equals(((Stueckliste) other).getId());
	}

	@Override
	public int hashCode() {
		if (id == null)
			throw new RuntimeException("Entity has not been saved.");
		return id.hashCode();
	}
}
