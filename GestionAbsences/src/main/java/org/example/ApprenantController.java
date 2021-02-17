package org.example;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.Model.Absence;
import javafx.fxml.FXML;


import javafx.scene.control.*;
import javafx.stage.Stage;
import java.awt.event.ActionEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    private TableView<Absence> TableAffiche;

    @FXML
    private TableColumn<Absence,String> colabsence;

    @FXML
    private TableColumn<Absence,String> coljust;

    @FXML
    private TableColumn<Absence,String> coldateAbsence;

    @FXML
    void Logoutbtn (ActionEvent event){


    }



    public void Logoutbtn(javafx.event.ActionEvent actionEvent) {
        try {
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("Login.fxml"));
            Parent PageFormateur=loader.load();
            Scene s = new Scene(PageFormateur);
            Stage page=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            page.setScene(s);
            page.show();
        } catch (Exception e) {

            System.out.println(e);
        }
    }

    public void affichagest(javafx.event.ActionEvent actionEvent) throws SQLException {
        ObservableList<Absence> oboist = FXCollections.observableArrayList();
        connexion con = new connexion();
        Connection cnx=con.getConnection();
        String  sql = "select * from absence where id_appr ='HH2131'";
        statement=cnx.createStatement();

        try(ResultSet res = statement.executeQuery(sql)){
            while (res.next()){


            int id_absence = res.getInt(1);
            String absence = res.getString(2);
            String date = res.getString(3);
                System.out.println(date);
            String justification = res.getString(4);
            String id_appr = res.getString(5);
                oboist.add(new Absence(id_absence, absence, date, justification, id_appr));



                colabsence.setCellValueFactory(new PropertyValueFactory<>("absence"));
                coljust.setCellValueFactory(new PropertyValueFactory<>("justification"));
                coldateAbsence.setCellValueFactory(new PropertyValueFactory<>("date"));
                TableAffiche.setItems(oboist);

        }

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("thats not truuue ther is a problem to solve try again !!");
        }


        String sql1 = "select * from user";
        statement = cnx.createStatement();
        try(ResultSet res = statement.executeQuery(sql1)) {
            while (res.next()) {


                apprenant_nom.setText(res.getString(2));
            }
        }






    }

}











