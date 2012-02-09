package Kayttoliittyma;

import Logiikka.Logica;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Kuuntelee näppäimistöä ja päivittää grafiikkaa. 
 * @author pekkotuo
 */
public class Piirturi extends JPanel implements KeyListener {
    private HARKKATYO harkkatyo;
    private Logica logiikka;
    private kuvio[][] arvaukset;
    private kuvio[] oikeaKoodi;
    private kuvio[][] vinkki;
    private int x = 30;
    private int y = 600;
    private int s = 350;
    private int r = 600;
    private int vari = -1;
    private int rivi = 0;
    private int sarake = 0;
    private int vinkkiRivi = 0;
    private int p = 30;
    private int q = 30;
    private int winCondition = 0;
    private int arvausMaara = 0 ;

    public Piirturi() {
        oikeaKoodi = new kuvio[4];
        for (int i = 0; i < 4; i++) {
            oikeaKoodi[i] = new kuvio(-1, p, q);
        }
        vinkki = new kuvio[10][4];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                vinkki[i][j] = new kuvio(0, s, r);
                s += 40;
            }
            s = 350;
            r -= 50;
        }
        s = 350;
        r = 600;
        logiikka = new Logica();
        arvaukset = new kuvio[10][4];
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 4; i++) {
                arvaukset[j][i] = new kuvio(vari, x, y);
            }
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        g.drawString("1 = SININEN ", 600, 30);
        
        g.setColor(Color.RED);
        g.drawString("2 = PUNAINEN", 600, 80);
        
        g.setColor(Color.GREEN);
        g.drawString("3 = VIHREÄ", 600, 130);
        
        g.setColor(Color.YELLOW);
        g.drawString("4 = KELTAINEN", 600, 180);
        
        g.setColor(Color.WHITE);
        g.drawString("5 = VALKOINEN", 600, 230);
        
        g.setColor(Color.BLACK);
        g.drawString("6 = MUSTA", 600, 280);
        
        g.setColor(Color.CYAN);
        g.drawString("'ENTER' = LUKITSE ARVAUS ", 600, 330);
        
        g.setColor(Color.CYAN);
        g.drawString("'BACKSPACE' = PERU SIIRTO", 600, 380);
        
        g.setColor(Color.CYAN);
        g.drawString("'F2' = UUSI PELI", 600, 430);


        if (oikeaKoodi[3].getVari() != -1) {
            for (int i = 0; i < 4; i++) {
                if (oikeaKoodi[i].getVari() == 0) {
                    g.setColor(Color.BLUE);
                    g.fillRect(oikeaKoodi[i].getX(), oikeaKoodi[i].getY(), 30, 30);

                }
                if (oikeaKoodi[i].getVari() == 1) {
                    g.setColor(Color.RED);
                    g.fillRect(oikeaKoodi[i].getX(), oikeaKoodi[i].getY(), 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(oikeaKoodi[i].getX(), oikeaKoodi[i].getY(), 30, 30);
                }
                if (oikeaKoodi[i].getVari() == 2) {
                    g.setColor(Color.GREEN);
                    g.fillRect(oikeaKoodi[i].getX(), oikeaKoodi[i].getY(), 30, 30);
                }
                if (oikeaKoodi[i].getVari() == 3) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(oikeaKoodi[i].getX(), oikeaKoodi[i].getY(), 30, 30);
                }
                if (oikeaKoodi[i].getVari() == 4) {
                    g.setColor(Color.WHITE);
                    g.fillRect(oikeaKoodi[i].getX(), oikeaKoodi[i].getY(), 30, 30);
                }
                if (oikeaKoodi[i].getVari() == 5) {
                    g.setColor(Color.BLACK);
                    g.fillRect(oikeaKoodi[i].getX(), oikeaKoodi[i].getY(), 30, 30);
                }
            }
        }

        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 4; b++) {
                if (vinkki[a][b].getVari() == 0) {
                    g.setColor(Color.PINK);
                    g.fillOval(vinkki[a][b].getX(), vinkki[a][b].getY(), 20, 20);
                } else if (vinkki[a][b].getVari() == 1) {
                    g.setColor(Color.WHITE);
                    g.fillOval(vinkki[a][b].getX(), vinkki[a][b].getY(), 20, 20);
                } else if (vinkki[a][b].getVari() == 2) {
                    g.setColor(Color.BLACK);
                    g.fillOval(vinkki[a][b].getX(), vinkki[a][b].getY(), 20, 20);
                }
            }
        }
        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 4; b++) {
                if (arvaukset[a][b].getVari() == 0) {
                    g.setColor(Color.BLUE);
                    g.fillRect(arvaukset[a][b].getX(), arvaukset[a][b].getY(), 30, 30);


                } else if (arvaukset[a][b].getVari() == 1) {
                    g.setColor(Color.RED);
                    g.fillRect(arvaukset[a][b].getX(), arvaukset[a][b].getY(), 30, 30);


                } else if (arvaukset[a][b].getVari() == 2) {
                    g.setColor(Color.GREEN);
                    g.fillRect(arvaukset[a][b].getX(), arvaukset[a][b].getY(), 30, 30);



                } else if (arvaukset[a][b].getVari() == 3) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(arvaukset[a][b].getX(), arvaukset[a][b].getY(), 30, 30);


                } else if (arvaukset[a][b].getVari() == 4) {
                    g.setColor(Color.WHITE);
                    g.fillRect(arvaukset[a][b].getX(), arvaukset[a][b].getY(), 30, 30);


                } else if (arvaukset[a][b].getVari() == 5) {
                    g.setColor(Color.BLACK);
                    g.fillRect(arvaukset[a][b].getX(), arvaukset[a][b].getY(), 30, 30);

                }
            }

        }


    }

    @Override
    public void keyPressed(KeyEvent e) {
        
      // System.out.println(e.getKeyCode());
       
       
       if(e.getKeyCode()==113){
           harkkatyo = new HARKKATYO();
       }
        
        if(e.getKeyCode()== 8 && sarake>=1 ){
           kuvio pyyhittava = arvaukset[rivi][sarake-1];
           arvaukset[rivi][sarake-1] = new kuvio(-1, pyyhittava.getX(), pyyhittava.getY());
           sarake = sarake -1 ;
           x-=40;
           repaint();
        }

        if (e.getKeyCode() == 10 && winCondition == 0) {
            

            if (riviTaynna()) {
                int[] row = new int[4];
                for (int i = 0; i < 4; i++) {
                    row[i] = arvaukset[rivi][i].getVari();
                }

                int[] tulos = logiikka.tuomitse(logiikka.luoArvaus(row), logiikka.getKoneenRivi());
                for (int i = 0; i < 4; i++) {
                    vinkki[vinkkiRivi][i] = new kuvio(tulos[i], s, r);
                    s += 40;
                }

                if (tulos[3] == 2) {
                    winCondition = 1;
                    for (int k = 0; k < 4; k++) {
                        oikeaKoodi[k] = new kuvio(logiikka.getKoneenRivi().haeIndeksi(k), p, q);
                        p += 40;
                    }
                    repaint();
                    JOptionPane.showMessageDialog(this, "VOITIT!!");
                    arvausMaara=rivi+1;
                    winCondition =1;
                    
                    JOptionPane.showInputDialog("Teit hyvän tuloksen! \n Anna nimesi:  ");
                    

                } else if (tulos[3] != 2 && rivi == 9) {
                    winCondition = -1;
                    for (int k = 0; k < 4; k++) {
                        oikeaKoodi[k] = new kuvio(logiikka.getKoneenRivi().haeIndeksi(k), p, q);
                        p += 40;
                    }
                    repaint();
                    JOptionPane.showMessageDialog(this, "GAME OVER!");
                    arvausMaara=rivi+1;
                    
                    
                    
                }


                for (int i = 0; i < 4; i++) {
                    tulos[i] = 0;
                }
                if(vinkkiRivi<=8){
                vinkkiRivi++;
                }
                s = 350;
                r -= 50;

                repaint();
                if(rivi <= 8){
                rivi++;
                }
                sarake = 0;
                x = 30;
                y -= 50;

            }

        }
        if (e.getKeyCode() == 49 && riviTaynna() == false && winCondition != 1) {
            vari = 0;
            arvaukset[rivi][sarake] = new kuvio(0, x, y);
            sarake++;
            x += 40;
            repaint();
        } else if (e.getKeyCode() == 50 && riviTaynna() == false && winCondition != 1) {
            vari = 1;
            arvaukset[rivi][sarake] = new kuvio(1, x, y);
            sarake++;
            x += 40;
            repaint();
        } else if (e.getKeyCode() == 51 && riviTaynna() == false && winCondition != 1) {
            vari = 2;
            arvaukset[rivi][sarake] = new kuvio(2, x, y);
            sarake++;
            x += 40;
            repaint();
        } else if (e.getKeyCode() == 52 && riviTaynna() == false && winCondition != 1) {
            vari = 3;
            arvaukset[rivi][sarake] = new kuvio(3, x, y);
            sarake++;
            x += 40;
            repaint();
        } else if (e.getKeyCode() == 53 && riviTaynna() == false && winCondition != 1) {
            vari = 4;
            arvaukset[rivi][sarake] = new kuvio(4, x, y);
            sarake++;
            x += 40;
            repaint();
        } else if (e.getKeyCode() == 54 && riviTaynna() == false && winCondition != 1) {
            vari = 5;
            arvaukset[rivi][sarake] = new kuvio(5, x, y);
            sarake++;
            x += 40;
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    /**
     * Palauttaa true jos riviin on asetettu 4 nappia
     * @return true/false
     */
    
    public boolean riviTaynna() {
        if (arvaukset[rivi][3].getVari() != -1) {
            return true;
        }
        return false;
    }
   /**
     * Palauttaa true, jos viimeinen arvaus on käytetty, muuten false
     * @return 
     */
    public boolean taulukkoTaynna() {
        if (arvaukset[9][3].getVari() != -1) {
            return true;
        }
        return false;
    }
    
   
}
