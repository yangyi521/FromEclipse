package com.hp.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
public class Stars {
	private int id;
	private String gender;
	private String name;
	private Set<Fans> fans = new HashSet<Fans>();
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
	@OneToMany(mappedBy="star",cascade=CascadeType.ALL)//把mapperedBy加载多的一方，即有onetomany的地方
	//@JoinColumn(name="starid") //指定在多的一方生成的表中 关联外键的字段
	public Set<Fans> getFans() {
		return fans;
	}
	public void setFans(Set<Fans> fans) {
		this.fans = fans;
	}
	@Override
	public String toString() {
		return "Stars [id=" + id + ", gender=" + gender + ", name=" + name
				+ ", fans=" + fans + "]";
	}
	

}
