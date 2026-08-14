package com.kodnest.SecondHibernate;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name, age, marks");
        Student stu = new Student(sc.next(), sc.nextInt(), sc.nextInt());
        
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        
        SessionFactory factory = conf.buildSessionFactory();
        
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        session.persist(stu);
        
        transaction.commit();
        
        session.close();
        factory.close();
    }
}
