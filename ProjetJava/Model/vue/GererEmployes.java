package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import Model.Employes_cantine;
import Model.Reservations;
import Model.Tache;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;

public class GererEmployes extends JFrame {
	
	private JPanel contentPane;
	private JPanel contentPane2;
	public JFrame MainMenu;
	public JFrame MenuAdd;
	public JFrame self;
	public int currentSelect = 0;

	public GererEmployes(JFrame menuMenu) {
		self = this;
		MainMenu = menuMenu;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dim.width/2-this.getSize().width/2-320, dim.height/2-this.getSize().height/2-210, 640,420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRetour = new JButton("Retour menu");
		btnRetour.setBounds(257, 347, 120, 23);
		contentPane.add(btnRetour);
		
		JButton btnModif = new JButton("modifier tache");
		btnModif.setBounds(257, 95, 120, 23);
		contentPane.add(btnModif);
		btnModif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				self.setVisible(false);
				modifierTache();
			}
		});
		
		JButton btnListe = new JButton("liste employe");
		btnListe.setBounds(257, 153, 120, 23);
		contentPane.add(btnListe);
		btnListe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				ListeEmployes LE = new ListeEmployes(self);
				LE.setVisible(true);
			    dispose();
			}
		});

		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				MainMenu.setVisible(true);
			    dispose();
			}
		});
	}
	
	//------------------------------------------------------------------------------------------------------------------
	//--------------------fonction du menu de modification des taches---------------------------------------------------
	//------------------------------------------------------------------------------------------------------------------
	
	public void modifierTache() {
		String[] entetes = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi"};
		MenuAdd = new JFrame();
		MenuAdd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		MenuAdd.setBounds(dim.width/2-MenuAdd.getSize().width/2-320, dim.height/2-MenuAdd.getSize().height/2-210, 640,420);
		MenuAdd.setVisible(true);
		contentPane2 = new JPanel();
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		MenuAdd.setContentPane(contentPane2);
		contentPane2.setLayout(null);
		
		Vector<Employes_cantine> listEmploye ;
		listEmploye = Employes_cantine.listEmployes_cantine;
		Vector<String> listNom = new Vector<String>();
		listNom.add("-------");
		for(var employe:listEmploye) {
			listNom.add(employe.Nom + " " + employe.Prenom);
		}
		
		JButton btnModifier = new JButton("modifier");
		btnModifier.setBounds(257, 227, 120, 23);
		contentPane2.add(btnModifier);
		btnModifier.setVisible(false);
		
		JButton btnConfirmer = new JButton("confirmer");
		btnConfirmer.setBounds(257, 255, 120, 23);
		contentPane2.add(btnConfirmer);
		btnConfirmer.setVisible(false);
		
		
		//--------------------------affiche les taches de l'employe selectionné---------------------------
		Vector<JLabel> listLblTache = new Vector<JLabel>();
		Vector<JComboBox> listComboTache = new Vector<JComboBox>();
		List<Date> listDate = Reservations.Ldate;
		JComboBox comboBox = new JComboBox(listNom);
		comboBox.setBounds(96, 46, 144, 22);
		contentPane2.add(comboBox);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				for(int i=0;i<5;i++) {
					Tache tempo;
					if(comboBox.getSelectedIndex()==0) {
						tempo = listEmploye.get(comboBox.getSelectedIndex()).Tache[i];
					}else {
						tempo = listEmploye.get(comboBox.getSelectedIndex()-1).Tache[i];	
					}
					if(tempo == null || comboBox.getSelectedIndex()==0) {
						listLblTache.get(i).setText("");
					}else {
						listLblTache.get(i).setText(listEmploye.get(comboBox.getSelectedIndex()-1).Tache[i].Nom);
					}
				}
				currentSelect = comboBox.getSelectedIndex();
					if(comboBox.getSelectedIndex()==0) {
						btnModifier.setVisible(false);	
					}else {
						btnModifier.setVisible(true);
					}
			}
		});
		//----------------affichage tache de l'employe par defaut---------------------------------------
		for(int i=0;i<5;i++) {
			JLabel lbl = new JLabel(entetes[i]);
			lbl.setBounds(96+96*i, 96,75,25);
			contentPane2.add(lbl);
			
			listLblTache.add(new JLabel(""));

			listLblTache.get(i).setBounds(96+96*i,150,75,25);
			contentPane2.add(listLblTache.get(i));
		}
		
		//----------------création des comboBox avec les taches-------------------------------
		int jour =listDate.get(0).getDay();
		System.out.println("jour : "+jour);
		String[] tempNom = new String[Tache.tacheType.size()];
		for(int j = 0;j<Tache.tacheType.size();j++) {
				tempNom[j]=Tache.tacheType.get(j).Nom;
		}
		for (int i=0;i<5;i++) {
			listComboTache.add(new JComboBox(tempNom));
			listComboTache.get(i).setBounds(96+96*i,200,75,25);
			contentPane2.add(listComboTache.get(i));
			listComboTache.get(i).setVisible(false);
		}
		
		//-------------------------------------------------------------------------------------
		JLabel lblNewLabel = new JLabel("employe :");
		lblNewLabel.setBounds(36, 50, 63, 14);
		contentPane2.add(lblNewLabel);
		
		JButton btnRetour = new JButton("Retour menu");
		btnRetour.setBounds(257, 347, 120, 23);
		contentPane2.add(btnRetour);
		btnRetour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				MenuAdd.setVisible(false);
			    self.setVisible(true);
			}
		});
		
		
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=0;i<5;i++) {
					if((i+1)>=jour) {
						listComboTache.get(i).setVisible(true);
					}else {
						listComboTache.get(i).setVisible(false);
					}
				}
				btnModifier.setVisible(false);
				comboBox.setVisible(false);
				btnConfirmer.setVisible(true);
			}
		});
		
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=0;i<5;i++) {
					if((i+1)>=jour) {
						listEmploye.get(currentSelect-1).Tache[i]=Tache.getTacheByNom(tempNom[listComboTache.get(i).getSelectedIndex()]);
					}
				}
				
				Tache[] currentTache = listEmploye.get(currentSelect-1).Tache;
				String databaseURL = "jdbc:ucanaccess://Database.accdb";
				
				try {
					Connection connection = DriverManager.getConnection(databaseURL);
					Statement statement = connection.createStatement();
					for(int i=0;i<5;i++) {
						if(i+1>=jour) {
							String sql="UPDATE Tache SET "+entetes[i]+" ='"+currentTache[i].Nom+"' WHERE nom='"+listEmploye.get(currentSelect-1).Nom+"' AND prenom='"+listEmploye.get(currentSelect-1).Prenom+"';";
							int rows= statement.executeUpdate(sql);
					
							if (rows>0) {
								System.out.println("infos insérées");
							}
						}
					}
				}catch(SQLException ev) {
					ev.printStackTrace();
				}
				btnConfirmer.setVisible(false);
				comboBox.setVisible(true);
				for(int i=0;i<5;i++) {
					listComboTache.get(i).setVisible(false);
				}
				comboBox.setSelectedIndex(0);
			}
		});
	}
}
