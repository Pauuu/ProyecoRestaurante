/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectorestaurante;

import java.awt.Container;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author pau
 */
public class Restaurante extends JFrame {

    ArrayList<Cocinero> cocinero = new ArrayList<>();
    ArrayList<Cliente> cliente = new ArrayList<>();
    ArrayList<Mesa> mesa = new ArrayList<>();
    ControlPanel controlPanel;
    Viewer viewer;
    Container cp = this.getContentPane();

    public Restaurante() {
        this.setSize(1000, 800);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.openRestaurante();

    }

    private synchronized void openRestaurante() { //no se si este método es util o no
        //cada cocinero deberia tener su propio hilo de ejecucion
        //Añadir mesas, cocineros y clientes
        this.addMesa();
        this.addCocinero();
        this.addCliente();
        
        
        
        
    //    notifyAll();
        
        //this.cliente.get(0).setMesa(this.mesa.get(0));
        
        
    }

    private void addCocinero() {
        this.cocinero.add(new Cocinero(this));
        this.cocinero.get(0).setMesa(this.mesa.get(0));
        (new Thread(this.cocinero.get(0))).start(); //cambiar
    }

    private void addCliente() {
        this.cliente.add(new Cliente(this));
        this.cliente.get(0).setMesa(this.mesa.get(0));
        (new Thread(this.cliente.get(0))).start();
    }

    private void addMesa() {
        this.mesa.add(new Mesa(this));
        
    }

    private void addControlPanel() {
        this.controlPanel = new ControlPanel(this);
    }

    private void addViewer() {
        this.viewer = new Viewer(this);
        this.cp.add(this.viewer);
    }
}
