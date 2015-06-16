package de.ants.aip.rating.graph.nodes;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = AuftragsPositionRelation.RELATIONSHIP_TYPE)
public class ProdukteRegionenRelation {
	public static final String RELATIONSHIP_TYPE = "VERKAUFT_IN";
	@GraphId
	private Long id;

	@StartNode
	private RegionNode region;
	@EndNode
	private ProduktNode produkt;

	public ProdukteRegionenRelation(RegionNode region, ProduktNode produkt) {
		this.region = region;
		this.produkt = produkt;
	}

	public RegionNode getRegion() {
		return region;
	}

	public void setRegion(RegionNode region) {
		this.region = region;
	}

	public ProduktNode getProdukt() {
		return produkt;
	}

	public void setProdukt(ProduktNode produkt) {
		this.produkt = produkt;
	}

}
