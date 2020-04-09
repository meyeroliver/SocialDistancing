package com.grounded.socials;

import com.grounded.socials.controllers.StoreController;
import com.grounded.socials.controllers.UserController;
import com.grounded.socials.services.StoreService;
import com.grounded.socials.services.UserService;
import com.grounded.socials.utils.DatabaseSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import spark.servlet.SparkApplication;

import javax.sql.DataSource;
import java.io.File;

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
            if (DatabaseSource.getSessionFactory().isOpen()) {
                return "connection established";
            } else {
                return "connection has not been established.";
            }
        });

        new UserController(new UserService());
        new StoreController(new StoreService());
    }
    public static void main(String[] args) {
        new Application().init();
    }
}
