package com.hp.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

@Entity
public class Fans {
    private int id;
    private String gender;
    private String name;
    private Stars star;
    @Id
    @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	
	public Stars getStar() {
		return star;
	}
	public void setStar(Stars star) {
		this.star = star;
	}
	@Override
	public String toString() {
		return "Fans [id=" + id + ", gender=" + gender + ", name=" + name + "]";
	}
}
