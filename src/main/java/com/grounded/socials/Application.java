package com.grounded.socials;

import com.grounded.socials.controllers.StoreController;
import com.grounded.socials.controllers.UserController;
import com.grounded.socials.models.User;
import com.grounded.socials.services.StoreService;
import com.grounded.socials.services.UserService;
import com.grounded.socials.utils.DataSourceConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import spark.servlet.SparkApplication;

import javax.servlet.ServletException;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;

import static spark.Spark.*;

public class Application implements SparkApplication {

    @Override
    public void init() {

        get("/", (request, response)
                -> "Hello Hello Hello."/*"Soul Brother Number 1 + 1. Getting Fed, like where the hell guns and drugs come from."*/);

        get("/connect", (request, response) -> {

            Configuration configuration =  new Configuration()
                    .configure(new File("./hibernate.cfg.xml"))
                    .addAnnotatedClass(User.class);
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            if (session.isOpen()) {
                Transaction transaction = session.beginTransaction();
                session.save(new User(2, "Okay", "Okay",
                        "Okay","Okay","Okay", 0L, 0L));
                transaction.commit();

                return "connection established";
            } else {
                return "connection has not been established.";
            }
        });
       /* new UserController(new UserService());
        new StoreController(new StoreService());*/
    }
    public static void main(String[] args) {
        new Application().init();
    }
}
