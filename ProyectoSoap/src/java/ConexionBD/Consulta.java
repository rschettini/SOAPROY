/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Jelkin Diaz
 */
public class Consulta extends Conexion{
    public boolean autetication(String usuario, String contraseña){
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            
            String consulta = "select * from usuario where usuario = ? and pass = ? ";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, contraseña);
            rs = pst.executeQuery();
            
            if (rs.absolute(1)){
                return true;
            }
            
        }catch(Exception e){
            System.err.println("Error"+ e);
        }finally{
            try{
             if (getConexion() != null) getConexion().close();
            
            
            }catch(Exception e){
                System.err.println("Error"+ e); 
          }
        }
        
        
        return false;
    }
}

