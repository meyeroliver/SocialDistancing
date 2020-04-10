package com.grounded.socials.services;

import com.grounded.socials.models.User;
import com.grounded.socials.utils.DatabaseSource;
import lombok.NonNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private SessionFactory sessionFactory;

    public UserService() {
        DatabaseSource databaseSource =  DatabaseSource.getInstance();
        sessionFactory = DatabaseSource.getSessionFactory();
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        return users;
    }

    public User getUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        User user =  (User) session.get(User.class, id);
        transaction.commit();
        return user;
    }

    public User createUser(String firstname, String lastname,
                           String address, @NonNull String cellPhone,
                           float latitude, float longitude){
        return null;
    }
}
