package com.tharindu.DemoHib;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Persons {
   @Id	
   private int pid;
   @Column(name = "p_name")
   private PersonName name;

@Override
public String toString() {
	return "Persons [pid=" + pid + ", name=" + name + "]";
}

public int getPid() {
	return pid;
}

public void setPid(int pid) {
	this.pid = pid;
}

public PersonName getName() {
	return name;
}

public void setName(PersonName name) {
	this.name = name;
}

   
   
}
