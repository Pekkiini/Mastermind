package Kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Piirtää pelissä tarvittavia erivärisiä ympyröitä. 
 * @author pekkotuo
 */
public class Piirturi extends JPanel implements KeyListener {

    private kuvio [][] arvaus;
   
    private int x = 30;
    private int y = 300;
    private int z = 0;
    private int vari = -1;
    private int rivi = 0;
    private int sarake =0 ;

    public Piirturi() {
        arvaus = new kuvio [10][4];
        for(int j = 0 ; j<10;j++){
            for(int i = 0 ; i<4 ;i++){
                arvaus[j][i]=-1;
            }
        }
       
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        

        for (int a = 0; a<10;a++) {
            for(int b = 0; b<4; b++){
            if (arvaus[a][b] == 0) {
                g.setColor(Color.BLUE);
                g.fillRect(x+z, y, 30, 30);
                z+=40;
               
            } else if (arvaus[a][b] == 1) {
                g.setColor(Color.RED);
                g.fillRect(x+z, y, 30, 30);
                 z+=40;
                
            } else if (arvaus[a][b] == 2) {
                g.setColor(Color.GREEN);
                g.fillRect(x+z, y, 30, 30);
                 z+=40;
                
                
            } else if (arvaus[a][b] == 3) {
                g.setColor(Color.YELLOW);
                g.fillRect(x+z, y, 30, 30);
                z+=40;
                
            } else if (arvaus[a][b] == 4) {
                g.setColor(Color.WHITE);
                g.fillRect(x+z, y, 30, 30);
              z+=40;
                
            } else if (arvaus[a][b] == 5) {
                g.setColor(Color.BLACK);
                g.fillRect(x+z, y, 30, 30);
               z+=40;
            }  
            }
            z+=100;
        }
        z=20;

    }

    @Override
    public void keyPressed(KeyEvent e) {
        
       
        
        if(taulukkoTaynna()){
            System.out.println("HÄvisit!");
            System.exit(0);
        }
        
       if(riviTaynna()){
           rivi++;
           sarake=0;
       }
        if (e.getKeyCode() == 49) {
            vari = 0;
            arvaus[rivi][sarake] = vari;
            sarake++;
            if(riviTaynna()){
                y-=50;
                x = 30;
                z= 0;
            }
            repaint();
        }
        else if (e.getKeyCode() == 50) {
            vari = 1;
            arvaus[rivi][sarake] = vari;
            sarake++;
            repaint();
        } else if (e.getKeyCode() == 51) {
            vari = 2;
            arvaus[rivi][sarake] = vari;
            sarake++;
            repaint();
        } else if (e.getKeyCode() == 52) {
            vari = 3;
            arvaus[rivi][sarake] = vari;
            sarake++;
            repaint();
        }else if (e.getKeyCode() == 53) {
            vari = 4;
            arvaus[rivi][sarake] = vari;
            sarake++;
            repaint();
        }else if (e.getKeyCode() == 54) {
            vari = 5;
            arvaus[rivi][sarake] = vari;
            sarake++;
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    public boolean riviTaynna(){
       if(arvaus [rivi][3]!=-1){
           return true;
       }
        return false;
    }
    public boolean taulukkoTaynna(){
        if(arvaus[9][3]!=-1){
            return true;
        }
        return false;
    }
    
}
