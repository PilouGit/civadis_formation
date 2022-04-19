package com.civadis.formation.candidature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.civadis.formation.candidature.model.Candidature;
import com.civadis.formation.candidature.model.Job;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, Long> {

}
