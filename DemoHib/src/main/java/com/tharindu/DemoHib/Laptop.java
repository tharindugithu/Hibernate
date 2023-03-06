package com.tharindu.DemoHib;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
public class Laptop {
   @Id	
   private int lid;
   private String lname;
   //one student has multiple laptops and one laptop has one student
   @ManyToOne
   private Student student;
   
public Student getStudent() {
	return student;
}
public void setStudent(Student student) {
	this.student = student;
}
public int getLid() {
	return lid;
}
public void setLid(int lid) {
	this.lid = lid;
}
@Override
public String toString() {
	return "Laptop [lid=" + lid + ", lname=" + lname + ", student=" + student + "]";
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
   
}