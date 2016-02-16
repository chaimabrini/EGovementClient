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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import edu.esprit.delegater.GestionClaimDelegater;
import edu.esprit.delegater.GestionEmployeeDelegater;
import edu.esprit.domain.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

public class MyClaim extends JFrame {

	private JPanel contentPane;
	List <Claim> listClaims;
	private JTable table;
	static Employee employee;
	int idclaim;
	//static Agent agent=null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					MyClaim frame = new MyClaim(employee);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.employee
	 */
	public MyClaim(Employee e) {
		employee=e;
		listClaims = new ArrayList<Claim>();
		
		listClaims=GestionClaimDelegater.doFindClaimByAgent(employee) ;
		
		//agent=agentconnected;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(188, 200, 532, 307);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idclaim =listClaims.get(table.getSelectedRow()).getIdClaim();
				 
				
			}
		});
		
		scrollPane.setViewportView(table);
		
		JLabel homeMenu = new JLabel("");
		homeMenu.setBounds(291, 47, 80, 37);
		homeMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		contentPane.add(homeMenu);
		
		JLabel servicesMenu = new JLabel("");
		servicesMenu.setBounds(374, 47, 80, 37);
		servicesMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		contentPane.add(servicesMenu);
		
		JLabel statisticMenu = new JLabel("");
		statisticMenu.setBounds(461, 47, 72, 37);
		statisticMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		contentPane.add(statisticMenu);
		
		JLabel serviceReqMenu = new JLabel("");
		serviceReqMenu.setBounds(543, 46, 152, 38);
		serviceReqMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
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
		claimMenu.setBounds(699, 47, 80, 37);
		contentPane.add(claimMenu);
		
		
		
		
		JLabel sendclaimlabel = new JLabel("");
		sendclaimlabel.setBounds(27, 139, 107, 44);
		sendclaimlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageClaim mClaim =new ManageClaim();
				hide();
				mClaim.show();
			}
		});
		contentPane.add(sendclaimlabel);
		
		JLabel claimslabel = new JLabel("");
		claimslabel.setBounds(27, 200, 107, 44);
		claimslabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MyClaim myclaim =new MyClaim(employee);
				hide();
				myclaim.show();
			}
		});
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
		clientlabel.setBounds(51, 334, 83, 44);
		clientlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ClientClaim clientClaim=new ClientClaim(employee);
				hide();
				clientClaim.show();
			}
		});
		contentPane.add(clientlabel);
		
		JLabel showresponselabel = new JLabel("");
		showresponselabel.setBounds(754, 321, 99, 37);
		showresponselabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean b=false; 
				idclaim =listClaims.get(table.getSelectedRow()).getIdClaim();
				for(Claim c:listClaims){
					if((c.getIdClaim()==idclaim)&&(c.getState().equals("treated"))){
						b=true;
					}
				}
				if(b==false)
				{
					JOptionPane.showMessageDialog(contentPane, "your claim is not yet treated");
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "affiiiicheeeeeeer answerrrrrr");
				}
			
			}
		});
		contentPane.add(showresponselabel);
		
		JLabel image = new JLabel("");
		image.setBounds(0, 0, 893, 600);
		image.setIcon(new ImageIcon(MyClaim.class.getResource("/edu/esprit/image/MyClaims.jpg")));
		contentPane.add(image);
		initDataBindings();
	
	}
	protected void initDataBindings() {
		JTableBinding<Claim, List<Claim>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, listClaims, table);
		//
		BeanProperty<Claim, String> claimBeanProperty = BeanProperty.create("subject");
		jTableBinding.addColumnBinding(claimBeanProperty).setColumnName("Subject");
		//
		BeanProperty<Claim, String> claimBeanProperty_1 = BeanProperty.create("mail");
		jTableBinding.addColumnBinding(claimBeanProperty_1).setColumnName("Mail");
		//
		BeanProperty<Claim, String> claimBeanProperty_2 = BeanProperty.create("state");
		jTableBinding.addColumnBinding(claimBeanProperty_2).setColumnName("State");
		//
		jTableBinding.bind();
	}
}
