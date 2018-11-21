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

    private boolean pedido = true;
    private BufferedImage imagen;
    private Mesa mesa;
    private Restaurante restaurante;
    private int tiempoCocina;
    private int id;

    public Cocinero(Restaurante restaurante, int tiempoCocina, int id) {
        this.restaurante = restaurante;
        this.tiempoCocina = tiempoCocina;
        this.id = id;
        try {
            this.imagen = (ImageIO.read(new File("imgs/ham.png")));
        } catch (IOException ex) {
            Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cocinarHamburguesa() { //poner synhronized??

        this.pedido = false;

        this.mesa.put();
        System.out.println("Hamburguesa cocinada");

    }

    public BufferedImage getImage() {
        return this.imagen;
    }

    public void setPedidio() {
        this.pedido = true;
    }

    public void setMesa(Mesa m) {
        this.mesa = m;
    }

    public void pintar(Graphics g, int posX, int posY) {
        g.drawImage(this.imagen, posX, posY, null);
    }

    @Override
    public void run() {
        while (true) {

            this.cocinarHamburguesa();

            this.servirHamburguesa();

            try {
                Thread.sleep(700);
            } catch (InterruptedException ex) {
                Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void servirHamburguesa() {

        int oX; //pos x de la mesa
        int oY; //pos y de la mesa

        // this.mesa.get
    }

}
