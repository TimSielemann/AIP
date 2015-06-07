package de.haw.ants.aip.auftrag.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Representation of a user that is allowed to log into the system.
 *
 */
@Entity
public class Auftrag {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, unique = false)
	private Long fertigungsauftrag;

	@Column(nullable = false)
	private Long kunde;
	
	@Column(nullable = false)
	private Long bauteilnr;
	
	@Column
	private Boolean bezahlt = false;
	
	@Column
	private Boolean ausgeliefert = false;
	
	@Column(nullable = false)
	private Double preis;

	public Auftrag(){}
		

	public Auftrag(Long kunde, Double preis, Long bauteilnr) {
		super();
		this.kunde = kunde;
		this.bauteilnr = bauteilnr;
		this.preis = preis;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getFertigungsauftrag() {
		return fertigungsauftrag;
	}


	public void setFertigungsauftrag(Long fertigungsauftrag) {
		this.fertigungsauftrag = fertigungsauftrag;
	}


	public Long getKunde() {
		return kunde;
	}


	public void setKunde(Long kunde) {
		this.kunde = kunde;
	}


	public Boolean getBezahlt() {
		return bezahlt;
	}


	public void setBezahlt(Boolean bezahlt) {
		this.bezahlt = bezahlt;
	}


	public Boolean getAusgeliefert() {
		return ausgeliefert;
	}


	public void setAusgeliefert(Boolean ausgeliefert) {
		this.ausgeliefert = ausgeliefert;
	}


	public Double getPreis() {
		return preis;
	}


	public void setPreis(Double preis) {
		this.preis = preis;
	}


	@Override
	public String toString() {
		return "Auftrag [id=" + id + ", fertigungsauftrag=" + fertigungsauftrag
				+ ", kunde=" + kunde + ", bezahlt=" + bezahlt
				+ ", ausgeliefert=" + ausgeliefert + ", preis=" + preis + "]";
	}

	
	//must not be used in collections before persisting
	@Override
	public int hashCode() {
		return id==null?0: (int)(id&0xffffffff);
	}
	
	@Override
	public boolean equals(Object other) {
		if(!(other instanceof Auftrag)) return false;
		return ((Auftrag)other).id == id;
	}


	public Long getBauteilnr() {
		return bauteilnr;
	}


	public void setBauteilnr(Long bauteilnr) {
		this.bauteilnr = bauteilnr;
	}
}
