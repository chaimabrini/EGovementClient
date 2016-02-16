package edu.esprit.gui.agent;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.delegater.GestionClaimDelegater;
import edu.esprit.delegater.GestionEmployeeDelegater;
import edu.esprit.domain.Agent;
import edu.esprit.domain.Claim;
import edu.esprit.domain.Employee;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageClaim extends JFrame {

	private JPanel contentPane;
	Employee employee ;
	//MyClaim myclaim=new MyClaim( agent );
	MyClaim myclaim;
	private JTextField textField;
	
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
		employee= new Employee();
		employee=GestionEmployeeDelegater.doFindAllEmployeeById(1);


		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel claimMenu = new JLabel("");
		claimMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageClaim mClaim=new ManageClaim();
				hide();
				mClaim.show();
			
			}
		});
		claimMenu.setBounds(699, 47, 80, 37);
		contentPane.add(claimMenu);
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
				TreatBirthReg birthReq=new TreatBirthReg(employee); 
				hide();
				birthReq.show();
			}
		});
		serviceReqMenu.setBounds(543, 46, 152, 38);
		contentPane.add(serviceReqMenu);
		
		
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
				myclaim=new MyClaim(employee);
				hide();
				myclaim.show();
				
			}
		});
		claimslabel.setBounds(27, 200, 107, 44);
		contentPane.add(claimslabel);
		
		JTextArea description = new JTextArea();
		description.setBounds(336, 325, 404, 118);
		
		contentPane.add(description);
		
				JTextField subject = new JTextField();
				subject.setBounds(336, 201, 409, 31);
				subject.setBorder(null);
				contentPane.add(subject);
		
		JTextField mail = new JTextField();
		mail.setBounds(336, 261, 409, 31);
		mail.setBorder(null);
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
				claim.setEmployee(employee);
				claim.setType("0");
				if(GestionClaimDelegater.doAddClaim(claim)){
					myclaim=new MyClaim(employee);
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
		
		JLabel image = new JLabel("");
		image.setIcon(new ImageIcon(ManageClaim.class.getResource("/edu/esprit/image/SendClaim.jpg")));
		image.setBounds(0, 0, 900, 600);
		contentPane.add(image);
		
	
		
		
	}
}
