package com.arya.model;

import java.beans.Transient;
import java.util.Base64;

import javax.persistence.Column;

/*
 * Represents a pair of sneakers 
 * */
public class Sneaker {
	
	private String name;
	private Integer id;
	private Integer score;
	
	/*
	 * Returns the name of this sneakers
	 * */
	public String getName() {
		return name;
	}
	
	/*
	 * Modifies the name of this sneakers to <code>name</code>
	 * 
	 * @param: name the name to be set, is not null
	 * */
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * Returns the ID of this sneakers
	 * */
	public Integer getId() {
		return id;
	}
	
	/*
	 * Modifies the ID of this sneakers to <code>id</code>
	 * 
	 * @param: id new ID of this sneakers, is not null and greater than 0
	 * */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/*
	 * Returns the score of this sneakers
	 * */
	public Integer getScore() {
		return score;
	}
	
	/*
	 * Modifies the score of this sneakers to <code>score</code>
	 * 
	 * @param: score the new score to be set, is not null. score >= 0
	 * */
	public void setScore(Integer score) {
		this.score = score;
	}

	
	
}
