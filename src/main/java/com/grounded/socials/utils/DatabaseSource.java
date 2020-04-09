package com.grounded.socials.utils;

import com.grounded.socials.models.Store;
import com.grounded.socials.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class DatabaseSource {

    private static DatabaseSource instance;
    private static SessionFactory sessionFactory;

    private DatabaseSource() {
    }

    public static DatabaseSource getInstance() {
        if (instance == null) {
            instance = new DatabaseSource();
            try {
                Configuration configuration = new Configuration();
                configuration.configure(new File("./hibernate.cfg.xml"))
                .addAnnotatedClass(User.class).addAnnotatedClass(Store.class);

                sessionFactory = configuration.buildSessionFactory();
            } catch (Throwable ex) {
                throw new ExceptionInInitializerError(ex);
            }
        }
        return instance;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}