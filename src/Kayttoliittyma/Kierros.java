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
    private  KoodiArpoja kone;
    private final int kierrostenMaara = 1;

    public Kierros() {
        muisti = new Muisti();
        lukija = new Lukija();
        tuomari = new Tuomari();
        kone = new KoodiArpoja();
    }
    
    public void pelaaPeli(){
        Arvaus koneen = new Arvaus();       
        koneen.asetaArvaus(kone.haeKoodi());  
        
        
        for(int k = 0 ; k <= kierrostenMaara ; k++){
            
            Arvaus ihmisen = lukija.lueJaTallennaArvaus();
            
            Arvaus ihmisenTupla = new Arvaus();
            int [] ihmisrivi = ihmisen.haeArvaus();
            ihmisenTupla.asetaArvaus(ihmisrivi);
            
            muisti.lisaaArvaus(ihmisen);  //Alkuperäinen muistiin,
            System.out.println("");       // Vain kopio muuttuisi.
            
            tuomari.vertaaRiveja(ihmisenTupla, koneen);
            System.out.println("");
            muisti.naytaArvaukset();
            
            
        }
    }
    
    public void naytaKoneenKoodi(){
        Arvaus koneen = new Arvaus();       
        koneen.asetaArvaus(kone.haeKoodi());  
        koneen.naytaArvaus();
    }
}
