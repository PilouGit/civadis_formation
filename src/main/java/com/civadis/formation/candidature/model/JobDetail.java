package com.civadis.formation.candidature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Vos responsabilités

- Votre profil

- Notre offre 
 */
@Entity
@Table(name="JOBDETAIL")
public class JobDetail {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(columnDefinition = "TEXT")
	private String responsabilites;
	@Column(columnDefinition = "TEXT")
	private String profil;
	@Column(columnDefinition = "TEXT")
	private String offre;
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobDetail other = (JobDetail) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
