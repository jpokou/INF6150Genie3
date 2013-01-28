package tp1genie3;

import java.util.List;

/**
 * Classe qui représente un dé à jouer.
 * @author Boris
 */
public class De {
    
    /** Valeur du dé. */
    private int valeur;
    
    /** Valeur minimum du dé. */
    private int min = 1;
    
    /** Valeur maximum du dé. */
    private int max = 6;
    
    /**
     * Cosntructeur qui crée un dé à 6 face avec une valeur aléatoire.
     */
    public De() {
        this.valeur = Aleatoire.genererNombre(min, max);
    }
    
    /**
     * Cosntructeur qui crée un dé à 6 face avec la valeur donnée.
     * @param valeur La valeur du dé
     */
    public De( int valeur ) {
        this.valeur = valeur;
    }
    
    /**
     * Cosntructeur qui crée un dé avec des valeur entre le minimum et maximum donnée inclusivement.
     * @param min Valeur minimum du dé.
     * @param max Valeur maximum du dé.
     */
    public De( int min, int max ) {
        this.min = min;
        this.max = max;
        this.valeur = Aleatoire.genererNombre(min, max);
    }
    
    /**
     * Retourne la valeur du dé.
     * @return La valeur du dé.
     */
    public int getValeur() {
        return this.valeur; 
    }
    
    /**
     * Retourne la plus petite valeur possible du dé.
     * @return  La plus petite valeur possible du dé.
     */
    public int getMin() {
        return this.min; 
    }
    
    /**
     * Retourne la plus grande valeur possible du dé.
     * @return  La plus grande valeur possible du dé.
     */
    public int getMax() {
        return this.max; 
    }
    
    /**
     * Set la nouvelle valeur du dé.
     * @param valeur La nouvelle valeur du dé.
     * @exception IllegalArgumentException si la valeur du dé n'est pas comprise entre la valeur minimum et maximum inclusivment.
     */
    public void setValeur( int valeur ) {
        if (valeur < min && valeur > max) {
            new IllegalArgumentException();
        }
        
        this.valeur = valeur;
    }
    
    /**
     * Set la valeur minimum du dé.
     * @param min La valeur minimum du dé.
     */
    public void setMin( int min ) {
        this.valeur = min;
    }
    
    /**
     * Set la valeur maximum du dé.
     * @param max La valeur maximum du dé.
     */
    public void setMax( int max){
        this.valeur = max;
    }
    
    /**
     * Brasser le dé et retourne la valeur obtenue.
     * @return Le résultat du dé.
     */
    public int brasser(){
        this.valeur = Aleatoire.genererNombre(min, max);

        return this.valeur;
    }
    
    /**
     * Brasse la liste de dés et retourne une liste contenant le résultat de chaques dés.
     * @param des Liste des dés à brasser.
     * @return Liste contenant le résultat de chaques dés.
     */
    public static List<De> brasser ( List<De> des ){
        for(int i=0 ; i < des.size() ; ++i){
            des.get(i).valeur = Aleatoire.genererNombre(des.get(i).min, des.get(i).max);
        }
        
        return des;      
    }
    
}
