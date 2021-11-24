/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biendaiduong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author ASUS
 */
public class Ca extends Rectangle {

    private String hinh;

    Thread t;

    public Ca(String hinh, int xx, int yy, int width, int height) {
        super(xx, yy, width, height);
        this.hinh = hinh;

    }

    void drawCa(Graphics g,String anh ) {

        if (g != null) {
            ImageIcon icon = new ImageIcon(anh);
            Image img = icon.getImage();
            g.drawImage(img, 100, 100, 100, 100, null);
            g.setColor(Color.red);
            g.fillRect(x, y, width, height);
            
        }
    }
}
