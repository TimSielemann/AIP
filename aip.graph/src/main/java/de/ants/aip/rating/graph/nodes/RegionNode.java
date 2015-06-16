package de.ants.aip.rating.graph.nodes;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphProperty;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;
import org.springframework.data.neo4j.fieldaccess.DynamicProperties;

@NodeEntity
public class RegionNode extends BaseNode {
	@Indexed
	@GraphProperty
	private String region;

	@RelatedToVia(type = KundeRegionenRelation.RELATIONSHIP_TYPE, direction = Direction.INCOMING)
    Set<KundeRegionenRelation> kunden = new HashSet<>();

	public RegionNode(Long id, String region) {
		super(id);
		this.region = region;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	public KundeRegionenRelation addKunde(KundeNode kunde) {
		KundeRegionenRelation r = new KundeRegionenRelation(this, kunde);
		this.kunden.add(r);
		return r;
	} 
}
