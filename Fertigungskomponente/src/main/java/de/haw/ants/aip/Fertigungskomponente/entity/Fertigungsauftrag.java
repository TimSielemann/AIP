package de.haw.ants.aip.Fertigungskomponente.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Fertigungsauftrag {
	@Id
	@GeneratedValue
	private Long id;
	@OneToOne
	private Bauteil bauteil;
	@Column
	private Date endtermin;

	public Fertigungsauftrag() {
	}

	public Fertigungsauftrag(Bauteil bauteil) {
		super();
		this.bauteil = bauteil;
	}

	public Long getId() {
		return id;
	}

	public Date getEndtermin() {
		return endtermin;
	}

	public Bauteil getBauteil() {
		return bauteil;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBauteil(Bauteil bauteil) {
		this.bauteil = bauteil;
	}

	public void setEndtermin(Date endtermin) {
		this.endtermin = endtermin;
	}

	public boolean equals(Object other) {
		if (!(other instanceof Fertigungsauftrag))
			return false;
		if (id == null)
			throw new RuntimeException("Entity has not been saved.");
		return id.equals(((Fertigungsauftrag) other).getId());
	}

	@Override
	public int hashCode() {
		if (id == null)
			throw new RuntimeException("Entity has not been saved.");
		return id.hashCode();
	}
}
