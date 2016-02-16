package gui.agent.service;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.delegater.ManageServicesDelegater;
import edu.esprit.domain.Employee;
import edu.esprit.domain.RequiredDocument;
import edu.esprit.domain.Service;
import edu.esprit.gui.agent.HomeAgent;
import edu.esprit.gui.agent.ManageClaim;
import edu.esprit.gui.agent.StatisticAgent;
import edu.esprit.gui.agent.TreatBirthReg;
import edu.esprit.gui.authentification.Authentification;

import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class ManageDocument extends JFrame {

	private JPanel contentPane;
	private JTextField nameDocument;
	DocumentTableModel docModel;
	Service service;
	private JTable table;
	ManageServicesDelegater mngServ;
    static Employee employee ;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageDocument frame = new ManageDocument(employee,new Service());
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
	public ManageDocument(Employee e,Service s) {
		employee=e;
		mngServ = new ManageServicesDelegater();
		service = new Service();
		service = s;
		System.out.println("test" + service.getName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 641);
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
		table.setModel(new DocumentTableModel(s));
		table.setBounds(123, 160, 670, 165);
		contentPane.add(table);

		JLabel nameService = new JLabel("");
		nameService.setBounds(208, 351, 163, 26);
		contentPane.add(nameService);

		JLabel categoryService = new JLabel("");
		categoryService.setBounds(208, 399, 163, 26);
		contentPane.add(categoryService);
		categoryService.setText(service.getCategorie().getName());

		JLabel establishmentService = new JLabel("");
		establishmentService.setBounds(208, 449, 163, 26);
		contentPane.add(establishmentService);

		nameDocument = new JTextField();
		nameDocument.setColumns(10);
		nameDocument.setBorder(null);
		nameDocument.setBounds(495, 351, 298, 26);
		contentPane.add(nameDocument);

		JTextArea descriptionDoc = new JTextArea();
		descriptionDoc.setBounds(495, 399, 298, 64);
		contentPane.add(descriptionDoc);

		JLabel refresh = new JLabel("");
		refresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				new ManageDocument(employee,service).setVisible(true);
			}
		});
		refresh.setBounds(820, 119, 46, 48);
		contentPane.add(refresh);

		JLabel updateLabel = new JLabel("");
		updateLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RequiredDocument d = new RequiredDocument();
				d = mngServ.doFindDocumentById((int) table.getValueAt(table.getSelectedRow(), 0));
				d.setName(nameDocument.getText());
				d.setDescription(descriptionDoc.getText());
				d.setService(service);
				mngServ.doUpdateDocument(d);
				setVisible(false);
				dispose();
				new ManageDocument(employee,s).setVisible(true);
			}
		});
		updateLabel.setBounds(186, 499, 117, 38);
		contentPane.add(updateLabel);

		JLabel deleteLabel = new JLabel("");
		deleteLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mngServ.doDeleteDocument((int) table.getValueAt(table.getSelectedRow(), 0));
				setVisible(false);
				dispose();
				new ManageDocument(employee,service).setVisible(true);
			}
		});
		deleteLabel.setBounds(378, 499, 117, 38);
		contentPane.add(deleteLabel);
		JLabel cancelLabel = new JLabel("");
		cancelLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				dispose();
				new MainService(employee).setVisible(true);
			}
		});
		cancelLabel.setBounds(577, 499, 117, 38);
		contentPane.add(cancelLabel);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nameDocument.setText((String) table.getValueAt(table.getSelectedRow(), 1));
				descriptionDoc.setText((String) table.getValueAt(table.getSelectedRow(), 2));
			}
		});
		nameService.setText(service.getName());
		
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
				mainLabel
						.setIcon(new ImageIcon(ManageDocument.class.getResource("/edu/esprit/image/Documents.jpg")));
				mainLabel.setBounds(0, -26, 903, 602);
				contentPane.add(mainLabel);
				
				
				
	}
}
