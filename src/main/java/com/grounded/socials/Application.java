package com.grounded.socials;

import com.grounded.socials.controllers.StoreController;
import com.grounded.socials.controllers.UserController;
import com.grounded.socials.models.Store;
import com.grounded.socials.models.User;
import com.grounded.socials.services.StoreService;
import com.grounded.socials.services.UserService;
import com.grounded.socials.utils.DatabaseSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import spark.servlet.SparkApplication;

import javax.sql.DataSource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

public class Application implements SparkApplication {

    @Override
    public void init() {

        /**
         * init database connection
         */
        DatabaseSource.getInstance();


        get("/", (request, response)
                -> "Hello Hello Hello."/*"Soul Brother Number 1 + 1. Getting Fed, like where the hell guns and drugs come from."*/);
        get("/connect", (request, response) -> {
            Session session = DatabaseSource.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();

            Store store = new Store("SUPERSPAR The Vineyard, Paarl",
                "7646 Main Road Paarl,Shop 1, Vineyard Centre, 57, Cape Town, 7620",
                -33.763f, 18.9621f);

            User user = new User( "oh-meyer", "Oliver", "Meyer",
                "6 Clift Street, Suider Paarl, Paarl, 7624", "0762598650",
                -33.7634f, 18.9621f);

            user.getStores().add(store);
            store.getUsers().add(user);

            session.save(store);
            session.save(user);
            transaction.commit();
            return "awe";
        });

        new UserController(new UserService());
        new StoreController(new StoreService());
    }
    public static void main(String[] args) {
        new Application().init();
    }
}
