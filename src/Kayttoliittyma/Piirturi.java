package Kayttoliittyma;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pekkotuo
 */
public class Piirturi extends JPanel implements KeyListener {
    
    @Override
   public void paint(Graphics g) {
    super.paint(g);
    

    }
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
  }
  
    @Override
  public void keyTyped(KeyEvent e) {
  }

    @Override
  public void keyReleased(KeyEvent e) {
  }
}
