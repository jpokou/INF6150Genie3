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
    private De[] des;
    private int facteur;
    
    public RegleDesPlusPetitOuEgal( De[] des, int facteur ){
        this.des = des;
        this.facteur = facteur;
    }
    
    public boolean estRespecte(){
        int somme = 0;
        boolean resultat = false;
        for(int i = 0; i < des.length; ++i){
            somme = somme + des[i].getValeur();
        }    
        if(somme == 7){
            resultat = true;
        }
        return resultat;
    }
    
    public int getFacteur(){
        return facteur;
    }
    
}
