package de.haw.ants.aip.Fertigungskomponente.businesslogic;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import de.haw.ants.aip.Fertigungskomponente.entity.Bauteil;
import de.haw.ants.aip.Fertigungskomponente.entity.Fertigungsauftrag;
import de.haw.ants.aip.Fertigungskomponente.repository.BauteilRepository;
import de.haw.ants.aip.Fertigungskomponente.repository.FertigungsauftragRepository;

public class FertigungBusinessLogic {

	@Autowired
	private FertigungsauftragRepository feRepo;
	@Autowired
	private BauteilRepository btRepo;

	public Fertigungsauftrag erstelleFertigungsauftrag(Long bauteilId,
			Date endtermin) {

		Fertigungsauftrag feAuftrag = new Fertigungsauftrag();
		try {
			feAuftrag.setBauteil(btRepo.findOne(bauteilId));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("##############");
			System.out
					.println("Im bauTeilRepo wurde kein Bauteil unter der ID: "
							+ bauteilId + " gefunden.");
			System.out.println("##############");
		}
		feAuftrag.setEndtermin(endtermin);
		try {
			feRepo.save(feAuftrag);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("##############");
			System.out
					.println("Der Fertigungsauftag konnte nicht abgescpeichert werden.");
			System.out.println("##############");
			return null;
		}
		return feAuftrag;
	}

	public Fertigungsauftrag holeFertigungsauftrag(long fertigungsAuftragId) {
		Fertigungsauftrag feAuft = new Fertigungsauftrag();
		try {
			feAuft = feRepo.findOne(fertigungsAuftragId);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("##############");
			System.out
					.println("Im fertigungsauftragRepo konnte kein Fertigungsauftrag mit der ID: "
							+ fertigungsAuftragId + " gefunden werden.");
			System.out.println("##############");
			return null;
		}
		return feAuft;
	}

	public boolean speichereFertigungauftrag(Fertigungsauftrag fertigungsAuftrag) {
		boolean flag = true;
		try {
			feRepo.save(fertigungsAuftrag);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("##############");
			System.out
					.println("Im fertigungsauftragRepo konnte der Fertigungsauftrag nicht abgespeichert werden");
			System.out.println("##############");
			flag = false;
		}
		return flag;
	}

	public boolean loescheFertigungsauftrag(long fertigungsAuftrag) {
		boolean flag = true;
		try {
			feRepo.delete(fertigungsAuftrag);
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	public boolean speichereBautel(Bauteil b) {
		boolean flag = true;
		try {
			btRepo.save(b);
		}catch(Exception e){ 
			e.printStackTrace();
			System.out.println("#############");
			System.out.println("Das Bauteil konnte nicht gespeichert werden");
			System.out.println("#############");
			flag=false;
		}
	return flag;
	}
}
