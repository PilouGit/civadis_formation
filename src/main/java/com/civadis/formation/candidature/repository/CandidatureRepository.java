package com.civadis.formation.candidature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.civadis.formation.candidature.model.Candidature;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, Long> {

	@Query("SELECT cv IS NOT NULL FROM Candidature f WHERE id = :id")
	public boolean hasCv(Long id);
	@Query("SELECT motivation IS NOT NULL FROM Candidature f WHERE id = :id")
	public boolean hasMotivation(Long id);
}
