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
public class RegleDesIdentiques implements Regle {
    private De[] des;
    private int facteur;
    
    public RegleDesIdentiques( De[] des, int facteur ){
        this.des = des;
        this.facteur = facteur;
    }
    
    public boolean estRespecte(){
        boolean respect = true;
        for( int i = 0; i < des.length-1; ++i ){
            if( des[i].getValeur() != des[i+1].getValeur()){ 
                respect = false;    
            }     
        }
        return true;
    }
    
    public int getFacteur(){
        return facteur;
    }
}
