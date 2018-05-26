package dao;

import domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    public void add(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/springy");
        PreparedStatement statement = connection.prepareStatement("INSERT INTO USER(id, password, name) VALUES(?, ?, ?)");
        statement.setLong(1, user.getId());
        statement.setString(2, user.getPasswd());
        statement.setString(3, user.getName());
        statement.executeUpdate();
        statement.close();;
        connection.close();
    }
}
