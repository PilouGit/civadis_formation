package com.civadis.formation.candidature.service;

import org.springframework.stereotype.Service;

import com.civadis.formation.candidature.controlleur.payload.EngagementDto;
import com.civadis.formation.candidature.controlleur.payload.JobDto;
import com.civadis.formation.candidature.controlleur.payload.StatusDto;
import com.civadis.formation.candidature.model.Engagement;
import com.civadis.formation.candidature.model.Job;
import com.civadis.formation.candidature.model.Status;

@Service
public class JobMapper {

	public EngagementDto simpleMapping(Engagement engagement)
	{
		switch (engagement)
		{
		case CDI: return EngagementDto.CDI;
		case CDD: return EngagementDto.CDD;
		case FREELANCE: return EngagementDto.FREELANCE;
		}
		return EngagementDto.CDI;
	}
	public StatusDto simpleMapping(Status engagement)
	{
		switch (engagement)
		{
		case ELABORATION: return StatusDto.ELABORATION;
		case VALIDATION: return StatusDto.VALIDATION;
		case PUBLICATION: return StatusDto.PUBLICATION;
		}
		return StatusDto.ELABORATION;
	}
	public JobDto simpleMapping(Job job, JobDto dto)
	{
		if (dto==null) dto=new JobDto();
		dto.setId(job.getId());
		dto.setTitreOffre(job.getTitreOffre());
		dto.setEngagement(simpleMapping(job.getEngagement()));
		dto.setStatus(simpleMapping(job.getStatus()));
		
		return dto;
	}
}
