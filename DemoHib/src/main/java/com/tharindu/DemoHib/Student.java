package com.tharindu.DemoHib;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity

public class Student {
   @Id	
   private int rollno;
   private String name;
   private int marks;
   @OneToMany(mappedBy = "student")
   private List<Laptop> laptop = new ArrayList<Laptop>();
   
@Override
public String toString() {
	return "Student [rollno=" + rollno + ", name=" + name + ", marks=" + marks + "]";
}
public List<Laptop> getLaptop() {
	return laptop;
}
public void setLaptop(List<Laptop> laptops) {
	this.laptop = laptops;
}
public int getRollno() {
	return rollno;
}
public void setRollno(int rollno) {
	this.rollno = rollno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}
   
}