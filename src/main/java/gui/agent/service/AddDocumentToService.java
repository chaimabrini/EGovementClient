package gui.agent.service;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class AddDocumentToService extends JFrame {

	private JPanel contentPane;
	private JTextField nameDocument;
	List<Service> services;
	ManageServicesDelegater mngServ;
	RequiredDocument d;
	static AddDocumentToService frame;
	static Employee employee;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AddDocumentToService(employee);
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
	public AddDocumentToService(Employee e) {
		employee=e;
		mngServ= new ManageServicesDelegater();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 623);
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
		
		
		nameDocument = new JTextField();
		nameDocument.setBounds(176, 278, 159, 20);
		nameDocument.setBorder(null);
		contentPane.add(nameDocument);
		nameDocument.setColumns(10);
		
		JTextArea descriptionDocument = new JTextArea();
		descriptionDocument.setBounds(477, 276, 304, 105);
		contentPane.add(descriptionDocument);
		
		JLabel validateButton = new JLabel("");
		validateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				services = new ArrayList<Service>();
				
				services=mngServ.doShowAllServices();
				int maxId= services.get(services.size()-1).getIdService();
				d= new RequiredDocument();
				d.setDescription(descriptionDocument.getText());
				d.setName(nameDocument.getText());
				d.setService(mngServ.doFindServiceById(maxId));
				mngServ.doAddDocumentToservice(d);
				
			    setVisible(false);
				dispose();
				new MainService(employee).setVisible(true);
			}
		});
		validateButton.setBounds(239, 427, 111, 43);
		contentPane.add(validateButton);
		
		JLabel addDocument = new JLabel("");
		addDocument.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                services = new ArrayList<Service>();
                mngServ= new ManageServicesDelegater();
				services=mngServ.doShowAllServices();
				int maxId= services.get(services.size()-1).getIdService();
				d= new RequiredDocument();
				d.setDescription(descriptionDocument.getText());
				d.setName(nameDocument.getText());
				d.setService(mngServ.doFindServiceById(maxId));
				mngServ.doAddDocumentToservice(d);
				setVisible(false);
				dispose();
				new AddDocumentToService(employee).setVisible(true);
			}
		});
		addDocument.setBounds(516, 427, 142, 43);
		contentPane.add(addDocument);
		
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
		mainLabel.setIcon(new ImageIcon(AddDocumentToService.class.getResource("/edu/esprit/image/AddDocument.jpg")));
		mainLabel.setBounds(0, 0, 896, 584);
		contentPane.add(mainLabel);
	}
}
