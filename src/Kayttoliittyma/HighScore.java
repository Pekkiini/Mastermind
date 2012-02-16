/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

/**
 * Yksittäistä hyvää tulosta mallintava luokka. 
 * Helpottaa tulosten vertailua. 
 * @author pekkotuo
 */
public class HighScore {
    private String nimi ;
    private int arvaukset ;
    
    public HighScore(String nimi, int arvaukset){
        this.nimi = nimi ;
        this.arvaukset = arvaukset;
    }
    
    public String getNimi(){
        return nimi;
    }
    public int getArvauset(){
        return arvaukset;
    }
    
    public void setNimi(String nimi){
        this.nimi=nimi;
    }
    public void setArvaukset(int luku){
        this.arvaukset = luku ;
    }
}
