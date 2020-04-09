package com.grounded.socials.services;

import com.grounded.socials.models.Store;
import com.grounded.socials.utils.DatabaseSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class StoreService {

    private SessionFactory sessionFactory;

    public StoreService() {
        sessionFactory = DatabaseSource.getSessionFactory();
    }

    public Store getStoreById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Store store =  session.get(Store.class, id);
        transaction.commit();
        return store;
    }
}
