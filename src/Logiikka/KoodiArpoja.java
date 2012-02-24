package Logiikka;


import java.util.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Luo arvattavan koodin
 * @author pekkotuo
 */
public class KoodiArpoja {

    private int [] koodi;
    private Random arpa = new Random();

    public KoodiArpoja() {
        koodi = new int [4];
        for (int i = 0; i <= 3; i++) {
           koodi [i] = arpa.nextInt(6) ;
        }
    }
    /**
     * 
     * @param j on haettava indeksi
     * @return palautetaan koodista kohdassa j oleva nappi
     */
    public int getNappula(int j) {
        return koodi [j];
    }    
     /**
     * 
     * @return luotu koodi
     */
    public int [] haeKoodi(){
        return koodi;
    }
    /**
     * 
     * @return palauttaa Arvaus olion 
     */
    public Arvaus luoArvattavaKoodi(){
        Arvaus koneenKoodi = new Arvaus(haeKoodi());
        return koneenKoodi;
    }
}
