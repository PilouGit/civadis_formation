package com.civadis.formation.candidature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.civadis.formation.candidature.model.Job;
import com.civadis.formation.candidature.repository.JobRepository;

@Service
public class JobService {

	@Autowired 
	JobRepository jobRepository;
	public Job createJob(Job job) {
		return jobRepository.save(job);
	}

}
