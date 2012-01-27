/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
    public void ArvausEiOleTyhja() {
        KoodiArpoja arpoja = new KoodiArpoja();
        assertNotSame(null, arpoja.getNappula(1));
    }
    
    @Test
    public void rivinTarkistusToimii(){
        Lukija lukija = new Lukija();
        int [] rivi = {1,2,3,8};
        assertEquals(false, lukija.tarkistaArvaus(rivi));
    }
    
    @Test 
    public void rivinTarkistusToimiiHyvin(){
        Lukija lukija = new Lukija();
        int [] rivi = {1,0,3,5};
        assertEquals(true, lukija.tarkistaArvaus(rivi));
    }
}
