package tp1genie3;

import java.util.List;

/**
 * Classe qui represente une règle qui vérifie si chaque dés sont identiques.
 * @author Boris
 */
public class RegleDesIdentiques extends Regle {

    /**
     * Constructeur dans lequel on donne la liste de dés et le facteur de multiplication 
     * de la mise.
     * @param Des     Liste des dés utilisée par cette règle.
     * @param facteur Facteur de multiplication de la mise.
     */
    public RegleDesIdentiques( List <De> des, int facteur ){
        this.des = des;
        this.facteur = facteur;
    }
    
    /**
     * Retourne si la règle a bien été respectée. Chaque dès doivent être identiques.
     * @return true si la règle a été respectée, sinon false;
     */
    @Override
    public boolean estRespecte(){

        for( int i = 0; i < des.size()-1; ++i ){
            if( des.get(i).getValeur() != des.get(i+1).getValeur()){ 
                return false;    
            }     
        }
        
        return true;
    }
    
}
