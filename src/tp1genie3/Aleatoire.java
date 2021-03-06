package tp1genie3;
import java.util.*;

/**
 * Generation de nombres aleatoires.
 * 
 * @author Louise Laforest 
 * @version octobre 2008
 */
public class Aleatoire {

    private static int germe = 25;     // valeur initiale qui peut etre changee avec initialiserLesDes
    private static Random generateur = new Random ( germe );
    
    /**
     * Initialise le processus aleatoire.  Un meme germe generera les memes des
     * @param germe le germe pour intialiser le processus aleatoire
     */
    public static void initialiserLesDes ( int germe ) {
        generateur = new Random ( germe );
    } // initialiserLesDes

    /**
     * Genere un nombre entier aleatoire entre une valeur minimum et maximum inclusivement
     * @param min Valeur minimum
     * @param max Valeur maximum
     * @return un nombre entier aleatoire entre la valeur minimum et maximum inclusivement
     */
    public static int genererNombre ( int min, int max ) {
        return (int) Math.floor ( ( max ) * generateur.nextDouble () ) + min;
    } // lancerUnDe
    
    /**
     * Genere un nombre entier aleatoire entre 1 et nbfaces inclusivement
     * @param nbFaces nombre de faces du de
     * @return un nombre entier aleatoire entre 1 et nbfaces inclusivement
     */
    public static int lancerUnDe ( int nbFaces ) {
        return (int) Math.floor ( ( nbFaces ) * generateur.nextDouble () ) + 1;
    } // lancerUnDe
    
    /**
     * Genere un nombre entier aleatoire entre 1 et 6 inclusivement
     * @return un nombre entier aleatoire entre 1 et 6 inclusivement
     */
    public static int lancerUnDe6 () {
        return lancerUnDe ( 6 );
    } // lancerUnDe6

} // Aleatoire