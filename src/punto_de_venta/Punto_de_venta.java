/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package punto_de_venta;

import java.sql.SQLException;
import punto_de_venta.db.create;
import punto_de_venta.ui.login;
import punto_de_venta.controllers.loginController;
import punto_de_venta.ui.home;
/**
 *
 * @author Nelson
 */
public class Punto_de_venta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        // creata la base de datos
        create.database();
        
        // activacion
        if(loginController.veryLogin()){
            login.main(args);
        }else{
            home.main(args);
        }
        
        
        
    }
    
}
