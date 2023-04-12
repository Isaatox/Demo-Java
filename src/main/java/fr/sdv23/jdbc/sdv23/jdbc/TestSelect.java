package fr.sdv23.jdbc.sdv23.jdbc;

import fr.sdv23.jdbc.sdv23.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TestSelect {

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
            Statement monStatement = cnx.createStatement(); ResultSet curseur = monStatement.executeQuery("SELECT * FROM fournisseur"); ) {

            ArrayList<Fournisseur> fournisseurs = new ArrayList<>();

            while (curseur.next()){
                Integer id = curseur.getInt("ID");
                String nom = curseur.getString("NOM");

                Fournisseur fournisseurCourant = new Fournisseur(id, nom);
                fournisseurs.add(fournisseurCourant);
            }
            for (Fournisseur fournisseur : fournisseurs){
                System.out.println(fournisseur.toString());
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
