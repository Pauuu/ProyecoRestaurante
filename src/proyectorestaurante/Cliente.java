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

    private BufferedImage imagen[] = new BufferedImage[3];
    private Mesa mesa;
    private Restaurante restaurante;
    private int paciencia;
    private int posX = 500;
    private int posY = 500;
    private int tiempoComida;
    private int id; //?

    public Cliente(Restaurante restaurante, int tiempoComida) {
        this.restaurante = restaurante;
        this.tiempoComida = tiempoComida;
        try {
            this.imagen[0] = (ImageIO.read(new File("imgs/cliente-normal.png")));
            this.imagen[1] = (ImageIO.read(new File("imgs/cliente-enfadado.png")));
        } catch (IOException ex) {
            Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void checkEstadoAnimo() {

    }

    public void comer() {
        try {
            Thread.sleep(this.tiempoComida);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cocinero.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.mesa.drop();

        System.out.println("Hamburguesa comida");
    }

    public void setMesa(Mesa m) {
        this.mesa = m;
    }

    @Override
    public void run() {
        while (true) {

            this.comer();

        }
    }

    public void pintar(Graphics g) {
        g.drawImage(this.imagen[0], posX, posY, null);
    }

    private void buscarComida() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
