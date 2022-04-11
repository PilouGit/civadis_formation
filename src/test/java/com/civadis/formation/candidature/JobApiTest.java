package com.civadis.formation.candidature;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.civadis.formation.candidature.controlleur.JobControlleur;
import com.civadis.formation.candidature.model.Job;
import com.civadis.formation.candidature.model.Status;
import com.civadis.formation.candidature.repository.JobRepository;

@SpringBootTest
public class JobApiTest {

	@Autowired 
	JobControlleur jobControlleur;
	@Autowired 
	JobRepository jobRepository;
	@Test
	public void createJob()
	{
		Job job=new Job();
		job.setTitreOffre("Mon titre");
		job.setStatus(Status.ELABORATION);
		jobControlleur.createJob(job);
	}
	@Test
	public void readJob()
	{
		System.err.println(this.jobRepository.getById(1L));
		
	}
	
}
