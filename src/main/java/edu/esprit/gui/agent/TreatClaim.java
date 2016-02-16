package edu.esprit.gui.agent;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.delegater.GestionClaimDelegater;
import edu.esprit.domain.Claim;
import edu.esprit.domain.Employee;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TreatClaim extends JFrame {

	private JPanel contentPane;
    static Employee employee;
    static int idclaim;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreatClaim frame = new TreatClaim(employee , idclaim);
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
	public TreatClaim(Employee e , int id) {
	System.out.println("behiiiiiiiiiiii");
		employee=e; 
		idclaim=id;
		Claim claimtreated=GestionClaimDelegater.doFindClaimById(idclaim);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		sendclaimlabel.setBounds(27, 148, 107, 44);
		contentPane.add(sendclaimlabel);
		
		JLabel claimslabel = new JLabel("");
		claimslabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MyClaim myclaim=new MyClaim(employee);
				hide();
				myclaim.show();
			}
		});
		claimslabel.setBounds(27, 215, 107, 44);
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
		clientlabel.setBounds(51, 344, 83, 44);
		contentPane.add(clientlabel);
		
		JTextArea subjecttext = new JTextArea();
		subjecttext.setEditable(false);
		subjecttext.setBounds(332, 214, 414, 31);
		subjecttext.setBorder(null);
		contentPane.add(subjecttext);
		subjecttext.setText(claimtreated.getSubject());
		
		JTextArea responseText = new JTextArea();
		responseText.setBounds(332, 282, 414, 183);
		contentPane.add(responseText);
		
		JLabel sendLabel = new JLabel("");
		sendLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Claim claimtreated=GestionClaimDelegater.doFindClaimById(idclaim);
				claimtreated.setEmployee(employee);
				claimtreated.setState("treated");
			//	claimtreated.set
				GestionClaimDelegater.doUpdateClaim(claimtreated);
				sendMail("shayma.br8@gmail.com");
				JOptionPane.showMessageDialog(contentPane, "your answer was sent");
				ClientClaim clientClaim=new ClientClaim(employee);
				setVisible(false);
				clientClaim.setVisible(true);
			}
		});
		sendLabel.setBounds(392, 501, 91, 31);
		contentPane.add(sendLabel);
		
		JLabel cancelLabel = new JLabel("");
		cancelLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClientClaim clientClaim=new ClientClaim(employee);
				setVisible(false);
				clientClaim.setVisible(true);
				
			}
		});
		cancelLabel.setBounds(581, 501, 98, 31);
		contentPane.add(cancelLabel);
		JLabel image = new JLabel("");
		image.setIcon(new ImageIcon(TreatClaim.class.getResource("/edu/esprit/image/TreatClaim.jpg")));
		image.setBounds(0, 11, 893, 600);
		contentPane.add(image);
		
		
	}
	
	public void sendMail(String email){
		final String username = "shayma.brini@gmail.com";
		final String password = "26197696hama";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
            System.out.print("1");
			Message message = new MimeMessage(session);
			 System.out.print("1");
			message.setFrom(new InternetAddress("shayma.brini@gmail.com"));
			 System.out.print("1");
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			
			 System.out.print("1");
			
	        message.setSubject(" treat claim");
			message.setText("Welcome "+employee.getLogin()+" the claim "+idclaim+" is treated ");
			
			
			 System.out.print("2");          
                              
			Transport.send(message);
                        
			System.out.println("Done");
 
		} catch (MessagingException e2) {
			throw new RuntimeException(e2);
		        }
	}
}
