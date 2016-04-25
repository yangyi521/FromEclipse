package com.hp.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="_wife")
public class Wife {
	 
  private int id;
  private String name;
  private Husband husband;
  @Id
	@GeneratedValue
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
@OneToOne(mappedBy="wife")
public Husband getHusband() {
	return husband;
}
public void setHusband(Husband husband) {
	this.husband = husband;
}
  
}
