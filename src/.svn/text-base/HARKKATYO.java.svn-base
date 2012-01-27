

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pekkotuo
 */
public class HARKKATYO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Arvaus pelaajan = new Arvaus();
        Arvaus koneen = new Arvaus();
        
       int [] pelaajankoodi = {1,4,4,4};
        int [] koneenkoodi =  {4,0,0,0};
        
        
        
        pelaajan.asetaArvaus(pelaajankoodi);
        koneen.asetaArvaus(koneenkoodi);
        System.out.println("ALKU");
        koneen.naytaArvaus();
        
        Tuomari tuomari = new Tuomari();
        
        
        
       tuomari.vertaaRiveja(pelaajan, koneen);
        System.out.println("LOPPU");
       koneen.naytaArvaus();
        
     //  Kierros kierros = new Kierros();
      //  kierros.naytaKoneenKoodi(); System.out.println("");
      //  kierros.pelaaPeli();
      //  System.out.println("");
      //  System.out.println("");
       // kierros.naytaKoneenKoodi();
        
    }
}
