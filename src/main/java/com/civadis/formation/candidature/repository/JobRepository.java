package com.civadis.formation.candidature.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.civadis.formation.candidature.model.Job;
public interface JobRepository extends JpaRepository<Job, Long> {

	

}
