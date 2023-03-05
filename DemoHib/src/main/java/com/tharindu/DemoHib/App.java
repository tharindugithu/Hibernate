package com.tharindu.DemoHib;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 

{
    public static void main( String[] args )
    {

        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        
   

        Transaction tx;
        
        Session session = sf.openSession();/////////create session 1////////////////////
        tx = session.beginTransaction();
        
        
        //difference between SQL and HQL ---> 
           /*
            * 1. HQL use class name for Table in SQL
            * from Laptop ---> fetch all the laptop details
            * 
            * 
            * */
        
        
        //fetch specific data
//        Query q1 =  session.createQuery("select lid,lname,student from Laptop where lid=101");
//        Object[] l = (Object[]) q1.uniqueResult(); 
//        System.out.println(l[2]);
        
        //fetch list of data using HQL
        Query q1 =  session.createQuery("from Laptop order by lname asc");
        List laptops =  q1.list();
//        for(Laptop l : laptops) {
//        	Student s = new Student();
//        	s=l.getStudent();
//        	System.out.println("Laptop [lid=" + l.getLid() + ", lname=" + l.getLname() + "sname "+s.getName() + "]");
//        }
        
    
        tx.commit();

 
    }
}
