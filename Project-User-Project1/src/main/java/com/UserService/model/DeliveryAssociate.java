package com.UserService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@ToString
@Entity
@Table(name = "DELIVERYASSOCIATE")
public class DeliveryAssociate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phonenumber;
	private String email;
	private String status;
	private Float latitude;
	private Float longitude;
	private String panno;
	private String daimage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public String getPanno() {
		return panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
	}

	public String getDaimage() {
		return daimage;
	}

	public void setDaimage(String daimage) {
		this.daimage = daimage;
	}

	public DeliveryAssociate() {
		super();
	}

	public DeliveryAssociate(String name, String phonenumber, String email, Float latitude, Float longitude,
			String panno, String daimage) {
		super();
		this.name = name;
		this.phonenumber = phonenumber;
		this.email = email;
		this.latitude = latitude;
		this.longitude = longitude;
		this.panno = panno;
		this.daimage = daimage;
	}

}
