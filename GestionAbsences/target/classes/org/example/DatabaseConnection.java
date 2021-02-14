package org.example;
import org.example.Model.Administrateur;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.Model.Apprenant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class DatabaseConnection {
 Connection connection; 
 Statement statement;
 Stage stage;


public void authentification(ActionEvent event, String email, String password) {

          Administrateur administrateur;
          
          
try {
        connexion con = new connexion();
      Connection cnx=con.getConnection();
    String  sql="select * from user where mail='"+email+"' and password='"+password+"'";
        statement=cnx.createStatement();
    try (ResultSet res = statement.executeQuery(sql)) {
        if (res.next()) {


            if (res.getString("role").equals("Admin")) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("AdminCRUD.fxml"));
                Parent PageFormateur = loader.load();
                Scene s = new Scene(PageFormateur);
                Stage page = (Stage) ((Node) event.getSource()).getScene().getWindow();
                page.setScene(s);
                page.show();

            }

            if (res.getString("role").equals("Formateur")) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("primary.fxml"));
                Parent PageFormateur = loader.load();
                Scene s = new Scene(PageFormateur);
                Stage page = (Stage) ((Node) event.getSource()).getScene().getWindow();
                page.setScene(s);
                page.show();

            }
            if (res.getString("role").equals("apprenant")) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("Apprenant.fxml"));
                Parent PageFormateur = loader.load();
                Scene s = new Scene(PageFormateur);
                Stage page = (Stage) ((Node) event.getSource()).getScene().getWindow();
                page.setScene(s);
                page.show();


            }
            else{
                System.out.println("thats not truuue !");
            }


        }
    }
} catch(Exception e) {
            e.printStackTrace();
        }

}

}