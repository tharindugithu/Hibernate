package com.tharindu.DemoHib;

import javax.persistence.Embeddable;

@Embeddable  //dont create new table for me 
public class PersonName {
   private String fname;
   private String lname;
   private String mnamel;
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getMnamel() {
	return mnamel;
}
public void setMnamel(String mnamel) {
	this.mnamel = mnamel;
}
   
   
}
