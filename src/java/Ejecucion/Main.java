/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecucion;

import DAO.Serializacion;
import dato.Activo;
import servicios.BD;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Isabel-Fabian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            //registrando un activo
            BD bd = new BD();
            Activo activo = new Activo("Osciloscopio");
            bd.addActivo(activo);
            
            Serializacion serializacion = new Serializacion();
            try {
                serializacion.escribir(bd);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
            //Antes de inserar nuevamente se debe leer la informacion existente
            bd = serializacion.leer();
            //Adicionar el nuevo activo
            Activo activo2 = new Activo("Arduino");
            bd.addActivo(activo2);
            //Escribir la nueva base de datos
            serializacion.escribir(bd);
            
            //Leyendo del archivo para hacer los calculos que se quieran.
            bd = serializacion.leer();
            System.out.println("Imprimiendo registros");
            
            for(Activo act: bd.getActivos())
                System.out.println(act.getNombre());
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
