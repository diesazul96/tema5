/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import servicios.BD;
import java.io.*;
public class Serializacion{
    
    public boolean escribir(BD bd) throws FileNotFoundException, IOException{
        File file = new File("bd.txt");
         System.out.println(file.getAbsolutePath());
        if(!file.exists()){
           file.createNewFile();
        }
        System.out.println(file.getAbsolutePath());
        
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("bd.txt")));
        out.writeObject(bd);
        out.flush();
        out.close();
        return true;
    }
    
    public BD leer() throws IOException, ClassNotFoundException{
        File file = new File("bd.txt");
         System.out.println(file.getAbsolutePath());
        BD bd = null;
        if(file.exists()){
          ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("bd.txt")));
          bd = (BD) in.readObject();
          in.close();
          return bd;
        }
        return bd;
    }
    
 
}