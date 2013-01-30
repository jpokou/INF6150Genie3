/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1genie3;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tino
 */
public class JoueurTest {
    
    /**
     * Test of getMise method, of class Joueur.
     */
    @Test
    public void testGetMise() {
        System.out.println("getMise");
        Joueur instance = new Joueur();
        int expResult = 0;
        int result = instance.getMise();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegle method, of class Joueur.
     */
    @Test
    public void testGetRegle() {
        System.out.println("getRegle");
        Joueur instance = new Joueur();
        Regle expResult = null;
        Regle result = instance.getRegle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCredit method, of class Joueur.
     */
    @Test
    public void testSetCredit() {
        System.out.println("setCredit");
        int credit = 0;
        Joueur instance = new Joueur();
        instance.setCredit(credit);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMise method, of class Joueur.
     */
    @Test
    public void testSetMise() {
        System.out.println("setMise");
        int mise = 0;
        Joueur instance = new Joueur();
        instance.setMise(mise);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRegle method, of class Joueur.
     */
    @Test
    public void testSetRegle() {
        System.out.println("setRegle");
        Regle regle = null;
        Joueur instance = new Joueur();
        instance.setRegle(regle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
