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
public class RegleDesPlusPetitOuEgal implements Regle {
    private List <De> des;
    private int facteur;
    
    public RegleDesPlusPetitOuEgal( List <De> des, int facteur ){
        this.des = des;
        this.facteur = facteur;
    }
    
    public boolean estRespecte(){
        int somme = 0;
        boolean resultat = false;
        for(int i = 0; i < des.size(); ++i){
            somme = somme + des.get(i).getValeur();
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
