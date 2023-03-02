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
        Persons p = new Persons();
        //p.setPid(14);
        //p.setName("Chamikara");
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Persons.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        
        //s.save(p); save the data in database	
        p = (Persons)s.get(Persons.class,14);//fetch the values in database
        tx.commit();
        System.out.println(p);
        
        
    }
}
