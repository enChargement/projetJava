package Model;
import vue.Connexion;
import vue.login;
import java.util.*;
import java.text.*;	
import java.sql.*;
import java.sql.Date;

public class Reservations {
	public static Vector<Reservations> listReservations = new Vector<Reservations>();
    ResultSet Rs = null;
    Connection cnx = login.ConnectDB();
    
	public Reservations(String n, String p,Date d) {
		creerLDate();
		nom=n;
		prenom=p;
		date=d;
		
		
		
    }
	
	public Connexion co;
	
	public static ArrayList <Date> Ldate;
	
	public String nom;
	
	public String prenom;
	
	public Date date;
	
	public static void creerLDate (){
		ArrayList<Date> actuelle=new ArrayList();
		long miliseconds = System.currentTimeMillis();
		Date temp1=new Date(miliseconds);
		DateFormat Annees = new SimpleDateFormat("yyyy");
		DateFormat Mois = new SimpleDateFormat("MM");
		DateFormat Jours = new SimpleDateFormat("dd");
		
		int annees;
		int mois;
		int jours;
		
		
		annees = Integer.parseInt(Annees.format(temp1));;
		mois = Integer.parseInt(Mois.format(temp1));
		jours = Integer.parseInt(Jours.format(temp1))-1;
		
		
		
		
		for (int i = 0;i<30;i++) {
			temp1 = augmenterJours(jours,mois-1,annees-1900);
			actuelle.add(temp1);
			annees = Integer.parseInt(Annees.format(temp1));
			mois = Integer.parseInt(Mois.format(temp1));
			jours = Integer.parseInt(Jours.format(temp1));

			
			
			
					
		}
		
		supWeek(actuelle);
		Ldate = actuelle;
	}
		public static Date augmenterJours(int j, int m , int a) {
			
			if (j == 31 && m == 12) {
				a += 1;
				m = 1;
				j = 1;
			
				
			}else if(j==28 && m == 2 && a % 4 != 0 ){
				m += 1;
				j = 1;
				
			}else if(j == 29 && m == 2) {
				m += 1;
				j = 1;
				
			}else if(j == 31 || j == 30 && m == 6){	
				
				m += 1;
				j = 1;
				
			}else if(j == 30 && (m % 2) == 0) {
				m += 1;
				j = 1;
				
			}else if(j == 31){	
				m += 1;
				j = 1;
			}else {
				j+=1;
			}
			Date temp=new Date(a,m,j);
			return temp;
	}
	public List <Date> getDate (){
		return Ldate;
	}
	public static List <Date> supWeek(List<Date> d){
		
		for(int i=0;i<d.size();i++) {
			
			if(d.get(i).getDay()== 6 || d.get(i).getDay() ==0) {
				d.remove(i);
			}
		}
		for(int i=0;i<d.size();i++) {
			
			if(d.get(i).getDay()== 6 || d.get(i).getDay() ==0) {
				d.remove(i);
			}
		}
		
		return d;
	}
	public static void addReservation(String n,String p , String d) {
		int jour = Integer.parseInt(d.substring(0,2));
		int mois = Integer.parseInt(d.substring(3,5));
		int annees =Integer.parseInt( d.substring(6,10));
		Date date=new Date(annees-1900,mois-1,jour);
		listReservations.add(new Reservations(n,p,date));
	}
	public String toString() {
		return (""+this.nom+" "+this.prenom+" a commande le " +this.date);
	}
}