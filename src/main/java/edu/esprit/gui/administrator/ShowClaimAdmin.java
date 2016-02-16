package edu.esprit.gui.administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.registry.infomodel.EmailAddress;

import edu.esprit.delegater.GestionClaimDelegater;
import edu.esprit.domain.Claim;
import edu.esprit.domain.Employee;
import edu.esprit.gui.agent.MyClaim;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowClaimAdmin extends JFrame {

	private JPanel contentPane;

	static Employee employee;
	MyClaim myclaim;
	static int idclaim;
	private JLabel profil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowClaimAdmin frame = new ShowClaimAdmin(employee, idclaim);
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
	public ShowClaimAdmin(Employee e, int idclm) {
       employee=e;
       idclaim=idclm;
		Claim claimtreat=GestionClaimDelegater.doFindClaimById(idclaim);
		System.out.println(idclaim);
		Claim claimselected = GestionClaimDelegater.doFindClaimById(idclm);
		System.out.println(claimselected.getIdClaim());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
		
				JLabel show = new JLabel("");
				show.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						TreatClaimAdmin treatCA=new TreatClaimAdmin(employee,idclaim);
						setVisible(false);
						treatCA.setVisible(true);
						
						
					}
				});
				show.setBounds(424, 541, 118, 37);
				contentPane.add(show);
		
				profil = new JLabel("");
				profil.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setVisible(false);
						new EditProfilAdmin(employee).setVisible(true);
						
					}
				});
				profil.setBounds(818, 11, 30, 35);
				contentPane.add(profil);
		
				JLabel subject = new JLabel("New label");
				subject.setBounds(289, 222, 414, 37);
				subject.setText(claimtreat.getSubject());
				contentPane.add(subject);
				
						subject.setText(claimselected.getSubject());
		
				JLabel email = new JLabel("New label");
				email.setBounds(289, 282, 414, 29);
				email.setText(claimtreat.getMail());
				contentPane.add(email);
				email.setText(claimselected.getMail());
		
				JLabel description = new JLabel("New label");
				description.setBounds(289, 338, 403, 192);
				description.setText(claimtreat.getTextClaim());
				contentPane.add(description);
				description.setText(claimselected.getTextClaim());

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ShowClaimAdmin.class.getResource("/edu/esprit/image/ShowClaimAdmin.jpg")));
		lblNewLabel.setBounds(0, 0, 894, 601);
		contentPane.add(lblNewLabel);

	}
}
