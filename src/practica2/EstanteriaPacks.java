/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Dany
 */
public class EstanteriaPacks {
    Estanteria<JLabel> estanteria;
    public EstanteriaPacks(int limite){
        this.estanteria = new Estanteria<JLabel>(limite);
    }
    public void encolar(JLabel paquete){
        try{
            this.estanteria.encolar(paquete);
            paquete.setBackground(Color.red);
            paquete.setText("F");
        }catch(Exception e){}
        
    }
    public JLabel retirar(){
        
        JLabel retirada = this.estanteria.retirar();
        retirada.setBackground(Color.white);
        retirada.setText("E");
        return retirada;
        
    }
            
}
