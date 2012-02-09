package Kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Itse pääohjelma, joka ajettaessa käynnistää pelin. 
 * @author pekkotuo
 */
public class HARKKATYO {
    
    public HARKKATYO(){
         JFrame ikkuna = new JFrame();
        Piirturi piirturi = new Piirturi();
        Container container = ikkuna.getContentPane();
        container.add(piirturi);
        ikkuna.addKeyListener(piirturi);       
        ikkuna.setSize(830, 700);
        ikkuna.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ikkuna.setVisible(true);

        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

   
        new HARKKATYO();



    }
}
