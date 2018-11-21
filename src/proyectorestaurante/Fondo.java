/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectorestaurante;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author pau
 */
public class Fondo extends BufferedImage {

    private BufferedImage imagen;
    private Viewer viewer;

    public Fondo(Viewer viewer, BufferedImage img) {
        super(img.getColorModel(), img.getRaster(), img.getColorModel().isAlphaPremultiplied(), null);
        this.imagen = img;
        this.viewer = viewer;

    }

    public void pintar(Graphics g, int posX, int posY) {
        g.drawImage(this.imagen, posX, posY, null);
    }
}
