/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1genie3;
/**
 *
 * @author Boris
 */

import java.util.ArrayList;
import java.util.List;
public class De {
    private int valeur;
    private int min;
    private int max;
    
    public De(){
        this.valeur = 1;
        this.min = 1;
        this.max = 6;
    }
    
     public De( int valeur ){
        this.valeur = valeur;
        this.min = 1;
        this.max = 6;
    }
    
    public De( int valeur, int min, int max ){
        this.valeur = valeur;
        this.min = min;
        this.max = max;
    }
    
    public int getValeur(){
        return this.valeur; 
    }
    
    public int getMin(){
        return this.min; 
    }
    
    public int getMax(){
        return this.max; 
    }
    
    public void setValeur( int valeur){
        this.valeur = valeur;
    }
    
    public void setMin( int min){
        this.valeur = min;
    }
    
    public void setMax( int max){
        this.valeur = max;
    }
    
    public int brasser(){
        //brasser le dé
        return 0;
    }
    
    public static De brasser ( De de ){
        de = new De( Aleatoire.lancerUnDe6());
        return de;      
    } 
    
}
