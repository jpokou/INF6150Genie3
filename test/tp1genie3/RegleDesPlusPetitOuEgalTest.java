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
public class RegleDesPlusPetitOuEgalTest {
    
    @Test
    public void testEstRespecteTruePlusPetit() {
        List<De> des = new ArrayList<De>();
        des.add(new De(1));
        des.add(new De(1));
        des.add(new De(1));
        RegleDesPlusPetitOuEgal regle = new RegleDesPlusPetitOuEgal(des, 1, 7);
        assertTrue(regle.estRespecte());
    }
    
    @Test
    public void testEstRespecteTrueEgal() {
        List<De> des = new ArrayList<De>();
        des.add(new De(1));
        des.add(new De(2));
        des.add(new De(4));
        RegleDesPlusPetitOuEgal regle = new RegleDesPlusPetitOuEgal(des, 1, 7);
        assertTrue(regle.estRespecte());
    }
    
    @Test
    public void testEstRespecteFalsePlusGrand() {
        List<De> des = new ArrayList<De>();
        des.add(new De(1));
        des.add(new De(1));
        des.add(new De(6));
        RegleDesPlusPetitOuEgal regle = new RegleDesPlusPetitOuEgal(des, 1, 7);
        assertFalse(regle.estRespecte());
    }
}
