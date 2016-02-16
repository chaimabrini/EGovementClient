package edu.esprit.gui.administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.client.claim.Gestionclaims;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	MainMenu main;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1053, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
	
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\FBI\\workspace\\E-Govement-Client\\src\\main\\java\\edu\\esprit\\image\\AgentInterface1.jpg"));
		lblNewLabel.setBounds(0, 0, 1034, 627);
		contentPane.add(lblNewLabel);
		
		JLabel claim = new JLabel("");
		
		claim.setBounds(679, 133, 88, 45);
		contentPane.add(claim);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				main=new MainMenu();
				hide();
				main.show();
			}
		});
		lblNewLabel_1.setBounds(272, 133, 78, 45);
		contentPane.add(lblNewLabel_1);
		claim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SendClaim gestionclaim =new SendClaim();
				hide();
				gestionclaim.show();
				
				System.out.println("okk");
				
			}
		});
	}

}
