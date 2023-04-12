package fr.sdv23.jdbc.sdv23.jdbc.dao;

import fr.sdv23.jdbc.sdv23.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public interface FournisseurDao {
    List<Fournisseur> findAll() throws SQLException;
    void insert(Fournisseur fournisseur) throws SQLException;
    void update(String ancienNom, String nouveauNom) throws SQLException;
    void delete(Fournisseur fournisseur) throws SQLException;
}
