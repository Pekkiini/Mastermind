/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

/**
 * Toimii GUI:n ja muiden luokkien välisenä tulkkina
 * Käyttää vain tuntemiensa luokkien metodeja
 * @author pekkotuo
 */
public class Logica {

    private Tuomari tuomari;
    private KoodiArpoja arpoja;
    private Arvaus koneen;

    public Logica() {
        tuomari = new Tuomari();
        arpoja = new KoodiArpoja();
        koneen = arpoja.luoArvattavaKoodi();


    }

    /**
     *  Vertaa pelaajan ja koneen riviä sekä antaa palautteen
     */
    public int[] tuomitse(Arvaus p, Arvaus k) {
        return tuomari.vertaaRiveja(p, k);
    }

    /**
     * 
     * @param int taulukko
     * @return palauttaa Arvaus olion
     */
    public Arvaus luoArvaus(int[] taulukko) {
        Arvaus arvaus = new Arvaus(taulukko);
        return arvaus;
    }

    /**
     * 
     * @return palauttaa Ohjelman generoiman rivin 
     */
    public Arvaus getKoneenRivi() {
        return koneen;
    }
}
