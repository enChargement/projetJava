package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Model.Employes_cantine;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class EDT extends JFrame {

	private JPanel contentPane;
	public JFrame Menu;
	String user= Connexion.txtuser.getText();
	String pwd= Connexion.txtpass.getText();
	public Vector<Employes_cantine> listEmploye= Employes_cantine.listEmployes_cantine;
	public Employes_cantine currentEmploye= null;
	public String[] entetes = {"LUNDI","MARDI","MERCREDI","JEUDI","VENDREDI"};
	public String[] heures = {"08h00","09h00","10h00","11h00","12h00","13h00","14h00","15h00","16h00","17h00","18h00"};

	/**
	 * Create the frame.
	 */
	public EDT(JFrame menuMenu) {
		Menu = menuMenu;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dim.width/2-this.getSize().width/2-325, dim.height/2-this.getSize().height/2-225, 650,450);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Emploi du temps");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(243, 11, 176, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Retour menu");
		btnNewButton.setBounds(270, 370, 120, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
			    Menu.setVisible(true);
			    dispose();
			}
		});
		
		for(int i =0;i<6;i++) {
			JSeparator separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBounds(80+100*i, 51, 15, 308);
			contentPane.add(separator);
		}
		for(int i =0;i<5;i++) {
			JLabel lblNewLabel_1 = new JLabel(entetes[i]);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setForeground(Color.BLACK);
			lblNewLabel_1.setBackground(Color.WHITE);
			lblNewLabel_1.setBounds(80+100*i, 51, 100, 23);
			contentPane.add(lblNewLabel_1);
		}
		for(int i =0;i<11;i++) {
			JLabel lblNewLabel_2 = new JLabel(heures[i]);
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
			lblNewLabel_2.setBounds(42, 78+26*i, 39, 14);
			contentPane.add(lblNewLabel_2);
		}
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(80, 51, 502, 2);
		contentPane.add(separator_6);
		
		JSeparator separator_6_1 = new JSeparator();
		separator_6_1.setBounds(42, 359, 540, 2);
		contentPane.add(separator_6_1);
		
		JSeparator separator_6_2 = new JSeparator();
		separator_6_2.setBounds(42, 72, 540, 10);
		contentPane.add(separator_6_2);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setBounds(42, 72, 15, 289);
		contentPane.add(separator_7);
		addTask();
	}
	
	public void getEmploye() {
		String databaseURL = "jdbc:ucanaccess://Database.accdb";
		try {
			Connection connection = DriverManager.getConnection(databaseURL);
			Statement statement = connection.createStatement();

			String sql="SELECT nom,prenom FROM tabLogin WHERE username='"+user+"' AND password='"+pwd+"';";
			ResultSet rs= statement.executeQuery(sql);
			rs.next();
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			for(var employe:listEmploye ) {
				if(employe.Nom.equals(nom) && employe.Prenom.equals(prenom)) {
					currentEmploye = employe;
					break;
				}
			}
			
			}catch(SQLException e) {
			e.printStackTrace();
		
		}
	}
	
	public void addTask() {
		getEmploye();
		for(int i=0;i<5;i++) {
			int h = 0;
			if(currentEmploye.Tache[i]!=null) {
				Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
				JLabel tacheLbl = new JLabel(currentEmploye.Tache[i].Nom);
				tacheLbl.setHorizontalAlignment(SwingConstants.CENTER);
				for(int j=0;j<heures.length;j++) {
					if(heures[j].equals(currentEmploye.Tache[i].Heure)) {
						h=j;
					}
				}
				tacheLbl.setBounds(80+100*i, 72+h*26, 101, 52);
				tacheLbl.setBorder(border);
				tacheLbl.setOpaque(true);
				tacheLbl.setBackground(Color.GRAY);
				contentPane.add(tacheLbl);
			}
		}
		
	}
}
