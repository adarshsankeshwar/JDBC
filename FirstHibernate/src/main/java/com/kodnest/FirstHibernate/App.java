package com.kodnest.FirstHibernate;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name, gender, salary");
        Employee emp = new Employee(sc.next(), sc.next(), sc.nextInt());
        
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfc.xml");
        
        SessionFactory factory = conf.buildSessionFactory();
        
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        session.persist(emp);
        
        transaction.commit();
        
        session.close();
        factory.close();
        
    }
}
