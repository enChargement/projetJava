package Model;

import java.util.*;

/**
 * 
 */
public class Employes_mairie extends Employes{

    /**
     * Default constructor
     */
    public Employes_mairie(String n,String p) {
    	super(n,p);
    }

    public static Vector<Employes_mairie> listEmployes_mairie = new Vector<Employes_mairie>();
    
    public static void addEmployes_mairie(String n,String p) {
    	listEmployes_mairie.add(new Employes_mairie(n,p));
    	System.out.println(listEmployes_mairie.size()+"employé de mairie");
    }
    /**
     * 
     */
    public String Tache;
    
    

    /**
     * 
     */
    public void Connexion() {
        // TODO implement here
    }

    /**
     * 
     */
    public void GererEDT() {
        // TODO implement here
    }

    /**
     * 
     */
    public void VisuListEmployee() {
        // TODO implement here
    }

    /**
     * 
     */
    public void GererEmpl() {
        // TODO implement here
    }

    /**
     * 
     */
    public void VisuListEleveC() {
        // TODO implement here
    }

    /**
     * 
     */
    public void VisuListEleveS() {
        // TODO implement here
    }

    /**
     * 
     */
    public void ValiderPieces() {
        // TODO implement here
    }

}