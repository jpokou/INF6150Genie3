
package tp1genie3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Classe qui permet la sauvegarde des données dans un fichier .txt
 * ou de charger des données
 * @author Nameless
 */
public class Memoire {
    
    final static String src = "src/tp1genie3/Save.txt";
    
    /**
     * Méthode qui charge le nombre de credit contenu dans le fichier src
     * 
     * @param
     * @return le nombre de credit  
     */
    public static String chargerCredit(){
        String ligne = " ";
        String credit = " ";
        File file = new File(src);
        try{
            InputStream ips=new FileInputStream(src);
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            
            while ((ligne=br.readLine())!=null){
                credit = ligne;
            }
            br.close();
            file.delete();
        }catch (Exception e){}
        return credit;
    }
    
    
    /**
     * Méthode qui charge le nombre de credit contenu dans le fichier src
     * 
     * @param le root vers le fichier .txt
     * @return le nombre de credit  
     */
    public static String chargerCredit( String src ){
        String ligne = " ";
        String credit = " ";
        File file = new File(src);
        try{
            InputStream is=new FileInputStream(src);
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            
            while ((ligne=br.readLine())!=null){
                credit = ligne;
            }
            br.close();
            file.delete();
        }catch (Exception e){}
        return credit;
    }
    
    /**
     * Méthode qui sauvegarde le nombre de credit dans le fichier src
     * 
     * @param le nombre de credit
     * @return   
     */
    public static void saveCredit(String credit){
        try{
            File save=new File(src); // définir l'arborescence
            save.createNewFile();
            FileWriter fw=new FileWriter(save);
            fw.write(credit);  // écrire une ligne dans le fichier resultat.txt
            fw.write("\n"); // forcer le passage à la ligne
            fw.close(); // fermer le fichier à la fin des traitements
        } catch (Exception e) {}
    
    }
}
    