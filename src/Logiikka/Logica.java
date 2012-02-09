/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

/**
 * Toimii GUI:n ja muiden luokkien välikätenä
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

    public Arvaus luoArvaus(int[] taulukko) {
        Arvaus arvaus = new Arvaus(taulukko);
        return arvaus;
    }

    public Arvaus getKoneenRivi() {
        return koneen;
    }
}
