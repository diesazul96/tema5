/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dato.Activo;
import dato.Prestamo;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Isabel-Fabian
 */
public class BD implements Serializable{
    private ArrayList<Activo> activos;
    private ArrayList<Prestamo> prestamos;

    public BD() {
        this.activos = new ArrayList<Activo>();
        this.prestamos = new ArrayList<Prestamo>();
    }
    
    public void addActivo(Activo activo){
       this.activos.add(activo);
    }
    
    public void addPrestamo(Prestamo prestamo){
      this.prestamos.add(prestamo);
    }

    public ArrayList<Activo> getActivos() {
        return activos;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }
    
    
}
