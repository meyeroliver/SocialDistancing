package com.grounded.socials;

import com.grounded.socials.controllers.StoreController;
import com.grounded.socials.controllers.UserController;
import com.grounded.socials.services.StoreService;
import com.grounded.socials.services.UserService;
import com.grounded.socials.utils.DataSourceConnection;
import spark.servlet.SparkApplication;

import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.SQLException;

import static spark.Spark.*;

public class Application implements SparkApplication {

    @Override
    public void init() {

        get("/", (request, response)
                -> "Hello Hello Hello."/*"Soul Brother Number 1 + 1. Getting Fed, like where the hell guns and drugs come from."*/);

        get("/connect", (request, response) -> {

            try {
                Connection conn = DataSourceConnection.getDataSourceConnection().getDataSource().getConnection();
                if (conn != null) {
                    return "connection established";
                } else {
                    return "connection has not been established.";
                }
            } catch (SQLException e) {
                throw new ServletException("Unable to connect to Cloud SQL", e);
            }
        });

        new UserController(new UserService());
        new StoreController(new StoreService());
    }
    public static void main(String[] args) {
        new Application().init();
    }
}
