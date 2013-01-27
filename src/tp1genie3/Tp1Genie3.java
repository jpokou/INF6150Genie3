package tp1genie3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * La classe Tp2 simule un jeu de dés.  L'utilisateur doit parier sur le résultat
 * du lancer de trois dés effectués par l'ordinateur.  Ce montant misé est déduit 
 * de ce qu'il a en main.  L'ordinateur lance les dés.  L'utilisateur à le choix 
 * de relancer chacun des dés une seule fois.  Ensuite, si le résultat final du 
 * lancer des dés correspond à ce que l'utilisateur a parié, il empoche un certain
 * nombre de crédits.  La partie termine lorsque le joueur n'a plus de crédit en
 * main ou lorsqu'il manifeste son désir de mettre fin à la partie.
 * 
 */
public class Tp1Genie3
{

    final static int NO_PARI_MIN = 1;  // Numéros de pari valides sont de 1 à 3, donc min 1
    final static int NO_PARI_MAX = 4;  // Numéros de pari valides sont de 1 à 3, donc max 3
    final static int MISE_MIN = 1;  // Nombre minimum de crédit à miser est 1
    final static String MESS_VOICI_LES_DES = "\nVoici les trois dés : ";
    
    final static int GAIN_PARI_1 = 10;     // Gain en crédits pour pari 1
    final static int GAIN_PARI_2 = 2;      // Gain en crédits pour pari 2
    final static int GAIN_PARI_3 = 5;      // Gain en crédits pour pari 3
    final static int GAIN_PARI_4 = 3;      // Gain en crédits pour pari 4 demande par le PO
    final static int NO_PARI_PAREILS = 1;  // Numéro du pari pour les dés pareils
    final static int NO_PARI_DIFF = 2;     // Numéro du pari pour les dés différents
    final static int NO_PARI_SUITE = 3;    // Numéro du pari pour les dés formant une suite
    final static int NO_PARI_EGAL7 = 4;    // Numéro du pari pour les dés formant une suite
    final static String MESS_CREDITS = " crédits.";
    
    final static String MESS_CREDITS_EN_MAIN = "\nVous disposez maintenant de ";
    final static String MESS_CREDIT = " crédit.";   
    //final static String MESS_CREDITS = " crédits."; 
    
    final static int CREDIT_PAR_LANCER = 3;  //Nouvelle demande du PO
    
    final static String MESS_FIN_PARTIE = "\nVous avez terminé la partie avec ";
    
    final static String MESS_DEBUT_PARTIE = "\nJEU DU LANCER DES DÉS\n";
    final static String MESS_DEBUT_SOULIGN = "=====================\n";
    
    /**
     * Une question est affichée à l'écran et l'utilisateur doit y répondre par un
     * nombre entier.
     * 
     * @param  question   question qui sera affichée à l'écran
     * @return            le nombre entier lu
     */
    public static int questionRepInt (String question)
    {
        try{
            System.out.print ( question );
        }catch
       
        return Clavier.lireIntLn ();
        
    } // questionRepInt

    
    /**
     * Une question est affichée à l'écran et l'utilisateur doit y répondre par une
     * chaîne de caractères.
     * 
     * @param  question   question qui sera affichée à l'écran
     * @return            la chaine de caractère lue    
     */
    public static String questionRepString (String question)
    {
        System.out.print ( question );
       
        return Clavier.lireString ();
        
    } // questionRepString
    
    
    /**
     * Afficher les choix des paris possibles (menu) et saisir le pari.  Valider le pari
     * pour qu'il corresponde à un choix valide (1, 2 ou 3) et retourner le pari.
     * 
     * @param  menu   le menu qui montre les choix possible
     * @return pari   le pari que l'utilisateur a entré 
     */
    public static int lireLePari (String menu)
    {
        int pari;                   // Numéro du pari entré par l'utilisateur
        //final int NO_PARI_MIN = 1;  // Numéros de pari valides sont de 1 à 3, donc min 1
        //final int NO_PARI_MAX = 4;  // Numéros de pari valides sont de 1 à 3, donc max 3
        
        // Afficher le menu et demander à l'utilisateur d'entrer son pari.
        //
        pari = questionRepInt ( menu );
        
        // Valider le pari pour qu'il corresponde à un choix valide (1 à 3)
        //
        while ( pari < NO_PARI_MIN || pari > NO_PARI_MAX ) {
            System.out.println ( MessagesTp2.MESS_ERREUR_PARI );
            pari = questionRepInt ( menu );    
        } // while

        return pari;
        
    } // lireLePari

    
    /**
     * Demander à l'utilisateur d'entrer sa mise (nombre de crédits).  Valider la mise 
     * pour qu'elle soit supérieur à 0 et inférieur ou égale au nombre de crédits en main
     * et retourner la mise.
     * 
     * @param  combienMise   question pour connaître la mise du joueur
     * @param  max           nombre de crédits maximum que le joueur peut miser (crédits en main)
     * @return mise          nombre de crédits misés par le joueur pour le prochain pari
     */
    public static int lireLaMise (String combienMise, int max)
    {
        int mise;                // Mise que le joueur a entrée
        //final int MISE_MIN = 1;  // Nombre minimum de crédit à miser est 1
        
        // Demander à l'utilisateur d'entrer sa mise.
        //
        mise = questionRepInt ( combienMise );
        
        // Valider la mise pour qu'elle soit supérieure à 0 et inférieure ou égale 
        // au nombre maximum de crédits pouvant être misés
        //
        while ( mise < MISE_MIN || mise > max ) {
            System.out.println ( MessagesTp2.MESS_ERREUR_MISE );
            mise = questionRepInt ( combienMise );    
        } // while

        return mise;
        
    } // lireLaMise

    
    /**
     * Une question est posée au joueur et le joueur doit répondre soit par oui ou
     * par non.  La méthode valide la réponse et retourne une valeur booléenne pour 
     * indiquer si la réponse est affirmative ou négative.
     * 
     * @param  question     question qui sera posée au joueur
     * @return repOui       true si le joueur a répondu par l'affirmative à la question
     */    
    public static boolean reponseEstOui (String question)
    {
        boolean repOui;
        String reponse;
           
        reponse = questionRepString ( question ).toUpperCase();
            
        while ( !(reponse.equals("O") || reponse.equals("OUI") || 
                  reponse.equals("N") || reponse.equals("NON")) ) {
            System.out.println ( MessagesTp2.MESS_ERREUR_OUI_NON );
            reponse = questionRepString ( question ).toUpperCase();
        } // while
        
        if ( reponse.equals("O") || reponse.equals("OUI") ) {
            repOui = true;
        } else {
            repOui = false;
        }

        return repOui;
        
    } // reponseEstOui
    
    
    public static boolean QuestionDebutJeu (String question, int credit)
    {
        boolean repOui = false;
        String reponse;
           
        reponse = questionRepString ( question );
            
        while ( !(reponse.equals("p") || reponse.equals("q") || 
                  reponse.equals("e") ) ) {
            System.out.println ( MessagesTp2.MESS_ERREUR_PARTIE_ENR_QUIT );
            reponse = questionRepString ( question );
        } // while
        
        if ( reponse.equals("p") ) {
            repOui = true;
        } else if ( reponse.equals("e") ){
            saveCredit(Integer.toString(credit)); //demande numero 5
        }

        return repOui;
        
    } // reponseEstOui
    
 
    /**
     * Méthode qui affiche le résultat des 3 dés lancés.
     *
     * @param  de1      résultat du dé1
     * @param  de2      résultat du dé2
     * @param  de3      résultat du dé3
     * @return 
     */    
    public static void afficherLesDes (int de1, int de2, int de3)
    {
        int somme = de1 + de2 + de3; //Demande nunero5 du PO
        //final String MESS_VOICI_LES_DES = "\nVoici les trois dés : ";
         
        System.out.println ( MESS_VOICI_LES_DES + de1 + " + " + de2 + " + " + de3 + " = "  + somme +"\n ");
        
    } // afficherLesDes
    

    /**
     * Cette méthode détermine s'il y a gain.  Si c'est le cas, elle évalue
     * à combien de fois la mise le gain correspond.
     * 
     * @param  de1      résultat du dé 1
     * @param  de2      résultat du dé 2
     * @param  de3      résultat du dé 3
     * @param  pari     le numéro du pari que le joueur a choisi
     * @return nbFoisMise   le nombre de fois la mise selon le gain
     */    
    public static int determineNbFoisMise (int de1, int de2, int de3, int pari)
    {
        int nbFoisMise = 0;             // Nombre de fois la mise
        //final int GAIN_PARI_1 = 10;     // Gain en crédits pour pari 1
        //final int GAIN_PARI_2 = 2;      // Gain en crédits pour pari 2
        //final int GAIN_PARI_3 = 5;      // Gain en crédits pour pari 3
        //final int GAIN_PARI_4 = 3;      // Gain en crédits pour pari 4 demande par le PO
        //final int NO_PARI_PAREILS = 1;  // Numéro du pari pour les dés pareils
        //final int NO_PARI_DIFF = 2;     // Numéro du pari pour les dés différents
        //final int NO_PARI_SUITE = 3;    // Numéro du pari pour les dés formant une suite
        //final int NO_PARI_EGAL7 = 4;    // Numéro du pari pour les dés formant une suite
        /*
        if ( pari == NO_PARI_PAREILS ) {
            if ( sontPareils ( de1, de2, de3 ) ) {
                nbFoisMise = GAIN_PARI_1;
            }
        } else if ( pari == NO_PARI_DIFF ) {
            if ( sontDifferents ( de1, de2, de3 ) ) {
                nbFoisMise = GAIN_PARI_2;
            }
        } else if ( sontUneSuite ( de1, de2, de3 ) ) {
            nbFoisMise = GAIN_PARI_3;
        }
        */
        
        if ( pari == NO_PARI_PAREILS ) {
            if ( sontPareils ( de1, de2, de3 ) ) {
                nbFoisMise = GAIN_PARI_1;
            }
        } else if ( pari == NO_PARI_SUITE ) { 
                if(sontUneSuite ( de1, de2, de3 )){
                    nbFoisMise = GAIN_PARI_3;
                }
        }else if ( pari == NO_PARI_EGAL7 ) {
            if (  sontEgale7( de1, de2, de3 ) ) {
                nbFoisMise = GAIN_PARI_4;
            }
        }else if ( pari == NO_PARI_DIFF ) {
            if ( sontDifferents( de1, de2, de3 ) ) {
                nbFoisMise = GAIN_PARI_2;
            }
        } 
        
        
        return nbFoisMise;
        
    } // determineNbFoisMise
    
    
    /**
     * Méthode qui détermine si les dés sont tous pareils.  Si c'est le cas,
     * la méthode retourne 'true', sinon elle retourne 'false'.
     * 
     * @param  de1      résultat du dé 1
     * @param  de2      résultat du dé 2
     * @param  de3      résultat du dé 3
     * @return          true si les dés sont pareils, sinon false est retourné 
     */
    public static boolean sontPareils ( int de1, int de2, int de3 )
    {
        if ( de1 == de2 && de1 == de3 ) {
            return true;
        } else {
            return false;
        }
        
    } // sontPareils

    
    /**
     * Méthode qui détermine si les dés sont tous différents.  Si c'est le cas,
     * la méthode retourne 'true', sinon elle retourne 'false'.
     * 
     * @param  de1      résultat du dé 1
     * @param  de2      résultat du dé 2
     * @param  de3      résultat du dé 3
     * @return          true si les dés sont différents, sinon false est retourné 
     */
    public static boolean sontDifferents ( int de1, int de2, int de3 )
    {
        if ( de1 != de2 && de1 != de3 && de2 != de3 ) {
            return true;
        } else {
            return false;
        }
        
    } // sontDifferents
    
    
    /**
     * Méthode qui détermine si les dés correspondent à une suite.  Si c'est le cas,
     * la méthode retourne 'true', sinon elle retourne 'false'.
     * 
     * @param  de1      résultat du dé 1
     * @param  de2      résultat du dé 2
     * @param  de3      résultat du dé 3
     * @return          true si les dés correspondent à une suite, sinon false est retourné 
     */
    public static boolean sontUneSuite ( int de1, int de2, int de3 )
    {
        
        int premChiffre;    // Le dé ayant le plus petit chiffre
        
        // Trouver le chiffre le plus petit des 3 dés
        //
        premChiffre = Math.min ( de1, de2 );
        premChiffre = Math.min ( premChiffre, de3 );
        
        // Vérifier si un dé correspond au chiffre suivant du plus petit trouvé précédemment
        //
        if ( premChiffre + 1 == de1 || premChiffre + 1 == de2 || premChiffre + 1 == de3 ) {
            // Vérifier si un dé correspond au 2ième chiffre suivant le plus petit trouvé précédemment
            //
            if ( premChiffre + 2 == de1 || premChiffre + 2 == de2 || premChiffre + 2 == de3 ) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
        
    } // sontUneSuite
    
    
    /**
     * Méthode qui détermine si la somme des valeurs des dés est egale a 7.  Si c'est le cas,
     * la méthode retourne 'true', sinon elle retourne 'false'.
     * 
     * @param  de1      résultat du dé 1
     * @param  de2      résultat du dé 2
     * @param  de3      résultat du dé 3
     * @return          true si les dés correspondent à une suite, sinon false est retourné 
     */
    //********************************//
    public static boolean sontEgale7 ( int de1, int de2, int de3 )
    {
        int somme = de1 + de2 + de3;
        boolean resultat = false;
        if(somme == 7){
            resultat = true;
        }
        return resultat;
    } // sontEgale7
    //*******************************//
    
    /**
     * Méthode qui réévalue le nombre de crédits en main selon le nombre de crédits
     * misés et le gain (nombre de fois la mise).  Le nombre de crédits en main 
     * réévalué est retourné.
     * 
     * @param  enMain        le nombre de crédits dont dispose le joueur
     * @param  crMises       le nombre de crédits que le joueur a misé
     * @param  nbFoisLaMise  gain représenté en nombre de fois la mise
     * @return               le nombre de crédits en main réévalué
     */
    public static int calculerCreditsEnMain ( int enMain, int crMises, int nbFoisLaMise )
    {
        int gainEnCredits;          // Gain calculé en nombre de crédits
        //final String MESS_CREDITS = " crédits."; 

        //  Si le nombre de fois la mise est égale à 0, ça indique que le joueur
        //  a perdu et un message en ce sens est affiché.  Sinon, le nombre de
        //  crédits en main est réévalué.
        //
        if ( nbFoisLaMise == 0 ) {
            afficherResultPari ( MessagesTp2.MESS_PERDU, enMain );
        } else {
            gainEnCredits = nbFoisLaMise * crMises;
            enMain = enMain + gainEnCredits;
            afficherResultPari ( MessagesTp2.MESS_GAGNE + gainEnCredits + MESS_CREDITS, enMain );
        }        
        
        return enMain;
        
    } // calculerCreditsEnMain
        
    
    /**
     * Méthode qui affiche s'il s'agit d'un gain ou non et qui affiche le nombre
     * de crédits dont le joueur dispose.
     * 
     * @param  message      message à afficher
     * @param  enMain       nombre de crédits en main
     * @return     
     */
    public static void afficherResultPari ( String message, int enMain )
    {
        //final String MESS_CREDITS_EN_MAIN = "\nVous disposez maintenant de ";
        //final String MESS_CREDIT = " crédit.";   
        //final String MESS_CREDITS = " crédits."; 
        
        System.out.print ( message );
        
        System.out.print ( MESS_CREDITS_EN_MAIN + enMain );
        if ( enMain > 1 ) {
            System.out.println ( MESS_CREDITS );
        } else {
            System.out.println ( MESS_CREDIT );
        }
        
    } // afficherResultPari
    
   
    /**
     * Méthode principale du jeu.  Les dés sont lancés, le résultat des dés est évalué
     * pour déterminer s'il y a gain.  Si c'est le cas, le gain est calculé en nombre
     * de crédits et le nombre de crédits en main est ajusté.
     * 
     * @param  creditsEnMain    crédits dont dispose le joueur
     * @param  pari             numéro du pari que le joueur a choisi
     * @param  creditsMises     le nombre de crédits misés par le joueur
     * @return credit en main   le nombre de crédits dont le joueur dispose après le jeu
     */    
    public static int determinerResultPari (int creditsEnMain, int pari, int creditsMises)
    {
        int de1;
        int de2;
        int de3;
        boolean deRelance = false;          // Indique si un des dés a été relancé
        //final int CREDIT_PAR_LANCER = 2;   // Il en coûte 2 crédits pour relancer un dé
        
        //*******************************//
        //final int CREDIT_PAR_LANCER = 3;  //Nouvelle demande du PO
        //*******************************//
        
        // Lancer les 3 dés et afficher le résultat
        //
        de1 = Aleatoire.lancerUnDe6();
        de2 = Aleatoire.lancerUnDe6();
        de3 = Aleatoire.lancerUnDe6();
        afficherLesDes ( de1, de2, de3 );
        
        // Pour chaque dé, demander si le joueur désire relancer le dé une deuxième fois.
        // Il doit avoir au moins 2 crédits en main pour avoir la possibilité de relancer un dé.
        //
        if ( creditsEnMain >= CREDIT_PAR_LANCER && 
             reponseEstOui ( MessagesTp2.MESS_RELANCER + "1 ? " ) ) {
            de1 = Aleatoire.lancerUnDe6();
            creditsEnMain = creditsEnMain - CREDIT_PAR_LANCER;
            deRelance = true;
        }
        if ( creditsEnMain >= CREDIT_PAR_LANCER && 
             reponseEstOui ( MessagesTp2.MESS_RELANCER + "2 ? " ) ) {
            de2 = Aleatoire.lancerUnDe6();
            creditsEnMain = creditsEnMain - CREDIT_PAR_LANCER;
            deRelance = true;
        }        
        if ( creditsEnMain >= CREDIT_PAR_LANCER && 
             reponseEstOui ( MessagesTp2.MESS_RELANCER + "3 ? " ) ) {
            de3 = Aleatoire.lancerUnDe6();
            creditsEnMain = creditsEnMain - CREDIT_PAR_LANCER;
            deRelance = true;
        }        
        // Afficher le résultat des dés si au moins un des dés a été relancé
        //
        if ( deRelance ) {
            afficherLesDes ( de1, de2, de3 );
        } else {
            System.out.println ();
        }
        
        // Selon le résultat du pari (determineNbFoisMise), calculer et retourner la nouvelle 
        // valeur des crédits en main
        //
        return calculerCreditsEnMain ( creditsEnMain, creditsMises, 
                                       determineNbFoisMise ( de1, de2, de3, pari ) );
        
    } // determinerResultPari
    
    
    /**
     * Méthode qui affiche le nombre de crédits en main à la fin de la partie.
     * 
     * @param  creditEnMain     nombre de crédits dont le joueur dispose
     * @return  
     */
    public static void afficherFinPartie ( int creditEnMain )
    {
        //final String MESS_FIN_PARTIE = "\nVous avez terminé la partie avec ";
        //final String MESS_CREDIT = " crédit";   
        //final String MESS_CREDITS = " crédits"; 
        
        System.out.print ( MESS_FIN_PARTIE + creditEnMain );
        if ( creditEnMain <= 1 ) {
            System.out.println ( MESS_CREDIT );
        } else {
            System.out.println ( MESS_CREDITS );
        }
        
    } // afficherFinPartie    
    
    
    /**
     * Méthode qui affiche le nom du jeu.
     * 
     * @param  
     * @return  
     */
    public static void afficherNomJeu ()
    {
        //final String MESS_DEBUT_PARTIE = "\nJEU DU LANCER DES DÉS\n";
        //final String MESS_DEBUT_SOULIGN = "=====================\n";

        System.out.print ( MESS_DEBUT_PARTIE );
        System.out.println ( MESS_DEBUT_SOULIGN );
        
    } // afficherNomJeu    
    
    
    
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
    
    public static void main ( String[] params ) {
        
        // Déclaration des variables
        //
        int pari;                   // Le numéro du pari, peut être 1, 2 ou 3. Voir menu
        int creditsMises;           // Le nombre de crédits que le joueur désire miser
        int creditsEnMain = 100;    // Le joueur débute la partie avec 100 crédits en main
        
        // Afficher le nom du jeu
        //
        afficherNomJeu ();
        
        File fichier = new File ("src/tp1genie3/Save.txt");
        if(fichier.exists() && reponseEstOui ( MessagesTp2.MESS_VEUT_CHARGER_PARTIE )){
            
            creditsEnMain = Integer.parseInt(chargerCredit( "src/tp1genie3/Save.txt" ));
        }
        
        // Initialiser le processus aléatoire à l'aide d'un nombre saisi par l'utilisateur
        //
        Aleatoire.initialiserLesDes ( questionRepInt ( MessagesTp2.MESS_INITIALISER ) );
        
        // Boucle principale du jeu.
        // L'utilisateur peut jouer tant qu'il a suffisamment de crédit en main et qu'il
        // manifeste son désir de jouer
        //
        //while ( creditsEnMain > 0 && reponseEstOui ( MessagesTp2.MESS_VEUT_JOUER ) ) {
        while ( creditsEnMain > 0 && QuestionDebutJeu ( MessagesTp2.MESS_VEUT_JOUER_ENREGISTRER_QUITTER, creditsEnMain ) ) {
            // Lire et valider le pari
            //
            pari = lireLePari ( "\n" + MessagesTp2.MENU );
            
            // Lire et valider la mise.  La mise doit être supérieur à 0 et inférieur
            // ou égale au nombre de crédits en main.
            //
            creditsMises = lireLaMise ( "\n" + MessagesTp2.MESS_COMBIEN_MISE, creditsEnMain );
            
            // Déduire les crédits misés du nombre de crédits en main
            //
            creditsEnMain = creditsEnMain - creditsMises;
            
            // Jouer les dés et déterminer le résultat du pari.  Ré-évaluer les crédits
            // en main selon le résultat du pari.
            //
            creditsEnMain = determinerResultPari ( creditsEnMain, pari, creditsMises );
            
        } // while
        
        afficherFinPartie ( creditsEnMain );
        
    } // main
}