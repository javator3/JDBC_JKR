package pl.jdbc;

import java.sql.*;
import java.util.Random;

public class StatementExamples {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection =
        DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC",
                "root", "kubistycznykot");
//        createTable(connection);
//        insert5newEmployees(connection);
//        insert5newEmplyees2(connection);
//        dropTable(connection);
//        dropLessThan(connection, 1000);
        selectNameAndSalaryFromTable(connection);
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

    static void insert5newEmplyees2(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection
        .prepareStatement("INSERT INTO employee9 (name, salary) values (?, ?)");
        for (int i = 0; i <5 ; i++) {
            preparedStatement.setString(1, "imie" + i);
            preparedStatement.setInt(2, new Random().nextInt(2000));
            preparedStatement.executeUpdate();

        }
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

    //napisz metode, która usunie pracownikow, których zarobki są
    //mniejsze niż argument podany w metodzie

    static void dropLessThan (Connection connection, int salary) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("delete from employee9 where salary < ?");
        preparedStatement.setInt(1, salary);
        // bez drugiego argumentu po connection to wtedy w setInt np (1, 1000 )
        preparedStatement.executeUpdate();
    }

    static void selectNameAndSalaryFromTable(Connection connection) throws SQLException{
        Statement statement =  connection.createStatement();
        ResultSet resultSet = statement
                .executeQuery("SELECT name, salary from employee9");

        while (resultSet.next()){
            String name = resultSet.getString("name");
            int salary = resultSet.getInt(2);
            System.out.println(name+ " "+salary);
        }
    }
}
