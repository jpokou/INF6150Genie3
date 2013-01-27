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
public class RegleDesSuite implements Regle {
    private List <De> des;
    private int facteur;
    
    public RegleDesSuite( List <De> des, int facteur ){
        this.des = des;
        this.facteur = facteur;
    }
    
    public boolean estRespecte(){
        int minimum;    // Le dé ayant le plus petit chiffre
        boolean resultat = true;
        List <Integer> valeur = new ArrayList <Integer>() ;
        minimum = des.get(0).getValeur();
        for(int i = 0; i < des.size(); ++i){
            valeur.add(des.get(i).getValeur());
            if( des.get(i).getValeur() < minimum ){
                minimum = des.get(i).getValeur(); 
            }
        }
        for(int i = 0; i < des.size(); ++i){
            if( !(valeur.contains(minimum)) ){
                resultat = true; 
            }
            minimum = minimum +1;
        } 
        return resultat;
    }
    
    public int getFacteur(){
        return facteur;
    }
    
}
