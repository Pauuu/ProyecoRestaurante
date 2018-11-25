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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author pau
 */
public class Mesa {

    private ArrayList<BufferedImage> dibujoHamburguesas = new ArrayList<>();
    private BufferedImage imagen;
    private Graphics manejadorGrafFrameActual;
    private Restaurante restaurante;
    private int numHamburguesas = 0;
    private int posX = 300;
    private int posY = 300;

    public Mesa(Restaurante restaurante, Graphics graphics) {
        this.restaurante = restaurante;
        this.manejadorGrafFrameActual = graphics;
        
        try {
            this.imagen = (ImageIO.read(new File("imgs/mesa.png")));
        } catch (IOException ex) {
            Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized void put() {

        while (this.numHamburguesas > 3) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.pintarHam();
        
        this.numHamburguesas++;

        notifyAll();
    }

    public synchronized void drop() {

        while (this.numHamburguesas <= 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Mesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.numHamburguesas--;

        notifyAll();

    }
    
    public void pintarHam(){
        
        try {
            this.dibujoHamburguesas.add(ImageIO.read(new File("imgs/ham.png")));
        } catch (IOException ex) {
            Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.manejadorGrafFrameActual.drawImage(dibujoHamburguesas.get(0), 0, 0 , null);
    
    }

    public void addHamburguesa() {
        this.numHamburguesas++;
    }

    public int getNumHamburguesas() {
        return numHamburguesas;
    }
    
    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public void pintar(Graphics g) {
        this.manejadorGrafFrameActual.drawImage(this.imagen, posX, posY, null);
    }

}
