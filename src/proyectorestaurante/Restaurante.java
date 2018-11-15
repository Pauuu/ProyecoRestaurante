/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectorestaurante;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author pau
 */
public class Restaurante extends JPanel {

    ArrayList<Cocinero> cocinero = new ArrayList<>();
    ArrayList<Cliente> cliente = new ArrayList<>();
    ArrayList<Mesa> mesa = new ArrayList<>();
    ControlPanel controlPanel;
    Viewer viewer;

    public Restaurante() {

    }

    private void addCocinero() {
        this.cocinero.add(new Cocinero(this));
    }

    private void addCliente() {
        this.cliente.add(new Cliente(this));
    }

    private void addMeas() {
        this.mesa.add(new Mesa(this));
    }

    private void addControlPanel() {
        this.controlPanel = new ControlPanel(this);
    }

    private void addViewer() {
        this.viewer = new Viewer(this);
    }
}
