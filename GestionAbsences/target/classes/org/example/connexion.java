

package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author DELL
 */
public class connexion {
    public  Connection connection;
    public  Connection getConnection(){
    String dbName="gestiondabsence";
    String user="root";
    String password="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,user,password);
        } catch (Exception ex) {
           System.out.print(ex); ;
        }
        return connection;
    }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
