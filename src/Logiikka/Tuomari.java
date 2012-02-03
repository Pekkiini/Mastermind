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

    public Tuomari() {
        mustienMaara = 0;
        valkoistenMaara = 0;
        koneentarkastettavatIndeksit = new ArrayList<Integer>();
        alusta(koneentarkastettavatIndeksit);

        pelaajantarkastettavatIndeksit = new ArrayList<Integer>();
        alusta(pelaajantarkastettavatIndeksit);
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

        tyhjenna(koneentarkastettavatIndeksit);

        alusta(koneentarkastettavatIndeksit);
        alusta(pelaajantarkastettavatIndeksit);

        int [] vinkit = {mustienMaara, valkoistenMaara};
        pelaaja.lisaaPalaute(vinkit);
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
}
