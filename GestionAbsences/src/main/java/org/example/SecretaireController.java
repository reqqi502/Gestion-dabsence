package org.example;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.time.LocalDate;


public class SecretaireController {


    String role;
    Connection connexion;
    Statement statement;
    Stage stage;


    @FXML
    private TextField Cin;

    @FXML
    private Button btnConnexion;

    @FXML
    private TextField nom;

    @FXML
    private PasswordField Password;

    @FXML
    private RadioButton appbtn;

    @FXML
    private ToggleGroup Role;

    @FXML
    private RadioButton staffbtn;

    @FXML
    private TextField prenom;

    @FXML
    private TextField Email;

    @FXML
    private MenuButton Promotion;

    @FXML
    private TextField msg;

    @FXML
    private RadioButton secrbtn;

    @FXML
    private TextField tele;

    @FXML
    private DatePicker dates;

        @FXML

        PreparedStatement pst = null;


    public void BtnRegistrement(javafx.event.ActionEvent actionEvent) {

        try{
            connexion con = new connexion();
            Connection cnx=con.getConnection();
            pst= cnx.prepareStatement("INSERT INTO `user`(`id_user`, `nom`, `prenom`, `password`, `mail`, `tele`, `dateDeNaissance`, `role`) VALUES (?,?,?,?,?,?,?,?)");
            pst.setString(1 , null);
            pst.setString(2, nom.getText());
            pst.setString(3 , prenom.getText());
            pst.setString(4 , Password.getText());
            pst.setString(5 , Email.getText());
            pst.setString(6 , tele.getText());
            pst.setDate(7 , java.sql.Date.valueOf(dates.getValue()));
            pst.setString(8 , role);
            int status = pst.executeUpdate();
            if(status==1){
                msg.setText("user added succefully");
            }
        }
        catch(Exception e){
            msg.setText("user not addeeed !!!");

        }
    }

    public void apprenant(javafx.event.ActionEvent actionEvent) {
        if (Role.getSelectedToggle().equals(appbtn)) {
            role = "apprenant";
            System.out.println(role);
        }
    }

    public void staff(javafx.event.ActionEvent actionEvent) {

        if (Role.getSelectedToggle().equals(staffbtn)) {
            role = "Formateur";
            System.out.println(role);
        }
    }

    public void First(javafx.event.ActionEvent actionEvent) {
    }

    public void last(javafx.event.ActionEvent actionEvent) {
    }

    public void secraitaire(javafx.event.ActionEvent actionEvent) {
        if (Role.getSelectedToggle().equals(secrbtn)) {
            role = "Secraitaire";
            System.out.println(role);
        }
    }

    public void logout(javafx.event.ActionEvent actionEvent) {
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
}











