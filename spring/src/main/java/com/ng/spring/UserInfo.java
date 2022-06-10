package com.ng.spring;

public class UserInfo 
{
	private String id,email,verified_email,picture;
	
	public UserInfo()
	{
		
	}
	public UserInfo(String id, String email, String verified_email, String picture) {
		super();
		this.id = id;
		this.email = email;
		this.verified_email = verified_email;
		this.picture = picture;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVerified_email() {
		return verified_email;
	}
	public void setVerified_email(String verified_email) {
		this.verified_email = verified_email;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", email=" + email + ", verified_email=" + verified_email + ", picture=" + picture
				+ "]";
	}
}
