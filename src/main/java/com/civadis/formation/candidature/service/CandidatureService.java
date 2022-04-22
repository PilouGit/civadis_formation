package com.civadis.formation.candidature.service;

import java.util.ArrayList;
import java.util.List;
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
	public List<TypeFile> getTypeFile(Long id)
	{
		List<TypeFile> result=new ArrayList<>();
		if (this.repository.hasCv(id))
		{
			result.add(TypeFile.cv);
		}
		if (this.repository.hasMotivation(id))
		{
			result.add(TypeFile.motivation);
		}
		return result;
	}
	
	@Transactional
	public Candidature saveDatabaseFile(Long id, TypeFile fileType, String fileName,String contentType,byte [] data)
	{
		Optional<Candidature> optionnalCandidature = this.repository.findById(id);
		if (optionnalCandidature.isPresent())
		{
			Candidature candidature=optionnalCandidature.get();
			DatabaseFile databaseFile=new DatabaseFile();
			switch (fileType)
			{
			case cv: 
				if (candidature.getCv()!=null)
					databaseFile=candidature.getCv();
				else candidature.setCv(databaseFile);
				
				break;
			case motivation: 
				if (candidature.getMotivation()!=null)
				databaseFile=candidature.getMotivation();
				else candidature.setMotivation(databaseFile);
				break;
			default: throw new IllegalArgumentException("Must not happen");
			}
			
			databaseFile.setName(fileName);
			databaseFile.setType(contentType);
			databaseFile.setData(data);
			
			this.repository.save(candidature);
			
			return candidature;
			
		}else
		{
			return null;
		}
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
	@Transactional(readOnly=true)
	public Optional<Candidature> getCandidature(Long id) {
		Optional<Candidature> optionnalCandidature = this.repository.findById(id);
		return optionnalCandidature; 
		
	}
	
	
}
