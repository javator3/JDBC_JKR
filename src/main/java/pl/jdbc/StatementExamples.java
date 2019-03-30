package pl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementExamples {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection =
        DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC",
                "root", "kubistycznykot");
//        createTable(connection);
//        insert5newEmployees(connection);
        dropTable(connection);
    }

    static void createTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement = connection.createStatement();
               statement .execute("CREATE TABLE employee9 ( \n" +
                       " id smallint not null auto_increment, \n" +
                       "name varchar(50), \n" +
                       " salary int, \n" +
                       " primary key (id))");

    }

    static void insert5newEmployees(Connection  connection) throws SQLException{
        Statement statement = connection.createStatement();
        for (int i = 0; i < 5; i++) {
           String formattedString = String.format("INSERT INTO employee9(name, salary) values ('name%s', 1234)", i);
//            statement.executeUpdate("INSERT INTO employee9(name, salary) values ('name "+i+" 1234)");
            statement.executeUpdate(formattedString);
        }
    }

    static  void dropTable(Connection connection) throws SQLException{
        Statement statement = connection.createStatement();
        statement.execute("DROP TABLE  employee9");
    }
}
