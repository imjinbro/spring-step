package dao;

import util.ConnectionMaker;
import util.DConnectionMaker;

public class DaoFactory {

    public static UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    public static AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    private static ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
