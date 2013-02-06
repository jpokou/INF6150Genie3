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
package tp1genie3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
public class NamelessSim1
{

    public final static int NO_PARI_MIN = 1;              // Numéros de pari valides sont de 1 à 3, donc min 1
    public final static int NO_PARI_MAX = 4;              // Numéros de pari valides sont de 1 à 3, donc max 3
    public final static int MISE_MIN = 1;                 // Nombre minimum de crédit à miser est 1
    public final static int CREDIT_DEBUT = 100;           // Nombre de crédit lors d'une nouvelle partie
    
    public final static int GAIN_PARI_PAREILS = 10;       // Gain en crédits pour pari 1
    public final static int GAIN_PARI_DIFF = 2;           // Gain en crédits pour pari 2
    public final static int GAIN_PARI_SUITE = 5;          // Gain en crédits pour pari 3
    public final static int GAIN_PARI_PETIT_OU_EGAL7 = 3; // Gain en crédits pour pari 4 demande par le PO
    public final static int NO_PARI_PAREILS = 1;          // Numéro du pari pour les dés pareils
    public final static int NO_PARI_DIFF = 2;             // Numéro du pari pour les dés différents
    public final static int NO_PARI_SUITE = 3;            // Numéro du pari pour les dés formant une suite
    public final static int NO_PARI_PETIT_OU_EGAL7 = 4;   // Numéro du pari pour les dés formant une suite
    
    public final static int CREDIT_PAR_LANCER = 3;        // Nouvelle demande du PO
    public final static int REGLE_MIN = 1;                // Valeur minimum lors du choix d'une règle à l'affichage.
    public final static int REGLE_MAX = 4;                // Valeur maximal lors du choix d'une règle à l'affichage.
    
    /**
     * Une question est affichée à l'écran et l'utilisateur doit y répondre par un
     * nombre entier.
     * 
     * @param  question   question qui sera affichée à l'écran
     * @return            le nombre entier lu
     */
    public static int questionRepInt (String question)
    {
        int reponse = -1;
        boolean valide;
        
        do {
            
            try {
                System.out.print ( question );
                reponse = Integer.parseInt(Clavier.lireString());
                valide = true;
            } catch(Exception e) {
                valide = false;
                System.out.println(Messages.MESS_ERREUR_FORMAT_INVALIDE + "\n");
            } 
            
        } while(!valide);
        
        return reponse;
        
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
        
        // Afficher le menu et demander à l'utilisateur d'entrer son pari.
        //
        pari = questionRepInt ( menu );
        
        // Valider le pari pour qu'il corresponde à un choix valide (1 à 4)
        //
        while ( pari < REGLE_MIN || pari > REGLE_MAX ) {
            System.out.println ( Messages.MESS_ERREUR_PARI );
            pari = questionRepInt ( menu );    
        } // while
        
        return pari;
        
    } // lireLePari

    /**
     * Demander à l'utilisateur d'entrer sa mise (nombre de crédits).  Valider la mise 
     * pour qu'elle soit supérieur à 0 et inférieur ou égale au nombre de crédits en main
     * et retourner la mise.
     * @param  question      question pour connaître la mise du joueur
     */
    public static int lireLaMise (String question, Joueur joueur)
    {
        int mise; // Mise que le joueur a entrée
        
        // Demander à l'utilisateur d'entrer sa mise.
        //
        mise = questionRepInt ( question );
        
        // Valider la mise pour qu'elle soit supérieure à 0 et inférieure ou égale 
        // au nombre maximum de crédits pouvant être misés
        //
        while ( mise < MISE_MIN || mise > joueur.getCredit() ) {
            System.out.println ( Messages.MESS_ERREUR_MISE );
            mise = questionRepInt ( question );    
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
        boolean repOui = false;
        String reponse;
           
        reponse = questionRepString ( question ).toUpperCase();
            
        while ( !(reponse.equals("O") || reponse.equals("OUI") || 
                  reponse.equals("N") || reponse.equals("NON")) ) {
            System.out.println ( Messages.MESS_ERREUR_OUI_NON );
            reponse = questionRepString ( question ).toUpperCase();
        } // while
        
        if ( reponse.equals("O") || reponse.equals("OUI") ) {
            repOui = true;
        } 

        return repOui;
        
    } // reponseEstOui
    
    /**
     * Question demandée à l'utilisateur s'il veut jouer une partie, enregister
     * la partie courante ou quitter le jeu.
     * @param question String qui représente la question.
     * @param credit   Nombre de crédit du joueur.
     * @return 
     */
    public static boolean questionDebutJeu (String question, int credit)
    {
        boolean repOui = false;
        String reponse;
           
        reponse = questionRepString ( question ).toUpperCase();
            
        while ( !(reponse.equals("P") || reponse.equals("Q") || 
                  reponse.equals("E") ) ) {
            System.out.println ( Messages.MESS_ERREUR_PARTIE_ENR_QUIT );
            reponse = questionRepString ( question ).toUpperCase();
        } // while
        
        if ( reponse.equals("P") ) {
            repOui = true;
        } else if ( reponse.equals("E") ){
            Memoire.saveCredit(Integer.toString(credit)); //demande numero 5
        }

        return repOui;
        
    } // reponseEstOui
    
    /**
     * Méthode qui affiche le résultat des dés lancés.
     *
     * @param  des Liste des dés à afficher.
     */    
    public static void afficherLesDes (Partie partie) {
        List<De> des = partie.getDes();
        StringBuilder buffer = new StringBuilder();
        char[][] deGraphique = Messages.MESS_DE1;

        buffer.append(Messages.MESS_VOICI_LES_DES);
        buffer.append("\n");
        
        // Écrire dans le buffer la valeur des dés et la somme
        buffer.append("    ");
        
        for (int i = 0; i < des.size(); ++i) {
            buffer.append(des.get(i).getValeur());
            
            if (i < des.size() - 1) {
                buffer.append("    +    ");
            } else {
                buffer.append("    = ");
            }
        }
        
        buffer.append(partie.getSommeDes());
        buffer.append("\n");
        
        // Écrire dans la buffer les dés graphiques.
        for (int i = 0; i < Messages.MESS_DE1.length; ++i) {
            
            for (int j = 0; j < des.size(); ++j) {

                switch(des.get(j).getValeur()) {
                    case 1 : deGraphique = Messages.MESS_DE1; break;
                    case 2 : deGraphique = Messages.MESS_DE2; break;
                    case 3 : deGraphique = Messages.MESS_DE3; break;
                    case 4 : deGraphique = Messages.MESS_DE4; break;
                    case 5 : deGraphique = Messages.MESS_DE5; break;
                    case 6 : deGraphique = Messages.MESS_DE6; break;
                }

                buffer.append(String.copyValueOf(deGraphique[i]));
                buffer.append(' ');
            }

            // Afficher le tout à l'écran.
            buffer.append("\n");
        }

        System.out.println(buffer.toString());
        
    } // afficherLesDes
    
    /**
     * Méthode qui réévalue le nombre de crédits en main selon le nombre de crédits
     * misés et le gain (nombre de fois la mise).
     * 
     * @param  joueur       Le joueur dont la mise sera évaluée.
     * @param  partie       La partie que le joueur a jouée.
     * @param  nbDeRelance  Le nombre de dés relancés.
     */
    public static void calculerCreditsEnMain ( Joueur joueur, Partie partie, int nbDeRelance )
    {
        int gainEnCredits;
        int coutRelance = nbDeRelance * CREDIT_PAR_LANCER;
        
        //  Si la règle est respectée, le joueur empoche les crédits, sinon il perd sa mise.
        if (partie.regleEstRespecter(joueur.getRegle())) {
            gainEnCredits = joueur.getCredit() - joueur.getMise() + partie.getCreditsGagnes() - coutRelance;
            joueur.setCredit(gainEnCredits);
            afficherResultPari ( Messages.MESS_GAGNE + partie.getCreditsGagnes() + Messages.MESS_CREDITS, joueur.getCredit() );
        } else {
            joueur.setCredit(joueur.getCredit() - joueur.getMise() - coutRelance);
            afficherResultPari ( Messages.MESS_PERDU, joueur.getCredit() );
        }
        
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
        System.out.print ( message );
        
        System.out.print ( Messages.MESS_CREDITS_EN_MAIN + enMain );
        if ( enMain > 1 ) {
            System.out.println ( Messages.MESS_CREDITS );
        } else {
            System.out.println ( Messages.MESS_CREDIT );
        }
        
    } // afficherResultPari
    
    /**
     * Pour chaque dé, demander si le joueur désire relancer le dé une deuxième fois.
     * Il doit avoir au moins 3 crédits en main pour avoir la possibilité de relancer un dé.
     * @param partie Partie contenant la liste des dés à relancer.
     * @param joueur Le joueur qui relance les dés.
     * @return       Le nombre de dés relancés.
     */
    public static int relancerDes(Partie partie, Joueur joueur) {
        boolean deRelance = false;
        int nbRelance = 0;
        int creditTemp = joueur.getCredit() - joueur.getMise();
        
        for (int i = 0; i < partie.getDes().size(); ++i) {
            if ( (creditTemp - (nbRelance * CREDIT_PAR_LANCER)) >= CREDIT_PAR_LANCER && 
                reponseEstOui ( Messages.MESS_RELANCER + (i + 1) + " ? " ) ) {
                partie.getDe(i).brasser();
                deRelance = true;
                nbRelance++;
            }
        }
        
        // Afficher le résultat des dés si au moins un des dés a été relancé
        //
        if ( deRelance ) {
            afficherLesDes ( partie );
        } else {
            System.out.println ();
        }
        
        return nbRelance;
    }
    
    /**
     * Méthode qui affiche le nombre de crédits en main à la fin de la partie.
     * 
     * @param  creditEnMain     nombre de crédits dont le joueur dispose
     * @return  
     */
    public static void afficherFinPartie ( int creditEnMain )
    {
        
        System.out.print ( Messages.MESS_FIN_PARTIE + creditEnMain );
        if ( creditEnMain <= 1 ) {
            System.out.println ( Messages.MESS_CREDIT );
        } else {
            System.out.println ( Messages.MESS_CREDITS );
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

        System.out.print ( Messages.MESS_DEBUT_PARTIE );
        System.out.println ( Messages.MESS_DEBUT_SOULIGN );
        
    } // afficherNomJeu    

    /**
     * Créer un objet Regle selon le choix de règle joueur.
     * @param numero Le numéro de la règle.
     * @return       L'objet Regle créer selon la règle choisie.
     */
    public static Regle creerRegle ( int numero ) {
        
        switch (numero){
            case NO_PARI_PAREILS:
                return new RegleDesIdentiques(null, GAIN_PARI_PAREILS); 
            case NO_PARI_DIFF:
                return new RegleDesDifferents(null, GAIN_PARI_DIFF);
            case NO_PARI_SUITE:
                return new RegleDesSuite(null, GAIN_PARI_SUITE);
            case NO_PARI_PETIT_OU_EGAL7:
                return new RegleDesPlusPetitOuEgal(null, GAIN_PARI_PETIT_OU_EGAL7, 7);
        }
        
        return null;
    }
    
    /**
     * Demander au joueur s'il veut charger une partie. Si oui on charge la partie et on efface
     * le nombre de crédits sauvegardés, sinon le joueur commence avec 100 crédits.
     * @param joueur Le joueur asocié au chargement de la partie.
     */
    public static void chargerUnePartie(Joueur joueur) {
        File fichier = new File (Memoire.src);
        
        if(fichier.exists() && reponseEstOui ( Messages.MESS_VEUT_CHARGER_PARTIE )){
            joueur.setCredit( Integer.parseInt( Memoire.chargerCredit( Memoire.src ) ) );
        } else {
            joueur.setCredit(CREDIT_DEBUT);
        }
    }
    
    public static void main ( String[] params ) {
        Partie partie;
        Joueur joueur1 = new Joueur();
        List<De> des = new ArrayList<De>();
        int nbDeRelance = 0;
        
        // Créer les dés.
        for(int i = 0; i < 3; ++i){
            des.add(new De()); // À chaque création de De le dé est lancé
        }
        
        // Créer une nouvelle partie.
        partie = new Partie( des, joueur1 );
        
        // Afficher le nom du jeu
        //
        afficherNomJeu();
        
        // Charger une partie si demander.
        chargerUnePartie(joueur1);

        // Initialiser le processus aléatoire à l'aide d'un nombre saisi par l'utilisateur
        //
        Aleatoire.initialiserLesDes ( questionRepInt ( Messages.MESS_INITIALISER ) );
        
        // Boucle principale du jeu.
        // L'utilisateur peut jouer tant qu'il a suffisamment de crédit en main et qu'il
        // manifeste son désir de jouer
        //
        while ( partie.getJoueur().getCredit() > 0 && questionDebutJeu ( Messages.MESS_VEUT_JOUER_ENREGISTRER_QUITTER, partie.getJoueur().getCredit() ) ) {
            // Lire et valider le pari
            //
            partie.getJoueur().setRegle(creerRegle(lireLePari ( "\n" + Messages.MENU )));
            
            // Lire et valider la mise. La mise doit être supérieur à 0 et inférieur
            // ou égale au nombre de crédits en main.
            //
            partie.getJoueur().setMise(lireLaMise ( "\n" + Messages.MESS_COMBIEN_MISE, joueur1 ));
            
            // Brasser les dés.
            partie.brasserDes();
            
            // afficher les dés
            afficherLesDes(partie);
            
            // Offrir la possibilité de lancer les dés une deuxième fois.
            nbDeRelance = relancerDes(partie, joueur1);
            
            // Ré-évaluer les crédits en main selon le résultat du pari.
            //
            calculerCreditsEnMain(joueur1, partie, nbDeRelance);
            
        } // while

        afficherFinPartie ( joueur1.getCredit() );
        
    } // main
    

}