package com.grounded.socials.services;

import com.grounded.socials.utils.DatabaseSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class StoreService {

    private Connection connection;

    public StoreService() {
        /*DataSource pool = DatabaseSource.getDatabaseSource().getDataSource();
        try {
            connection = pool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
