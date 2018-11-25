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
public class FrameActual extends BufferedImage{
    
    Viewer viewer;
    
    public FrameActual(Viewer viewer) {
        super(700, 700, TYPE_4BYTE_ABGR);
        this.viewer = viewer;
    }
}
