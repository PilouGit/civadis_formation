package com.civadis.formation.candidature.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="JOBRATING")
public class JobRating {
	@EmbeddedId
	JobRatingKey id;

    @ManyToOne
    @MapsId("candidatureId")
    @JoinColumn(name = "candidature_id")
    Candidature candidature;

    @ManyToOne
    @MapsId("jobId")
    @JoinColumn(name = "job_id")
    Job job;
	@Column(name="STATUT",columnDefinition = "ENUM('REJECTED','VALIDATED','ACCEPTED')")
	@Enumerated(EnumType.STRING)
	private Rating rating;

    
}
