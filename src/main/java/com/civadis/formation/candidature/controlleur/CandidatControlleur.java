package com.civadis.formation.candidature.controlleur;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.civadis.formation.candidature.controlleur.payload.CandidatureDto;
import com.civadis.formation.candidature.controlleur.payload.JobDto;
import com.civadis.formation.candidature.model.Candidature;
import com.civadis.formation.candidature.model.DatabaseFile;
import com.civadis.formation.candidature.service.CandidatMapper;
import com.civadis.formation.candidature.service.CandidatureService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/candidat")
public class CandidatControlleur {


	 @Autowired CandidatureService service;
	 @Autowired CandidatMapper candidatMapper;
	
	 @PostMapping("/")
	 @Operation(summary = "Create or update a Job by its id")
	 @Transactional
	 public  ResponseEntity<CandidatureDto> createCandidature(@RequestParam("id") Optional<Long> id,@RequestBody final CandidatureDto candidatureDto) {
		 
		 Candidature candidature=null;
		 if (id.isEmpty())
		 {
			 candidature=candidatMapper.simpleMapping( candidatureDto,candidature);
			 candidature.setId(null);
		 }else
		 {
			 Optional<Candidature> optionnalCandidature = service.getCandidature(id.get());
			 if (optionnalCandidature.isEmpty())
			 {
				 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			 }else
			 {
				 candidature=optionnalCandidature.get();
				 candidature=this.candidatMapper.simpleMapping(candidatureDto,candidature);
			 }
			 
		 }
		 candidature=service.createOrUpdateCandidature(candidature);
		 
		 
		 return ResponseEntity.ok(this.candidatMapper.simpleMapping(candidature, null));
		
	 }

	 @PostMapping("/files/{typeFile}")
	 @Operation(summary = "Create or update a Job by its id")
	 @Transactional
	 public  ResponseEntity<CandidatureDto> uploadFile(@PathVariable("typeFile") CandidatureService.TypeFile mode,@RequestParam("id") Long id,@RequestParam("file") MultipartFile file) {
		 
		 try {
			byte [] data=file.getBytes();
	
		 String fileName=file.getName();
		 String contentType=file.getContentType();
		 Candidature candidature = this.service.saveDatabaseFile(id, mode, fileName, contentType, data);
		 if (candidature!=null)
		 {
			 return ResponseEntity.ok(this.candidatMapper.simpleMapping(candidature, null));
		 }else
		 {
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			 
		 }
			} catch (IOException e) {
				 return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			}	
	 }
	 
	 @GetMapping(path = "/files")
	 public ResponseEntity<List<CandidatureService.TypeFile>> fileInfo(@RequestParam("id") Long id)  {
		 
		 return ResponseEntity.ok(this.service.getTypeFile(id));
		 
	 }
			
	 @GetMapping(path = "/files/{typeFile}")
	 @Transactional
	 public ResponseEntity<Resource> download(@PathVariable("typeFile") CandidatureService.TypeFile mode,@RequestParam("id") Long id)  {
		 
		 DatabaseFile databaseFile;
		 if (CandidatureService.TypeFile.cv==mode)
			 {
			 databaseFile=this.service.getCv(id);
			 }
		 else
		 {
			 databaseFile=this.service.getMotivation(id);
		 }
		 if (databaseFile==null)
		 {
			   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
		  return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(databaseFile.getType()))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + databaseFile.getName() + "\"")
	                .body(new ByteArrayResource(databaseFile.getData()));
		 	 }

	
}
