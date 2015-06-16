package de.ants.aip.rating.services;

import de.ants.aip.rating.dto.SalesData;
import de.ants.aip.rating.graph.nodes.KundeNode;
import de.ants.aip.rating.graph.nodes.ProduktNode;
import de.ants.aip.rating.graph.nodes.RegionNode;

public interface RatingService {

	Iterable<? extends SalesData> showProductSalesByCity(String string);

	KundeNode getOrCreateKunde(Long id, String name, String stadt);

	ProduktNode getOrCreateProdukt(Long id, String name);
	
	RegionNode getOrCreateRegion(Long id, String region);

	void addBestellung(KundeNode k, ProduktNode p, int i);
	
	Iterable<? extends ProduktNode> showProductBuyed(String string);

}
