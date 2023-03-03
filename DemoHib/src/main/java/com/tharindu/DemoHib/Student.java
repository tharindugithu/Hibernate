package com.tharindu.DemoHib;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
   @Id	
   private int rollno;
   private String name;
   private int marks;
   @OneToMany
   private List<Laptop> laptops = new ArrayList<Laptop>();
   
@Override
public String toString() {
	return "Student [rollno=" + rollno + ", name=" + name + ", marks=" + marks + ", laptop=" + laptops + "]";
}
public List<Laptop> getLaptop() {
	return laptops;
}
public void setLaptop(List<Laptop> laptops) {
	this.laptops = laptops;
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
