package org.example.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.example.Model.Users;
import org.example.MysqlConnect.ConnectionClass;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImp implements UserDao{
    Connection conn;
    Users users = new Users();


    public void creatUser(String nom, String prenom, String password, String Email, String Tele, LocalDate date, Object role, String cin, String Specialite, String Sale, String promo) throws SQLException, ClassNotFoundException {
        //hash password
        //String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));

        try {
            conn = ConnectionClass.getMyConnexion();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO user (nom, prenom, password, mail, tele, dateDeNaissance, role) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, nom);
        preparedStatement.setString(2, prenom);
        preparedStatement.setString(3, password);
        preparedStatement.setString(4, Email);
        preparedStatement.setString(5, Tele);
        preparedStatement.setString(6, String.valueOf(date));
        preparedStatement.setString(7, String.valueOf(role));
        preparedStatement.executeUpdate();
        ResultSet rs = preparedStatement.getGeneratedKeys();

        System.out.println("User cree");






        if (role == "Formateur" && rs.next()) {
            users.setId_user(rs.getInt(1));
            String qr = "INSERT INTO formateur (id_user) VALUES (?)";
            PreparedStatement preparedStatement1 = conn.prepareStatement(qr);


            preparedStatement1.setInt(1, users.getId_user());
            preparedStatement1.executeUpdate();
            System.out.println("Inser Formateur");
        }

    }

    @Override
    public void updateUser(int id_user, String nom, String prenom, String password, String email, String tele, LocalDate dateNaissance, Object role, String cin, String Specialite, String Sale, String promo) throws SQLException {

    }

    @Override
    public void deleteUser(int id, Object role) throws SQLException {

    }



    @Override
    public ObservableList<Users> getUsersList()  {
        ObservableList<Users> usersList = FXCollections.observableArrayList();

        try {
            conn = ConnectionClass.getMyConnexion();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        String query = "SELECT * FROM user";

        Statement st;
        ResultSet rs;
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Users users;
            while (rs.next()){
                users = new Users(rs.getInt("id_user"),rs.getString("nom"),rs.getString("prenom"),rs.getString("password"), rs.getString("mail"), rs.getString("tele"), rs.getString("dateDeNaissance"), rs.getString("role"));
                usersList.add(users);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return usersList;
    }



}