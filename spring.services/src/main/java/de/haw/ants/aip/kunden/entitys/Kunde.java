package de.haw.ants.aip.kunden.entitys;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Representation of a user that is allowed to log into the system.
 *
 */
@Entity
public class Kunde {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, unique = true)
	private String vorname;

	@Column(nullable = false)
	private String nachname;

	// Getters and Setters
	public Long getId() {
		return id;
	}


	public String getVorname() {
		return vorname;
	}


	public void setVorname(String vorname) {
		this.vorname = vorname;
	}


	public String getNachname() {
		return nachname;
	}


	public void setNachname(String nachname) {
		this.nachname = nachname;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", vorname=" + vorname + ", nachname="
				+ nachname + "]";
	}
	
	
	//must not be used in collections before persisting
	@Override
	public int hashCode() {
		return id==null?0: (int)(id&0xffffffff);
	}
	
	@Override
	public boolean equals(Object other) {
		if(!(other instanceof Kunde)) return false;
		return ((Kunde)other).id == id;
	}
}
