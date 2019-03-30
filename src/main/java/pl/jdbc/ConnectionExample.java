package pl.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Connection connection =
        DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC","root", "kubistycznykot");
    }
}
