package vue;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RepasSemaine extends JFrame {

	private JPanel contentPane;
	public JFrame Menu;

	/**
	 * Create the frame.
	 */
	public RepasSemaine(JFrame menuMenu) {
		Menu = menuMenu;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dim.width/2-this.getSize().width/2-350, dim.height/2-this.getSize().height/2-250, 700,500);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			 
		JLabel lblNewLabel = new JLabel("Menu de la semaine");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(224, 11, 196, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Retour menu");
		btnNewButton.setBounds(279, 384, 120, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Lundi");
		lblNewLabel_1.setFont(new Font("Garamond", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(67, 76, 56, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mardi");
		lblNewLabel_2.setFont(new Font("Garamond", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(178, 76, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mercredi");
		lblNewLabel_3.setFont(new Font("Garamond", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(292, 76, 69, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Jeudi");
		lblNewLabel_4.setFont(new Font("Garamond", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(430, 76, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Vendredi");
		lblNewLabel_5.setFont(new Font("Garamond", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(552, 76, 76, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Salade de concombre ");
		lblNewLabel_6.setFont(new Font("Garamond", Font.PLAIN, 12));
		lblNewLabel_6.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6.setBounds(61, 120, 107, 26);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Entr\u00E9e :");
		lblNewLabel_7.setFont(new Font("Garamond", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(5, 119, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Plat :");
		lblNewLabel_8.setFont(new Font("Garamond", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(5, 203, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Dessert :");
		lblNewLabel_9.setFont(new Font("Garamond", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(5, 309, 51, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_6_1 = new JLabel("Tomate Mozza");
		lblNewLabel_6_1.setFont(new Font("Garamond", Font.PLAIN, 12));
		lblNewLabel_6_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6_1.setBounds(178, 120, 89, 14);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Salade de laitue");
		lblNewLabel_6_2.setFont(new Font("Garamond", Font.PLAIN, 12));
		lblNewLabel_6_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6_2.setBounds(292, 120, 89, 14);
		contentPane.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_2_1 = new JLabel("Salade de carotte");
		lblNewLabel_6_2_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6_2_1.setFont(new Font("Garamond", Font.PLAIN, 12));
		lblNewLabel_6_2_1.setBounds(414, 120, 89, 14);
		contentPane.add(lblNewLabel_6_2_1);
		
		JLabel lblNewLabel_6_2_2 = new JLabel("Salade de betterave");
		lblNewLabel_6_2_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6_2_2.setFont(new Font("Garamond", Font.PLAIN, 12));
		lblNewLabel_6_2_2.setBounds(539, 120, 99, 14);
		contentPane.add(lblNewLabel_6_2_2);
		
		JLabel lblNewLabel_6_2_3 = new JLabel("Couscous de poulet");
		lblNewLabel_6_2_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6_2_3.setFont(new Font("Garamond", Font.PLAIN, 12));
		lblNewLabel_6_2_3.setBounds(61, 204, 99, 14);
		contentPane.add(lblNewLabel_6_2_3);
		
		JLabel lblNewLabel_6_2_4 = new JLabel("Steak hach\u00E9");
		lblNewLabel_6_2_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6_2_4.setFont(new Font("Garamond", Font.PLAIN, 12));
		lblNewLabel_6_2_4.setBounds(178, 204, 63, 14);
		contentPane.add(lblNewLabel_6_2_4);
		
		JLabel lblNewLabel_6_2_5 = new JLabel("Fricass\u00E9 de poulet");
		lblNewLabel_6_2_5.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6_2_5.setFont(new Font("Garamond", Font.PLAIN, 12));
		lblNewLabel_6_2_5.setBounds(292, 204, 89, 14);
		contentPane.add(lblNewLabel_6_2_5);
		
		JLabel lblNewLabel_6_2_6 = new JLabel("Boulette et p\u00E2tes");
		lblNewLabel_6_2_6.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6_2_6.setFont(new Font("Garamond", Font.PLAIN, 12));
		lblNewLabel_6_2_6.setBounds(414, 204, 89, 14);
		contentPane.add(lblNewLabel_6_2_6);
		
		JLabel lblNewLabel_6_2_7 = new JLabel("Saucisse de Toulouse");
		lblNewLabel_6_2_7.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6_2_7.setFont(new Font("Garamond", Font.PLAIN, 12));
		lblNewLabel_6_2_7.setBounds(539, 204, 99, 14);
		contentPane.add(lblNewLabel_6_2_7);
		
		JLabel lblNewLabel_6_2_8 = new JLabel("Yaourts aux fruits");
		lblNewLabel_6_2_8.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6_2_8.setFont(new Font("Garamond", Font.PLAIN, 12));
		lblNewLabel_6_2_8.setBounds(61, 310, 89, 14);
		contentPane.add(lblNewLabel_6_2_8);
		
		JLabel lblNewLabel_6_2_9 = new JLabel("Brownie");
		lblNewLabel_6_2_9.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6_2_9.setFont(new Font("Garamond", Font.PLAIN, 12));
		lblNewLabel_6_2_9.setBounds(178, 310, 46, 14);
		contentPane.add(lblNewLabel_6_2_9);
		
		JLabel lblNewLabel_6_2_10 = new JLabel("Salade de fruits");
		lblNewLabel_6_2_10.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6_2_10.setFont(new Font("Garamond", Font.PLAIN, 12));
		lblNewLabel_6_2_10.setBounds(292, 310, 76, 14);
		contentPane.add(lblNewLabel_6_2_10);
		
		JLabel lblNewLabel_6_2_11 = new JLabel("Flan napp\u00E9 au caramel");
		lblNewLabel_6_2_11.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6_2_11.setFont(new Font("Garamond", Font.PLAIN, 12));
		lblNewLabel_6_2_11.setBounds(414, 310, 115, 14);
		contentPane.add(lblNewLabel_6_2_11);
		
		JLabel lblNewLabel_6_2_12 = new JLabel("Glace \u00E0 l'eau");
		lblNewLabel_6_2_12.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6_2_12.setFont(new Font("Garamond", Font.PLAIN, 12));
		lblNewLabel_6_2_12.setBounds(539, 310, 89, 14);
		contentPane.add(lblNewLabel_6_2_12);
		
		JLabel lblNewLabel_6_2_4_1 = new JLabel("et lentilles");
		lblNewLabel_6_2_4_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6_2_4_1.setFont(new Font("Garamond", Font.PLAIN, 12));
		lblNewLabel_6_2_4_1.setBounds(178, 222, 63, 14);
		contentPane.add(lblNewLabel_6_2_4_1);
		
		JLabel lblNewLabel_6_2_5_1 = new JLabel("et mac\u00E9doine l\u00E9gumes");
		lblNewLabel_6_2_5_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6_2_5_1.setFont(new Font("Garamond", Font.PLAIN, 12));
		lblNewLabel_6_2_5_1.setBounds(292, 222, 107, 14);
		contentPane.add(lblNewLabel_6_2_5_1);
		
		JLabel lblNewLabel_6_2_5_1_1 = new JLabel("et haricots blancs curry");
		lblNewLabel_6_2_5_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6_2_5_1_1.setFont(new Font("Garamond", Font.PLAIN, 12));
		lblNewLabel_6_2_5_1_1.setBounds(539, 222, 126, 14);
		contentPane.add(lblNewLabel_6_2_5_1_1);
		btnNewButton.addActionListener(new ActionListener() 
		
		
		{
			
			public void actionPerformed(ActionEvent arg0)
			
			{
				Menu.setVisible(true);
			    dispose();
			}
			
		});
	}
}