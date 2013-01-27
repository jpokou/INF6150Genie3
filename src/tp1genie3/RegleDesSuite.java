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
    private De[] des;
    private int facteur;
    
    public RegleDesSuite( De[] des, int facteur ){
        this.des = des;
        this.facteur = facteur;
    }
    
    public boolean estRespecte(){
        int premChiffre;    // Le dé ayant le plus petit chiffre
        boolean resultat = false;
        
        // Trouver le chiffre le plus petit des 3 dés
        //
        premChiffre = Math.min ( des[0].getValeur(), des[1].getValeur() );
        premChiffre = Math.min ( premChiffre, des[2].getValeur() );
        // Vérifier si un dé correspond au chiffre suivant du plus petit trouvé précédemment
        //
        if ( premChiffre + 1 == des[0].getValeur() || premChiffre + 1 == des[1].getValeur() || premChiffre + 1 == des[2].getValeur() ) {
            // Vérifier si un dé correspond au 2ième chiffre suivant le plus petit trouvé précédemment
            //
            if ( premChiffre + 2 == des[0].getValeur() || premChiffre + 2 == des[1].getValeur() || premChiffre + 2 == des[2].getValeur() ) {
                resultat = true;
            } 
        } 
        
        return resultat;
    }
    
    public int getFacteur(){
        return facteur;
    }
    
}
