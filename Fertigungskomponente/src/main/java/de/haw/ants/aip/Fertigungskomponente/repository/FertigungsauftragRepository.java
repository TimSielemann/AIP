package de.haw.ants.aip.Fertigungskomponente.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import de.haw.ants.aip.Fertigungskomponente.entity.Fertigungsauftrag;


public interface FertigungsauftragRepository extends 
PagingAndSortingRepository<Fertigungsauftrag, Long> {
	
}
