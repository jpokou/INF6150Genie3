/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1genie3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Boris
 */
public class RegleDesIdentiques implements Regle {
    private List <De> des;
    private int facteur;
    
    public RegleDesIdentiques( List <De> des, int facteur ){
        this.des = des;
        this.facteur = facteur;
    }
    
    public boolean estRespecte(){
        boolean respect = true;
        for( int i = 0; i < des.size()-1; ++i ){
            if( des.get(i).getValeur() != des.get(i+1).getValeur()){ 
                respect = false;    
            }     
        }
        return true;
    }
    
    public int getFacteur(){
        return facteur;
    }
}
