/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1genie3;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Tino
 */
public class PartieTest {
    
    /**
     * Test of getSommeDes method, of class Partie.
     */
    @Test
    public void testGetSommeDesEgal3() {
        List<De> des = new ArrayList<De>();
        des.add(new De(1));
        des.add(new De(1));
        des.add(new De(1));
        Partie p = new Partie(des, null);
        int actual = p.getSommeDes();
        assertEquals(3, actual);
    }
    
    @Test 
    public void testGetDePremierDe() {
        List<De> des = new ArrayList<De>();
        des.add(new De(1));
        des.add(new De(2));
        des.add(new De(3));
        Partie p = new Partie(des, null);
        De de = p.getDe(0);
        assertTrue(de.getValeur() == 1);
    }
    
    @Test 
    public void testGetDeDeuxiemeDe() {
        List<De> des = new ArrayList<De>();
        des.add(new De(1));
        des.add(new De(2));
        des.add(new De(3));
        Partie p = new Partie(des, null);
        De de = p.getDe(1);
        assertTrue(de.getValeur() == 2);
    
    }
    
    @Test 
    public void testGetDeTroisiemeDe() {
        
        List<De> des = new ArrayList<De>();
        des.add(new De(1));
        des.add(new De(2));
        des.add(new De(3));
        Partie p = new Partie(des, null);
        De de = p.getDe(2);
        assertTrue(de.getValeur() == 3);
    }
    
    
}
