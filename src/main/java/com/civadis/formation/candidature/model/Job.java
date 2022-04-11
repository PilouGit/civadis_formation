package com.civadis.formation.candidature.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *  Numéro de l’offre

- Titre de l’offre

- Statut : (En cours d’élaboration, Validée, publiée)

- Type engagement

- Lieu travail

- Régime de travail

- Diplôme requis

- Vos responsabilités

- Votre profil

- Notre offre 
 * @author pilou
 *
 */
@Entity
@Table(name="JOB")
public class Job {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "TITRE")
	@NotBlank
    String titreOffre;
	@Column(name="STATUT",columnDefinition = "ENUM('ELABORATION','VALIDATION','PUBLICATION')")
	@Enumerated(EnumType.STRING)
	private Status status;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitreOffre() {
		return titreOffre;
	}
	public void setTitreOffre(String titreOffre) {
		this.titreOffre = titreOffre;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
