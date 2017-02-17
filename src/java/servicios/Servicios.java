/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import DAO.Serializacion;
import dato.Activo;
import java.io.IOException;

/**
 *
 * @author Isabel-Fabian
 */
public class Servicios {
    
    public boolean escribir(Activo activo) throws IOException, ClassNotFoundException{
        Serializacion serializacion = new Serializacion();
        BD bd = serializacion.leer();
        if(bd == null)
             bd = new BD();
               
         bd.addActivo(activo);
         boolean resultado = serializacion.escribir(bd);
         return resultado;
    }
    
    public BD  leer() throws IOException, ClassNotFoundException{
      Serializacion serializacion = new Serializacion();
        BD bd = serializacion.leer();
        return bd;
    }
    
}
