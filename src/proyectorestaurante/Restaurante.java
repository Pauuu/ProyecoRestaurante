/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectorestaurante;

import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author pau
 */
public class Restaurante extends JFrame {

    private static int numCocineros;

    private ArrayList<Cocinero> cocineros = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Mesa> mesas = new ArrayList<>();
    private Container cp = this.getContentPane();
    private ControlPanel controlPanel;

    private int totalHamburguesas;

    final int FRAME_HEIGHT = 750;
    final int FRAME_WIDTH = 1000;

    private Viewer viewer;

    public Restaurante() {
        this.createFrame();

        this.addViewer();

        this.openRestaurante();

        //this.viewer.addObjFondo();
        this.viewer.addObjFrameActual();
        
        
    }

    public Cocinero getCocinero(int id) {
        return this.cocineros.get(id);
    }

    public Cliente getCliente(int id) {
        return this.clientes.get(id);
    }

    public Mesa getMesa(int id) {
        return this.mesas.get(id);
    }

    public Viewer getViewer() {
        return this.viewer;
    }

    public int getNumHamburguesas(int id) {
        return this.mesas.get(id).getNumHamburguesas();

    }

    public void createFrame() {
        this.setSize(this.FRAME_WIDTH, this.FRAME_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridBagLayout());

        //this.pack();
        this.setVisible(true);
    }

    private void openRestaurante() {
        //cada cocinero deberia tener su propio hilo de ejecucion
        //Añadir mesas, cocineros y clientes
        this.addMesa();
        this.addCliente();
        this.addCocinero();
    }

    private void addCocinero() {
        this.cocineros.add(new Cocinero(this, 2000, 1));

        this.cocineros.get(0).setMesa(this.mesas.get(0));
        (new Thread(this.cocineros.get(0))).start(); //cambiar
    }

    private void addCliente() {
        this.clientes.add(new Cliente(this));
        this.clientes.get(0).setMesa(this.mesas.get(0));
        (new Thread(this.clientes.get(0))).start();

        this.clientes.add(new Cliente(this));
        this.clientes.get(1).setMesa(this.mesas.get(0));
        (new Thread(this.clientes.get(1))).start();
    }

    private void addMesa() {
        this.mesas.add(new Mesa(this));
    }

    private void addControlPanel() {
        this.controlPanel = new ControlPanel(this);
    }

    private void addViewer() {

        GridBagConstraints c = new GridBagConstraints();

        this.viewer = new Viewer(this);
        this.viewer.setSize(800, 800);
        this.viewer.setBackground(Color.blue);

        c.gridx = 0;
        c.gridy = 0;
        this.cp.add(this.viewer, c);
        //this.viewer.addObjFondo();
    }

}
