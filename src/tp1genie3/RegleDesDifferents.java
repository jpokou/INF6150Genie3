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
public class RegleDesDifferents implements Regle {
    private List <De> des;
    private int facteur;
    
    public RegleDesDifferents( List <De> Des, int facteur ){
        this.des = Des;
        this.facteur = facteur;
    }
    
    public boolean estRespecte(){
        boolean respect = true;
        for( int i = 0; i < des.size(); ++i ){
            for( int j = i+1; j < des.size(); ++j ){
                if( des.get(i).getValeur() == des.get(j).getValeur()){ 
                    respect = false;
                }
            }
        }
        return true;
    }
    
    public int getFacteur(){
        return facteur;
    }
}
