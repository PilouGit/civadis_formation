package com.civadis.formation.candidature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address {

   
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "ADDRESS_FULL",columnDefinition="TEXT")
	private String address = null;
	@Column(name = "CITY")
	private String city = null;
	@Column(name = "STTAE")
	private String state = null;
	@Column(name = "ZIPPOSTAL")
	private String zipPostal = null;
	@Column(name = "COUNTRY")
	private String country = null;
  
 

  
}