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
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class DaiDuong extends javax.swing.JPanel {

    /**
     * Creates new form DaiDuong
     */
    Thread t; 
    Graphics g;
    Ca player;
    ArrayList<Ca> calon;
    ArrayList<Ca> cabe;
    String BackgrPic ="HLYE26o.png";
    String playerPic ="animated-dolphin-image-0112.gif";
    String calonPic ="animated-shark-image-0083.gif";
    String cabePic ="animated-fish-image-0097.gif";
    String GmaeOverPic ="lose.jpg";
    String WinPic = "win.jpg";
  
    
    
     boolean conchoi = true;
    
    int size = 5;
    int grade=0; // diem
    int smallfist;

    public DaiDuong() {
        initComponents();
      
        //g = this.getGraphics();
        //this.setBackground(Color.CYAN);
     
       
        setup();
        
        starGame();
   
        
        
    }

    
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        //hinh o day
         ImageIcon Icon = new ImageIcon(BackgrPic);
        Image img = Icon.getImage();
       
         g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
        player.drawCa(g);
        for (Ca fish : calon) {
            fish.drawCa(g);
        }
        for (Ca fish : cabe) {
            fish.drawCa(g);
        }
       g.setColor(Color.red);
        g.drawString("Diem" + grade, 30, 40);
        
        ImageIcon Icon1;
        Image img1;
        if (!conchoi) {
           
            if (gameover()) {
                //g.drawString("GAME OVER", 400, 300);
                Icon1 = new ImageIcon(GmaeOverPic);
                img1 = Icon1.getImage();
                g.drawImage(img1, 500, 300, 500, 300, null);
            }
            if (Win()) {
                //g.drawString("YOU WIN", 400, 300);
                Icon1 = new ImageIcon(WinPic);
                img1 = Icon1.getImage();
                g.drawImage(img1, 500, 300, 500, 300, null);
            }

        }
        }
    boolean gameover() {
        for (Ca fish : calon) {
            if (player.intersects(fish) && fish.isbigger == 1) {
                return true;
            }
        }
        return false;
    }
   /* public void getGrade() {
        for(Ca c: cabe){
        for (int i = 0; i < cabe.size(); i++) {
            Ca fish = cabe.get(i);
            if (player.intersects(fish) && fish.isbigger == 0) {
                grade++;
               cabe.remove(cabe);
               
            }
        }
    }
    }*/
     public void getGrade() {
        for (int i = 0; i < cabe.size(); i++) {
            Ca fish = cabe.get(i);
            if (player.intersects(fish) && fish.isbigger == 0) {
                grade++;
                cabe.remove(fish);
            }
        }
    }
    int countSmallFish() {
        int count = 0;
        for (Ca fish : cabe) {
            if (fish.isbigger == 0) {
                count++;
            }
        }
        return count;
    }
    boolean Win() {
        if ( grade == smallfist) {
            return true;
        }
        return false;
    }
    
    

    void setup() {
        grade = 0;
        player = new Ca(playerPic,0, 70, 70, 70, 70);
        calon = new ArrayList<>();
        cabe = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Random obj = new Random();
            int x = obj.nextInt(1500);
            obj = new Random();
            int y = obj.nextInt(600);
            Ca l = new Ca(calonPic,1, x, y, 100, 80);
            l.t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Random r = new Random();
                            int newx = r.nextInt(6);
                            int newy = r.nextInt(6);
                            r = new Random();
                            int huong = r.nextInt(4);// huong
                            if (huong == 0) {//trai
                                int i = 0;
                                do {
                                    if (l.x > 10) {
                                        l.x = l.x - newx;
                                    }
                                    i++;
                                    Thread.sleep(20);
                                } while (i <= newx);
                            }
                            if (huong == 1) {//phai
                                int i = 0;
                                do {
                                    if (l.x < 1800) {
                                        l.x = l.x + newx;
                                    }
                                    i++;
                                    Thread.sleep(20);
                                } while (i <= newx);
                            }
                            if (huong == 2) {//len
                                int i = 0;
                                do {
                                    if (l.y > 10) {
                                        l.y = l.y - newy;
                                    }
                                    i++;
                                    Thread.sleep(20);
                                } while (i <= newy);
                            }
                            if (huong == 3) {
                                int i = 0;
                                do {
                                    if (l.y < 950) {
                                        l.y = l.y + newy;
                                    }
                                    i++;
                                    Thread.sleep(20);
                                } while (i <= newy);
                            }
                            repaint();

                        } catch (Exception e) {

                        }
                    }

                }
            });
            l.t.start();
            calon.add(l);
        }
        for (int i = 0; i < size; i++) {
            Random obj = new Random();
            int x = obj.nextInt(1500);
            obj = new Random();
            int y = obj.nextInt(800);
            Ca c = new Ca(cabePic,0, x, y, 40, 50);
            c.t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Random r = new Random();
                            int newx = r.nextInt(9);
                            int newy = r.nextInt(9);
                            r = new Random();
                            int huong = r.nextInt(4);// huong
                            if (huong == 0) {//trai
                                int i = 0;
                                do {
                                    if (c.x > 10) {
                                        c.x = c.x - newx;
                                    }
                                    i++;
                                    Thread.sleep(10);
                                } while (i <= newx);
                            }
                            if (huong == 1) {//phai
                                int i = 0;
                                do {
                                    if (c.x < 1500) {
                                        c.x = c.x + newx;
                                    }
                                    i++;
                                    Thread.sleep(10);
                                } while (i <= newx);
                            }
                            if (huong == 2) {//len
                                int i = 0;
                                do {
                                    if (c.y > 10) {
                                        c.y = c.y - newy;
                                    }
                                    i++;
                                    Thread.sleep(10);
                                } while (i <= newy);
                            }
                            if (huong == 3) {
                                int i = 0;
                                do {
                                    if (c.y < 1000) {
                                        c.y = c.y + newy;
                                    }
                                    i++;
                                    Thread.sleep(10);
                                } while (i <= newy);
                            }
                            repaint();

                        } catch (Exception e) {

                        }
                    }

                }
            });
            c.t.start();
            cabe.add(c);
        }
        
           
        
        smallfist = countSmallFish();

        

    }
    
    
    public void starGame() {
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (conchoi) {
                  
                        if (Win()) {
                           conchoi = false;                          
                            int choice = JOptionPane.showConfirmDialog(null, "Do you want to play again", "", JOptionPane.YES_NO_OPTION);
                            if (choice == JOptionPane.YES_NO_OPTION) {
                                conchoi = true;
                                setup(); starGame();
              
                repaint();
                                
                            }

                        }
                        if (gameover()) {
                            conchoi = false;
                           int choice = JOptionPane.showConfirmDialog(null, "Do you want to play again", "", JOptionPane.YES_NO_OPTION);
                            if (choice == JOptionPane.YES_NO_OPTION) {
                                conchoi = true;
                                setup();
                starGame();
              
                repaint();
                            }
                        }
                        getGrade();
                        repaint();
                        try {
                            Thread.sleep(20);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            
        });
        t.start();
    }
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1029, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 776, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
