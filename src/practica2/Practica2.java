/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.LinkedList;

/**
 *
 * @author Dany
 */
public class Practica2 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Estanteria<String> estanteria = new Estanteria<String>(20);
         for(int i = 0;i<20;i++){
             estanteria.encolar("Posicion " + i);
             System.out.println("Posicion " + i);
         }
         System.out.println(estanteria.retirar());
         System.out.println(estanteria.retirar());
         System.out.println(estanteria.retirar());
         System.out.println(estanteria.retirar());
         System.out.println(estanteria.retirar());                     
    }
    
    
}
