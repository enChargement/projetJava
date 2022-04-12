package vue;

import Model.Employes_cantine;
import Model.Employes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ListeEmployes extends JFrame {
	
	public static Vector<Model.Employes_cantine> listEmploye;
	private JPanel contentPane;
	public JFrame Menu;

	public ListeEmployes(JFrame menuMenu) {
		
		listEmploye = Model.Employes_cantine.listEmployes_cantine;
		
		Menu = menuMenu;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dim.width/2-this.getSize().width/2-350, dim.height/2-this.getSize().height/2-250, 700,500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employ\u00E9s pr\u00E9sents :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 11, 167, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Retour menu");
		btnNewButton.setBounds(264, 406, 120, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent arg0)
			
			{
				Menu.setVisible(true);
			    dispose();
			}
			
		});
		
		Object[][] objEmploye = new Object[listEmploye.size()][7];
		System.out.println(listEmploye.get(0).Nom);
		for(int i=0;i<listEmploye.size();i++) {
			objEmploye[i][0] = listEmploye.get(i).Nom;
			objEmploye[i][1] = listEmploye.get(i).Prenom;
			for(int j=0;j<5;j++) {
				if(listEmploye.get(i).Tache[j]==null) {
					objEmploye[i][j+2] = "";
				}else {
					objEmploye[i][j+2] = listEmploye.get(i).Tache[j].Nom;
				}
			}
			
		}
		String[] entetes = {"Nom","Prenom","Lundi","Mardi","Mercredi","Jeudi","Vendredi"};
		
		
		JTable tab = new JTable(objEmploye, entetes);
		
		JScrollPane jsp = new JScrollPane(tab);
		
		jsp.setBounds(10, 50, 645, 345);
		contentPane.add(jsp);
		

		
	}
}


