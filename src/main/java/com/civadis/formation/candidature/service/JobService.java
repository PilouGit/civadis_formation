package com.civadis.formation.candidature.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.civadis.formation.candidature.model.Job;
import com.civadis.formation.candidature.repository.JobRepository;

@Service
public class JobService {

	@Autowired 
	JobRepository jobRepository;
	public Job createJob(Job job) {
		return jobRepository.save(job);
	}
	@Transactional(readOnly=true)
	public Optional<Job> findById(Long id) {
		return jobRepository.findById(id);
	}
	

}
