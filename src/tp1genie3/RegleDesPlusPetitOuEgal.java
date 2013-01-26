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
public class RegleDesPlusPetitOuEgal implements Regle {
    private ArrayList Des;
    private int facteur;
    
    public RegleDesPlusPetitOuEgal( ArrayList Des, int facteur ){
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
