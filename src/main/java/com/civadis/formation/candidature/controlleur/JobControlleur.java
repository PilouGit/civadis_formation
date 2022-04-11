package com.civadis.formation.candidature.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.civadis.formation.candidature.model.Job;
import com.civadis.formation.candidature.repository.JobRepository;
import com.civadis.formation.candidature.service.JobService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/job")
public class JobControlleur {

	@Autowired 
	JobService jobService;
	@Operation(summary = "Get a Job by its id")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "Found the Jon", 
	    content = { @Content(mediaType = "application/json", 
	      schema = @Schema(implementation = Job.class)) }),
	  @ApiResponse(responseCode = "400", description = "Invalid id supplied", 
	    content = @Content), 
	  @ApiResponse(responseCode = "404", description = "Job not found", 
	    content = @Content) })
	@GetMapping("/{id}")
    public Job findById(@PathVariable long id) {
		
			
			return null;
		}
	 @PostMapping("/")
	 @Operation(summary = "Create a Job by its id")
	 public  ResponseEntity<Job> createJob(@RequestBody final Job job) {
		
		 
		    return ResponseEntity.ok(jobService.createJob(job));
		
	}
}
