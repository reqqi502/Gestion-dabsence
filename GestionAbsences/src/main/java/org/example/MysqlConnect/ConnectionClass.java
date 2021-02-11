package org.example.MysqlConnect;


import javax.swing.*;
import java.sql.*;

public class ConnectionClass{


    static String url = "jdbc:mysql://localhost/gestiondabsence?serverTimezone=UTC";
    static String utilisateur = "root";
    static String password = "";
    static Connection connection;

    public static Connection getMyConnexion() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Pilote de la base de donnees est charge");
        connection = DriverManager.getConnection(url, utilisateur, password);
        System.out.println("La connexion a est bien etablie");

        return connection;
    }
}
