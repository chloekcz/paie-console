package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.domain.Cotisation;

public interface CotisationRepository extends JpaRepository<Cotisation, Integer>{
	
}
