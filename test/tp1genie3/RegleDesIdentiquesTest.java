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
public class RegleDesIdentiquesTest {
    
   @Test
    public void testEstRespecteTrue() {
        List<De> des = new ArrayList<De>();
        des.add(new De(1));
        des.add(new De(1));
        des.add(new De(1));
        RegleDesIdentiques regle = new RegleDesIdentiques(des, 1);
        assertTrue(regle.estRespecte());
    }
    
    @Test
    public void testEstRespecteFalseAvec1Different() {
        List<De> des = new ArrayList<De>();
        des.add(new De(1));
        des.add(new De(1));
        des.add(new De(3));
        RegleDesIdentiques regle = new RegleDesIdentiques(des, 1);
        assertFalse(regle.estRespecte());
    }
    
    
    @Test
    public void testEstRespecteFalseAvec3Differents() {
        List<De> des = new ArrayList<De>();
        des.add(new De(1));
        des.add(new De(2));
        des.add(new De(3));
        RegleDesIdentiques regle = new RegleDesIdentiques(des, 1);
        assertFalse(regle.estRespecte());
    }
}
