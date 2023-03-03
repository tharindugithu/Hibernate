package com.tharindu.DemoHib;

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
    	Laptop laptop = new Laptop();
    	laptop.setLid(101);
    	laptop.setLname("MSI");
    	
    	Student s = new Student();
    	s.setRollno(1);
    	s.setName("Tharindu");
    	s.setMarks(20);
    	s.getLaptop().add(laptop);//add laptop in list
        laptop.setStudent(s);
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(laptop);
        session.save(s);
        //s.save(p);// save the data in database	
       
        tx.commit();
       
        
        
    }
}
