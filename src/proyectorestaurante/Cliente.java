/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectorestaurante;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author pau
 */
public class Cliente implements Runnable {

    //boolean hamburguesa = false;
    private BufferedImage imagen;
    private Mesa mesa;
    private Restaurante restaurante;
    private int id; //?

    public Cliente(Restaurante restaurante) {
        this.restaurante = restaurante;
        try {
            this.imagen = (ImageIO.read(new File("imgs/mesa.jpeg")));
        } catch (IOException ex) {
            Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void comer() {

        this.mesa.drop();
        System.out.println("Hamburguesa comida");

    }

    public void setMesa(Mesa m) {
        this.mesa = m;
    }

    @Override
    public void run() {
        while (true) {
            
            //this.buscarComida();

            this.comer();

            try {
                Thread.sleep(700);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void pintar(Graphics g, int posX, int posY){
        g.drawImage(this.imagen, posX, posY, null);   
    }

    private void buscarComida() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
