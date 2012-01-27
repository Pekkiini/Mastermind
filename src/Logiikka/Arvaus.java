
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pekkotuo
 */
public class Arvaus {

    private int[] nappulaLuvut;

    public Arvaus() {
        nappulaLuvut = new int[4];
    }

    public void naytaArvaus() {
        for (int luku : nappulaLuvut) {
            System.out.print(luku+" ");
        }
    }

    public void asetaArvaus(int [] arvaus) {
        nappulaLuvut = arvaus; 
    }
    
    public int haeIndeksi(int indeksi){
        return nappulaLuvut [indeksi];
    }
    
    public void asetaIndeksi(int i , int n){
        nappulaLuvut [i] = n ;
    }
    
    public int [] haeArvaus(){
        return nappulaLuvut;
    }
}
