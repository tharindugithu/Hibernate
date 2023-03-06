package com.tharindu.DemoHib;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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
        
        //Native query

        Transaction tx;
        
        Session session = sf.openSession();
        tx = session.beginTransaction();
        //////////update//////////////
//        Student s = (Student)session.get(Student.class, 3);
//        Laptop laptop = new Laptop();
//        laptop.setLname("MSI22");
//        laptop.setLid(106);
//        laptop.setStudent(s);
//        
//        session.update(laptop);
        
        
        
        
        /////delete///////////////////
        /*
         * we can fetch the data using get or load method
         * */
       // Student s = (Student)session.get(Student.class, 1);
//        List<Laptop> laptops =  s.getLaptop();
//        for(Laptop l : laptops) {
//        	session.delete(l);
//        }
//        session.delete(s);

        System.out.println("hee");
        tx.commit();

 
    }
}
