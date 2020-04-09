package com.grounded.socials;

import com.grounded.socials.controllers.StoreController;
import com.grounded.socials.controllers.UserController;
import com.grounded.socials.services.StoreService;
import com.grounded.socials.services.UserService;
import com.grounded.socials.utils.DataSourceConnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

            Configuration configuration =  new Configuration().configure(new File("./hibernate.cfg.xml"));
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            Session session = sessionFactory.openSession();
            if (session.isOpen()) {
                return "connection established";
            } else {
                return "connection has not been established.";
            }

            /*try {
                Connection conn = DataSourceConnection.getDataSourceConnection().getDataSource().getConnection();
                if (conn != null) {
                    return "connection established";
                } else {
                    return "connection has not been established.";
                }
            } catch (SQLException e) {
                throw new ServletException("Unable to connect to Cloud SQL", e);
            }*/
        });

       /* new UserController(new UserService());
        new StoreController(new StoreService());*/
    }
    public static void main(String[] args) {
        new Application().init();
    }

    /*
    *  <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name="hibernate.connection.url">jdbc:mysql:///migrate_test?cloudSqlInstance=social-distancing-272013:europe-west1:mysql-test&amp;socketFactory=com.google.cloud.sql.mysql.SocketFactory</property>
        <property name="hibernate.connection.username">oliver</property>
        <property name="hibernate.connection.password">oliver123</property>


        <property name="show_sql">true</property>
    * */
}
