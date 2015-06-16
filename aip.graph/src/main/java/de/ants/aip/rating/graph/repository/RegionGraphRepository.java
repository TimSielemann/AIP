package de.ants.aip.rating.graph.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import de.ants.aip.rating.graph.nodes.RegionNode;

public interface RegionGraphRepository extends GraphRepository<RegionNode>{
	RegionNode findByDbid(Long id);
}
