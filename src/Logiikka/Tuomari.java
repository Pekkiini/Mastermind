
import java.util.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pekkotuo
 */
public class Tuomari {

    private int mustienMaara;
    private int valkoistenMaara;
    private ArrayList<Integer> tarkastettavatIndeksit;

    public Tuomari() {
        mustienMaara = 0;
        valkoistenMaara = 0;
        tarkastettavatIndeksit = new ArrayList<Integer>();
        tarkastettavatIndeksit.add(0);
        tarkastettavatIndeksit.add(1);
        tarkastettavatIndeksit.add(2);
        tarkastettavatIndeksit.add(3);
    }

    public void vertaaRiveja(Arvaus pelaaja, Arvaus kone) {
        
        ArrayList<Integer> poistettavat = new ArrayList<Integer>();
        
        for (int indeksi : tarkastettavatIndeksit) {
            if (pelaaja.haeIndeksi(indeksi) == kone.haeIndeksi(indeksi)) {
                mustienMaara++;
                int poistettavaindeksi = indeksi;
                poistettavat.add(poistettavaindeksi);
            }
        }
        for (int luku : poistettavat) {
            tarkastettavatIndeksit.remove(new Integer(luku));
        }
        
    //    for(int vapaaIndeksi : tarkastettavatIndeksit){
     //    int seuraavaVapaa =  pelaaja.haeIndeksi(vapaaIndeksi);
      //     for(int indeksi : tarkastettavatIndeksit ){
        //       if(kone.haeIndeksi(indeksi) == seuraavaVapaa ){
           //        valkoistenMaara++;
            //        int loydetty = kone.haeIndeksi(indeksi);
           //        tarkastettavatIndeksit.remove(new Integer (loydetty) );
          //         break;
                   
        //       }
       //    }
           
      //  }
        
        
       
        

        System.out.println("Vinkki.  Mustia: " + mustienMaara + "    Valkoisia: "
                + valkoistenMaara);

    }
}
