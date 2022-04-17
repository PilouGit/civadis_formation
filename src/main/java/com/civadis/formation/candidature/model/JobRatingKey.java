package com.civadis.formation.candidature.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class JobRatingKey implements Serializable {
	@Column(name = "candidature_id")
    Long candidatureId;

    @Column(name = "job_id")
    Long jobId;

	@Override
	public int hashCode() {
		return Objects.hash(candidatureId, jobId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobRatingKey other = (JobRatingKey) obj;
		return Objects.equals(candidatureId, other.candidatureId) && Objects.equals(jobId, other.jobId);
	}
    
    
}
