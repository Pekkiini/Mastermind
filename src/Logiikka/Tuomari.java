package Logiikka;

import java.util.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Pisteyttää pelaajan arvauksen.
 * @author pekkotuo
 */
public class Tuomari {

    private int mustienMaara;
    private int valkoistenMaara;
    private ArrayList<Integer> koneentarkastettavatIndeksit;
    private ArrayList<Integer> pelaajantarkastettavatIndeksit;
    private int [] vinkit;
    private ArrayList<Integer> vinkinTaytettavatIndeksit;

    public Tuomari() {
        vinkit = new int [4];
        for(int i =0 ; i<4;i++){
            vinkit [i] = 0;
        }
        mustienMaara = 0;
        valkoistenMaara = 0;
        koneentarkastettavatIndeksit = new ArrayList<Integer>();
        alusta(koneentarkastettavatIndeksit);

        pelaajantarkastettavatIndeksit = new ArrayList<Integer>();
        alusta(pelaajantarkastettavatIndeksit);
        
        vinkinTaytettavatIndeksit = new ArrayList<Integer>();
        alusta(vinkinTaytettavatIndeksit); 
    }
    /**
     * Vertaa pelaajan arvausta ohjelman koodiin
     * Asettaa pelaajan arvakukseen palautteen 
     * @param pelaaja Parametrina annetaan pelaajan tekemä arvaus
     * @param kone parametri on ohjelman generoima oikea koodirivi
     * @return Palauttaa String olion, jossa mustien ja valkoisten määrä
     */
    public int [] vertaaRiveja(Arvaus pelaaja, Arvaus kone) {
//        String palautus = "";

        tarkistaMustienMaara(pelaaja, kone);

        for (int i = 0; i < 4; i++) {
            tarkistaValkoistenMaara(pelaaja, kone);
        }
//        palautus = palautus + "Vinkki.  Mustia: " + mustienMaara + "    Valkoisia: "
//                + valkoistenMaara;

        tyhjennaLista(koneentarkastettavatIndeksit);

        alusta(koneentarkastettavatIndeksit);
        alusta(pelaajantarkastettavatIndeksit);
        
       ArrayList<Integer> apuLista = new ArrayList<Integer>();
        for(int i = 0 ; i < mustienMaara; i++){
            vinkit [i] = 2 ;
            apuLista.add(i);
        }
        for(int indeksi : apuLista){
        vinkinTaytettavatIndeksit.remove(new Integer(indeksi));
        }
        if(vinkinTaytettavatIndeksit.isEmpty() != true  ){
        for(int i =vinkinTaytettavatIndeksit.get(0) ; i<4;i++ ){
            if(valkoistenMaara>0){
                vinkit[i] = 1 ;
                valkoistenMaara--;
            }
        }
        }
        pelaaja.lisaaPalaute(vinkit);
        tyhjennaLista(vinkinTaytettavatIndeksit);
        alusta(vinkinTaytettavatIndeksit);
        mustienMaara = 0;
        valkoistenMaara = 0;

        return vinkit;
    }
   /**
     * Lisaa parametrina annettuun listaan numerot 0-3 
     * @param lista on Kokonaislukuja sisältävä ArrayLista
     */
    public static void alusta(ArrayList<Integer> lista) {
        lista.add(0);
        lista.add(1);
        lista.add(2);
        lista.add(3);
    }

    /**
     * Tarkistaa kuinka moni nappi pelaajan arvauksesta on oikella paikalla
     * @param pelaaja on käyttäjän arvaus
     * @param kone on ohjelman luoma oikea koodi
     */
    public void tarkistaMustienMaara(Arvaus pelaaja, Arvaus kone) {
        ArrayList<Integer> poistettavat = new ArrayList<Integer>();

        for (int indeksi : koneentarkastettavatIndeksit) {
            if (pelaaja.haeIndeksi(indeksi) == kone.haeIndeksi(indeksi)) {
                mustienMaara++;
                int poistettavaindeksi = indeksi;
                poistettavat.add(poistettavaindeksi);
            }
        }
        for (int luku : poistettavat) {
            koneentarkastettavatIndeksit.remove(new Integer(luku));
            pelaajantarkastettavatIndeksit.remove(new Integer(luku));
        }

//        if (mustienMaara == 4) {
//
//            System.out.println("Voitit!");
//            System.exit(0);
//        }
    }

    /**
     * Tarkistaa mitkä pelaajan arvausken napeista ovat oikein,
     * mutta väärällä paikalla
     * @param pelaaja on käyttäjän arvaus
     * @param kone on ohjelman luoma oikea koodi
     */
    public void tarkistaValkoistenMaara(Arvaus pelaaja, Arvaus kone) {
        if (pelaajantarkastettavatIndeksit.size() > 0) {
            int verrattava = pelaaja.haeIndeksi(pelaajantarkastettavatIndeksit.get(0));
            for (int indeksi : koneentarkastettavatIndeksit) {
                if (verrattava == kone.haeIndeksi(indeksi)) {
                    valkoistenMaara++;
                    koneentarkastettavatIndeksit.remove(new Integer(indeksi));
                    break;
                }
            }
            pelaajantarkastettavatIndeksit.remove(0);
        }
    }

    /**
     * Tyhjentää parametrina annetun listan kaikista alkioista
     * @param lista on kokonaislukuja sisältävä ArrayLista 
     */
    public void tyhjenna(ArrayList<Integer> lista) {
        ArrayList<Integer> koneenRivistaPoistettavat = new ArrayList<Integer>();
        for (int luku : koneentarkastettavatIndeksit) {
            koneenRivistaPoistettavat.add(luku);
        }
        for (int luku : koneenRivistaPoistettavat) {
            koneentarkastettavatIndeksit.remove(new Integer(luku));
        }
    }
    
    public void tyhjennaLista(ArrayList<Integer> lista){
        ArrayList<Integer> helppiLista = new ArrayList<Integer>();
        for(int luku:lista){
            helppiLista.add(luku);
        }
        for(int luku : helppiLista){
            lista.remove(new Integer(luku));
        }
    }
}
