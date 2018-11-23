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

    public void loadImageCocinero(Cocinero co) {
        Graphics g = this.frameActual.getGraphics();
        co.pintar(g);
    }

    public void loadImageCliente(Cliente cl) {
        Graphics g = this.frameActual.getGraphics();
        cl.pintar(g);
    }

    public void loadImageFondo() {
        Graphics g = this.getGraphics();
        g.drawImage(this.fondo, 0, 0, null);
    }

    public void loadImageMesa(Mesa m) {
        Graphics g = this.frameActual.getGraphics();
        m.pintar(g);
    }

    public void loadObjects() {
        this.cocineros = this.restaurante.getCocineros();
        this.clientes = this.restaurante.getClientes();
        this.mesas  = this.restaurante.getMesas();
    }

    public void paintComponents() {
        for (int i = 0; i < this.restaurante.getMesas().size(); i++) {
            this.loadImageMesa(this.restaurante.getMesa(i));
        }

        for (int i = 0; i < this.restaurante.getCocineros().size(); i++) {
            this.loadImageCocinero(this.restaurante.getCocinero(i));
        }

        for (int i = 0; i < this.restaurante.getClientes().size(); i++) {
            this.loadImageCliente(this.restaurante.getCliente(i));
        }
    }

    @Override
    public void paint(Graphics g) {
    }

    @Override
    public void run() {

    }
}
