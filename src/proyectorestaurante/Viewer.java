/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectorestaurante;

import java.awt.Canvas;

public class Viewer extends Canvas implements Runnable{

    Restaurante restaurante;
    Fondo fondo;
    FrameActual frameActual;

    public Viewer(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public void addFodno() {

    }

    public void updateFrameActual() {

    }

    public void addFrameActual() {
        //no se si hará falta usar este método o no realmente
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
