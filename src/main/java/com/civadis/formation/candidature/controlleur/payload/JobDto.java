package com.civadis.formation.candidature.controlleur.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JobDto {
	@JsonProperty("id")
	private Long id;
	private String titreOffre;
	private String status;
		private String engagement;
	
		private String responsabilites;
		private String profil;
		private String offre;
}
