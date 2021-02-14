package org.example;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;






public class SecondaryController {
    private Label label;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private Button btnConnexion;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    public void connexion(ActionEvent actionEvent) {
        DatabaseConnection dbc=new DatabaseConnection();
        dbc.authentification(actionEvent,email.getText(),password.getText());
    }
    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    /**
     *
     * @author DELL
     */
    public class FXMLDocumentController implements Initializable {
        Connection connection;
        Statement statement;
        private Label label;
        @FXML
        private TextField email;
        @FXML
        private TextField password;
        @FXML
        private Button btnConnexion;



        @Override
        public void initialize(URL url, ResourceBundle rb) {
            // TODO
        }




    }

}