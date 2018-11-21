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
public class Mesa {

    private BufferedImage imagen;
    private Restaurante restaurante;
    private int numHamburguesas = 0;
    private int posX = 0;
    private int posY = 0;

    public Mesa(Restaurante restaurante) {
        this.restaurante = restaurante;
         try {
            this.imagen = (ImageIO.read(new File("imgs/mesa.jpeg")));
        } catch (IOException ex) {
            Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized void put() {

        while (numHamburguesas > 3) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        numHamburguesas++;

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

        this.numHamburguesas--;

        notifyAll();

    }

    public void addHamburguesa() {
        this.numHamburguesas++;
    }

    public int getNumHamburguesas() {
        return numHamburguesas;
    }
    
    public int getPosX(){
        return this.posX;
    }
    
    public int getPosY(){
        return this.posY;
    }
    
    public void pintar(Graphics g, int posX, int posY){
        g.drawImage(this.imagen, posX, posY, null);
    }

}
