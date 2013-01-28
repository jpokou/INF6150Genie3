package tp1genie3;

import java.util.List;

/**
 * Classe qui représente l'état d'une partie de dé.
 * @author Boris
 */
public class Partie {
    
    /** Liste des dés */
    private List <De> des;
    
    /** Joueur de la partie. */
    private Joueur joueur;

    /**
     * Constructeur qui crée une partie avec les dés et le joueur donnés en 
     * paramètres.
     * @param des     Liste contenant les dés de la partie.
     * @param joueur  Joueur de la partie.
     */
    public Partie( List <De> des, Joueur joueur) {
        this.des = des;
        this.joueur = joueur;
    }
    
    /**
     * Retourne la somme des dés.
     * @return Somme des dés.
     */
    public int getSommeDes() {
        int somme = 0;
        
        for(int i = 0; i < des.size(); ++i) {
            somme = somme + des.get(i).getValeur();
        }         
        
        return somme;
    }
    
    /**
     * Brasser les dés.
     */
    public void brasserDes() {
        
        for (int i = 0; i < des.size(); ++i) {
            des.get(i).brasser();
        }
        
    }
    
    /**
     * Retourne le dé à l'index donné.
     * @param index L'index du dé demandé.
     * @return      Le dé à l'index donné.
     */
    public De getDe( int index ) {
        if (index < 0 || index >= des.size()) {
            new IllegalArgumentException();
        }
        
        return des.get(index);
    }
    
    /**
     * Retourne la liste de dés.
     * @return La liste de dés.
     */
    public List<De> getDe() {
        return this.des;
    }
    
    /**
     * Retourne si la règle donné en paramètre est respecté par rapport aux dés
     * @param regle La règle que l'on veut vérifier.
     * @return      true si la règle est valide, sinon false.
     */
    public boolean regleEstRespecter( Regle regle ){
        regle.setDes(des);
        
        return regle.estRespecte();
    }
    
    /**
     * Retourne le nombre de crédits gagnés par le joueur.
     * @return Le nombre de crédits gagnés par le joueur.
     */
    public int getCreditsGagnes(){
        
        if (regleEstRespecter(joueur.getRegle())) {
            return joueur.getMise() * joueur.getRegle().facteur;
        } else {
            return 0;
        }
        
    }
    
    /**
     * Retourne le joueur de la partie.
     * @return  Le joueur de la partie.
     */
    public Joueur getJoueur() {
        return this.joueur;
    }
    
    /**
     * Retourne la liste de dés de la partie.
     * @return  La liste de dés de la partie.
     */
    public List <De> getDes() {
        return des;
    }
    
}