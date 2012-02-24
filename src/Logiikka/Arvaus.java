package Logiikka;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Pelaajan arvauksenn synnyttämä kokonaislukutaulukon sisältävä olio. 
 * @author pekkotuo
 */
public class Arvaus {

    private int[] nappulaLuvut;
    private int [] palaute ;

    public Arvaus() {
        nappulaLuvut = new int[4];
        palaute = new int[4];
       
    }
    
    public Arvaus (int [] taulukko){
        this.nappulaLuvut = taulukko;
        
    }
    
    /**
     * 
     * @param indeksi on haettava indeksi
     * @return palautetaan arvausken kohdassa indeksi oleva nappi
     */
    public int haeIndeksi(int indeksi){
        return nappulaLuvut [indeksi];
    }
    
    /**
     * Asettaa Arvaus oliolle palautteen
     * @param palaute on kokonaislukutaulukko, joka kertoo miten monta mustaa
     * ja valkoista palautemerkkiä pelaajan arvaus ansaitsi
     */
    public void lisaaPalaute(int [] palaute){
        this.palaute = palaute;
    }
    /**
     * 
     * @return palauttaa Arvaukseen liitetyn palautteen 
     */
    public int [] getPalaute(){
        return this.palaute;
    }
}
