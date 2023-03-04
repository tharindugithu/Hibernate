package com.tharindu.DemoHib;

import java.util.ArrayList;
import java.util.List;

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
        

        /////////////firing query only one time because hibernate default store cache inside first level caching /////////
        //Laptop laptop = new Laptop();
        
        //Transaction tx;
        //Session session = sf.openSession();
        //session.beginTransaction();
        
        //laptop = (Laptop) session.get(Laptop.class, 103);
        //System.out.println(laptop.getLname());
       
        
        //laptop = (Laptop) session.get(Laptop.class, 103);
        //System.out.println(laptop.getLname());
        //session.getTransaction().commit();
        
        
        
        /////////firing query two time because we need second level caching////////////////////
        Laptop laptop = new Laptop();
        Transaction tx;
        
        Session session = sf.openSession();/////////create session 1////////////////////

        tx = session.beginTransaction();
     
        laptop = (Laptop) session.get(Laptop.class, 103);
        
        tx.commit();
        //or
        //session.getTransaction().commit();
        session.close();
        
       
        Session session2 = sf.openSession(); /////////create session 2////////////////////
        tx = session2.beginTransaction();        
        
        laptop = (Laptop) session2.get(Laptop.class, 103);
        
        tx.commit();
        //or
        //session2.getTransaction().commit();
        session2.close();
        
        
        
        
        
        
        
        
        
        
        /////////////get all the laps names belong to rollno = 1 student////////////////      
        //Student s = new Student();
        //s = (Student)session.get(Student.class, 1);
        //List<Laptop> laptops = new ArrayList<Laptop>();
        
        
        ////////////fetch laptop details///////////////////////
        // laptops = s.getLaptop();
        //for(Laptop l : laptops) {
        // 	System.out.println(l.getLname());
        //}
        
        
        /////////////create a new laptop obj and assing to that lap exisiting student in db//////////////
        //Laptop laptop = new Laptop();
      	//Laptop laptop2 = new Laptop();
    	//laptop.setLid(104);//create new laptop obj
    	//laptop.setLname("HP");
        //laptop2 =  (Laptop)session.get(Laptop.class, 103);//get student object id = 103
        //laptop.setStudent((Student)laptop2.getStudent());//assign that student object to laptop obj
        //session.save(laptop);//save the laptop obj db
        
       
       
        
        
    }
}
