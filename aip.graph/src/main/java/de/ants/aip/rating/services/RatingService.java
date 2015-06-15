package de.ants.aip.rating.services;

import de.ants.aip.rating.dto.SalesData;
import de.ants.aip.rating.graph.nodes.KundeNode;
import de.ants.aip.rating.graph.nodes.ProduktNode;

public interface RatingService {

	Iterable<? extends SalesData> showProductSalesByCity(String string);

	KundeNode getOrCreateKunde(Long id, String name, String stadt);

	ProduktNode getOrCreateProdukt(Long id, String name);

	void addBestellung(KundeNode k, ProduktNode p, int i);

}
