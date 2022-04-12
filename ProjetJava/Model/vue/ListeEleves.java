package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Reservations;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class ListeEleves extends JFrame {
	Vector<Reservations> listeReservations = new Vector<Reservations>();
	private JPanel contentPane;
	public JFrame Menu;
	String[] nomliste= new String []{"nom", "prenom", "date"};
	
	

    

	public ListeEleves(JFrame menuMenu) {
		Menu = menuMenu;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("El\u00E8ves inscrits : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 144, 25);
		contentPane.add(lblNewLabel);
		JButton btnNewButton = new JButton("Retour menu");
		btnNewButton.setBounds(292, 368, 120, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0)
			
			{
				Menu.setVisible(true);
			    dispose();
			}
			
		});
		Connection cnx = null;
		Statement statement2 = null;
		ResultSet resultat2 = null;
		try {
			cnx = login.ConnectDB();
			statement2 = cnx.createStatement();
			resultat2 = statement2.executeQuery("SELECT * FROM Reservations;");
			while(resultat2.next()){
				
				String nom2 = resultat2.getString("nom");
				String prenom2 = resultat2.getString("prenom");
				String date = resultat2.getString("dates");
				
				int jour = Integer.parseInt(date.substring(0,2));
				int mois = Integer.parseInt(date.substring(3,5));
				int annees =Integer.parseInt( date.substring(6,10));
				Date date2=new Date(annees-1900,mois-1,jour);
				System.out.print(jour);
				System.out.print(mois);
				System.out.print(annees);
				Reservations reserv = new Reservations(nom2,prenom2,date2);
				listeReservations.add(reserv);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[][] objReservations = new Object[listeReservations.size()][3];
		for(int i=0;i<listeReservations.size();i++) {
	        objReservations[i][0] = listeReservations.get(i).nom;
	        objReservations[i][1] = listeReservations.get(i).prenom;
	        objReservations[i][2] = listeReservations.get(i).date;
	        
		}
		JTable comboBox = new JTable(objReservations,nomliste);
		comboBox.setBounds(20, 34, 628, 91);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane(comboBox);
		scrollPane.setBounds(20, 34, 628, 323);
		contentPane.add(scrollPane);
		
		
		
	}
}