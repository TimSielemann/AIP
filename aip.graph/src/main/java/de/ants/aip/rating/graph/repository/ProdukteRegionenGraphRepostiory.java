package de.ants.aip.rating.graph.repository;

import org.springframework.data.neo4j.repository.GraphRepository;

import de.ants.aip.rating.graph.nodes.ProdukteRegionenRelation;

public interface ProdukteRegionenGraphRepostiory extends GraphRepository<ProdukteRegionenRelation> {

}
