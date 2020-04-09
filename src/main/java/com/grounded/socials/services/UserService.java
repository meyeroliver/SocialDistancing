package com.grounded.socials.services;

import com.grounded.socials.models.User;
import com.grounded.socials.utils.DataSourceConnection;
import lombok.NonNull;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private Connection connection;

    public UserService() {
        DataSource pool = DataSourceConnection.getDataSourceConnection().getDataSource();
        try {
            connection = pool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement query = connection.prepareStatement("select * from users");
            ResultSet resultSet = query.executeQuery();
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(6), resultSet.getString(5), resultSet.getFloat(7),
                        resultSet.getFloat(8)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //users.add(new User(1,"oliver", "meyer","home", "0762598650", 0,0));
        return users;
    }

    public User getUser(int id) {
        return null;
    }

    public User createUser(String firstname, String lastname,
                           String address, @NonNull String cellPhone,
                           float latitude, float longitude){
        return null;
    }
}
