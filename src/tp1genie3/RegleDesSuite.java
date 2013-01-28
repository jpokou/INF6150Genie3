package tp1genie3;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui represente une règle qui vérifie si les dés représentent une suite.
 * @author Boris
 */
public class RegleDesSuite extends Regle {

    /**
     * Constructeur dans lequel on donne la liste de dés et le facteur de multiplication 
     * de la mise.
     * @param Des     Liste des dés utilisée par cette règle.
     * @param facteur Facteur de multiplication de la mise.
     */
    public RegleDesSuite( List <De> des, int facteur ){
        this.des = des;
        this.facteur = facteur;
    }
    
    /**
     * Retourne si la règle a bien été respectée. Les dés doivent représenter une
     * suite.
     * @return true si la règle a été respectée, sinon false;
     */
    @Override
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
}
