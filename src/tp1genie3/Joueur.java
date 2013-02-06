/**
 * 
 *Amélioration apportée: Création de la classe Joueur afin de permettre ultérieurement un jeu multijoueur.
 */

package tp1genie3;

/**
 * Classe qui représente un joueur.
 * @author Boris
 */
public class Joueur {
    
    /** Nombre de crédits du joueur. */
    private int credit = 100;
    
    /** La mise du joueur en crédit. */
    private int mise = 0;
    
    /** Règle qui correspond au type de pari du joueur. */
    private Regle regle = null;
    
    /**
     * Constructeur par défaut qui crée un joueur avec 100 crédits.
     */
    public Joueur() {}
    
    /**
     * Constructeur dans on donne le nombre de crédits du joueur.
     * @param credit Le nombre de crédits du joueur.
     */
    public Joueur( int credit ){
        this.credit = credit;
    }
    
    /**
     * Constructeur dans on donne le nombre de crédits du joueur et le montant
     * de la mise.
     * @param credit Le nombre de crédits du joueur.
     * @param mise   La mise du joueur en crédit.
     */
    public Joueur( int credit, int mise ){
        this.credit = credit;
        this.mise = mise;
    }
    
    /**
     * Constructeur dans on donne le nombre de crédits du joueur, le montant
     * de la mise et la règle.
     * @param credit Le nombre de crédits du joueur.
     * @param mise   La mise du joueur en crédit.
     * @param regle  La règle du pari du joueur.
     */
    public Joueur( int credit, int mise, Regle regle ){
        this.credit = credit;
        this.mise = mise;
        this.regle = regle;
    }
    
    /**
     * Retourne le nombre de crédits du joueur.
     * @return Le nombre de crédits du joueur.
     */
    public int getCredit(){
        return this.credit;
    }
    
    /**
     * Retourne la mise du joueur en crédit.
     * @return La mise du joueur en crédit.
     */
    public int getMise(){
        return this.mise;
    }
    
    /**
     * Retourne la règle du pari du joueur.
     * @return La règle du pari du joueur.
     */
    public Regle getRegle(){
        return this.regle;
    }
    
    /**
     * Set le nouveau nombre de crédits du joueur.
     * @param credit Nombre de crédits du joueur.
     */
    public void setCredit(int credit){
        this.credit = credit;
    }
    
    /**
     * Set la nouvlle mise du joueur en crédit.
     * @param credit La mise du joueur en crédit.
     */
    public void setMise(int mise){
        this.mise = mise;
    }
    
    /**
     * Set la nouvelle règle de pari du joueur.
     * @param regle La nouvelle règle de pari.
     */
    public void setRegle(Regle regle){
        this.regle = regle;
    }    
}