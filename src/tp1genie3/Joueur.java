/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1genie3;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Boris
 */
public class Joueur {
    private int credit = 100;
    private int mise = 0;
    private int pari = 0;
    
    //private Regle regle;
    
    public Joueur(){
        //this.credit = 100;
        //this.regle = new RegleDesDifferents();
    }
    
    public Joueur( int credit ){
        this.credit = credit;
    }
    
    public Joueur( int credit, int mise ){
        this.credit = credit;
        this.mise = mise;
    }
    
    //public Joueur( int credit, int mise, Regle regle ){
        //this.credit = credit;
        //this.mise = mise;
        //this.regle = regle;
    //}
    
    public int getCredit(){
        return this.credit;
    }
    
    public int getMise(){
        return this.credit;
    }
    
    public int getPari(){
        return this.pari;
    }
    
    //public int getRegle(){
        //return this.credit;
    //}
    
    public void setCredit(int credit){
        this.credit = credit;
    }
    
    public void setMise(int mise){
        this.mise = mise;
    }
    
    public void setPari(int pari){
        this.pari = pari;
    }
    
    //public void setRegle(Regle regle){
        //this.regle = regle;
    //}    
}
