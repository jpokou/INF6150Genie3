/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1genie3;

import java.util.ArrayList;

/**
 *
 * @author Boris
 */
public class RegleDesSuite implements Regle {
    private ArrayList Des;
    private int facteur;
    
    public RegleDesSuite( ArrayList Des, int facteur ){
        this.Des = Des;
        this.facteur = facteur;
    }
    
    public boolean estRespecte(){
        return true;
    }
    
    public int getFacteur(){
        return 0;
    }
    
}
