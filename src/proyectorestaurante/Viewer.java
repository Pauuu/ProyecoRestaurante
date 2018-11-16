/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectorestaurante;

import java.awt.Canvas;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Viewer extends Canvas implements Runnable {

    Fondo fondo;
    FrameActual frameActual;
    Restaurante restaurante;

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
        
    }

    //Privados
}
