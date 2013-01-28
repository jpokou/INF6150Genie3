package tp1genie3;

import java.util.List;

/**
 * Classe qui represente une règle qui vérifie si chaque dés sont différents.
 * @author Boris
 */
public class RegleDesDifferents extends Regle {
    
    /**
     * Constructeur dans lequel on donne la liste de dés et le facteur de multiplication 
     * de la mise.
     * @param Des     Liste des dés utilisée par cette règle.
     * @param facteur Facteur de multiplication de la mise.
     */
    public RegleDesDifferents( List <De> Des, int facteur ){
        this.des = Des;
        this.facteur = facteur;
    }
    
    /**
     * Retourne si la règle a bien été respectée. Chaque dès doivent être différents.
     * @return true si la règle a été respectée, sinon false;
     */
    @Override
    public boolean estRespecte(){
        
        for( int i = 0; i < des.size(); ++i ){
            for( int j = i+1; j < des.size(); ++j ){
                if( des.get(i).getValeur() == des.get(j).getValeur()){ 
                    return false;
                }
            }
        }
        
        return true;
    }
}