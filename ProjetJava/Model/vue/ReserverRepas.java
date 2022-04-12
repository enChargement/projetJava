package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Model.Enfants;
import Model.Reservations;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class ReserverRepas extends JFrame {

	private JPanel contentPane;
	public JFrame Menu;
	public ArrayList<String> joursSemaine = new ArrayList<String>();
	Connection cnx =  login.ConnectDB();
	Statement statement2 = null;
	ResultSet resultat2 = null;
	ArrayList<Enfants> Lenfant=new ArrayList<Enfants>();
	String Nenfant;
	int autorite;
	Boolean vege= false;
	Enfants Enfantc;
	JCheckBox chekbox;
	String Nenf;

	public ReserverRepas(int a,JFrame menuMenu) {
		
		Menu = menuMenu;
		autorite=a;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("R\u00E9server son repas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(213, 11, 215, 29);
		contentPane.add(lblNewLabel);
		
		
		for (int i =0;i<Reservations.Ldate.size();i++) {
			joursSemaine.add((String)Reservations.Ldate.get(i).toString());
		}
		String[] array = new String[joursSemaine.size()];
		for(int i = 0; i < array.length; i++) {
		    array[i] = joursSemaine.get(i);
		}
		
		JCheckBox chekbox = new JCheckBox("vege");
		chekbox.setBounds(335, 120, 131, 23);
		contentPane.add(chekbox);

		JComboBox comboBox = new JComboBox(array); // jour des reservations
		comboBox.setBounds(374, 75, 285, 22);
		comboBox.setVisible(false);
		contentPane.add(comboBox);
		if (autorite==3 || autorite==4) {
			
		JComboBox comboBoxstaff = new JComboBox(array); // jour des reservations
		comboBoxstaff.setBounds(231, 172, 285, 22);
		comboBoxstaff.setVisible(true);
		contentPane.add(comboBoxstaff);
		String Sql2 = "Select * from tabLogin WHERE username ='" +Connexion.txtuser.getText()+
       		 "'AND password='"+Connexion.txtpass.getText()+"'";
		try{
		cnx = login.ConnectDB();
		Statement statement2 = cnx.createStatement();
		resultat2 = statement2.executeQuery(Sql2);
		
			if (resultat2.next()) {
				String txt=resultat2.getString("nom");
				String txtp=resultat2.getString("prenom");
				String regime = resultat2.getString("regime");
				if (regime.equals("vege")) {
					chekbox.setVisible(false);
					chekbox.setSelected(true);
					
				}
				updateV(comboBoxstaff,txt,txtp);
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		JButton btnNewButton_1 = new JButton("Reserver");
		btnNewButton_1.setBounds(305, 293, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try{
				String txt=null;
				String txtp=null;
				String regime;
				
				if (chekbox.getSelectedObjects()==null) {
					regime="normal";	
				}else {
					regime ="vege";
				}

				String jour5;
				String mois5;
				String annees5;
				String concatenation12= (String) comboBoxstaff.getSelectedItem();

				jour5 = concatenation12.substring(0,2);
				mois5 = concatenation12.substring(3,5);
				annees5 = concatenation12.substring(6,10);
				
				String resultatdate =(jour5+"-"+mois5+"-"+annees5);
				String Sql = "Select * from tabLogin WHERE username ='" +Connexion.txtuser.getText()+
		        		 "'AND password='"+Connexion.txtpass.getText()+"'";
				
				
				Statement statement = cnx.createStatement();
				resultat2 = statement.executeQuery(Sql);
				
				if (resultat2.next()) {
					txt=resultat2.getString("nom");
					txtp=resultat2.getString("prenom");	
				}
				String sql="INSERT INTO Reservations (nom, prenom,dates,regime) VALUES ('"+txt+"','"+txtp+"','"+resultatdate+"','"+regime+"')";
				
				statement = cnx.createStatement();
				int rows= statement.executeUpdate(sql);
				
				updateV(comboBoxstaff,txt,txtp);
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}});
		}
		JButton btnNewButton = new JButton("Retour menu");
		btnNewButton.setBounds(292, 368, 120, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				Menu.setVisible(true);
			    dispose();
			}
		});
		try {	
			cnx = login.ConnectDB();
			statement2 = cnx.createStatement();
			resultat2  = statement2.executeQuery("SELECT * FROM tabLogin;");
			while(resultat2.next()) { 
				if(Connexion.txtuser.getText().equals(resultat2.getString("username")) ){
					if(Connexion.txtpass.getText().equals(resultat2.getString("password"))){
						for (var i : Enfants.listEnfants) {
							
							if(resultat2.getString("nom").equals(i.Nom) ) {
								Lenfant.add(i);
							}
						}
					}
				}
			}
		}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		if(autorite==2) {
		String[] array3 = new String[Lenfant.size()];
		for(int i = 0; i < array3.length; i++) {
		    array3[i] = Lenfant.get(i).Prenom;
		}
		String[] array4 = new String[Lenfant.size()];
		for(int i = 0; i < array3.length; i++) {
		    array4[i] = array3[i];
		}
		JComboBox comboBox_1 = new JComboBox(array4);
		comboBox_1.setBounds(48, 75, 285, 22);
		contentPane.add(comboBox_1);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				updateV(comboBox,comboBox_1);
		}});
		
		for(var enf:Lenfant) {
			if (enf.Prenom.equals(comboBox_1.getSelectedItem())) {
				 Nenf=enf.Nom;
			}
		}

		String Sql26 = "Select * from tabLogin WHERE prenom ='" +comboBox_1.getSelectedItem()+
	       		 "'AND nom='"+Nenf+"'";
		try {
			resultat2  = statement2.executeQuery(Sql26);
			resultat2.next();
			String regime =resultat2.getString("regime");
			if(regime.equals("vege")) {
				chekbox.setVisible(false);
				chekbox.setSelected(true);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		JButton btnNewButton_1 = new JButton("Reserver");
		btnNewButton_1.setBounds(305, 293, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try{
				String databaseURL = "jdbc:ucanaccess://Database.accdb";
				Connection connection = DriverManager.getConnection(databaseURL);
				
				String txt=(String) comboBox_1.getSelectedItem();
				String txtp=Connexion.txtpass.getText();
				String regime;
				if (chekbox.getSelectedObjects()==null) {
					regime="normal";	
				}
				else {
					regime ="vege";
				}
				
				String concatenation5= (String) comboBox.getSelectedItem();
				for (int i = 0;i<array4.length;i++) {
					if (Lenfant.get(i).Prenom==comboBox_1.getSelectedItem()) {
						Nenfant = Lenfant.get(i).Nom;
					}
				}
				String sql="INSERT INTO Reservations (nom, prenom,dates,regime) VALUES ('"+Nenfant+"','"+txt+"','"+concatenation5+"','"+regime+"')";
				Statement statement = connection.createStatement();
				int rows= statement.executeUpdate(sql);
				
				updateV(comboBox,comboBox_1);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}});
		}
	}
	
	public void updateV(JComboBox comboBox ,JComboBox comboBox_1) {
		comboBox.setVisible(true);
		comboBox.removeAllItems();
		try {
			statement2 = cnx.createStatement();
			String alpha = (String) comboBox_1.getSelectedItem();
			resultat2  = statement2.executeQuery("SELECT * FROM Reservations;");
			ArrayList<String> temp2 =new ArrayList<String>();
				while(resultat2.next()) {
					temp2.add( resultat2.getString("dates"));
				}
			ArrayList <String> temp = new ArrayList <String>();
			for (var dat:Reservations.Ldate) {
				temp.add(dat.toString());	
			}
			
			String jour;
			String mois;
			String annees;
			String concatenation;
			
			ArrayList <String> Lconca = new ArrayList <String>();
			for (int i =0;i<temp.size();i++) {
				jour = temp.get(i).toString().substring(8,10);
				
				mois = temp.get(i).toString().substring(5,7);
				
				annees = temp.get(i).toString().substring(0,4);
				
				concatenation=(jour+"-"+mois+"-"+annees);
				Lconca.add(concatenation);
			}
			
			temp.clear();
			for (var temp18:Lconca) {
				temp.add(temp18);
			}
			for (int omega=0;omega<temp.size();omega++) {
				for(int beta=0;beta<temp2.size();beta++) {
					
					if (temp.get(omega).equals(temp2.get(beta))) {
						temp.remove(temp.get(omega));
					}
				}
			}
			String[] array5 = new String[temp.size()];
			for(int i = 0; i < array5.length; i++) {
				array5[i] = temp.get(i);
				comboBox.addItem(array5[i]);
				}
			}catch (SQLException e) {
				e.printStackTrace();
				}
		}
	
	public void updateV(JComboBox comboBox,String txt,String txtp) {
		comboBox.removeAllItems();
		try {
			statement2 = cnx.createStatement();
			String Sql = "SELECT * fROM Reservations";
			resultat2  = statement2.executeQuery(Sql);
			ArrayList<String> temp2 =new ArrayList<String>();
				while(resultat2.next()) {
					if(resultat2.getString("nom").equals(txt) && resultat2.getString("prenom").equals(txtp)) {
					temp2.add( resultat2.getString("dates"));
					}
				}
			
			ArrayList <String> temp = new ArrayList <String>();
			for (var dat:Reservations.Ldate) {
				temp.add(dat.toString());	
				}
			String jour;
			String mois;
			String annees;
			String concatenation;
			
			ArrayList <String> Lconca = new ArrayList <String>();
			for (int i =0;i<temp.size();i++) {
				jour = temp.get(i).toString().substring(8,10);
				
				mois = temp.get(i).toString().substring(5,7);
				
				annees = temp.get(i).toString().substring(0,4);
				
				concatenation=(jour+"-"+mois+"-"+annees);
				Lconca.add(concatenation);
				}
			temp.clear();
			for (var temp18:Lconca) {	
				temp.add(temp18);
				}
			
			for (int omega=0;omega<temp.size();omega++) {
				for(int beta=0;beta<temp2.size();beta++) {
					if (temp.get(omega).equals(temp2.get(beta))) {
						temp.remove(temp.get(omega));
					}
				}
			}
			String[] array5 = new String[temp.size()];
			for(int i = 0; i < array5.length; i++) {
				array5[i] = temp.get(i);
				comboBox.addItem(array5[i]);
				}
			}catch (SQLException e) {
				e.printStackTrace();
				}
		}
	}
