package com.grounded.socials.services;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.grounded.socials.models.Store;
import com.grounded.socials.models.User;
import com.grounded.socials.utils.DatabaseSource;
import lombok.NonNull;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import static com.grounded.socials.utils.JsonUtil.*;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private SessionFactory sessionFactory;

    public UserService() {
        sessionFactory = DatabaseSource.getSessionFactory();
    }

    public List<User> getAllUsers(){
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM User");
        List<User> userList = query.list();
        transaction.commit();
        return userList;
    }

    public User getUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        User user =  (User) session.get(User.class, id);
        transaction.commit();
        return user;
    }

    public void createUser(String firstname, String lastname,
                           String address, @NonNull String cellPhone,
                           float latitude, float longitude){
    }

    public boolean createUser(String body){
        try {
            Session session = sessionFactory.getCurrentSession();
            Transaction transaction = session.beginTransaction();
            User user = objectMapper().readValue(body, User.class);
            session.persist(user);
            transaction.commit();
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateUser(int id, String body) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Transaction transaction = session.beginTransaction();
            User user = objectMapper().readValue(body, User.class);
            user.setId(id);
            session.update(user);
            transaction.commit();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Integer deleteUser(int id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM User WHERE id = :id");
            query.setParameter("id", id);
            int deleted = query.executeUpdate();
            transaction.commit();
            return deleted;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }
}
