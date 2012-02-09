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
     * @return palauttaa pelaajan arvauksen, sekä siihen liitetyn palautteen
     */
    public String palautaArvaus() {
        String alku = "";
        for (int luku : nappulaLuvut) {
            alku = alku + luku+ " ";
            
        }
        alku = alku + "     " + "Mustia "+palaute[0]+ "  "+"Valkoisia " + palaute[1] ;
        return alku;
    }

    /**
     * Asettaa oliolle arvauksen
     * @param arvaus on kokonaislukutaulukko 
     */
    public void asetaArvaus(int [] arvaus) {
        nappulaLuvut = arvaus; 
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
     * 
     * @param i on muokattava indeksi
     * @param n on kohtaan i asetettava luku
     */
    public void asetaIndeksi(int i , int n){
        nappulaLuvut [i] = n ;
    }
    /**
     * 
     * @return palauttaa arvauksen 
     */
    public int [] haeArvaus(){
        return nappulaLuvut;
    }
    /**
     * 
     * @param palaute on kokonaislukutaulukko, joka kertoo miten monta mustaa
     * ja valkoista palautemerkkiä pelaajan arvaus ansaitsi
     */
    public void lisaaPalaute(int [] palaute){
        this.palaute = palaute;
    }
    /**
     * 
     * @return Arvaukseen liitetyn palautteen 
     */
    public int [] getPalaute(){
        return this.palaute;
    }
}
