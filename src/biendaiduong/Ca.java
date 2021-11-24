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


    String filename;
    int isbigger;//  ĐK 1: lớn hơn cá của mình, 0: bé hơn hoặc bằng mình
    Color fishcolor;
      Thread t; 

    

    public Ca(String filename,int isbigger, int xx, int yy, int width, int height) {
        super(xx, yy, width, height);
        this.filename = filename;
        
        this.isbigger = isbigger;

    }
     

    public void drawCa(Graphics g ) {
        

         ImageIcon icon=new ImageIcon(filename);
            Image img=icon.getImage();
            g.drawImage(img, this.x, this.y, this.width, this.height, null);
           // g.setColor(Color.red);
           // g.fillRect(x, y, width, height);
            
        
    }
    
}
