
import java.util.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pekkotuo
 */
public class Muisti {

    private ArrayList<Arvaus> siirrot;

    public Muisti() {
        siirrot = new ArrayList<Arvaus>();
    }
    public void lisaaArvaus(Arvaus arvaus) {
        siirrot.add(arvaus);
    }

    public void naytaArvaukset() {
        System.out.println("Aikaisemmat siirtosi:");
        int numero = 1;
        for (Arvaus arvaus : siirrot) {
            System.out.print(numero + ".   ");
            arvaus.naytaArvaus();
            numero++;
            System.out.println("");
            System.out.println("");
        }
    }
}
