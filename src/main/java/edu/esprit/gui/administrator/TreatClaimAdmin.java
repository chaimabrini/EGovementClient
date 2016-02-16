package edu.esprit.gui.administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.delegater.GestionClaimDelegater;
import edu.esprit.domain.Claim;
import edu.esprit.domain.Employee;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TreatClaimAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField Subject;
	static Employee employee;
	static int idclaim ; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreatClaimAdmin frame = new TreatClaimAdmin(employee , idclaim);
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
	public TreatClaimAdmin(Employee e , int id) {
		employee=e;
		idclaim=id;
		Claim claimtreat=GestionClaimDelegater.doFindClaimById(idclaim);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Subject = new JTextField();
		Subject.setBounds(261, 210, 431, 41);
		Subject.setText(claimtreat.getSubject());
		contentPane.add(Subject);
		Subject.setColumns(10);
		
		JTextArea Description = new JTextArea();
		Description.setBounds(261, 281, 431, 199);
		contentPane.add(Description);
		
		JLabel Send = new JLabel("New label");
		Send.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				claimtreat.setResponse(Description.getText());
				GestionClaimDelegater.doUpdateClaim(claimtreat);
				listClaims listClaimsAd=new listClaims(employee);
				setVisible(false);
				listClaimsAd.setVisible(true);
			}
		});
		Send.setBounds(320, 504, 120, 34);
		contentPane.add(Send);
		
		JLabel Cancel = new JLabel("New label");
		Cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Subject.setText(null);
				Description.setText(null);
				
			}
		});
		Cancel.setBounds(511, 498, 120, 40);
		contentPane.add(Cancel);
		
		JLabel Home = new JLabel("New label");
		Home.setBounds(282, 39, 85, 49);
		contentPane.add(Home);
		
		JLabel Establishment = new JLabel("New label");
		Establishment.setBounds(371, 39, 79, 49);
		contentPane.add(Establishment);
		
		JLabel Category = new JLabel("New label");
		Category.setBounds(448, 39, 85, 49);
		contentPane.add(Category);
		
		JLabel Employee = new JLabel("New label");
		Employee.setBounds(533, 39, 85, 49);
		contentPane.add(Employee);
		
		JLabel Statistic = new JLabel("New label");
		Statistic.setBounds(617, 42, 79, 46);
		contentPane.add(Statistic);
		
		JLabel Claim = new JLabel("New label");
		Claim.setBounds(698, 39, 85, 49);
		contentPane.add(Claim);
		
		JLabel profil = new JLabel("New label");
		profil.setBounds(811, 11, 30, 35);
		contentPane.add(profil);
		
		JLabel logout = new JLabel("New label");
		logout.setBounds(861, 11, 23, 35);
		contentPane.add(logout);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TreatClaimAdmin.class.getResource("/edu/esprit/image/TreatClaimAdmin.jpg")));
		lblNewLabel.setBounds(0, 0, 894, 601);
		contentPane.add(lblNewLabel);
	}

}
