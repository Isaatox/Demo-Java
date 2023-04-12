package org.example;

import fr.sdv23.jdbc.sdv23.jdbc.dao.FournisseurDao;
import fr.sdv23.jdbc.sdv23.jdbc.dao.FournisseurDaoJdbc;
import fr.sdv23.jdbc.sdv23.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){
        try {
            FournisseurDao dao = new FournisseurDaoJdbc();
            List<Fournisseur> fournisseurs = dao.findAll();
//            dao.insert(new Fournisseur(6,"Test"));
            dao.insert(new Fournisseur("L’Espace Création"));
            fournisseurs.forEach(System.out::println);
        } catch ( SQLException e ) {
            throw new RuntimeException(e);
        }
    }
}