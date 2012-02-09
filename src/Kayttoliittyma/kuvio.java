/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

/**
 * Yksittäisestä napista luodaan kuvio-olio, joka tuntee oman 
 * värinsä ja sijaintinsa. Piirturi piirtää kuvioita ruudulle
 * @author pekkotuo
 */
public class kuvio {
    private int vari;
    private int x;
    private int y;
    
    public kuvio(){
        
    }
    public kuvio(int color, int xk , int yk){
        this.vari = color;
        x=xk;
        y=yk;
    }
    public int getVari(){
        return this.vari;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
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
