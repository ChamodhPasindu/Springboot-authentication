package com.cmg.authenticationservice.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Auth {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authID;
	private String username;
	private String password;
	private String socialType;
	private String refreshToken;
	private String tokenHash;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="viewerID")
	private Viewers viewerID; 

	public Auth(int authID, String username, String password, String socialType, String refreshToken, String tokenHash,
			Viewers viewerID) {
		super();
		this.authID = authID;
		this.username = username;
		this.password = password;
		this.socialType = socialType;
		this.refreshToken = refreshToken;
		this.tokenHash = tokenHash;
		this.viewerID = viewerID;
	}

	public Auth() {
		super();
	}

	public int getAuthID() {
		return authID;
	}

	public void setAuthID(int authID) {
		this.authID = authID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSocialType() {
		return socialType;
	}

	public void setSocialType(String socialType) {
		this.socialType = socialType;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getTokenHash() {
		return tokenHash;
	}

	public void setTokenHash(String tokenHash) {
		this.tokenHash = tokenHash;
	}

	public Viewers getViewerID() {
		return viewerID;
	}

	public void setViewerID(Viewers viewerID) {
		this.viewerID = viewerID;
	}

	

	
	
	
}
