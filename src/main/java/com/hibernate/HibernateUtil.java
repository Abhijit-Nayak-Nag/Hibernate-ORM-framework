package com.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    public static StandardServiceRegistry registry;
    public static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
        if (sessionFactory==null){
            try{
                registry= new StandardServiceRegistryBuilder().configure().build();
                MetadataSources sources= new MetadataSources(registry);
                Metadata metadata=sources.getMetadataBuilder().build();
                sessionFactory= metadata.getSessionFactoryBuilder().build();
            }catch (Exception e){
                System.out.println(e);

            }
        }
        return sessionFactory;
    }
}


