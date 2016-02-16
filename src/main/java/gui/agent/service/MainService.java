package gui.agent.service;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JTable;

import edu.esprit.delegater.GestionCategorieDelegater;
import edu.esprit.delegater.ManageServicesDelegater;
import edu.esprit.domain.Categorie;
import edu.esprit.domain.Employee;
import edu.esprit.domain.Etablishment;
import edu.esprit.domain.Service;
import edu.esprit.gui.agent.HomeAgent;
import edu.esprit.gui.agent.ManageClaim;
import edu.esprit.gui.agent.StatisticAgent;
import edu.esprit.gui.agent.TreatBirthReg;
import edu.esprit.gui.authentification.Authentification;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.Color;

public class MainService extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ManageServicesDelegater mngServ;
	GestionCategorieDelegater mngCategory;
	Service s;
	ServicesTableModel serv;
	List<Categorie> categories;
    static Employee employee;
     
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainService frame = new MainService(employee);
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
	public MainService(Employee e) {
		employee=e;
		mngServ = new ManageServicesDelegater();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JLabel homeMenu = new JLabel("");
		homeMenu.setBounds(291, 47, 80, 37);
		homeMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomeAgent homeAgent=new HomeAgent(employee);
			    setVisible(false);
			    homeAgent.setVisible(true);
			}
		});
		contentPane.add(homeMenu);
		
		JLabel servicesMenu = new JLabel("");
		servicesMenu.setBounds(374, 47, 80, 37);
		servicesMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainService mainService=new MainService(employee);
				setVisible(false);
				mainService.setVisible(true);
			}
		});
		contentPane.add(servicesMenu);
		
		JLabel statisticMenu = new JLabel("");
		statisticMenu.setBounds(461, 47, 72, 37);
		statisticMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StatisticAgent statAgent =new StatisticAgent(employee);
				setVisible(false);
				statAgent.setVisible(true);
				
			}
		});
		contentPane.add(statisticMenu);
		
		JLabel serviceReqMenu = new JLabel("");
		serviceReqMenu.setBounds(543, 46, 152, 38);
		serviceReqMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TreatBirthReg treatBR =new TreatBirthReg(employee);
				setVisible(false);
				treatBR.setVisible(true);
				
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
		
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		serv = new ServicesTableModel(new Etablishment());
		table.setModel(serv);
		table.setBounds(114, 185, 681, 174);
		contentPane.add(table);

		JComboBox categoryListComboBox = new JComboBox();
		categoryListComboBox.setBackground(Color.WHITE);
		categoryListComboBox.setBounds(204, 442, 150, 27);
		categoryListComboBox.setBorder(null);
		contentPane.add(categoryListComboBox);
		categories = new ArrayList<>();
		mngCategory = new GestionCategorieDelegater();
		categories = mngCategory.doFindAllCategorie();
		for (int i = 0; i < categories.size(); i++) {
			categoryListComboBox.addItem(categories.get(i).getName());
		}

		JTextPane name = new JTextPane();
		name.setBounds(204, 388, 143, 33);
		contentPane.add(name);

		JTextPane description = new JTextPane();
		description.setBounds(489, 388, 308, 110);
		contentPane.add(description);

		JLabel updateLabel = new JLabel("");
		updateLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				s = new Service();
				s = mngServ.doFindServiceById((int) table.getValueAt(table.getSelectedRow(), 0));
				s.setName(name.getText());
				s.setDescription(description.getText());
				s.setEtablishment(null);
				s.setCategorie(mngCategory.doFindCategorieByName((String) categoryListComboBox.getSelectedItem()));
				mngServ.doUpdateService(s);
				setVisible(false);
				dispose();
				new MainService(employee).setVisible(true);
			}
		});
		updateLabel.setBounds(204, 537, 115, 33);
		contentPane.add(updateLabel);

		JLabel deleteLabel = new JLabel("");
		deleteLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mngServ.doDeleteService((int) table.getValueAt(table.getSelectedRow(), 0));
				setVisible(false);
				dispose();
				new MainService(employee).setVisible(true);
			}
		});
		deleteLabel.setBounds(397, 531, 118, 39);
		contentPane.add(deleteLabel);

		JLabel showDetailsLabel = new JLabel("");
		showDetailsLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (table.getSelectedRow() != -1) {
					setVisible(false);
					dispose();
					new ManageDocument(employee,mngServ.doFindServiceById((int) table.getValueAt(table.getSelectedRow(), 0)))
							.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Thank you to select a service!!!");

				}

			}
		});
		showDetailsLabel.setBounds(598, 533, 115, 37);
		contentPane.add(showDetailsLabel);

		JLabel refresh = new JLabel("");
		refresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				setVisible(false);
				dispose();
				new MainService(employee).setVisible(true);
			}
		});
		refresh.setBounds(823, 140, 46, 39);
		contentPane.add(refresh);

		JLabel addLabel = new JLabel("");
		addLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new AddServiceAndDocument(employee).setVisible(true);
			}
		});
		addLabel.setBounds(25, 140, 58, 77);
		contentPane.add(addLabel);
				
				JLabel deconnexionLabel = new JLabel("");
				deconnexionLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						Authentification auth=new Authentification();
						setVisible(false);
						auth.setVisible(true);
					}
				});
				deconnexionLabel.setBounds(857, 11, 36, 36);
				contentPane.add(deconnexionLabel);
		
				JLabel mainLabel = new JLabel("");
				
						mainLabel.setIcon(new ImageIcon(MainService.class.getResource("/edu/esprit/image/Services.jpg")));
						mainLabel.setBounds(0, 0, 900, 600);
						contentPane.add(mainLabel);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				name.setText((String) table.getValueAt(table.getSelectedRow(), 1));
				description.setText((String) table.getValueAt(table.getSelectedRow(), 2));
				categoryListComboBox.setSelectedItem(table.getValueAt(table.getSelectedRow(), 4));

			}
		});

	}
}
