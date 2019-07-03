package decipher.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnection {

    public static Connection getDbConnection () {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentRecord", "root", "root");
        } catch (Exception e)
        {
            System.out.println(e);
        }
        return connection;
    }
}
