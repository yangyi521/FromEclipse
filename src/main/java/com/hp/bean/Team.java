package com.hp.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="t_team")
public class Team {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToMany(cascade=CascadeType.ALL)
	//@JoinColumn(name="_id")
	private Set<Player> player = new HashSet<Player>();
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
	public Set<Player> getPlayer() {
		return player;
	}
	public void setPlayer(Set<Player> player) {
		this.player = player;
	}
	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", player=" + player + "]";
	}
	
	

}
