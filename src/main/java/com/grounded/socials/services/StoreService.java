package com.grounded.socials.services;

import com.grounded.socials.utils.DataSourceConnection;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class StoreService {

    private Connection connection;

    public StoreService() {
        DataSource pool = DataSourceConnection.getDataSourceConnection().getDataSource();
        try {
            connection = pool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
