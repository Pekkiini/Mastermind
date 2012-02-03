package Logiikka;

import java.util.Scanner;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Käy vuoropuhelua käyttäjän kanssa. Lukee käyttäjän syötteen. 
 * @author pekkotuo
 */
public class Lukija {

    public static Scanner lukija = new Scanner(System.in);

    public Lukija() {
    }
   /**
     * 
     * @return palauttaa käyttäjän syötteestä luodun Arvaus olion
     */
    public Arvaus lueJaTallennaArvaus() {
        Arvaus arvaus = new Arvaus();
        boolean looppi = true;
        while (looppi) {
            int[] rivi = lueLuvut();
            if (tarkistaArvaus(rivi)) {
                arvaus.asetaArvaus(rivi);
                looppi = false;
            } else {
                System.out.println("Lukujen täytyy olla väliltä 0-5!");
                looppi = true;
            }
        }
        return arvaus;
    }
   /**
     * Tarkistaa onko annettu taulukko oikeaa muotoa
     * @param taulukko on kok.lukutaulukko
     * @return true/fasle
     */
    public boolean tarkistaArvaus(int[] taulukko) {
        for (int luku : taulukko) {
            if (luku < 0 || luku > 5) {
                return false;
            }
        }
        return true;
    }
  
    /**
     * Kyselee käyttäjältä lukuja
     * @return käyttäjän syöttämät luvut
     */
    public int[] lueLuvut() {
        int[] luvut = new int[4];
        System.out.println("Anna 4 lukua : (Väliltä 0-5)");
        for (int i = 0; i <= 3; i++) {
            int luku = lukija.nextInt();
            luvut[i] = luku;
        }
        return luvut;
    }
}
