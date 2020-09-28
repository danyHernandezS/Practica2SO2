/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import javax.swing.JLabel;
import javax.swing.JFrame;

/**
 *
 * @author Dany
 */
public class Entrega implements Runnable{
    private EstanteriaPacks estanteria = null;
    private JFrame frame = null;
    
    public Entrega(EstanteriaPacks estanteria,JFrame frame ){
        this.estanteria = estanteria;
        this.frame = frame;
    }
    
    public void run(){
        JLabel newPack = null;
        while(true)
       {
            try{
                newPack = obtenerLabelDisponible();
                if(newPack!=null){
                    estanteria.encolar(newPack);
                    System.out.println("Enconlando"+newPack.getName());
                }
                Thread.sleep(1000);
           }catch(Exception e){
               System.out.println("error " +e.getMessage());
           }
       }
    }
    public JLabel obtenerLabelDisponible(){
        JLabel jlabel = null;
        String strNombre = "";
        for(int i = 1; i<=20;i++){
            strNombre = "jLabel"+i;
            jlabel =Awt1.getComponentByName(frame,strNombre);
            jlabel.setName(strNombre);
            if(jlabel.getText().equals("E"))
                return jlabel;
        }
        return jlabel;
    }
}
