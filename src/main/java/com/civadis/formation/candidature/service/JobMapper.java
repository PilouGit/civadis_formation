package com.civadis.formation.candidature.service;

import org.springframework.stereotype.Service;

import com.civadis.formation.candidature.controlleur.payload.JobDto;
import com.civadis.formation.candidature.model.Job;

@Service
public class JobMapper {

	public JobDto simpleMapping(Job job, JobDto dto)
	{
		if (dto==null) dto=new JobDto();
		
		return dto;
	}
}
