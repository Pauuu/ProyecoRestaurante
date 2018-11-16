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
public class Cocinero implements Runnable {

    boolean pedido = true;
    Mesa mesa;
    Restaurante restaurante;

    public Cocinero(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    /**
     * 
     */
    public synchronized void cocinarHamburguesa() {
        
        
        
        this.mesa.put();

//        while (!this.pedido) {
//            try {
//                wait();
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        try {
//            Thread.sleep(1200);
//        } catch (InterruptedException ex) {
//            System.out.println("Deberia poner algun tipo de manejador de excepciones");
//        }

        this.pedido = false;

        System.out.println("Hamburguesa cocinada");
        
        //notifyAll();
    }

    public void setPedidio() {
        this.pedido = true;
    }
    
    public void setMesa(Mesa m){
        this.mesa = m;
    }

    @Override
    public void run() {
        this.cocinarHamburguesa();
    }

}
