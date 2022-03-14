package mx.unam.dgtic.admglp.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCUtil implements DBConnection {

    private static JDBCUtil instance;

    private JDBCUtil() {
    }

    public static JDBCUtil getInstance() {
        if (instance == null) {
            instance = new JDBCUtil();
        }
        return instance;
    }

    @Override
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(ResourceBundle.getBundle("admglp").getString("datasource.driverClassName"));
            conn = DriverManager
                    .getConnection(ResourceBundle.getBundle("admglp").getString("datasource.jdbcUrl"),
                            ResourceBundle.getBundle("admglp").getString("datasource.username"),
                            ResourceBundle.getBundle("admglp").getString("datasource.password"));
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERROR AL OBTENER LA CONEXION MYSQL=="
                    + ex.getMessage());
        }

        return conn;
    }

    @Override
    public void closeConnection(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

}
