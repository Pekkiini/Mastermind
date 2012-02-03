package Kayttoliittyma;

import java.awt.Container;
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        JFrame ikkuna = new JFrame();
        Piirturi piirturi = new Piirturi();
        Container container = ikkuna.getContentPane();
        container.add(piirturi);
        ikkuna.addKeyListener(piirturi);
        ikkuna.setSize(780, 600);
        ikkuna.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        ikkuna.setVisible(true);


//     Kierros kierros = new Kierros();
//       
//       kierros.pelaaPeli();12
//      
//     System.out.println("");        System.out.println("");
//        kierros.naytaKoneenKoodi();
    }
}
