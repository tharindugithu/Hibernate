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
        

        /////////by default second level cache only support get method in session not HQL . /////////////////////////
        ///////// <property name="hibernate.cache.use_query_cache">true</property> for second level query caching////////////////////
        Laptop laptop = new Laptop();
        Transaction tx;
        
        Session session = sf.openSession();/////////create session 1////////////////////
        tx = session.beginTransaction();
        
        Query q1 =  session.createQuery("from Laptop where lid=101");
        q1.setCacheable(true);
        laptop = (Laptop) q1.uniqueResult();
        System.out.println(laptop.getLname());
        tx.commit();
        //or
        //session.getTransaction().commit();
        session.close();
        
       
        Session session2 = sf.openSession(); /////////create session 2////////////////////
        tx = session2.beginTransaction();        
        
        Query q2 = session2.createQuery("from Laptop where lid=101");
        q2.setCacheable(true);
        laptop = (Laptop) q2.uniqueResult();
        System.out.println(laptop.getLname());
        tx.commit();
        //or
        //session2.getTransaction().commit();
        session2.close();
        
        

        
        
    }
}
