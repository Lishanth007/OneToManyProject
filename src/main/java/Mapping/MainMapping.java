package Mapping;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainMapping {

	public static void main(String[] args) {
		Ownership ownership1 = new Ownership();
		ownership1.setOwnerId(1);
		ownership1.setOwnerName("Mark Zuckerberg");

		Ownership ownership2 = new Ownership();
		ownership2.setOwnerId(2);
		ownership2.setOwnerName("Elon Musk");

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

		ownership1.setOwnerOfProduct(Arrays.asList(products1, products2, products3));
		Configuration configuration = new Configuration().configure().addAnnotatedClass(Ownership.class)
				.addAnnotatedClass(Products.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(ownership1);
		session.save(ownership2);
		session.save(products1);
		session.save(products2);
		session.save(products3);

		transaction.commit();
	}

}
