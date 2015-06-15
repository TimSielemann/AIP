package de.ants.aip.rating.graph.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import de.ants.aip.rating.graph.nodes.ProduktNode;

public interface ProduktGraphRepository extends GraphRepository<ProduktNode> {

	ProduktNode findByDbid(Long id);

}