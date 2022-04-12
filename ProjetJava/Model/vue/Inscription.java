package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JCheckBox;

public class Inscription extends JFrame {

	private JPanel contentPane;
	static JTextField txtNom;
	static JTextField txtPrenom;
	static JTextField txtID;
	String txtRegime="normal";
	static JTextField txtAdresse;
	static JTextField txtClasse;
	static JTextField txtAutorite;
	public JFrame reference;
	Connection cnx = null;
	ResultSet Rs = null;
	static JTextField txtMdp;

	/**
	 * Launch the application.
	 */

	public Inscription(JFrame menuCo) {
		reference = menuCo;
		cnx = login.ConnectDB();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds(dim.width/2-this.getSize().width/2-365, dim.height/2-this.getSize().height/2-200, 730,400);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inscription");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(307, 11, 106, 27);
		contentPane.add(lblNewLabel);
		
		txtNom = new JTextField();
		txtNom.setBounds(106, 85, 128, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(106, 135, 128, 20);
		contentPane.add(txtPrenom);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(106, 184, 128, 20);
		contentPane.add(txtID);
		
		JLabel lblNewLabel_1 = new JLabel("Nom :");
		lblNewLabel_1.setBounds(50, 88, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prenom :");
		lblNewLabel_1_1.setBounds(39, 138, 57, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Identifiant :");
		lblNewLabel_1_2.setBounds(27, 187, 82, 14);
		contentPane.add(lblNewLabel_1_2);
		
		txtAdresse = new JTextField();
		txtAdresse.setBounds(520, 124, 112, 20);
		contentPane.add(txtAdresse);
		txtAdresse.setColumns(10);
	
		JLabel lblNewLabel_3 = new JLabel("Adresse :");
		lblNewLabel_3.setBounds(448, 127, 72, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Classe :");
		lblNewLabel_4.setBounds(463, 228, 57, 14);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setVisible(false);
		
		txtClasse = new JTextField();
		txtClasse.setColumns(10);
		txtClasse.setBounds(520, 225, 112, 20);
		contentPane.add(txtClasse);
		txtClasse.setVisible(false);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Regime Vegetarien");
		chckbxNewCheckBox_1.setBounds(520, 84, 115, 23);
		contentPane.add(chckbxNewCheckBox_1);
		chckbxNewCheckBox_1.setVisible(false);
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_1.isSelected()) {
					txtRegime = "Vege";
				}else {
					txtRegime = "normal";
				}
			}
		});
		
		txtAutorite = new JTextField();
		txtAutorite.setBounds(520, 174, 22, 20);
		contentPane.add(txtAutorite);
		txtAutorite.setColumns(10);
		txtAutorite.addKeyListener(new KeyAdapter() {
			
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if  (c =='1' || c=='2'){
		             // 
		        }else {
		        	e.consume();
		        }
		        if (txtAutorite.getText().length() >= 1 ) {//limit to 3 characters
		        	e.consume();
		        }
		        if (c=='1') {
		        	chckbxNewCheckBox_1.setVisible(true);
		        	txtClasse.setVisible(true);
		        	txtClasse.revalidate();
		        	txtClasse.repaint();
		        	lblNewLabel_4.setVisible(true);
		        }else {
		        	txtClasse.setVisible(false);
		        	lblNewLabel_4.setVisible(false);
		        	chckbxNewCheckBox_1.setVisible(false);
		        }
		     }
		});
		
		JLabel lblNewLabel_5 = new JLabel("Nature du compte");
		lblNewLabel_5.setBounds(400, 165, 112, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("(Enfants : 1, Parents : 2) :");
		lblNewLabel_6.setBounds(375, 177, 144, 14);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Confirmer");
		btnNewButton.setBounds(307, 284, 106, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuCo.setVisible(true);
                dispose();
            }
        });
        btnRetour.setBounds(307, 316, 106, 23);
        contentPane.add(btnRetour);
		
		txtMdp = new JTextField();
		txtMdp.setBounds(106, 225, 128, 20);
		contentPane.add(txtMdp);
		txtMdp.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Mot de passe :");
		lblNewLabel_7.setBounds(10, 228, 86, 14);
		contentPane.add(lblNewLabel_7);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				String autorite = txtAutorite.getText();
				while (txtAutorite.getText().isEmpty()) {	
					if ( txtID.getText()!= null && !txtID.getText().isEmpty() && txtMdp.getText()!=null  && !txtMdp.getText().isEmpty() && txtAutorite.getText()!=null  && !txtAutorite.getText().isEmpty() && txtRegime!=null  && !txtRegime.isEmpty() && txtNom.getText()!=null  && !txtNom.getText().isEmpty() && txtPrenom.getText()!=null  && !txtPrenom.getText().isEmpty() && txtAdresse.getText()!=null  && !txtAdresse.getText().isEmpty()) { 
					}else {
					JOptionPane.showMessageDialog(null, "Remplissez les champs demandés ! ");
					break;
					}
				}
				if (autorite.equals("2")) { 
					if ( txtID.getText()!= null && !txtID.getText().isEmpty() && txtMdp.getText()!=null  && !txtMdp.getText().isEmpty() && txtAutorite.getText()!=null  && !txtAutorite.getText().isEmpty() && txtNom.getText()!=null  && !txtNom.getText().isEmpty() && txtPrenom.getText()!=null  && !txtPrenom.getText().isEmpty() && txtAdresse.getText()!=null  && !txtAdresse.getText().isEmpty())  { 
						try {
							String Sql = "INSERT INTO tabLogin (username, password, autorite, nom, prenom, adresse, classe) VALUES ('"+txtID.getText()+"','"+txtMdp.getText()+"','"
									+txtAutorite.getText()+"','"+txtNom.getText()+"','"+txtPrenom.getText()+"','"+txtAdresse.getText()+"','"+txtClasse.getText()+"')";
							Statement statement = cnx.createStatement();
							int rows = statement.executeUpdate(Sql);
							if (rows>0){
								JOptionPane.showMessageDialog(null, "Inscription validée" );
								System.out.println("infos insérées");
								menuCo.setVisible(true);
				                dispose(); 
							
							}
							}catch (SQLException e) {
							e.printStackTrace();
							}   
						}else {
							JOptionPane.showMessageDialog(null, "Remplissez les champs demandés ! ");
						}
					}else if (autorite.equals("1")) {
						if ( txtID.getText()!= null && !txtID.getText().isEmpty() && txtMdp.getText()!=null  && !txtMdp.getText().isEmpty() && txtAutorite.getText()!=null  && !txtAutorite.getText().isEmpty() && txtRegime!=null  && !txtRegime.isEmpty() && txtNom.getText()!=null  && !txtNom.getText().isEmpty() && txtPrenom.getText()!=null  && !txtPrenom.getText().isEmpty() && txtAdresse.getText()!=null  && !txtAdresse.getText().isEmpty() && txtClasse.getText()!=null && !txtClasse.getText().isEmpty()) { 
								try {
									String Sql = "INSERT INTO tabLogin (username, password, autorite, regime, nom, prenom, adresse, classe) VALUES ('"+txtID.getText()+"','"+txtMdp.getText()+"','"
											+txtAutorite.getText()+"','"+txtRegime+"','"+txtNom.getText()+"','"+txtPrenom.getText()+"','"+txtAdresse.getText()+"','"+txtClasse.getText()+"')";

									Statement statement = cnx.createStatement();
									int rows = statement.executeUpdate(Sql);
									if (rows>0){
										JOptionPane.showMessageDialog(null, "Inscription validée" );
										System.out.println("infos insérées");
										menuCo.setVisible(true);
						                dispose();
						            } 
								}  catch (SQLException e) {
									e.printStackTrace();
								}
					    }else {
					    	JOptionPane.showMessageDialog(null, "Remplissez les champs demandés ! ");
					    }
					}
				}
			});
		}
	}