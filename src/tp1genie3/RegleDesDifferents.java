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
public class RegleDesDifferents implements Regle {
    private De[] des;
    private int facteur;
    
    public RegleDesDifferents( De[] Des, int facteur ){
        this.des = Des;
        this.facteur = facteur;
    }
    
    public boolean estRespecte(){
        boolean respect = true;
        for( int i = 0; i < des.length; ++i ){
            for( int j = i+1; j < des.length; ++j ){
                if( des[i].getValeur() == des[j].getValeur()){ 
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
