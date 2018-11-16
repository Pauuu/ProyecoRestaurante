/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectorestaurante;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pau
 */
public class Mesa {

    Restaurante restaurante;
    int numHamburguesas = 0;

    public Mesa(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public synchronized void put() {
        
        numHamburguesas++;
        
        while (numHamburguesas > 10) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        notifyAll();
        
    }

    public synchronized void drop() {
        while (numHamburguesas <= 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        notifyAll();
        
        this.numHamburguesas--;
    }
    
    public void addHamburguesa(){
        this.numHamburguesas++;
    }
    
    public int numHamburguesas(){
        return this.numHamburguesas;
    }

}
