/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1genie3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Boris
 */
public class Memoire {
    
    final static String src = "src/tp1genie3/Save.txt";
    
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
                //System.out.println(ligne);
            }
            br.close();
            file.deleteOnExit();
        }catch (Exception e){
            //System.out.println(e.toString());
        }
        return credit;
    }
    
    
    
    public static String chargerCredit( String src ){
        String ligne = " ";
        String credit = " ";
        File file = new File(src);
        try{
            InputStream ips=new FileInputStream(src);
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            
            while ((ligne=br.readLine())!=null){
                credit = ligne;
                //System.out.println(ligne);
            }
            br.close();
            file.deleteOnExit();
        }catch (Exception e){
            //System.out.println(e.toString());
        }
        return credit;
    }
    
    
    public static void saveCredit(String credit){
        try{
            File save=new File("src/tp1genie3/Save.txt"); // définir l'arborescence
            save.createNewFile();
            FileWriter ffw=new FileWriter(save);
            ffw.write(credit);  // écrire une ligne dans le fichier resultat.txt
            ffw.write("\n"); // forcer le passage à la ligne
            ffw.close(); // fermer le fichier à la fin des traitements
        } catch (Exception e) {}
    
    }
    
}
