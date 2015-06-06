package de.haw.ants.aip.Fertigungskomponente.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class StuecklistePosition {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Stueckliste stueckliste;
	@ManyToOne
	private Bauteil bauteil;
	@Column(nullable = false)
	private Long position;

	public StuecklistePosition() {
	}

	public StuecklistePosition(Stueckliste stueckliste, Bauteil bauteil,
			Long position) {
		super();
		this.stueckliste = stueckliste;
		this.bauteil = bauteil;
		this.position = position;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Stueckliste getStueckliste() {
		return stueckliste;
	}

	public void setStueckliste(Stueckliste stueckliste) {
		this.stueckliste = stueckliste;
	}

	public Bauteil getBauteil() {
		return bauteil;
	}

	public void setBauteil(Bauteil bauteil) {
		this.bauteil = bauteil;
	}

	public Long getPosition() {
		return position;
	}

	public void setPosition(Long position) {
		this.position = position;
	}

	public boolean equals(Object other) {
		if (!(other instanceof StuecklistePosition))
			return false;
		if (id == null)
			throw new RuntimeException("Entity has not been saved.");
		return id.equals(((StuecklistePosition) other).getId());
	}

	@Override
	public int hashCode() {
		if (id == null)
			throw new RuntimeException("Entity has not been saved.");
		return id.hashCode();
	}
}
