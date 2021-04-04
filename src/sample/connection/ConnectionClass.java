package sample.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
    public Connection connection;
    public Connection getConnection() {
        String dbName = "biblioteque";
        String userName = "saad";
        String password = "saad";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:8888/" +dbName,userName,password);
        }
        catch(Exception e ) {
            e.printStackTrace();
        }
        return connection;
    }
}