package dao;

import domain.User;
import util.ConnectionMaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection connection = connectionMaker.make();
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
