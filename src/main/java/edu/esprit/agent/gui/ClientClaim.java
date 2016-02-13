package edu.esprit.agent.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ClientClaim extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientClaim frame = new ClientClaim();
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
	public ClientClaim() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel image = new JLabel("");
		image.setIcon(new ImageIcon("C:\\Users\\FBI\\Desktop\\PIDEV\\SPRINT 1\\Clients.jpg"));
		image.setBounds(0, 0, 893, 600);
		contentPane.add(image);

		JLabel homeMenu = new JLabel("");
		homeMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		homeMenu.setBounds(291, 47, 80, 37);
		contentPane.add(homeMenu);
		
		JLabel servicesMenu = new JLabel("");
		servicesMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		servicesMenu.setBounds(374, 47, 80, 37);
		contentPane.add(servicesMenu);
		
		JLabel statisticMenu = new JLabel("");
		statisticMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		statisticMenu.setBounds(461, 47, 72, 37);
		contentPane.add(statisticMenu);
		
		JLabel serviceReqMenu = new JLabel("");
		serviceReqMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		serviceReqMenu.setBounds(543, 46, 152, 38);
		contentPane.add(serviceReqMenu);
		
		JLabel claimMenu = new JLabel("");
		claimMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageClaim mClaim=new ManageClaim();
				
				mClaim.show();
				hide();
			}
		});
		claimMenu.setBounds(699, 47, 46, 14);
		contentPane.add(claimMenu);
		
		JLabel sendclaimlabel = new JLabel("");
		sendclaimlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageClaim mClaim =new ManageClaim();
				hide();
				mClaim.show();
			}
		});
		sendclaimlabel.setBounds(27, 139, 107, 44);
		contentPane.add(sendclaimlabel);
		
		JLabel claimslabel = new JLabel("");
		claimslabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MyClaim myclaim=new MyClaim();
				hide();
				myclaim.show();
			}
		});
		claimslabel.setBounds(27, 200, 107, 44);
		contentPane.add(claimslabel);
		JLabel clientlabel = new JLabel("");
		clientlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClientClaim clientClaim=new ClientClaim();
				hide();
				clientClaim.show();
			}
		});
		clientlabel.setBounds(51, 334, 83, 44);
		contentPane.add(clientlabel);
		
		JLabel showclaimlabel = new JLabel("");
		showclaimlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowClaim showClaim=new ShowClaim();
				hide();
				showClaim.show();
			}
		});
		showclaimlabel.setBounds(752, 227, 99, 26);
		contentPane.add(showclaimlabel);
		
		
	}

}
