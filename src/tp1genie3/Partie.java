/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1genie3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Boris
 */


public class Partie {
    
    final static String src = "src/tp1genie3/Save.txt";
    private List <De> des;
    private Joueur joueurs;
    

    
    public Partie(){
    
    }
    
    public Partie( List <De> des, Joueur joueurs, int fact){
        this.des = des;
        this.joueurs = joueurs;
         Aleatoire.initialiserLesDes ( fact );
    }
    
    public void nouvellePartie(){
    
    }
    
    public int SommeDes(){
        int somme = 0;
        for(int i = 0; i < des.size(); ++i){
            somme = somme + des.get(i).getValeur();
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
    
    public static void lancerPartie(){
        Joueur joueur1;
        List<De> des = new ArrayList<>();
        //debut jeu
        afficherDebutJeu();
        //load save
        joueur1 = new Joueur();
        
        File fichier = new File ("src/tp1genie3/Save.txt");
        if(fichier.exists() && reponseEstOui ( MessagesTp2.MESS_VEUT_CHARGER_PARTIE )){
            joueur1.setCredit( Integer.parseInt( Memoire.chargerCredit( "src/tp1genie3/Save.txt" ) ) );
        }
        
        //etape0
        Aleatoire.initialiserLesDes ( questionRepInt ( MessagesTp2.MESS_INITIALISER ) );
        
        //joueur1.setChoix();
        //etape1
        
        //etape2
        joueur1.setPari(lireLePari ( "\n" + MessagesTp2.MENU ));
        //etape3
        joueur1.setMise(lireLaMise ( "\n" + MessagesTp2.MESS_COMBIEN_MISE, creditsEnMain ));
        
        for(int i = 0; i < 3; ++i){
            des.add(new De());
        }
        
        
        
        
        
        
        //
        
        
        //creer joueur
        
        //
        
        
        
    }
    
    public static void afficherDebutJeu(){
        System.out.print ( "\nJEU DU LANCER DES DÉS\n=====================\n" );
    } // afficherNomJeu
     
     
     
    public static boolean reponseEstOui (String question)
    {
        boolean reponseBoolean = false;
        String reponse; 
        reponse = questionRepString ( question ).toUpperCase();
        while ( !(reponse.equals("O") || reponse.equals("OUI") || 
                  reponse.equals("N") || reponse.equals("NON")) ) {
            System.out.println ( MessagesTp2.MESS_ERREUR_OUI_NON );
            reponse = questionRepString ( question ).toUpperCase();
        } // while
        if ( reponse.equals("O") || reponse.equals("OUI") ) {
            reponseBoolean = true;
        } 
        return reponseBoolean;
    } // reponseEstOui
    
    /**
     * Une question est affichée à l'écran et l'utilisateur doit y répondre par une
     * chaîne de caractères.
     * 
     * @param  question   question qui sera affichée à l'écran
     * @return            la chaine de caractère lue    
     */
    public static String questionRepString (String question)
    {
        String reponse;
        try{
            System.out.print ( question );
            reponse = Clavier.lireString ();
        }catch(Exception e){
            reponse = questionRepString ( question );
        }
        return reponse;
        
    } // questionRepString
    
    public static int questionRepInt (String question)
    {
        int reponse;
        try{
            System.out.print ( question );
            reponse = Clavier.lireIntLn ();
        }catch(Exception e){
            reponse = questionRepInt ( question );
        } 
        return reponse;
    } // questionRepInt
    
    
    
}
