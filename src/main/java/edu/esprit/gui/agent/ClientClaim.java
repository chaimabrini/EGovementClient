package edu.esprit.gui.agent;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

public class ClientClaim extends JFrame {

	private JPanel contentPane;
	 static Employee employee;
	 private JTable table;
	 List<Claim> listClaimClient ;
	 int idclaim;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientClaim frame = new ClientClaim(employee);
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
	public ClientClaim(Employee e) {
		employee=e;
		listClaimClient=new ArrayList<Claim>();
		listClaimClient=GestionClaimDelegater.doFindClaimClient();
		
		
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
		claimMenu.setBounds(699, 47, 88, 37);
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
				MyClaim myclaim=new MyClaim(employee);
				hide();
				myclaim.show();
			}
		});
		claimslabel.setBounds(27, 200, 107, 44);
		contentPane.add(claimslabel);
		
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
		
		JLabel showclaimlabel = new JLabel("");
		showclaimlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				
				
				boolean b=false; 
				idclaim =listClaimClient.get(table.getSelectedRow()).getIdClaim();
				for(Claim c:listClaimClient){
					if((c.getIdClaim()==idclaim)&&(c.getState().equals("treated"))){
						b=true;
					}
				}
				if(b==false)
				{
					ShowClaim showClaim=new ShowClaim(employee,idclaim);
					setVisible(false);
					showClaim.setVisible(true);;
					
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "claim is treated");
				}
				
			}
		});
		showclaimlabel.setBounds(752, 227, 99, 26);
		contentPane.add(showclaimlabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(192, 200, 527, 305);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel image = new JLabel("");
		image.setIcon(new ImageIcon(ClientClaim.class.getResource("/edu/esprit/image/Clients.jpg")));
		image.setBounds(0, 0, 893, 600);
		contentPane.add(image);
		initDataBindings();
		
		
	}
	protected void initDataBindings() {
		JTableBinding<Claim, List<Claim>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, listClaimClient, table);
		//
		BeanProperty<Claim, String> claimBeanProperty = BeanProperty.create("citizen.firstName");
		jTableBinding.addColumnBinding(claimBeanProperty).setColumnName("Citizen");
		//
		BeanProperty<Claim, String> claimBeanProperty_1 = BeanProperty.create("subject");
		jTableBinding.addColumnBinding(claimBeanProperty_1).setColumnName("Subject");
		//
		BeanProperty<Claim, String> claimBeanProperty_2 = BeanProperty.create("mail");
		jTableBinding.addColumnBinding(claimBeanProperty_2).setColumnName("Mail");
		//
		BeanProperty<Claim, String> claimBeanProperty_3 = BeanProperty.create("state");
		jTableBinding.addColumnBinding(claimBeanProperty_3).setColumnName("State");
		//
		jTableBinding.bind();
	}
}
