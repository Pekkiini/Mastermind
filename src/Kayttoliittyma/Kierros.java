package Kayttoliittyma;

import Logiikka.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pekkotuo
 */
public class Kierros {

    private Muisti muisti;
    private Lukija lukija;
    private Tuomari tuomari;
    private KoodiArpoja kone;
    private Arvaus koneen ;
    private Arvaus ihmisen;
    private final int kierrostenMaara = 9;

    public Kierros() {
        muisti = new Muisti();
        lukija = new Lukija();
        tuomari = new Tuomari();
        kone = new KoodiArpoja();
        koneen = new Arvaus();
        ihmisen = new Arvaus();
    }

    /**
     * Pyörittää peliä kierros kierrokselta ja hoitaa pelin loppumisen ajallaan
     */
    public void pelaaPeli() {
       
        koneen.asetaArvaus(kone.haeKoodi());


        for (int k = 0; k <= kierrostenMaara; k++) {

             ihmisen = lukija.lueJaTallennaArvaus();

            muisti.lisaaArvaus(ihmisen);
            System.out.println("");

            tuomari.vertaaRiveja(ihmisen, koneen);
            System.out.println("");
            System.out.println(muisti.palautaArvaukset());
            

        }
        System.out.println("Hävisit pelin. Oikea rivi oli: "); naytaKoneenKoodi();
        System.exit(0);
    }

    /**
     * Näyttää ohjelman luoman, arvattavan koodin
     */
    public void naytaKoneenKoodi() {
        System.out.println(""+koneen.haeIndeksi(0)+" "+koneen.haeIndeksi(1)
                +" "+koneen.haeIndeksi(2)+" "+ koneen.haeIndeksi(3) );
//        Arvaus koneen = new Arvaus();
//        koneen.asetaArvaus(kone.haeKoodi());
//        System.out.println( koneen.palautaArvaus());
    }
}
