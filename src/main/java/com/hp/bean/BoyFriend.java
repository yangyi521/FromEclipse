package com.hp.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class BoyFriend {
	@Id @GeneratedValue
	private int id;
	private String username;
	private String password;
	private String gender;
	@ManyToOne(targetEntity=GirlFriend.class)
	@JoinColumn
	@Cascade(CascadeType.ALL)
	private GirlFriend girlfriend;
	public GirlFriend getGirlfriend() {
		return girlfriend;
	}
	public void setGirlfriend(GirlFriend girlfriend) {
		this.girlfriend = girlfriend;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	

}
