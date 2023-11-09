package Mapping;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.mapping.internal.PluralAttributeMappingImpl.Aware;

public class MainMapping {

	public static void main(String[] args) {

		Products products1 = new Products();
		products1.setProductId(101);
		products1.setProductName("Meta");
		products1.setProductUserCount("3.59 Billion");

		Products products2 = new Products();
		products2.setProductId(102);
		products2.setProductName("Instagram");
		products2.setProductUserCount("2.35 Billion");

		Products products3 = new Products();
		products3.setProductId(103);
		products3.setProductName("WhatApp");
		products3.setProductUserCount("2.7 Billion");

		Products products4 = new Products();
		products4.setProductId(104);
		products4.setProductName("Twitter");
		products4.setProductUserCount("206 Million");
		
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Ownership.class)
				.addAnnotatedClass(Products.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		ArrayList<Products> List1 = new ArrayList<Products>();
		List1.add(products1);
		List1.add(products2);
		List1.add(products3);

		ArrayList<Products> List2 = new ArrayList<Products>();
		List2.add(products4);
		
		Ownership ownership1 = new Ownership();
		ownership1.setOwnerId(1);
		ownership1.setOwnerName("Mark Zuckerberg");
		ownership1.setOwnerOfProduct(List1);
		
		Ownership ownership2 = new Ownership();
		ownership2.setOwnerId(2);
		ownership2.setOwnerName("Elon Musk");
		ownership2.setOwnerOfProduct(List2);

		List1.forEach(session::save);
		List2.forEach(session::save);
		session.save(ownership1);
		session.save(ownership2);

		transaction.commit();
	}

}
