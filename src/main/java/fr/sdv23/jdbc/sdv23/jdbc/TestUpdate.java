package fr.sdv23.jdbc.sdv23.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestUpdate {
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

        try(Connection cnx = DriverManager.getConnection(DB_URL, DB_NAME, DB_PWD);
            Statement monStatement = cnx.createStatement(); ) {
            monStatement.executeUpdate("UPDATE fournisseur SET Nom = 'Hugo LPB' WHERE Nom='John DOE'");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
