package de.haw.ants.aip.kunden.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import de.haw.ants.aip.kunden.entitys.Kunde;

public interface KundenRepository extends PagingAndSortingRepository<Kunde, Long> {

}
