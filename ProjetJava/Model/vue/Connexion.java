package vue;
import Model.Enfants;
import Model.Reservations;
import Model.Tache;
import Model.Employes_cantine;
import Model.Employes_mairie;
import Model.Parents;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.SwingConstants;

public class Connexion extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFrame frame;
	static JTextField txtuser;
	static JTextField txtpass;
	Connection cnx = null;
	ResultSet Rs = null;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */

	public static void main(String[] args) throws SQLException {
		
		Reservations.creerLDate();
		EventQueue.invokeLater(
				new Runnable() {
			public void run() {
				try {
					
					Connexion window = new Connexion();
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public Connexion() {
		initialize();
	}
	
	public void initializeBDD() {
		Statement statement = null;
		ResultSet resultat = null;
		
		Statement stmt = null;
		ResultSet rs = null;
		
		Statement stmt2 = null;
		ResultSet rs2 = null;
		
		try {
			statement = cnx.createStatement();
			resultat  = statement.executeQuery("SELECT * FROM tabLogin;");
			stmt2 = cnx.createStatement();
			rs2 = stmt2.executeQuery("SELECT * FROM ListeTache;");
			while(rs2.next()) {
				String nomTache = rs2.getString("nom");
				String heureTache = rs2.getString("heure");
				System.out.println(nomTache + " " + heureTache);
				Tache.addTache(nomTache, heureTache);
			}
			while (resultat.next()) {
				String nomRS = resultat.getString("nom");
				String prenomRS = resultat.getString("prenom");
				String classe = resultat.getString("classe");
				String adresse = resultat.getString("adresse");
				String regime = resultat.getString("regime");
				if(resultat.getInt("autorite")==1) {
					Enfants.addEnfant(nomRS, prenomRS, classe);	
				}else if(resultat.getInt("autorite")==2){
					Parents.addParent(nomRS, prenomRS, adresse);
				
				}else if(resultat.getInt("autorite")==4) {
					Employes_mairie.addEmployes_mairie(nomRS, prenomRS);
				
				}else if(resultat.getInt("autorite")==3) {

					stmt = cnx.createStatement();
					rs = stmt.executeQuery("SELECT * FROM Tache " + "INNER JOIN tabLogin USING(nom, prenom);");
					
					String[] jours = {"lundi","mardi","mercredi","jeudi","vendredi"};
						
						while(rs.next()) {
							String[] tache = new String[5];
							for(int i = 0;i<5;i++) {
								tache[i] = rs.getString(jours[i]);
							}
							if(rs.getString("nom").equals(resultat.getString("nom")) && rs.getString("prenom").equals(resultat.getString("prenom"))) {
								System.out.println(tache[0]);
								Tache[] listTache = Tache.getListeTache(tache);
								
								
								System.out.println("ajout d'un employe de cantine : "+ nomRS + " " + prenomRS);

								Employes_cantine.addEmployes_cantine(nomRS, prenomRS, listTache);
							}	
						}
					}
				}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement statement2 = null;
		ResultSet resultat2 = null;
		try {
			
			statement2 = cnx.createStatement();
			resultat2 = statement2.executeQuery("SELECT * FROM Reservations;");
			while(resultat2.next()){
				String nom2 = resultat2.getString("nom");
				String prenom2 = resultat2.getString("prenom");
				String date = resultat2.getString("dates");
				Reservations.addReservation(nom2, prenom2, date);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                cnx = login.ConnectDB();
                initializeBDD();   
            }
        });
		
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dim.width/2-frame.getSize().width/2-250, dim.height/2-frame.getSize().height/2-150, 612,369);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		txtuser = new JTextField();
		txtuser.setBounds(196, 79, 192, 20);
		panel.add(txtuser);
		txtuser.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Identifiant :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(115, 82, 83, 14);
		panel.add(lblNewLabel);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(196, 136, 192, 20);
		panel.add(txtpass);
		txtpass.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mot de passe :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(100, 139, 83, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Se connecter");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(243, 27, 96, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ma Cantine");
		lblNewLabel_3.setBounds(10, 305, 71, 14);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Inscription");
        btnNewButton_1.setBounds(234, 229, 133, 28);
        panel.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Inscription s = new Inscription(frame);
                s.setVisible(true);
                frame.dispose();
            }
        });
		
		JButton btnNewButton = new JButton("Confirmer");
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ev){
			try {
				String Sql = "Select * from tabLogin WHERE username ='" +txtuser.getText()+"'and password='"+txtpass.getText()+"'";
				Statement statement = cnx.createStatement();
				Rs = statement.executeQuery(Sql);
				if (Rs.next()){
					int autorite = Rs.getInt("autorite");
					Menu s = new Menu(autorite,frame);
					s.setVisible(true);
					frame.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Identifiant ou mot de passe incorrect." );
					}
				}catch (SQLException e) {
						e.printStackTrace();
				}          
			}
		});

		btnNewButton.setBounds(234, 191, 133, 28);
		panel.add(btnNewButton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Afficher mot de passe");
        chckbxNewCheckBox.setBounds(413, 135, 157, 23);
        panel.add(chckbxNewCheckBox);
        
        JButton btnQuit = new JButton("Quitter");
        btnQuit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        btnQuit.setBounds(497, 282, 89, 23);
        panel.add(btnQuit);
        chckbxNewCheckBox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if ( ((JPasswordField) txtpass).getEchoChar() != '\u0000' ) {
                    ((JPasswordField) txtpass).setEchoChar('\u0000');

                } else {
                    ((JPasswordField) txtpass).setEchoChar((Character) UIManager.get("PasswordField.echoChar"));
                    }
                }
            });
        }
	
}
