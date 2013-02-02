/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1genie3;

import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tino
 */
public class RegleDesSuiteTest {
    
    @Test
    public void testEstRespecteTrueSuite123() {
        List<De> des = new ArrayList<De>();
        des.add(new De(1));
        des.add(new De(2));
        des.add(new De(3));
        RegleDesSuite regle = new RegleDesSuite(des, 1);
        assertTrue(regle.estRespecte());
    }
    
    @Test
    public void testEstRespecteTrueSuite456() {
        List<De> des = new ArrayList<De>();
        des.add(new De(4));
        des.add(new De(5));
        des.add(new De(6));
        RegleDesSuite regle = new RegleDesSuite(des, 1);
        assertTrue(regle.estRespecte());
    }
    
    @Test
    public void testEstRespecteFalse134() {
        List<De> des = new ArrayList<De>();
        des.add(new De(1));
        des.add(new De(3));
        des.add(new De(4));
        RegleDesSuite regle = new RegleDesSuite(des, 1);
        assertFalse(regle.estRespecte());
    }
    
    @Test
    public void testEstRespecteTrueSuiteInverse321() {
        List<De> des = new ArrayList<De>();
        des.add(new De(3));
        des.add(new De(2));
        des.add(new De(1));
        RegleDesSuite regle = new RegleDesSuite(des, 1);
        assertTrue(regle.estRespecte());
    }
    
    @Test
    public void testEstRespecteTrueSuiteInverse654() {
        List<De> des = new ArrayList<De>();
        des.add(new De(6));
        des.add(new De(5));
        des.add(new De(4));
        RegleDesSuite regle = new RegleDesSuite(des, 1);
        assertTrue(regle.estRespecte());
    }
    
    @Test
    public void testEstRespecteTrueSuiteNonOrdonne231() {
        List<De> des = new ArrayList<De>();
        des.add(new De(2));
        des.add(new De(3));
        des.add(new De(1));
        RegleDesSuite regle = new RegleDesSuite(des, 1);
        assertTrue(regle.estRespecte());
    }
}
