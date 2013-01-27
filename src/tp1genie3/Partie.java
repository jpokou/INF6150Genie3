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

public class Partie {
    
    private De[] des;
    private Joueur[] joueurs;

    
    public Partie(){
    
    }
    
    public Partie( De[] des, Joueur[] joueurs, int fact){
        this.des = des;
        this.joueurs = joueurs;
         Aleatoire.initialiserLesDes ( fact );
    }
    
    public void nouvellePartie(){
    
    }
    
    public int SommeDes(){
        int somme = 0;
        for(int i = 0; i < des.length; ++i){
            somme = somme + des[i].getValeur();
        }         
        return somme;
    }
    
    public int brasserDes(){
        return 0;
    }
    
    public De getDe( int index ){
        return null;
    }
    
    public boolean regleEstRespecter( Regle regle ){
        return true;
    }
    
    public int getCreditsGagnes(){
        return 0;
    }
    
    
}
