package Model;

import java.util.*;

/**
 * 
 */
public class Parents extends Usagers {

    /**
     * Default constructor
     */
    public Parents(String n, String p,String a) {
    	super(n,p);
    	this.Adresse = a;
    }

    public static Vector<Parents> listParents = new Vector<Parents>();
    
    public static void addParent(String n,String p,String a) {
    	listParents.add(new Parents(n,p,a));
    	System.out.println(listParents.size()+"parents");
    }
   public String Adresse;

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

    /**
     * 
     */
    public void SignalerAbsence() {
        // TODO implement here
    }

    /**
     * 
     */
    public void InscriptionSport() {
        // TODO implement here
    }

}