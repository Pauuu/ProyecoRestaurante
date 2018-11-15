/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectorestaurante;

import java.awt.image.BufferedImage;

/**
 *
 * @author pau
 */
public class FrameActual extends BufferedImage{
    
    Restaurante restaurante;
    
    public FrameActual(Restaurante restaurante, int width, int height, int imageType) {
        super(width, height, imageType);
        this.restaurante = restaurante;
    }
    
}
