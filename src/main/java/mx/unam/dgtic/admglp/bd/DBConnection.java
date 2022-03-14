package mx.unam.dgtic.admglp.bd;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnection {

    Connection getConnection();

    void closeConnection(Connection conn) throws SQLException;

}
