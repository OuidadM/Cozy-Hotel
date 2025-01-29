package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnectivity {
    private Connection connection;
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cozy-hotel", "root", "");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error while connecting to database: " + e.getMessage());
        }
        return connection;
    }

    public void closeConnection() {
        if(connection != null) {
            try{
                connection.close();
            }
            catch (SQLException e) {
                System.err.println("Error while closing connection: " + e.getMessage());
            }
        }
    }

}
