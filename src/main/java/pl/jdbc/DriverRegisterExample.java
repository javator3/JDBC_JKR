package pl.jdbc;

public class DriverRegisterExample {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }
}
