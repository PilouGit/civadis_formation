package com.civadis.formation.candidature.service;

import org.springframework.stereotype.Service;

import com.civadis.formation.candidature.controlleur.payload.CandidatureDto;
import com.civadis.formation.candidature.controlleur.payload.JobDto;
import com.civadis.formation.candidature.model.Candidature;
import com.civadis.formation.candidature.model.Job;

@Service
public class CandidatMapper {

	public CandidatureDto simpleMapping(Candidature candidature, CandidatureDto dto)
	{
		if (dto==null) dto=new CandidatureDto();
		dto.setId(candidature.getId());
		dto.setNom(candidature.getNom());
		dto.setPrenom(candidature.getPrenom());
		dto.setLinkedin(candidature.getLinkedin());
		dto.setAddress(candidature.getAddress().getAddress());
		dto.setCity(candidature.getAddress().getCity());
		dto.setCountry(candidature.getAddress().getCountry());
		dto.setState(candidature.getAddress().getState());
		dto.setZipPostal(candidature.getAddress().getZipPostal());
		return dto;
	}
	public Candidature simpleMapping(CandidatureDto dto,Candidature candidature)
	{
		if (candidature==null) candidature=new Candidature();
		candidature.setId(dto.getId());
		candidature.setNom(dto.getNom());
		candidature.setPrenom(dto.getPrenom());
		candidature.setLinkedin(dto.getLinkedin());
		candidature.getAddress().setAddress(dto.getAddress());
		candidature.getAddress().setCity(dto.getCity());
		candidature.getAddress().setCountry(dto.getCountry());
		candidature.getAddress().setState(dto.getState());
		candidature.getAddress().setZipPostal(dto.getZipPostal());
		return candidature;
		
	}
}
