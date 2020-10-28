package com.aps.cc.unip.DAO;

//import com.aps.cc.unip.model.Author;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//
//public class HibernateConnection {
//    private static SessionFactory sessionFactory;
//    public HibernateConnection() {
//    }
//    public Session openSession() {
//        if (sessionFactory == null) {
//            criaSessionFactory();
//        }
//        return sessionFactory.openSession();
//    }
//    public void criaSessionFactory() {
//        Configuration configuration = new Configuration();
//        configuration.addAnnotatedClass(Author.class);
//        ServiceRegistry serviceRegistry = new
//                StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).
//                build();
//        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//    }
//}
