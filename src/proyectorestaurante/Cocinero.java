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
public class Cocinero implements Runnable {

    private BufferedImage imagenCocinero;
    private BufferedImage imagenHamburguesa;
    private Graphics manejadorGrafico;
    private Mesa mesa;
    private Restaurante restaurante;
    private int posX = 300;
    private int posY = 200;
    private int tiempoCocina;

    public Cocinero(Restaurante restaurante, int tiempoCocina) {
        this.restaurante = restaurante;
        this.tiempoCocina = tiempoCocina;
        this.cargarImagenes();
    }

    public BufferedImage getImage() {
        return this.imagenCocinero;
    }

    public void cocinarHamburguesa() {
//        Graphics g = this.restaurante.getViewer().getFrameActual().getGraphics();
        this.mesa.put();
        System.out.println("Hamburguesa cocinada");
    }

    public void pintar(Graphics g) {
        //this.manejadorGrafico = g;
        g.drawImage(this.imagenCocinero, posX, posY, null);
    }

    public void setMesa(Mesa m) {
        this.mesa = m;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(this.tiempoCocina);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
            }

            this.cocinarHamburguesa();
            //this.servirHamburguesa();
        }
    }

    private void cargarImagenes() {
        //cargar imagen 1
        try {
            this.imagenCocinero = (ImageIO.read(new File("imgs/cocinero.png")));

        } catch (IOException ex) {
            Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
        }

        //cargar imagen 2
        try {
            this.imagenHamburguesa = (ImageIO.read(new File("imgs/ham.png")));
        } catch (IOException ex) {
            Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void servirHamburguesa() {

        int oX; //pos x de la mesa
        int oY; //pos y de la mesa

        // this.mesa.get
    }

}
