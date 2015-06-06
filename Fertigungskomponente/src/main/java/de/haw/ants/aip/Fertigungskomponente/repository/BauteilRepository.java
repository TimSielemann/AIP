package de.haw.ants.aip.Fertigungskomponente.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import de.haw.ants.aip.Fertigungskomponente.entity.Bauteil;

public interface BauteilRepository extends
		PagingAndSortingRepository<Bauteil, Long> {

}
