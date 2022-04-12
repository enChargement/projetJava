package Model;

import java.util.*;

/**
 * 
 */
public class Employes_cantine extends Employes{
	
	
	public static Vector<Employes_cantine> listEmployes_cantine = new Vector<Employes_cantine>();
    /**
     * Default constructor
     */
    public Employes_cantine(String n, String p, Tache[] t) {
    	super(n,p);
    	this.Tache = t;
    }
    
    
    
    public static void addEmployes_cantine(String n,String p,Tache[] tache) {
    	listEmployes_cantine.add(new Employes_cantine(n,p,tache));
    	System.out.println(listEmployes_cantine.size()+"employé de cantine");
    }

    /**
     * 
     */
    
    /**
     * 
     */
    public Tache[] Tache = new Tache[5];

    /**
     * 
     */
    public void Connexion() {
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
    public void AccesEDT() {
        // TODO implement here
    }

}