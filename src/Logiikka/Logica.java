/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logiikka;

import Kayttoliittyma.Kierros;
import com.sun.org.apache.bcel.internal.generic.L2D;

/**
 * Toimii GUI:n ja muiden luokkien välikätenä
 * Käyttää vain tuntemiensa luokkien metodeja
 * @author pekkotuo
 */
public class Logica {
    private Tuomari tuomari;
    private KoodiArpoja arpoja;
    private Muisti muisti;
    private Lukija lukija;
    private Arvaus pelaajan;
    private Arvaus koneen;
    private Kierros kierros;
    
    public Logica(){
        tuomari = new Tuomari();
        arpoja = new KoodiArpoja();
        muisti = new Muisti();
        lukija = new Lukija();
        koneen = arpoja.luoArvattavaKoodi();
        pelaajan = new Arvaus();      
        kierros = new Kierros();
    }
    /**
     * Aloittaa pelin
     */
    public void aloitaPeli(){
        kierros.pelaaPeli();
    }
    /**
     *  Vertaa pelaajan ja koneen riviä sekä antaa palautteen
     */
    public int [] tuomitse(Arvaus p , Arvaus k){
       return tuomari.vertaaRiveja(p, k);
    }
    
    public Arvaus luoArvaus(int [] taulukko){
        Arvaus arvaus = new Arvaus(taulukko);
        return arvaus;
    }
    public Arvaus getKoneenRivi(){
        return koneen;
    }
    
}
