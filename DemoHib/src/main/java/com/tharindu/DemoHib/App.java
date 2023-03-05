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
        ////////////fetching entire row in table////////////////////////
//        SQLQuery sqlQuery = session.createSQLQuery("select * from laptop where lid=101");
//        sqlQuery.addEntity(Laptop.class);
//        List <Laptop> laptops = sqlQuery.list();
//        for(Laptop l : laptops) {
//        	System.out.println(l.getLname());
//        }
        /////////////////fetching specific colounm///////////////////
        SQLQuery sqlQuery = session.createSQLQuery("select lid,lname from laptop");
        sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);//this will convert to output in MAP format
        
        List laptops = sqlQuery.list();// not a student obj
        
        for(Object obj : laptops) {//every obj get a MAP
        	 Map m = (Map)obj;
        	 System.out.println(m.get("lid") + " "+m.get("lname"));
        }
        
        tx.commit();

 
    }
}
