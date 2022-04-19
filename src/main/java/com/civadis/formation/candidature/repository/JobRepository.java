package com.civadis.formation.candidature.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import com.civadis.formation.candidature.model.Job;
import com.civadis.formation.candidature.model.Status;
@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
	    
	 List<Job> findAllByStatus(Status status, Pageable pageable);

}
