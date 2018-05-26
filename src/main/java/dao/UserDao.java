package dao;

import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class UserDao {

    abstract Connection getConnection() throws ClassNotFoundException, SQLException;

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO USER(id, password, name) VALUES(?, ?, ?)");
        statement.setLong(1, user.getId());
        statement.setString(2, user.getPasswd());
        statement.setString(3, user.getName());
        statement.executeUpdate();
        statement.close();
        ;
        connection.close();
    }
}
