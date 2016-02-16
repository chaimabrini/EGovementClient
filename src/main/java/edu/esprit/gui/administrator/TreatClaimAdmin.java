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
		
		JLabel homeMenu = new JLabel("");
		homeMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomeAdmin homeA=new HomeAdmin(employee);
				setVisible(false);
				homeA.setVisible(true);
			}
		});
		homeMenu.setBounds(284, 42, 89, 37);
		contentPane.add(homeMenu);
		
		JLabel establishmentMenu = new JLabel("");
		establishmentMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		establishmentMenu.setBounds(377, 42, 72, 37);
		contentPane.add(establishmentMenu);
		JLabel categoryMenu = new JLabel("");
		categoryMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			   ManageCategories manageCat=new ManageCategories(employee);
			   setVisible(false);
			   manageCat.setVisible(true);
			}
		});
		categoryMenu.setBounds(453, 42, 80, 38);
		contentPane.add(categoryMenu);
		
		JLabel employeeMenu = new JLabel("");
		employeeMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionEmployees gestionEmp =new GestionEmployees(employee);
				setVisible(false);
				gestionEmp.setVisible(true);
			}
		});
		employeeMenu.setBounds(540, 42, 72, 37);
		contentPane.add(employeeMenu);
		
		JLabel statisticMenu = new JLabel("");
		statisticMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StatisticAdmin statisticAdm=new StatisticAdmin(employee);
				setVisible(false);
				statisticAdm.setVisible(true);
			}
		});
		statisticMenu.setBounds(622, 42, 72, 37);
		contentPane.add(statisticMenu);
		JLabel claimMenu = new JLabel("");
		claimMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			listClaims listClaim=new listClaims(employee);
			setVisible(false);
			listClaim.setVisible(true);
			
			}
		});
		claimMenu.setBounds(704, 42, 80, 37);
		contentPane.add(claimMenu);
		
		
		JLabel Send = new JLabel("");
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
		
		JLabel Cancel = new JLabel("");
		Cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Subject.setText(null);
				Description.setText(null);
				
			}
		});
		Cancel.setBounds(511, 498, 120, 40);
		contentPane.add(Cancel);
		
		JLabel profil = new JLabel("");
		profil.setBounds(811, 11, 30, 35);
		contentPane.add(profil);
		
		JLabel logout = new JLabel("");
		logout.setBounds(861, 11, 23, 35);
		contentPane.add(logout);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TreatClaimAdmin.class.getResource("/edu/esprit/image/TreatClaimAdmin.jpg")));
		lblNewLabel.setBounds(0, 0, 894, 601);
		contentPane.add(lblNewLabel);
	}

}
