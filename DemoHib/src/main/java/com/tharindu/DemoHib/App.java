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
    	PersonName pname = new PersonName();//create pname object and fill 3 fields
    	pname.setFname("Tharindu");
    	pname.setMnamel("Mandusanka");
    	pname.setLname("Dissanayaka");
        Persons p = new Persons();
        p.setPid(01);
        p.setName(pname);//name is now object
        
        Configuration con = new Configuration().configure().addAnnotatedClass(Persons.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf = con.buildSessionFactory(reg);
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        
        s.save(p);// save the data in database	
       
        tx.commit();
       
        
        
    }
}
