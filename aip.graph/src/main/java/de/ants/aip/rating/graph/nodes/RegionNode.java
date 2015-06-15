package de.ants.aip.rating.graph.nodes;

import org.springframework.data.neo4j.annotation.GraphProperty;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.fieldaccess.DynamicProperties;

@NodeEntity
public class RegionNode extends BaseNode {
	@Indexed
	@GraphProperty
	private String region;

	@Indexed
	private DynamicProperties stadtMap;

	public RegionNode(Long id, String region, String stadt) {
		super(id);
		this.stadtMap.setProperty(stadt, 1);
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setStadt(String stadt) {
		this.stadtMap.setProperty(stadt, 1);
	}

	public DynamicProperties getStadtMap() {
		return stadtMap;
	}
}
