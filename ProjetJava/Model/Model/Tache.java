package Model;

import java.util.*;

/**
 * 
 */
public class Tache {
	public String Nom;
	
    public String Heure;
    /**
     * Default constructor
     */
    public Tache(String nom,String heure) {
    	Nom = nom;
    	Heure = heure;
		
    }

    
    public static Tache[] getListeTache(String[] nom) {
    	Tache[] temp = new Tache[5];
    	for(int i =0;i<5;i++) {
    		temp[i]=getTacheByNom(nom[i]);
    	}
    	return temp;
    	 
    }
    
    public static Tache getTacheByNom(String nom) {
    	for(int i =0;i<tacheType.size();i++) {
    		if(tacheType.get(i).Nom.equals(nom)) {
    			return tacheType.get(i);
    		}
    	}
    	return null;
    }
    
    public static void addTache(String nomT, String heureT) {
    	tacheType.add(new Tache(nomT,heureT));
    }
    
    public static Vector<Tache> tacheType = new Vector<Tache>();

}