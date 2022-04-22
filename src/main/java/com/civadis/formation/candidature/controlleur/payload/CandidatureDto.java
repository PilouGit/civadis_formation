package com.civadis.formation.candidature.controlleur.payload;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class CandidatureDto {

	@JsonProperty("id")
	private Long id;
	
	@NotNull
	@JsonProperty("nom")
	private String nom;
	@NotNull
	@JsonProperty("prenom")
	private String prenom;
	@JsonProperty("linkedin")
	private String linkedin;
	@JsonProperty("address")
	private String address ;
	@JsonProperty("city")
	private String city ;
	@JsonProperty("state")
	private String state ;
	@JsonProperty("zipPostal")
	private String zipPostal ;
	@JsonProperty("country")
	private String country ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLinkedin() {
		return linkedin;
	}
	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipPostal() {
		return zipPostal;
	}
	public void setZipPostal(String zipPostal) {
		this.zipPostal = zipPostal;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return String.format(
				"CandidatureDto [id=%s, nom=%s, prenom=%s, linkedin=%s, address=%s, city=%s, state=%s, zipPostal=%s, country=%s]",
				id, nom, prenom, linkedin, address, city, state, zipPostal, country);
	}
	
	  
}
