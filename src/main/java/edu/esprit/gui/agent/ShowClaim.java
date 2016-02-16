package edu.esprit.gui.agent;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.delegater.GestionClaimDelegater;
import edu.esprit.domain.Agent;
import edu.esprit.domain.Claim;
import edu.esprit.domain.Employee;

import javax.swing.JLabel;
import javax.persistence.IdClass;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ShowClaim extends JFrame {

	private JPanel contentPane;
	static Employee employee; 
	//MyClaim myclaim=new MyClaim( agent );
	MyClaim myclaim;
	static int idclaim;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowClaim frame = new ShowClaim(employee,idclaim);
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
	public ShowClaim(Employee employee , int idclm ) {
		idclaim=idclm;
		myclaim=new MyClaim(employee);
		System.out.println(idclaim);
		Claim claimselected=GestionClaimDelegater.doFindClaimById(idclaim);
	    System.out.println(claimselected.getIdClaim());
	    
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTextArea descriptiontext = new JTextArea();
		descriptiontext.setEditable(false);
		descriptiontext.setBounds(338, 334, 407, 165);
		contentPane.add(descriptiontext);
		descriptiontext.setText(claimselected.getTextClaim());
		
		JTextArea subjecttext = new JTextArea();
		subjecttext.setEditable(false);
		subjecttext.setBounds(338, 200, 397, 31);
		contentPane.add(subjecttext);
		subjecttext.setText(claimselected.getSubject());
		
		JTextArea mailtext = new JTextArea();
		mailtext.setEditable(false);
		mailtext.setBounds(338, 263, 397, 31);
		contentPane.add(mailtext);
		mailtext.setText(claimselected.getMail());
		
		
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
		claimMenu.setBounds(699, 47, 83, 37);
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
				ClientClaim clientClaim=new ClientClaim(employee);
				hide();
				clientClaim.show();
			}
		});
		clientlabel.setBounds(51, 334, 83, 44);
		contentPane.add(clientlabel);
		JLabel myclaimlabel = new JLabel("");
		myclaimlabel.setBounds(51, 269, 80, 44);
		myclaimlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyClaim myclaim =new MyClaim(employee);
				hide();
				myclaim.show();
			}
		});
		contentPane.add(myclaimlabel);
		
		JLabel treat = new JLabel("");
		treat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				TreatClaim treatclaim=new TreatClaim(employee, idclaim);
				setVisible(false);
				treatclaim.setVisible(true);;
				
				
				
				
			}
		});
		treat.setBounds(503, 540, 95, 31);
		contentPane.add(treat);
		
		JLabel image = new JLabel("");
		image.setIcon(new ImageIcon(ShowClaim.class.getResource("/edu/esprit/image/ShowClaim.jpg")));
		image.setBounds(0, 0, 893, 600);
		contentPane.add(image);
		
		
		
	}
}
