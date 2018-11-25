package proyectorestaurante;

import java.awt.Canvas;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Viewer extends Canvas implements Runnable {

    private Fondo fondo;
    private FrameActual frameActual;
    private Restaurante restaurante;
    private ArrayList<Cocinero> cocineros;
    private ArrayList<Cliente> clientes;
    private ArrayList<Mesa> mesas;

    public Viewer(Restaurante restaurante) {

        this.restaurante = restaurante;
        this.loadObjects();
        this.addObjFondo("imgs/valdosas.jpeg");
        this.addObjFrameActual();
    }

    public FrameActual getFrameActual() {
        return this.frameActual;
    }

    public void addObjFrameActual() {
        this.frameActual = new FrameActual(this);
    }

    public void addObjFondo(String url) {
        try {
            this.fondo = new Fondo(this, ImageIO.read(new File(url)));
        } catch (IOException ex) {
            System.out.println("imagen no cargada");
        }
    }

    public void loadObjects() {
        this.cocineros = this.restaurante.getCocineros();
        this.clientes = this.restaurante.getClientes();
        this.mesas = this.restaurante.getMesas();
    }

    public void paintComponents() {

        
    }

    @Override
    public void paint(Graphics g) {
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(17);
                updateFrame();
            } catch (InterruptedException ex) {
                Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void updateFrame() {

        this.getGraphics().drawImage(this.fondo, 0, 0, null);
        this.restaurante.getMesa(0).pintar(this.frameActual.getGraphics());
        this.getGraphics().drawImage(this.frameActual, 0, 0, null);

    }
}
