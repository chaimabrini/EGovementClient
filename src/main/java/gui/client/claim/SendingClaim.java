package gui.client.claim;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import edu.esprit.delegater.GestionClaimDelegater;
import edu.esprit.domain.Citizen;
import edu.esprit.domain.Claim;
import edu.esprit.domain.Employee;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SendingClaim extends JFrame {

	private JPanel contentPane;
	private JTextField subject;
	private JTextField mail;
	Claim claim =new Claim();
    Menu menu=new Menu();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					SendingClaim frame = new SendingClaim();
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
	public SendingClaim() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "Sending claim", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 0, 414, 262);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Subject");
		label.setBounds(10, 38, 46, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Mail");
		label_1.setBounds(10, 63, 88, 14);
		panel.add(label_1);
		
		subject = new JTextField();
		subject.setColumns(10);
		subject.setBounds(108, 35, 202, 20);
		panel.add(subject);
		
		mail = new JTextField();
		mail.setColumns(10);
		mail.setBounds(108, 60, 202, 20);
		panel.add(mail);
		
		JLabel label_2 = new JLabel("Description");
		label_2.setBounds(10, 88, 93, 14);
		panel.add(label_2);
		
		JTextArea description = new JTextArea();
		description.setBounds(108, 91, 202, 86);
		panel.add(description);
		
		JButton button = new JButton("Send");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

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
		button.setBounds(79, 215, 89, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setBounds(243, 215, 89, 23);
		panel.add(button_1);
	}

}
