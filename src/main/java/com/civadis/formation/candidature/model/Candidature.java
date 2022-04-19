package com.civadis.formation.candidature.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *  Données personnelles

o Nom

o Prénom

o Sexe

o Date de naissance

o Nationalité

o Langue

o Email

o Numéro téléphone

- Adresse

o Rue

o Numéro

o Code postal

o Ville

o Pays

- Connaissance

o Diplôme

o Langue

§ Français (pas de connaissance, Notions, Bonne Très bonne, langue maternelle)

§ Néerlandais (pas de connaissance, Notions, Bonne Très bonne, langue maternelle)

§ Anglais (pas de connaissance, Notions, Bonne Très bonne, langue maternelle)

o Informations complémentaires

§ CV

§ Motivation

§ URL profil linkedin
 * @author pilou
 *
 */
@Entity
@Table(name="CANDIDATURE")
public class Candidature {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "PRENOM")
	private String prenom;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	@Column(name = "LINKEDIN",columnDefinition="TEXT")
	private String linkedin;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "cv_id", referencedColumnName = "id")
	private DatabaseFile cv;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "motivation_id", referencedColumnName = "id")
	private DatabaseFile motivation;
	
	@OneToMany(mappedBy = "candidature")
    Set<JobRating> ratings;

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public DatabaseFile getCv() {
		return cv;
	}

	public void setCv(DatabaseFile cv) {
		this.cv = cv;
	}

	public DatabaseFile getMotivation() {
		return motivation;
	}

	public void setMotivation(DatabaseFile motivation) {
		this.motivation = motivation;
	}

	public Set<JobRating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<JobRating> ratings) {
		this.ratings = ratings;
	}
	
	
}
