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
public class Cliente implements Runnable {

    boolean hamburguesa = false;
    Mesa mesa;
    Restaurante restaurante;
    int id; //?

    public Cliente(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public synchronized void comer() {

        while (this.mesa.numHamburguesas <= 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.mesa.drop();

  
        
        
        
        this.hamburguesa = false;

        System.out.println("hamburguesa comida");

        //notifyAll();
    }

    public void setMesa(Mesa m) {
        this.mesa = m;
    }

    @Override
    public void run() {
        this.comer();
    }
}
