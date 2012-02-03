/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

/**
 *
 * @author pekkotuo
 */
public class kuvio {
    private int vari;
    private int x;
    private int y;
    
    public kuvio(){
        
    }
    public int getVari(){
        return this.vari;
    }
    public int getXKoordinaatti(){
        return this.x;
    }
    public int getYKoordinaatti(){
        return y;
    }
    
    public void setVari(int vari){
        this.vari=vari;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y ;
    }
    
}
