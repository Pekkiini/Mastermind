package Kayttoliittyma;

import Logiikka.Logica;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Kuuntelee näppäimistöä ja päivittää grafiikkaa. 
 * @author pekkotuo
 */
public final class Piirturi extends JPanel implements KeyListener {

    private HARKKATYO harkkatyo;
    private Logica logiikka;
    private kuvio[][] arvaukset;
    private kuvio[] oikeaKoodi;
    private kuvio[][] vinkki;
    private int x = 30;
    private int y = 600;
    private int s = 300;
    private int r = 600;
    private int vari = -1;
    private int rivi = 0;
    private int sarake = 0;
    private int vinkkiRivi = 0;
    private int p = 30;
    private int q = 30;
    private int winCondition = 0;
    private int arvausMaara = 0;
    private File ennatysLista = new File("mastermind.txt");
    private Scanner lukija;
    private ArrayList<HighScore> parhaatTulokset = new ArrayList<HighScore>();
    private ArrayList<String> lista = new ArrayList<String>();
    private String pisteet;

    public Piirturi() {
        lataaHighScore();
        alustaPeliLauta();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 830, 700);
        g.setColor(Color.BLACK);
        g.drawRect(1, 1, 830, 700);
        g.drawRect(2, 2, 830, 700);
        g.drawRect(3, 3, 830, 700);
        g.drawRect(4, 4, 830, 700);
        g.drawRect(5, 5, 830, 700);


        g.setColor(Color.BLUE.brighter());
        g.fillRect(600, 30, 30, 30);
        g.setColor(Color.BLACK);
        g.drawRect(600, 30, 30, 30);
        g.setColor(Color.MAGENTA.brighter());
        g.drawString("1", 612, 50);

        g.setColor(Color.RED.brighter());
        g.fillRect(600, 80, 30, 30);
        g.setColor(Color.BLACK);
        g.drawRect(600, 80, 30, 30);
        g.drawString("2", 612, 100);

        g.setColor(Color.GREEN);
        g.fillRect(600, 130, 30, 30);
        g.setColor(Color.BLACK.darker());
        g.drawRect(600, 130, 30, 30);
        g.drawString("3", 612, 150);

        g.setColor(Color.YELLOW);
        g.fillRect(600, 180, 30, 30);
        g.setColor(Color.BLACK);
        g.drawRect(600, 180, 30, 30);
        g.drawString("4", 612, 200);

        g.setColor(Color.WHITE);
        g.fillRect(600, 230, 30, 30);
        g.setColor(Color.BLACK);
        g.drawRect(600, 230, 30, 30);
        g.drawString("5", 612, 250);

        g.setColor(Color.BLACK);
        g.fillRect(600, 280, 30, 30);
        g.drawRect(600, 280, 30, 30);
        g.setColor(Color.MAGENTA.brighter());
        g.drawString("6", 612, 300);

        g.setColor(Color.DARK_GRAY.darker());
        g.drawString("'ENTER' = LUKITSE ARVAUS ", 600, 350);

        g.setColor(Color.DARK_GRAY.darker());
        g.drawString("'BACKSPACE' = PERU SIIRTO", 600, 400);

        g.setColor(Color.DARK_GRAY.darker());
        g.drawString("'F2' = UUSI PELI", 600, 450);
        
        g.setColor(Color.DARK_GRAY.darker());
        g.drawString("'F1' = OHJEET", 600, 500);


        for (int i = 0; i < 4; i++) {

            if (oikeaKoodi[i].getVari() == -1) {
                g.setColor(Color.MAGENTA);
                g.fillRect(oikeaKoodi[i].getX(), oikeaKoodi[i].getY(), 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(oikeaKoodi[i].getX(), oikeaKoodi[i].getY(), 30, 30);
                g.drawString("  ???", oikeaKoodi[i].getX() - 1, oikeaKoodi[i].getY() + 19);
            }

            if (oikeaKoodi[i].getVari() == 0) {
                g.setColor(Color.BLUE);
                g.fillRect(oikeaKoodi[i].getX(), oikeaKoodi[i].getY(), 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(oikeaKoodi[i].getX(), oikeaKoodi[i].getY(), 30, 30);
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
                g.setColor(Color.BLACK);
                g.drawRect(oikeaKoodi[i].getX(), oikeaKoodi[i].getY(), 30, 30);
            }
            if (oikeaKoodi[i].getVari() == 3) {
                g.setColor(Color.YELLOW);
                g.fillRect(oikeaKoodi[i].getX(), oikeaKoodi[i].getY(), 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(oikeaKoodi[i].getX(), oikeaKoodi[i].getY(), 30, 30);
            }
            if (oikeaKoodi[i].getVari() == 4) {
                g.setColor(Color.WHITE);
                g.fillRect(oikeaKoodi[i].getX(), oikeaKoodi[i].getY(), 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(oikeaKoodi[i].getX(), oikeaKoodi[i].getY(), 30, 30);
            }
            if (oikeaKoodi[i].getVari() == 5) {
                g.setColor(Color.BLACK);
                g.fillRect(oikeaKoodi[i].getX(), oikeaKoodi[i].getY(), 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(oikeaKoodi[i].getX(), oikeaKoodi[i].getY(), 30, 30);
            }
        }


        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 4; b++) {
                if (vinkki[a][b].getVari() == 0) {
                    g.setColor(Color.PINK);
                    g.fillOval(vinkki[a][b].getX(), vinkki[a][b].getY(), 20, 20);
                    g.setColor(Color.BLACK);
                    g.drawOval(vinkki[a][b].getX(), vinkki[a][b].getY(), 20, 20);
                } else if (vinkki[a][b].getVari() == 1) {
                    g.setColor(Color.WHITE);
                    g.fillOval(vinkki[a][b].getX(), vinkki[a][b].getY(), 20, 20);
                    g.setColor(Color.BLACK);
                    g.drawOval(vinkki[a][b].getX(), vinkki[a][b].getY(), 20, 20);
                } else if (vinkki[a][b].getVari() == 2) {
                    g.setColor(Color.BLACK);
                    g.fillOval(vinkki[a][b].getX(), vinkki[a][b].getY(), 20, 20);
                    g.setColor(Color.BLACK);
                    g.drawOval(vinkki[a][b].getX(), vinkki[a][b].getY(), 20, 20);
                }
            }
        }
        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 4; b++) {
                if (arvaukset[a][b].getVari() == -1) {
                    g.setColor(Color.PINK);
                    g.fillRect(arvaukset[a][b].getX(), arvaukset[a][b].getY(), 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(arvaukset[a][b].getX(), arvaukset[a][b].getY(), 30, 30);
                }

                if (arvaukset[a][b].getVari() == 0) {
                    g.setColor(Color.BLUE);
                    g.fillRect(arvaukset[a][b].getX(), arvaukset[a][b].getY(), 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(arvaukset[a][b].getX(), arvaukset[a][b].getY(), 30, 30);

                } else if (arvaukset[a][b].getVari() == 1) {
                    g.setColor(Color.RED);
                    g.fillRect(arvaukset[a][b].getX(), arvaukset[a][b].getY(), 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(arvaukset[a][b].getX(), arvaukset[a][b].getY(), 30, 30);


                } else if (arvaukset[a][b].getVari() == 2) {
                    g.setColor(Color.GREEN);
                    g.fillRect(arvaukset[a][b].getX(), arvaukset[a][b].getY(), 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(arvaukset[a][b].getX(), arvaukset[a][b].getY(), 30, 30);



                } else if (arvaukset[a][b].getVari() == 3) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(arvaukset[a][b].getX(), arvaukset[a][b].getY(), 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(arvaukset[a][b].getX(), arvaukset[a][b].getY(), 30, 30);


                } else if (arvaukset[a][b].getVari() == 4) {
                    g.setColor(Color.WHITE);
                    g.fillRect(arvaukset[a][b].getX(), arvaukset[a][b].getY(), 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(arvaukset[a][b].getX(), arvaukset[a][b].getY(), 30, 30);


                } else if (arvaukset[a][b].getVari() == 5) {
                    g.setColor(Color.BLACK);
                    g.fillRect(arvaukset[a][b].getX(), arvaukset[a][b].getY(), 30, 30);
                    g.setColor(Color.BLACK);
                    g.drawRect(arvaukset[a][b].getX(), arvaukset[a][b].getY(), 30, 30);

                }
            }

        }


    }

    @Override
    public void keyPressed(KeyEvent e) {

        // System.out.println(e.getKeyCode());

        if(e.getKeyCode()==112){
            String ohjeet = "Mastermind on peli, jossa pelaajan täytyy ratkaista \n"
                    +"salainen värikoodi. Koodi koostuu neljästä väristä, joita \n "
                    +"käytössä on kuusi. Arvauksia pelaaja saa käyttää enintään 10. \n "
                    +"Jokaisen tehdyn arvauksen jälkeen pelaaja saa palautteen siitä, \n"
                    +"miten lähelle arvaus osui. Musta merkki tarkoittaa oikeaa väriä \n"
                    +"oikeassa paikassa, valkoinen merkki taas oikeaa väriä väärässä \n"
                    +"paikassa. Jos yhtään merkkiä ei ilmesty vinkkitaulukkoon, \n"
                    +"tarkoittaa se sitä, että yksikään arvauksen väreistä ei esiinny \n"
                    +"ratkaistavassa koodissa. Pelaaja voittaa pelin ratkaistessaan \n"
                    +"koodin 10. arvaukseen mennessä, muutoin pelaaja häviää. Myös \n"
                    +"luovuttaminen katsotaan pelaajan tappioksi.";
                      
            JOptionPane.showMessageDialog(this, ohjeet, "Ohjeet", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getKeyCode() == 113) {

            alustaPeliLauta();

        }

        if (e.getKeyCode() == 8 && sarake >= 1) {
            kuvio pyyhittava = arvaukset[rivi][sarake - 1];
            arvaukset[rivi][sarake - 1] = new kuvio(-1, pyyhittava.getX(), pyyhittava.getY());
            sarake = sarake - 1;
            x -= 40;
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
                    try {
                        PrintWriter kirjoittaja = new PrintWriter(new FileWriter("mastermind.txt"), true);
                        winCondition = 1;
                        for (int k = 0; k < 4; k++) {
                            oikeaKoodi[k] = new kuvio(logiikka.getKoneenRivi().haeIndeksi(k), p, q);
                            p += 40;
                        }
                        repaint();
                        JOptionPane.showMessageDialog(this, "VOITIT!!");
                        arvausMaara = rivi + 1;
                        winCondition = 1;
                        if (parhaatTulokset.size() != 0) {
                            if (arvausMaara <= parhaatTulokset.get(parhaatTulokset.size() - 1).getArvauset()) {
                                String pelaajanNimi = JOptionPane.showInputDialog("Teit hyvän tuloksen! \n Anna nimesi:  ");
                                if (pelaajanNimi == null) {
                                    pelaajanNimi = "Mr. Smith";
                                }
                                if (pelaajanNimi.equals("")) {
                                    pelaajanNimi = "Mr. Smith";
                                }
                                HighScore score = new HighScore(pelaajanNimi, arvausMaara);
                                int poistettavanPaikka = -1;
                                for (HighScore verrattava : parhaatTulokset) {
                                    if (score.getArvauset() <= verrattava.getArvauset()) {
                                        poistettavanPaikka = parhaatTulokset.indexOf(verrattava);

                                        break;
                                    }
                                }
                                if (poistettavanPaikka >= 0) {
                                    parhaatTulokset.remove(parhaatTulokset.size() - 1);
                                    parhaatTulokset.add(score);
                                }
                                Collections.sort(parhaatTulokset);

                                for (HighScore high : parhaatTulokset) {
                                    kirjoittaja.println(high.getNimi() +" "+  high.getArvauset());
                                }
                                kirjoittaja.close();
                                pisteet = "";
//                                Scanner reader = new Scanner(ennatysLista);
//                                while (reader.hasNextLine()) {
//                                    String lisays = reader.nextLine();
//       //!!!!!!!!!!!!               //!!!!!!!!!      lisays.split("\\ ");
//                                    pisteet += lisays + "\n";
//                                }
                                for (HighScore point : parhaatTulokset) {
                                    pisteet += point.toString();
                                }
                                JOptionPane.showMessageDialog(HARKKATYO.ikkuna, pisteet, "HighScores", JOptionPane.PLAIN_MESSAGE);
                            }
                        }
                        if (parhaatTulokset.size() != 0) {
                            if (arvausMaara > parhaatTulokset.get(parhaatTulokset.size() - 1).getArvauset()) {
                                for (HighScore high : parhaatTulokset) {
                                    kirjoittaja.println(high.getNimi() + " " + high.getArvauset());
                                }
                                kirjoittaja.close();
                                pisteet = "";
//                                Scanner reader = new Scanner(ennatysLista);
//                                while (reader.hasNextLine()) {
//                                    String lisays = reader.nextLine();
//                                    pisteet += lisays + "\n";
//                                }
                                for (HighScore boint : parhaatTulokset) {
                                    pisteet += boint.toString();
                                }
                                JOptionPane.showMessageDialog(HARKKATYO.ikkuna, pisteet, "HighScores", JOptionPane.PLAIN_MESSAGE);
                            }
                        }
                    } catch (IOException ax) {
                        Logger.getLogger(Piirturi.class.getName()).log(Level.SEVERE, null, ax);

                    }

                } else if (tulos[3] != 2 && rivi == 9) {
                    winCondition = -1;
                    for (int k = 0; k < 4; k++) {
                        oikeaKoodi[k] = new kuvio(logiikka.getKoneenRivi().haeIndeksi(k), p, q);
                        p += 40;
                    }
                    repaint();
                    JOptionPane.showMessageDialog(this, "GAME OVER!");
                    arvausMaara = rivi + 1;
                    pisteet = "";
                    for (HighScore score : parhaatTulokset) {
                        pisteet += score.toString();
                    }

                    JOptionPane.showMessageDialog(HARKKATYO.ikkuna, pisteet, "HighScores", JOptionPane.PLAIN_MESSAGE);

                }

                for (int i = 0; i < 4; i++) {
                    tulos[i] = 0;
                }
                if (vinkkiRivi <= 8) {
                    vinkkiRivi++;
                }
                s = 300;
                r -= 50;

                repaint();
                if (rivi <= 8) {
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

    /**
     * Piirtää pelilaudan alkuasetelmaansa 
     */
    public void alustaPeliLauta() {
        x = 30;
        y = 600;
        s = 300;
        r = 600;
        p = 30;
        q = 30;
        winCondition = 0;
        arvausMaara = 0;
        vari = -1;
        rivi = 0;
        sarake = 0;
        vinkkiRivi = 0;
        oikeaKoodi = new kuvio[4];
        for (int i = 0; i < 4; i++) {
            oikeaKoodi[i] = new kuvio(-1, p, q);
            p += 40;
        }
        p = 30;
        vinkki = new kuvio[10][4];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                vinkki[i][j] = new kuvio(0, s, r);
                s += 40;
            }
            s = 300;
            r -= 50;
        }
        s = 300;
        r = 600;
        logiikka = new Logica();
        arvaukset = new kuvio[10][4];
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 4; i++) {
                arvaukset[j][i] = new kuvio(vari, x, y);
                x += 40;
            }
            x = 30;
            y -= 50;
        }
        x = 30;
        y = 600;
        repaint();
    }

    /**
     * Lataa aikaisemmin saavutetut hyvät tulokset "mastermind.txt" tiedostosta 
     * ja tallentaa ne pelin uuden instanssin muistiin.
     */
    public void lataaHighScore() {
        for (int i = 0; i < lista.size(); i++) {
            lista.remove(i);
        }
        try {
            lukija = new Scanner(ennatysLista);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Piirturi.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (lukija.hasNextLine()) {
            while (lukija.hasNextLine()) {
                String row = lukija.nextLine();
                String[] taulu = row.split(" ");
                String name = "";
                int i = Integer.parseInt(taulu[taulu.length - 1]);
                for(int k = 0; k < taulu.length - 1; k++) {
                    name += taulu[k] + " ";
                }
                parhaatTulokset.add(new HighScore(name, i));
            }
        }
        lukija.close();
        Collections.sort(parhaatTulokset);
        if (parhaatTulokset.size() == 0) {
            for (int k = 0; k < 5; k++) {
                parhaatTulokset.add(new HighScore("<empty>", 999));
            }
        }
    }
}
