package edu.esprit.gui.administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.delegater.GestionClaimDelegater;
import edu.esprit.domain.Claim;
import edu.esprit.domain.Employee;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class listClaims extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<Claim> claims;
	static Employee employee;
	
	int idclaim;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listClaims frame = new listClaims(employee);
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
	public listClaims(Employee e) {
		employee=e;
		claims = new ArrayList<Claim>();
		claims = GestionClaimDelegater.doFindClaimClient();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(109, 194, 702, 316);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
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
		
		JLabel profil = new JLabel("");
		profil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new EditProfilAdmin(employee).setVisible(true);
				
			}
		});
		profil.setBounds(818, 11, 30, 35);
		contentPane.add(profil);
		
		JLabel logout = new JLabel("");
		logout.setBounds(861, 11, 23, 35);
		contentPane.add(logout);
		
		JLabel showClaim_1 = new JLabel("");
		showClaim_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				boolean b=false; 
				idclaim =claims.get(table.getSelectedRow()).getIdClaim();
				for(Claim c:claims){
					if((c.getIdClaim()==idclaim)&&(c.getState().equals("treated"))){
						b=true;
					}
				}
				if(b==false)
				{
					ShowClaimAdmin showClaim=new ShowClaimAdmin(employee,idclaim);
					setVisible(false);
					showClaim.setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "claim is treated");
				}
			
			}
		});
		showClaim_1.setBounds(386, 528, 118, 42);
		contentPane.add(showClaim_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 894, 601);
		lblNewLabel.setIcon(new ImageIcon(listClaims.class.getResource("/edu/esprit/image/ClaimsAdmin.jpg")));
		contentPane.add(lblNewLabel);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Claim, List<Claim>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, claims, table);
		//
		BeanProperty<Claim, Integer> claimBeanProperty = BeanProperty.create("idClaim");
		jTableBinding.addColumnBinding(claimBeanProperty).setColumnName("id");
		//
		BeanProperty<Claim, String> claimBeanProperty_1 = BeanProperty.create("mail");
		jTableBinding.addColumnBinding(claimBeanProperty_1).setColumnName("Mail");
		//
		BeanProperty<Claim, String> claimBeanProperty_2 = BeanProperty.create("subject");
		jTableBinding.addColumnBinding(claimBeanProperty_2).setColumnName("Subject");
		//
		BeanProperty<Claim, String> claimBeanProperty_3 = BeanProperty.create("citizen.firstName");
		jTableBinding.addColumnBinding(claimBeanProperty_3).setColumnName("From");
		//
		BeanProperty<Claim, String> claimBeanProperty_4 = BeanProperty.create("state");
		jTableBinding.addColumnBinding(claimBeanProperty_4).setColumnName("State");
		//
		jTableBinding.bind();
	}
}
