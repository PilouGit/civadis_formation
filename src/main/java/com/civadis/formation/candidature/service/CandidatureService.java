package com.civadis.formation.candidature.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.civadis.formation.candidature.model.Candidature;
import com.civadis.formation.candidature.model.DatabaseFile;
import com.civadis.formation.candidature.repository.CandidatureRepository;

@Service
public class CandidatureService {

	@Autowired 
	CandidatureRepository repository;
	public enum TypeFile
	{
		cv,motivation
	}
	@Transactional
	public Candidature createOrUpdateCandidature(Candidature candidature)
	{
		return repository.save(candidature);
	}
	
	@Transactional(readOnly=true)
	public DatabaseFile getCv(Long id) {
		
		Optional<Candidature> optionnalCandidature = this.repository.findById(id);
		if (optionnalCandidature.isPresent())
		{
			Candidature candidature= optionnalCandidature.get();
			return candidature.getCv();
			
		}
		return null;
	}
	@Transactional(readOnly=true)
	public DatabaseFile getMotivation(Long id) {
		Optional<Candidature> optionnalCandidature = this.repository.findById(id);
		if (optionnalCandidature.isPresent())
		{
			Candidature candidature= optionnalCandidature.get();
			return candidature.getMotivation();
			
		}
		return null;
	}
	
	
}
