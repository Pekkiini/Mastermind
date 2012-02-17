package Kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
    public static JFrame ikkuna;

    public HARKKATYO() {
        ikkuna = new JFrame();
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