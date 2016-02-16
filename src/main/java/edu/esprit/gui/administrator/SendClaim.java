package edu.esprit.gui.administrator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.delegater.GestionClaimDelegater;
import edu.esprit.domain.Claim;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SendClaim extends JFrame {

	private JPanel contentPane;
	private JTextField subject;
	private JTextField mail;
	Claim claim =new Claim();

	MainMenu main=new MainMenu();
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendClaim frame = new SendClaim();
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
	public SendClaim() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1051, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\FBI\\Desktop\\sendClaims.jpg"));
		lblNewLabel.setBounds(0, 0, 1035, 631);
		contentPane.add(lblNewLabel);
		
		subject = new JTextField();
		subject.setBounds(471, 203, 352, 37);
		contentPane.add(subject);
		subject.setColumns(10);
		
		mail = new JTextField();
		mail.setBounds(470, 260, 353, 37);
		contentPane.add(mail);
		mail.setColumns(10);
		
		JTextArea description = new JTextArea();
		description.setBounds(471, 325, 345, 154);
		contentPane.add(description);
		
		JLabel send = new JLabel("New label");
		send.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				claim.setMail(mail.getText());
				claim.setSubject(subject.getText());
				claim.setTextClaim(description.getText());
				//claim.setCitizen(new Citizen());
				//claim.setEmployee(new Employee());
				claim.setState("untreated");
				if(GestionClaimDelegater.doAddClaim(claim)){
				System.out.println("oke");
				}
			}
		});
		send.setBounds(527, 518, 82, 31);
		contentPane.add(send);
		
		JLabel cancel = new JLabel("cancel");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				subject.setText("");
				mail.setText("");
				description.setText("");
			}
		});
		cancel.setBounds(677, 518, 76, 31);
		contentPane.add(cancel);
		
		JLabel claimlabel = new JLabel("New label");
		claimlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				show();
			}
		});
		claimlabel.setBounds(705, 11, 82, 46);
		contentPane.add(claimlabel);
		
		JLabel home = new JLabel("New label");
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				hide();
				main.show();
			}
		});
		home.setBounds(288, 11, 82, 46);
		contentPane.add(home);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(389, 26, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(471, 26, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(547, 26, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(636, 26, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setOpaque(false);
		textField.setBounds(471, 155, 345, 37);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
