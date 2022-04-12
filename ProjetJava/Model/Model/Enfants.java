package Model;

import java.util.*;


/**
 * 
 */
public class Enfants extends Usagers {

    /**
     * Default constructor
     */
    public Enfants(String n,String p,String classe) {
    	super(n,p);
    	this.Classe = classe;

    }
    
    public static Vector<Enfants> listEnfants = new Vector<Enfants>();
    
    public static void addEnfant(String n,String p,String classe) {
    	listEnfants.add(new Enfants(n,p,classe));
    	System.out.println(listEnfants.size()+"enfants");
    }

    public String Classe;

    /**
     * 
     */
    public void AccesEDT() {
        // TODO implement here
    }

    /**
     * 
     */
    public void Connexion() {
        // TODO implement here
    }

    /**
     * 
     */
    public void Inscription() {
        // TODO implement here
    }

    /**
     * 
     */
    public void Inscriptionsport() {
        // TODO implement here
    }

}