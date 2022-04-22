package com.civadis.formation.candidature;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.civadis.formation.candidature.controlleur.CandidatControlleur;
import com.civadis.formation.candidature.controlleur.payload.CandidatureDto;
import com.civadis.formation.candidature.service.CandidatureService;

@SpringBootTest
public class CandidatureApiTest {

	@Autowired CandidatControlleur candidatControlleur;
	
	@Test
	public void testCreateCandidature()
	{
		CandidatureDto dto=new CandidatureDto();
		dto.setNom("pilou");
		dto.setPrenom("pilou");
		dto=candidatControlleur.createCandidature(Optional.empty(), dto).getBody();
		System.out.println(dto);
		dto.setAddress("Mon adresse");
		
		dto=candidatControlleur.createCandidature(Optional.of(dto.getId()), dto).getBody();
		System.out.println(dto);
		
	}
	@Test
	public void fileInfo()
	{
		
		List<CandidatureService.TypeFile> result=candidatControlleur.fileInfo(2L).getBody();
		System.err.println(result);
		
		
	}
}
