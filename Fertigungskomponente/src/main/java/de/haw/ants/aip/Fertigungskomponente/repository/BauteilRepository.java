package de.haw.ants.aip.Fertigungskomponente.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import de.haw.ants.aip.Fertigungskomponente.entity.Bauteil;
@Component
public interface BauteilRepository extends
		PagingAndSortingRepository<Bauteil, Long> {

}
