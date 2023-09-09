/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto_de_venta.db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;


public class create {
    private static final String ACTIVATION_TABLE = "CREATE TABLE IF NOT EXISTS activation(id INTEGER PRIMARY KEY, nombre TEXT NOT NULL, clave TEXT NOT NULL)";
    private static final String TASAS_TABLE = "CREATE TABLE IF NOT EXISTS tasas(id INTEGER PRIMARY KEY, nombre TEXT NOT NULL, tasa REAL NOT NULL, fecha_hora TEXT NOT NULL)";
    private static final String CONFIG_TABLE = "CREATE TABLE IF NOT EXISTS config(id INTEGER PRIMARY KEY, name TEXT NOT NULL, valor TEXT NOT NULL)";
    
    private static void createTable(String TABLE) throws SQLException{
        Connection connection = conn.conectar();
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(TABLE);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if (connection!=null){
                try{
                    connection.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            } 
        }
    }
    
    public static void database() throws SQLException {
        createTable(ACTIVATION_TABLE);
        createTable(TASAS_TABLE);
        createTable(CONFIG_TABLE);
    }
}
