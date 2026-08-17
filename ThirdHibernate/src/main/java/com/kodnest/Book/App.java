package com.kodnest.Book;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter boook name, price, author and publisher");
        Book book = new Book(sc.next(), sc.nextInt(), sc.next(), sc.next());
        
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        
        SessionFactory factory = conf.buildSessionFactory();
        
        Session session = factory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        session.persist(book);
        
        transaction.commit();
        
        session.close();
        factory.close();    
    }
}
