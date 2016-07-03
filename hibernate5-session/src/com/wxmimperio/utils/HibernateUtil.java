package com.wxmimperio.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by wxmimperio on 2016/7/3.
 */
public class HibernateUtil {
    private static ServiceRegistry registry = null;
    private static SessionFactory sessionFactory = null;
    private static Session session = null;
    private static Transaction transaction = null;

    static {
        try {
            registry = new StandardServiceRegistryBuilder().configure("/config/hibernate.cfg.xml").build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static Session getSession() {
        if (sessionFactory != null) {
            return sessionFactory.openSession();
        } else {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            return sessionFactory.openSession();
        }
    }

    public static Transaction getTransaction(Session session) {
        transaction = session.beginTransaction();
        if (transaction != null && session.isOpen()) {
            return transaction;
        } else {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            return transaction;
        }
    }

    public static void closeSession() {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null && sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }
}
