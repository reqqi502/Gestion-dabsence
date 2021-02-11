package org.example.test;

import org.example.DAO.FormateurDaoImp;
import org.example.Model.Absence;


import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        FormateurDaoImp hanae = new FormateurDaoImp();



        //Afficher la liste des absence
        List<Absence> absenceList = hanae.getAllAbsence();

        System.out.println("-----------------------------------");

        for(Absence absence : absenceList)
        {
            System.out.println(absence.getId_absence());
            System.out.println(absence.getAbsence());
            System.out.println(absence.getDate());
            System.out.println(absence.getJustification());
            System.out.println(absence.getId_appr());

        }

        System.out.println("-----------------------------------");

        //Afficher un seul etudiant
        Absence absence = hanae.getEtudiantById("h451528");


        System.out.println(absence.getId_absence());
        System.out.println(absence.getAbsence());
        System.out.println(absence.getDate());
        System.out.println(absence.getJustification());
        System.out.println(absence.getId_appr());

        System.out.println("-----------------------------------");
    }

}
