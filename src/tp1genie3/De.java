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
    private int min = 1;
    private int max = 6;
    
    public De(){
        this.valeur = 1;
    }
    
     public De( int valeur ){
        this.valeur = valeur;
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
    
    public void brasser(){
        //brasser le dé
        this.setValeur(Aleatoire.lancerUnDe6());
    }
    
    public static De brasser ( De de ){
        de.setValeur(Aleatoire.lancerUnDe6());
        return de;      
    }
    
    public static De[] brasser ( De[] des ){
        for(int i=0 ; i < des.length ; ++i){
            des[i].setValeur(Aleatoire.lancerUnDe6());
        }
        
        return des;      
    }
    
}
