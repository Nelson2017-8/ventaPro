/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto_de_venta.controllers;

import com.google.gson.JsonObject;
import punto_de_venta.db.activation;

public class loginController {
    public static boolean veryLogin(){
        //var conectar = conn.conectar();
        activation act = new activation();
        JsonObject data = act.getActivacion();
        System.out.println(data);
        if( data.get("id") == null ) {
            return true;
        } 
        return false;
    }
    
    public boolean save(String nombre, String clave){
        activation act = new activation();
        
        return act.insertActivacion(nombre, clave);
    }

}
