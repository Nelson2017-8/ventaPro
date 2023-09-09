/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto_de_venta.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import com.google.gson.JsonObject;

/**
 *
 * @author Nelson
 */
public class activation {
    private final String SQLdelete = "";
    private final String SQLinsert = "INSERT INTO activation (nombre, clave) VALUES";
    private final String SQLupdate = "";
    private final String SQLconsult = "SELECT * FROM activation LIMIT 1";
    
    public boolean insertActivacion(String nombre, String clave){
        Connection conexion = null;
        Statement stmt = null;
        
        try{
            conexion = conn.conectar();
            stmt = conexion.createStatement();
            String sql = SQLinsert + "('"+ nombre +"', '"+ clave +"')";
            stmt.executeUpdate(sql);
            stmt.close();
            //conexion.commit();
            conn.cerrar(conexion);
            
        }catch(Exception e){
            System.err.println("Error de activacion");
            System.err.println(e.getClass().getName() + ": " + e.getMessage() );
            return false;
        }
        
        
        return true;
    }
    
    public int eliminarActivacion(long id){
        Connection conexion = null;
        Statement stmt = null;
        try{
            conexion = conn.conectar();
            stmt = conexion.createStatement();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return 0;
    }

    public JsonObject getActivacion(){
        Connection conexion = null;
        Statement stmt = null;
        JsonObject data = new JsonObject();
        
        try{
            conexion = conn.conectar();
            stmt = conexion.createStatement();
            String sql = SQLconsult;
            ResultSet rs = stmt.executeQuery(sql);
            
            while( rs.next() ){
                data.addProperty("id", rs.getInt("id"));
                data.addProperty("nombre", rs.getString("nombre"));
                data.addProperty("clave", rs.getString("clave"));
            }
            rs.close();
            stmt.close();
            conexion.close();
            
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage() );
        }
        
        
        return data;
    }
}
