package daos;

import com.mysql.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://localhost:3306/car?autoReconnect=true&useSSL=false";
    public static final String USER = "angelina";
    public static final String PASSWORD = "Ammu";

    /**
     * Get a connection to database
     *
     * @return ConnectionFactory object
     */
    public static java.sql.Connection getConnection()
    {
        try {
            DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    /**
     * Test ConnectionFactory
     */
    public static void main(String[] args) {
    }

}