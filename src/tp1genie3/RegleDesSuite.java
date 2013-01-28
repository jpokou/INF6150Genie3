package tp1genie3;

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
        int minimum = des.get(0).getValeur();  // Le dé ayant le plus petit chiffre
        int temp;
        
        // Trier les valeurs
        for (int i = 0; i < des.size(); ++i) {
            for (int j = des.size() - 1; j > i; --j) {
                if (des.get(j - 1).getValeur() > des.get(j).getValeur()) {
                    temp = des.get(j - 1).getValeur();
                    des.get(j - 1).setValeur(des.get(j).getValeur());
                    des.get(j).setValeur(temp);
                }
            }
        }

        // Vérifier si on a une suite
        for (int i = 0; i < des.size() - 1; ++i) {
            if (des.get(i).getValeur() != (des.get(i + 1).getValeur() - 1)) {
                return false;
            }
        }
        
        return true;
    }
}