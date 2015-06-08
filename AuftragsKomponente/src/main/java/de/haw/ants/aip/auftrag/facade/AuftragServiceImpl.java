package de.haw.ants.aip.auftrag.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import de.haw.ants.aip.auftrag.buisnesslogic.AuftragBusinessLogic;
import de.haw.ants.aip.auftrag.entity.Auftrag;
import de.haw.ants.aip.auftrag.facade.interfaces.IAuftragService;
@Service
public class AuftragServiceImpl implements IAuftragService {
	
	@Autowired
	private AuftragBusinessLogic businessLogic;
	
	@Override
	public Auftrag erstelleAuftrag(Auftrag auftrag) {
		Assert.isNull(auftrag.getFertigungsauftrag());
		Assert.isNull(auftrag.getId());
		Assert.notNull(auftrag.getKunde());
		Assert.notNull(auftrag.getPreis());
		return this.businessLogic.erstelleAuftrag(auftrag);
	}

	@Override
	public Auftrag auftragAusliefern(Long auftragsnr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Auftrag auftragBezahlen(Long auftragsnr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auftrag> getAuftragForKunde(long kundennr) {
		return businessLogic.getAuftragForKunde(kundennr);
	}

}
