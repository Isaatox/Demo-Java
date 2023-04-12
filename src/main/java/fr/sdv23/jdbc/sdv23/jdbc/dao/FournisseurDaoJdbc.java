package fr.sdv23.jdbc.sdv23.jdbc.dao;

import fr.sdv23.jdbc.sdv23.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurDaoJdbc implements FournisseurDao{
    private static final String DB_URL;
    private static final String DB_NAME;
    private static final String DB_PWD;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_NAME = bundle.getString("db.user");
        DB_PWD = bundle.getString("db.password");
    }

    @Override
    public List<Fournisseur> findAll() throws SQLException {
        List<Fournisseur> fournisseurs = new ArrayList();
        try(Connection cnx = DriverManager.getConnection(DB_URL, DB_NAME, DB_PWD);
            PreparedStatement pst = cnx.prepareStatement("SELECT * FROM fournisseur");
            ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                fournisseurs.add(new Fournisseur(rs.getInt("ID"), rs.getString("NOM")));
            }
        }
        return fournisseurs;
    }


    @Override
    public void insert(Fournisseur fournisseur) throws SQLException {
        try (Connection cnx = DriverManager.getConnection(DB_URL, DB_NAME, DB_PWD);
             PreparedStatement ps = cnx.prepareStatement("INSERT INTO fournisseur (NOM) VALUES (?)")) {

            ps.setString(1, fournisseur.getNom());
            int nb = ps.executeUpdate();
            System.out.println(nb);
        }
    }

    @Override
    public void update(String ancienNom, String nouveauNom) throws SQLException {
        try(Connection cnx = DriverManager.getConnection(DB_URL, DB_NAME, DB_PWD);
            PreparedStatement ps = cnx.prepareStatement("UPDATE fournisseur SET NOM = ? WHERE NOM = ?");) {

            ps.setString(1, nouveauNom);
            ps.setString(2, ancienNom);

            int nb = ps.executeUpdate();
            System.out.println(nb);
        }
    }

    @Override
    public void delete(Fournisseur fournisseur) throws SQLException {
        try(Connection cnx = DriverManager.getConnection(DB_URL, DB_NAME, DB_PWD);
            PreparedStatement ps = cnx.prepareStatement("DELETE FROM fournisseur WHERE NOM = ?");) {

            ps.setString(1, fournisseur.getNom());

            int nb = ps.executeUpdate();
            System.out.println(nb);
        }
    }
}
