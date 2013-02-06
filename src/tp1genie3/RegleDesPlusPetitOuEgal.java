/**
 * 
 *Amélioration apportée: Découpé en classe, utilisation du polymorphisme et permet de rajouté des règles aiséments.
 */

package tp1genie3;

import java.util.List;

/**
 * Classe qui represente une règle qui vérifie si la somme des dés est plus petite
 * ou égale à une valeur maximale.
 * @author Nameless
 */
public class RegleDesPlusPetitOuEgal extends Regle {
    
    /** Représente la valeur maximale que la règle doit respectée. */
    private int max;
    
    /**
     * Constructeur dans lequel on donne la liste de dés, le facteur de multiplication 
     * de la mise et la valeur maximale de la règle.
     * @param Des     Liste des dés utilisée par cette règle.
     * @param facteur Facteur de multiplication de la mise.
     * @param max     Valeur maximale de la règle.
     */
    public RegleDesPlusPetitOuEgal( List <De> des, int facteur, int max ){
        this.des = des;
        this.facteur = facteur;
        this.max = max;
    }
    
    /**
     * Retourne si la règle a bien été respectée. La somme de des dés doit être
     * plus petite que la valeur maximale de la règle.
     * @return true si la règle a été respectée, sinon false;
     */
    @Override
    public boolean estRespecte(){
        int somme = 0;
        boolean resultat = false;
        
        for(int i = 0; i < des.size(); ++i){
            somme = somme + des.get(i).getValeur();
        }    
        
        if(somme <= max){
            resultat = true;
        }
        
        return resultat;
    }
    
}