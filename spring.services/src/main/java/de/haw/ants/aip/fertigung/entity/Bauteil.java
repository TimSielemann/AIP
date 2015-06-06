package de.haw.ants.aip.fertigung.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Bauteil {
	
	@Id
	@GeneratedValue
	private long id;
	@Column
	private String name;
	@Column
	private String modellnummer;
	@Column
	private String seriennummer;
	@Column
	private long anzahl;
	
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
}
