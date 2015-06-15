package de.ants.aip.rating.graph.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import de.ants.aip.rating.graph.nodes.AuftragsPositionRelation;

public interface AuftragsPositionGraphRepository extends GraphRepository<AuftragsPositionRelation> {

//    // TODO: Replace with @Param("name") when Spring Data Neo4j supports names vs. positional arguments
//    List<AuftragsPositionNode> findByLastName(@Param("0") String name);

}