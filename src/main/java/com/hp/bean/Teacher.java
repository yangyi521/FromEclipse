package com.hp.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

//多对多的关联
@Entity
public class Teacher {
  private int id;
  private String name;
  private String gender;
  private Set<Student> students = new HashSet<Student>();
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
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
@ManyToMany
@JoinTable(name="t_s", //指定中间表的名字
  joinColumns={@JoinColumn(name="teacher_id")},//指定本类对应的字段的信息
  inverseJoinColumns={@JoinColumn(name="student_id")}//指定对方类指定字段的信息
)//指定中间表的信息,
public Set<Student> getStudents() {
	return students;
}
public void setStudents(Set<Student> students) {
	this.students = students;
} 
}
