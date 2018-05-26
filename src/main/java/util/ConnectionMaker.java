package util;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {

    Connection make() throws ClassNotFoundException, SQLException;
}
