package Logiikka;

import java.util.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Muistaa pelaajan pelin aikana tekemät arvaukset
 * @author pekkotuo
 */
public class Muisti {

    public ArrayList<Arvaus> siirrot;
    /**
     * 
     */
    public Muisti() {
        siirrot = new ArrayList<Arvaus>();
    }

    /**
     * Tallentaa pelaajan tekemän arvauksen
     * @param arvaus on pelaajan tekemä arvaus
     */
    public void lisaaArvaus(Arvaus arvaus) {
        siirrot.add(arvaus);
    }

    /**
     * Luettelee muistissa olevat aikaisemmat arvaukset
     * @return muistissa olevat arvaukset palautteineen
     */
    public String palautaArvaukset() {
        String vastaus = "";
        vastaus = vastaus + "Aikaisemmat siirtosi:\n";
        int numero = 1;
        for (Arvaus arvaus : siirrot) {
            vastaus = vastaus + " " + numero + ".   ";
            vastaus = vastaus + arvaus.palautaArvaus();
            numero++;
            vastaus = vastaus + "\n";

        }
        return vastaus;
    }
}
