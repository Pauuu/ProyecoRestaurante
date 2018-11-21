/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectorestaurante;

import java.awt.Color;
import java.awt.Container;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author pau
 */
public class ControlPanel extends JFrame {

    private JPanel mainPanel;
    private JTextArea textArea;
    private Restaurante restaurante;
    private int numHamburguesas;

    public ControlPanel(Restaurante restaurante) {
        this.restaurante = restaurante;
        this.setSize(500, 1000);
        this.setBackground(Color.red);
        this.addJTable();

        this.setVisible(true);

        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }

   
    private void addJTable() {
        Container cp = this.getContentPane();
        mainPanel = new JPanel();

        String n = Integer.toString(this.restaurante.getNumHamburguesas(0));
        textArea = new JTextArea(n);

        mainPanel.add(textArea);
        cp.add(mainPanel);
    }

}
