package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;

public class Menu extends JFrame {

	private JPanel contentPane;
	public int authority;
	public JFrame reference;
	public JFrame moi;

	/**
	 * Create the frame.
	 */
	public Menu(int level, JFrame menuCo) {
		authority = level;
		reference = menuCo;
        moi = this;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dim.width/2-this.getSize().width/2-325, dim.height/2-this.getSize().height/2-250, 650, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenue ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
		lblNewLabel.setBounds(260, 15, 130, 26);
		contentPane.add(lblNewLabel);
		
		JButton deco = new JButton("Deconnexion");
        deco.setBounds(275, 424, 100, 25);
        contentPane.add(deco);
        deco.addActionListener(new ActionListener() 

        {

            public void actionPerformed(ActionEvent arg0)

            {
                menuCo.setVisible(true);
                dispose();
            }

        });
	
		
		JButton btnMenu = new JButton("Menu de la semaine");
		btnMenu.setBounds(50,50,150,25);
		contentPane.add(btnMenu);
		btnMenu.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e)
			
			{
				RepasSemaine s = new RepasSemaine(moi);
			    s.setVisible(true);
			    dispose();
			}
			
		});
		if(level!=1) {
			JButton btnReserver = new JButton("reserver repas");
			btnReserver.setBounds(250,50,150,25);
			contentPane.add(btnReserver);
			btnReserver.addActionListener(new ActionListener() 
			{
				
				public void actionPerformed(ActionEvent e)
				
				{
					ReserverRepas s = new ReserverRepas(authority,moi);
				    s.setVisible(true);
				    dispose();
				}
			});
			if(level==3 ||level==4) {
				JButton btnListeEleve = new JButton("Liste eleves");
				btnListeEleve.setBounds(450,50,150,25);
				contentPane.add(btnListeEleve);
				btnListeEleve.addActionListener(new ActionListener() 
				{
					
					public void actionPerformed(ActionEvent arg0)
					
					{
						ListeEleves s = new ListeEleves(moi);
					    s.setVisible(true);
					    dispose();
					}
					
				});
				
				if(level==3) {
					JButton btnEDT = new JButton("Emploi du temps");
					btnEDT.setBounds(250,100,150,25);
					contentPane.add(btnEDT);
					btnEDT.addActionListener(new ActionListener() 
					{
						
						public void actionPerformed(ActionEvent e)
						
						{
							EDT s = new EDT(moi);
						    s.setVisible(true);
						    dispose();
						}
						
					});
				
				
				}
				if(level==4) {
					JButton btnGerer = new JButton("Gerer employe");
					btnGerer.setBounds(250,100,150,25);
					contentPane.add(btnGerer);
					btnGerer.addActionListener(new ActionListener() 
					{
						
						public void actionPerformed(ActionEvent arg0)
						
						{
							GererEmployes s = new GererEmployes(moi);
						    s.setVisible(true);
						    dispose();
						}
					});
				
				}
				
			}
		}
	}
}