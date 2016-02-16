package edu.esprit.gui.agent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.delegater.GestionClaimDelegater;
import edu.esprit.domain.Agent;
import edu.esprit.domain.Claim;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageClaim extends JFrame {

	private JPanel contentPane;
	Agent agent ;
	//MyClaim myclaim=new MyClaim( agent );
	MyClaim myclaim=new MyClaim();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageClaim frame = new ManageClaim();
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
	public ManageClaim() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel image = new JLabel("");
		image.setIcon(new ImageIcon("C:\\Users\\FBI\\Desktop\\PIDEV\\SPRINT 1\\SendClaim.jpg"));
		image.setBounds(0, 0, 900, 600);
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
				hide();
				mClaim.show();
			
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
				
				myclaim.show();
				hide();
			}
		});
		claimslabel.setBounds(27, 200, 107, 44);
		contentPane.add(claimslabel);
		
		JTextArea description = new JTextArea();
		description.setBounds(336, 325, 404, 118);
		contentPane.add(description);

		JTextArea subject = new JTextArea(1,1);
		subject.setBounds(336, 201, 409, 31);
		
		contentPane.add(subject);
		
		JTextArea mail = new JTextArea();
		mail.setBounds(336, 261, 409, 31);
		contentPane.add(mail);
		
		JLabel sendbouton = new JLabel("");
		sendbouton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Claim claim =new Claim();
				claim.setMail(mail.getText());
				claim.setState("untreated");
				claim.setSubject(subject.getText());
				claim.setTextClaim(description.getText());
				claim.setCitizen(null);//lezim null 5ater agent bich yab3ath 
				claim.setEmployee(null);
				if(GestionClaimDelegater.doAddClaim(claim)){
					hide();
					myclaim.show();
				}
				
			}
		});
		sendbouton.setBounds(407, 483, 92, 31);
		contentPane.add(sendbouton);
		
		JLabel cancelbouton = new JLabel("");
		cancelbouton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				subject.setText(null);
				mail.setText(null);
				description.setText(null);
			}
		});
		cancelbouton.setBounds(596, 483, 92, 31);
		contentPane.add(cancelbouton);
		
		
	}
}
