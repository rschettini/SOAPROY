/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jelkin Diaz
 */
public class Conexion {
    private String username = "root";
    private String password = "123456";
    private String host = "localhost";
    private String port = "3306";
    private String database = "login";
    private String classname = "com.mysql.jdbc.driver";
    private String url = "jdbc:mysql://"+host+":"+port+"/"+database;
    private java.sql.Connection con;
    
    public Conexion(){
        try{
        Class.forName(classname);
        con = DriverManager.getConnection(url, username, password);
        
        
    }catch(ClassNotFoundException | SQLException e){
            System.out.println("ERROR"+e);
        }
        }
    public Connection getConexion(){
        return (Connection) con;
      
    
    
    }
    public static void main(String[] args) {
        Conexion con = new Conexion();
    }
    
}
    
