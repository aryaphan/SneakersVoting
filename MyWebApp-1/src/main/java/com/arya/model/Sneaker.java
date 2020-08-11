package com.arya.model;

import java.beans.Transient;
import java.util.Base64;

import javax.persistence.Column;

public class Sneaker {
	
	private String name;
	private Integer id;
	private Integer score;
//	private byte[] image;
//
//	@Column(name = "image")
//	public byte[] getImage() {
//		return this.image;
//	}
//	
//	
//	private String base64Image;
//	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	
//	@Override
//	public String toString() {
//		return name;
//	}
	
//	@Transient
//	public String getBase64Image() {
//		base64Image = Base64.getEncoder().encodeToString(this.image);
//		return base64Image;
//	}
//	
//	public void setBase64Image(String base64Image) {
//		this.base64Image = base64Image;
//	}
//	
	
	
}
