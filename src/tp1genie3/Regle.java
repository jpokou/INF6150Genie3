package tp1genie3;

import java.util.List;

/**
 * Classe qui represente le format d'une règle qui s'applique à un jeu de dé.
 * @author Boris
 */
public abstract class Regle {
    
    /** Liste des dés qui vont avoir un impact sur la règle. */
    protected List <De> des;
    
    /** Facteur multiplicateur de la mise. */
    protected int facteur;
    
    /**
     * Retourne si la règle a bien été respectée.
     * @return true si la règle a été respectée, sinon false;
     */
    public abstract boolean estRespecte();
    
    /**
     * Retourne le facteur multiplicateur de la mise.
     * @return Le facteur multiplicateur de la mise.
     */
    public int getFacteur() {
        return facteur;
    }
    
    /**
     * Set le nouveau facteur multiplicateur de la mise.
     * @return Le facteur multiplicateur de la mise.
     */
    public void getFacteur(int facteur) {
        this.facteur = facteur;
    }
    
    /**
     * Set une nouvelle liste de dés.
     * @param des La liste de dés.
     */
    public void setDes(List <De> des) {
        this.des = des;
    }
    
    /**
     * Retourne la liste de dés.
     * @return La liste de dés.
     */
    public List<De> getDes() {
        return this.des;
    }
}    