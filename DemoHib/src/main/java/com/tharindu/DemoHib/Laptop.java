package com.tharindu.DemoHib;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Laptop {
   @Id	
   private int lid;
   private String lname;
   //one student has multiple laptops and one laptop has one student
   @ManyToMany
   private  List<Student> student = new ArrayList<Student>();
   
public List<Student> getStudent() {
	return student;
}
public void setStudent(List<Student> student) {
	this.student = student;
}
public int getLid() {
	return lid;
}
public void setLid(int lid) {
	this.lid = lid;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
   
}
