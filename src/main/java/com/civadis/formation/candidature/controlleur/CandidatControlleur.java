package com.civadis.formation.candidature.controlleur;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.civadis.formation.candidature.controlleur.payload.CandidatureDto;
import com.civadis.formation.candidature.controlleur.payload.JobDto;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/candidat")
public class CandidatControlleur {

	
	 @PostMapping("/")
	 @Operation(summary = "Create or update a Job by its id")
	 public  ResponseEntity<CandidatureDto> createCandidature(@RequestParam("id") Optional<Long> id,@RequestBody final CandidatureDto JobDto) {
		    return null;
		
	 }
	 @PostMapping("/uploadcv")
	 @Operation(summary = "Create or update a Job by its id")
	 public  ResponseEntity<CandidatureDto> uploadCv(@RequestParam("id") Optional<Long> id,@RequestParam("file") MultipartFile file) {
		    return null;
		
	 }
	 @PostMapping("/uploadmotivation")
	 @Operation(summary = "Create or update a Job by its id")
	 public  ResponseEntity<CandidatureDto> uploadMotivation(@RequestParam("id") Optional<Long> id,@RequestParam("file") MultipartFile file) {
		    return null;
		
	 }
}
