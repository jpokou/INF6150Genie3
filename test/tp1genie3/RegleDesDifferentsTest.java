/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1genie3;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tino
 */
public class RegleDesDifferentsTest {
    
    @Test
    public void testEstRespecteTrue() {
        List<De> des = new ArrayList<De>();
        des.add(new De(1));
        des.add(new De(2));
        des.add(new De(3));
        RegleDesDifferents regle = new RegleDesDifferents(des, 1);
        assertTrue(regle.estRespecte());
    }
    
    @Test
    public void testEstRespecteFalseAvec2DesIdentique() {
        List<De> des = new ArrayList<De>();
        des.add(new De(1));
        des.add(new De(1));
        des.add(new De(3));
        RegleDesDifferents regle = new RegleDesDifferents(des, 1);
        assertFalse(regle.estRespecte());
    }
    
    
    @Test
    public void testEstRespecteFalseAvec3DesIdentique() {
        List<De> des = new ArrayList<De>();
        des.add(new De(1));
        des.add(new De(1));
        des.add(new De(1));
        RegleDesDifferents regle = new RegleDesDifferents(des, 1);
        assertFalse(regle.estRespecte());
    }
    
}
