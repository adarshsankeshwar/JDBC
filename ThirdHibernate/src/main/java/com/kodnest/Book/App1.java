package com.kodnest.Book;

import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		
		SessionFactory factory = conf.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		System.out.println("Enter id to Fetch the book details:");
		
		Book ref = session.get(Book.class, sc.nextInt());
		
		System.out.println(ref);
		
		transaction.commit();
		
		factory.close();
		session.clear();

	}
}
