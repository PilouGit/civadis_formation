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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
  
 

  
}