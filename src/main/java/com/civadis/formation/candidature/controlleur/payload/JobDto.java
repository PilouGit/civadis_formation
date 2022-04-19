package com.civadis.formation.candidature.controlleur.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class JobDto {
	@JsonProperty("id")
	private Long id;
	@JsonProperty("titre")
	private String titreOffre;
	@JsonProperty("status")
	private StatusDto status;
	@JsonProperty("engagement")
	private EngagementDto engagement;
	@JsonProperty("responsabilites")
	private String responsabilites;
	@JsonProperty("profil")
	private String profil;
	@JsonProperty("offre")
	private String offre;
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
	
	public StatusDto getStatus() {
		return status;
	}
	public void setStatus(StatusDto status) {
		this.status = status;
	}
	public EngagementDto getEngagement() {
		return engagement;
	}
	public void setEngagement(EngagementDto engagement) {
		this.engagement = engagement;
	}
	public String getResponsabilites() {
		return responsabilites;
	}
	public void setResponsabilites(String responsabilites) {
		this.responsabilites = responsabilites;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
	public String getOffre() {
		return offre;
	}
	public void setOffre(String offre) {
		this.offre = offre;
	}
	
}
