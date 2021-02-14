package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	private String url;
	private String user;
	private String pwd;
        private  Connection conx;

	Connection con;
	public Database(){
		super();
		this.url = "jdbc:mysql://localhost:3306/gestiondabsence";
		this.user = "root";
		this.pwd = "";
	}
        /* public  Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
             conx=DriverManager.getConnection("jdbc:mysql://localhost/"+this.url,this.user,this.pwd);
        } catch (Exception ex) {
           System.out.print(ex); ;
        }
        return conx;
    }*/
}
