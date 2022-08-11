package com.intelligent.realestate.dao.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.intelligent.realestate.exceptions.Exceptions;

public final class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry registry;

	/*
	 * Implementa el Singleton Pattern.
	 */
	private static SessionFactory getSessionFactory() {
		if (sessionFactory != null) {
			return sessionFactory;
		}

		registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml") // se carga la configuracion de
																						// Hibernate.
				.build();
		try {
			// se crea una fabrica de sessiones hibernate
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
			throw new Exceptions.DbException("Error inicializando Hibernate", ex);
		}

		return sessionFactory;
	}

	public static Session getSession() {
		return getSessionFactory().openSession();
	}
}
