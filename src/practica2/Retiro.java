/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import javax.swing.JLabel;

/**
 *
 * @author Dany
 */
public class Retiro implements Runnable{
    private EstanteriaPacks estanteria = null;
    
    public Retiro(EstanteriaPacks estanteria){
        this.estanteria = estanteria;
    }
    public void run(){
        try{
            while(true){
                JLabel retirada = estanteria.retirar();
                System.out.println("retirando " + retirada.getName());
                Thread.sleep(1000);
           }
        }catch(Exception e){
               System.out.println("error " +e.getMessage()); 
        }
    }
    
}
