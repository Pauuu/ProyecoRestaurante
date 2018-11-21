/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectorestaurante;

import java.awt.Canvas;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Viewer extends Canvas implements Runnable {

    private Fondo fondo;
    private FrameActual frameActual;

    private Restaurante restaurante;

    public Viewer(Restaurante restaurante) {

        this.restaurante = restaurante;
        this.addObjFondo("imgs/valdosas.jpeg");
    }

    public void addObjFrameActual() {
        this.frameActual = new FrameActual(this);
        this.loadImageCliente(this.restaurante.getCliente(0));
        this.getGraphics().drawImage(this.frameActual, 0, 0, null);
    }

    public void addObjFondo(String url) {
        try {
            this.fondo = new Fondo(this, ImageIO.read(new File(url)));
        } catch (IOException ex) {
            System.out.println("imagen no cargada");
        }
    }

    public void loadImageCocinero(Cocinero co) {
        Graphics g = this.frameActual.getGraphics();
        co.pintar(g, 500, 88);
    }

    public void loadImageCliente(Cliente cl) {
        Graphics g = this.frameActual.getGraphics();
        cl.pintar(g, 500, 600);
    }
   
    public void loadImageFondo() {
        Graphics g = this.getGraphics();
        //this.fondo.pintar(g, 0, 0);   
        g.drawImage(this.fondo, 0, 0, null);
    }

    public void loadImageMesa(Mesa m) {
        Graphics g = this.frameActual.getGraphics();
        m.pintar(g, 90, 400);
    }

    @Override
    public void paint(Graphics g) {
//        g.drawImage(this.fondo, 0, 0, null);

    }

    @Override   //nada de momento
    public void run() {

    }

}
