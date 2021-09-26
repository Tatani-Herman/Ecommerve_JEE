/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author USER
 */
public class hibernateCurrentSession {
    private static SessionFactory session;
    public static SessionFactory getSessionFactory() throws HibernateException
    {
        Configuration config = new Configuration().configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        session = config.buildSessionFactory(serviceRegistry);
        return session;
    }
    
    
    
    
}
