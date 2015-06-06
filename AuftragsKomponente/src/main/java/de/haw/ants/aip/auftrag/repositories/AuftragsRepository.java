package de.haw.ants.aip.auftrag.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import de.haw.ants.aip.auftrag.entity.Auftrag;


public interface AuftragsRepository extends PagingAndSortingRepository<Auftrag, Long>{

}
