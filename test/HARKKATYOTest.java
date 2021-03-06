/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
import Logiikka.Arvaus;
import Logiikka.KoodiArpoja;
import Logiikka.Logica;
import Logiikka.Tuomari;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pekkotuo
 */
public class HARKKATYOTest {
     public static Scanner lukija = new Scanner(System.in);

    public HARKKATYOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
     @Test
     public void hello() {}

    @Test
    public void KoneenKoodiEiOleTyhja() {
        KoodiArpoja arpoja = new KoodiArpoja();
        assertNotSame(null, arpoja.getNappula(1));
    }
    
    @Test
    public void tuomariAntaaOikeatVihjeet(){
        int [] ihmisen = {0,1,2,3};
        int [] koneen =  {2,3,4,5};
        int [] oikea = {1,1,0,0};
        Arvaus ihmisenArvaus = new Arvaus(ihmisen);
        Arvaus koneenArvaus = new Arvaus(koneen);
        Tuomari tuomari = new Tuomari();
        tuomari.vertaaRiveja(ihmisenArvaus, koneenArvaus);
        assertArrayEquals(oikea, ihmisenArvaus.getPalaute());
    }
    
    @Test
    public void tuomariAntaaOikeatVihjeet2(){
        int [] ihmisen = {2,3,2,3};
        int [] koneen =  {2,3,4,5};
        int [] oikea = {2,2,0,0};
        Arvaus ihmisenArvaus = new Arvaus(ihmisen);
        Arvaus koneenArvaus = new Arvaus(koneen);
        Tuomari tuomari = new Tuomari();
        tuomari.vertaaRiveja(ihmisenArvaus, koneenArvaus);
        assertArrayEquals(oikea, ihmisenArvaus.getPalaute());
    }
    
    @Test
    public void tuomariAntaaOikeatVihjeet3(){
        int [] ihmisen = {1,1,1,1};
        int [] koneen =  {2,3,4,5};
        int [] oikea = {0,0,0,0};
        Arvaus ihmisenArvaus = new Arvaus(ihmisen);
        Arvaus koneenArvaus = new Arvaus(koneen);
        Tuomari tuomari = new Tuomari();
        tuomari.vertaaRiveja(ihmisenArvaus, koneenArvaus);
        assertArrayEquals(oikea, ihmisenArvaus.getPalaute());
    }
    @Test
    public void tuomariAntaaOikeatVihjeet4(){
        int [] ihmisen = {2,3,4,4};
        int [] koneen =  {4,2,3,3};
        int [] oikea = {1,1,1,0};
        Arvaus ihmisenArvaus = new Arvaus(ihmisen);
        Arvaus koneenArvaus = new Arvaus(koneen);
        Tuomari tuomari = new Tuomari();
        tuomari.vertaaRiveja(ihmisenArvaus, koneenArvaus);
        assertArrayEquals(oikea, ihmisenArvaus.getPalaute());
    }
    @Test
    public void tuomariAntaaOikeatVihjeet5(){
        int [] ihmisen = {4,4,1,2};
        int [] koneen =  {4,4,1,5};
        int [] oikea = {2,2,2,0};
        Arvaus ihmisenArvaus = new Arvaus(ihmisen);
        Arvaus koneenArvaus = new Arvaus(koneen);
        Tuomari tuomari = new Tuomari();
        tuomari.vertaaRiveja(ihmisenArvaus, koneenArvaus);
        assertArrayEquals(oikea, ihmisenArvaus.getPalaute());
    }
   
   
    @Test
    public void logicaOsaaTuomita(){
        Logica logiikka = new Logica();
        int [] pelaaja = {4,3,1,2};
        int [] kone = {4,3,2,1};
        Arvaus p = new Arvaus(pelaaja);
        Arvaus k = new Arvaus(kone);
        int [] actual = logiikka.tuomitse(p, k);
        int [] oikea = {2,2,1,1};
       assertArrayEquals(null, oikea, actual);
    }
    @Test
    public void toimiikoTuomariAina(){
        int [] ihmisen = {3,4,4,1};
        int [] koneen =  {4,1,4,3};
        int [] oikea = {2,1,1,1};
        Arvaus ihmisenArvaus = new Arvaus(ihmisen);
        Arvaus koneenArvaus = new Arvaus(koneen);
        Tuomari tuomari = new Tuomari();
        tuomari.vertaaRiveja(ihmisenArvaus, koneenArvaus);
        assertArrayEquals(oikea, ihmisenArvaus.getPalaute());
    }
    
}
