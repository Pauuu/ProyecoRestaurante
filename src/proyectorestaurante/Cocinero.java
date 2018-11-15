/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectorestaurante;

/**
 *
 * @author pau
 */
public class Cocinero implements Runnable{
    
    Restaurante restaurante;
    
    public Cocinero(Restaurante restaurante){
        this.restaurante = restaurante;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
