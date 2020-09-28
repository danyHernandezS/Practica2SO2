/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Dany
 */
public class Estanteria<T> {
    Condition condicionEstaLlena;
    Condition condicionestaVacia;
    Lock lock;
    int limite;
    Queue<T> q = new LinkedList<T>();
    public Estanteria(int limite){
        this.limite = limite;
        lock = new ReentrantLock();
        condicionEstaLlena = lock.newCondition();
        condicionestaVacia = lock.newCondition();              
    }
    public void encolar (T t){
        lock.lock();
        try{
            while(estaLlena()){
                try{
                    condicionEstaLlena.await();
                }catch(InterruptedException ex){System.out.println("practica2.Estanteria.encolar()\n" + ex.getMessage());}
            }
            q.add(t);
            condicionestaVacia.signalAll();
        }
        finally{lock.unlock();}
    }
    public T retirar(){
        T t = null;
        lock.lock();
        try{
            while(estaVacia()){
                try{
                    condicionestaVacia.await();
                }catch(InterruptedException ex){System.out.println("practica2.Estanteria.encolar()\n" + ex.getMessage());}
            }
            t = q.poll();
            condicionEstaLlena.signal();
        }
        finally{lock.unlock();}
        return t;
    }
    private boolean estaLlena(){
        return q.size() == limite;
    }
    private boolean estaVacia(){
        return q.size() == 0;
    }
            
            
}
