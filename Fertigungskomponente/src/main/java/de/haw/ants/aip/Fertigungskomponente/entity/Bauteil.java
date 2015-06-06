package de.haw.ants.aip.Fertigungskomponente.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Bauteil {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String name;
	@ManyToOne
	private Fertigungsauftrag fertigungsauftraege;
	@Column
	private String modellnummer;
	@Column
	private String seriennummer;
	@Column
	private long anzahl;
	@OneToMany
	private StuecklistePosition stuecklistePos;

	public Bauteil() {
	}

	public Bauteil(String name, Fertigungsauftrag fertigungsauftraege,
			String modellnummer, String seriennummer, long anzahl,
			StuecklistePosition stuecklistePos) {
		super();
		this.name = name;
		this.fertigungsauftraege = fertigungsauftraege;
		this.modellnummer = modellnummer;
		this.seriennummer = seriennummer;
		this.anzahl = anzahl;
		this.stuecklistePos = stuecklistePos;
	}

	public StuecklistePosition getStuecklistePos() {
		return stuecklistePos;
	}

	public void setStuecklistePos(StuecklistePosition stuecklistePos) {
		this.stuecklistePos = stuecklistePos;
	}

	public Fertigungsauftrag getFertigungsauftraege() {
		return fertigungsauftraege;
	}

	public void setFertigungsauftraege(Fertigungsauftrag fertigungsauftraege) {
		this.fertigungsauftraege = fertigungsauftraege;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModellnummer() {
		return modellnummer;
	}

	public void setModellnummer(String modellnummer) {
		this.modellnummer = modellnummer;
	}

	public String getSeriennummer() {
		return seriennummer;
	}

	public void setSeriennummer(String seriennummer) {
		this.seriennummer = seriennummer;
	}

	public long getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(long anzahl) {
		this.anzahl = anzahl;
	}

	public boolean equals(Object other) {
		if (!(other instanceof Bauteil))
			return false;
		if (id == null)
			throw new RuntimeException("Entity has not been saved.");
		return id.equals(((Bauteil) other).getId());
	}

	@Override
	public int hashCode() {
		if (id == null)
			throw new RuntimeException("Entity has not been saved.");
		return id.hashCode();
	}
}
