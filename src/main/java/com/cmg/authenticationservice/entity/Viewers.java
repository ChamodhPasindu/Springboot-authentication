package com.cmg.authenticationservice.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Viewers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int viewerID;
	private String email;
	private Date dob;
	private String laguage;
	private String gender;
	private String name;
	private String mobileNumber;
	private String verified;
	private String country;
	private Date datecreatedTime;
	private Date lastUpdateTime;
	private String deviceID;
	private String socailUserID;
	private String socialToken;
	
	
	public Viewers(int viewerID, String email, Date dob, String laguage, String gender, String name,
			String mobileNumber, String verified, String country, Date datecreatedTime, Date lastUpdateTime,
			String deviceID, String socailUserID, String socialToken) {
		super();
		this.viewerID = viewerID;
		this.email = email;
		this.dob = dob;
		this.laguage = laguage;
		this.gender = gender;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.verified = verified;
		this.country = country;
		this.datecreatedTime = datecreatedTime;
		this.lastUpdateTime = lastUpdateTime;
		this.deviceID = deviceID;
		this.socailUserID = socailUserID;
		this.socialToken = socialToken;
	}

	public Viewers() {
		super();
	}

	public int getViewerID() {
		return viewerID;
	}

	public void setViewerID(int viewerID) {
		this.viewerID = viewerID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getLaguage() {
		return laguage;
	}

	public void setLaguage(String laguage) {
		this.laguage = laguage;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDatecreatedTime() {
		return datecreatedTime;
	}

	public void setDatecreatedTime(Date datecreatedTime) {
		this.datecreatedTime = datecreatedTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	public String getSocailUserID() {
		return socailUserID;
	}

	public void setSocailUserID(String socailUserID) {
		this.socailUserID = socailUserID;
	}

	public String getSocialToken() {
		return socialToken;
	}

	public void setSocialToken(String socialToken) {
		this.socialToken = socialToken;
	}

	
	
}
