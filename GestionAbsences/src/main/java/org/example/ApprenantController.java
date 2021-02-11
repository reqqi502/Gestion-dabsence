package org.example;
import org.example.Model.Administrateur;
import javafx.fxml.FXML;


import javafx.scene.control.*;
import javafx.stage.Stage;
import java.awt.event.ActionEvent;

import java.sql.Statement;
import java.sql.Connection;


public class ApprenantController {

    Connection connection;
    Statement statement;
    Stage stage;

    @FXML
    private Button btnBack;

    @FXML
    private Label apprenant_nom;

    @FXML
    private Label nbrAbsence;

    @FXML
    private TableView<?> TableAffiche;

    @FXML
    private TableColumn<?, ?> colabsence;

    @FXML
    private TableColumn<?, ?> coljust;

    @FXML
    private TableColumn<?, ?> coldateAbsence;

    @FXML
    void Logoutbtn (ActionEvent event){


    }

    @FXML
    void affichagest(ActionEvent event) {

        try {
            connexion con = new connexion();
            Connection cnx = con.getConnection();
            String sql = "select * from user";
            statement = cnx.createStatement();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("thats not truuue ther is a problem to solve try again !!");
        }
    }

}





