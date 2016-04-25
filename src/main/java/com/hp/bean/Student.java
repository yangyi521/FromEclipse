package com.hp.bean;
//一对多的理解，一个老师可以教授多个学生，同时一个学生也可以有多个老师进行教授，形成一个多对多的关系
public class Student {
   private int id;
   private String name;
   private String classno;
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
public String getClassno() {
	return classno;
}
public void setClassno(String classno) {
	this.classno = classno;
}
   
}
