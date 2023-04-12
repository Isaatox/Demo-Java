package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnexionJdbc {
//    private static final String DB_URL = "jdbc:mariadb://localhost:3306/compta";
//    private static final String DB_NAME = "root";
//    private static final String DB_PWD = "";

    private static final String DB_URL;
    private static final String DB_NAME;
    private static final String DB_PWD;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_NAME = bundle.getString("db.user");
        DB_PWD = bundle.getString("db.password");
    }

    public static void main(String[] args) {

        try(Connection cnx = DriverManager.getConnection(DB_URL, DB_NAME, DB_PWD)) {
            System.out.println(cnx);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
