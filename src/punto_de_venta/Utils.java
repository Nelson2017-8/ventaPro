/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package punto_de_venta;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;

public class Utils {
    public static void copiarAlPortapapeles(String texto){
        //String texto = "Texto a copiar en el portapapeles";
        StringSelection seleccion = new StringSelection(texto);
        Clipboard portapapeles = Toolkit.getDefaultToolkit().getSystemClipboard();
        
        portapapeles.setContents(seleccion, null);
    }
    
    public static String copiarDesdePortapapeles(){
        Clipboard portapapeles = Toolkit.getDefaultToolkit().getSystemClipboard();
        try{
            String text = (String) portapapeles.getData(DataFlavor.stringFlavor);
            return text;
            
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage() );
            e.printStackTrace();
        }
        return "";
    }
}
