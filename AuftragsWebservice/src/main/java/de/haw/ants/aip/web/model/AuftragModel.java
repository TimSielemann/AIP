package de.haw.ants.aip.web.model;

import de.haw.ants.aip.auftrag.entity.Auftrag;

public class AuftragModel {
	
	private long bauteilnr;
	private long kundennr;
	private double preis;
	
	public AuftragModel(long bauteilnr, long kundennr, double preis) {
		super();
		this.bauteilnr = bauteilnr;
		this.kundennr = kundennr;
		this.preis = preis;
	}

	
	
	
	public long getBauteilnr() {
		return bauteilnr;
	}
	public void setBauteilnr(long bauteilnr) {
		this.bauteilnr = bauteilnr;
	}
	public long getKundennr() {
		return kundennr;
	}
	public void setKundennr(long kundennr) {
		this.kundennr = kundennr;
	}
	
	public Auftrag toAuftrag(){
		Auftrag returnAuftrag = new Auftrag(this.kundennr, this.preis, this.bauteilnr);
		return returnAuftrag;
	}




	public double getPreis() {
		return preis;
	}




	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	
}
