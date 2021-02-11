package org.example.DAO;

import java.sql.SQLException;
import java.util.List;

public interface FormateurDao<T> {


    void insertAbsence(T item) throws Exception;


    T getEtudiantById(String id) throws SQLException, ClassNotFoundException;
    List<T> getAllAbsence() throws SQLException, ClassNotFoundException;


    void updateAbsence(String ab, String Dt, String jt, String id) throws SQLException, ClassNotFoundException;


    boolean deleteAbsence(int id) throws SQLException, ClassNotFoundException;
}
