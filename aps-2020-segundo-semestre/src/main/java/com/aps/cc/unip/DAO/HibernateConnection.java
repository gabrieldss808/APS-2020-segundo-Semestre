package com.aps.cc.unip.DAO;

import com.aps.cc.unip.model.Authors;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateConnection {
    private static SessionFactory sessionFactory;

    public HibernateConnection() {
    }

    public Session openSession() {
        if (sessionFactory == null) {
            createSessionFactory();
        }
        return sessionFactory.openSession();
    }

    private void createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Authors.class);
        ServiceRegistry serviceRegistry = new
                StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).
                build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
}
