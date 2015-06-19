package de.ants.aip.rating.graph.nodes;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

@RelationshipEntity(type = ProdukteRegionenRelation.RELATIONSHIP_TYPE)
public class ProdukteRegionenRelation {
	public static final String RELATIONSHIP_TYPE = "GEKAUFT_IN";
	@GraphId
	private Long id;

	@StartNode
	private KundeNode kunde;


	@EndNode
	private RegionNode region;

	public ProdukteRegionenRelation(RegionNode region, KundeNode kunde) {
		this.region = region;
		this.kunde = kunde;
	}

	public RegionNode getRegion() {
		return region;
	}

	public void setRegion(RegionNode region) {
		this.region = region;
	}
	
	public KundeNode getKunde() {
		return kunde;
	}

	public void setKunde(KundeNode kunde) {
		this.kunde = kunde;
	}
}
