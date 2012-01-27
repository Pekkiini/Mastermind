
import java.util.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pekkotuo
 */
public class KoodiArpoja {

    private int [] koodi;
    private Random arpa = new Random();

    public KoodiArpoja() {
        koodi = new int [4];
        for (int i = 0; i <= 3; i++) {
           koodi [i] = arpa.nextInt(6) ;
        }
    }

    public int getNappula(int j) {
        return koodi [j];
    }
    @Override
    public String toString(){
        return koodi.toString();
       
    }
    
    public int [] haeKoodi(){
        return koodi;
    }
}
