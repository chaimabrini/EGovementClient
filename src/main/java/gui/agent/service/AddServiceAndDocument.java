package gui.agent.service;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.delegater.GestionCategorieDelegater;
import edu.esprit.delegater.GestionClaimDelegater;
import edu.esprit.delegater.ManageServicesDelegater;
import edu.esprit.domain.Categorie;
import edu.esprit.domain.Claim;
import edu.esprit.domain.Employee;
import edu.esprit.domain.RequiredDocument;
import edu.esprit.domain.Service;
import edu.esprit.gui.agent.HomeAgent;
import edu.esprit.gui.agent.ManageClaim;
import edu.esprit.gui.agent.StatisticAgent;
import edu.esprit.gui.agent.TreatBirthReg;
import edu.esprit.gui.authentification.Authentification;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

public class AddServiceAndDocument extends JFrame {

	private JPanel contentPane;
	private JTextField nameService;
	private JTextField textField_1;
	private JTextField nameDocument;
	ManageServicesDelegater mngServ ;
	GestionCategorieDelegater mngCategory;
	GestionClaimDelegater mngClaim;
	
	Service s;
	RequiredDocument d;
	List<Service> services;
	List<Categorie> categories;
	static Employee employee ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddServiceAndDocument frameServe = new AddServiceAndDocument(employee);
					frameServe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddServiceAndDocument(Employee e ) {
		employee =e ;
		mngServ= new ManageServicesDelegater();
		mngCategory= new GestionCategorieDelegater();
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
		
		
		categories= new ArrayList<>();
		categories=mngCategory.doFindAllCategorie();
		JComboBox comboBox = new JComboBox();
		for(int i = 0; i < categories.size(); i++) {
		    //array[i] = arrayList.get(i);
		   // comboBox.addItem(services.get(i).getName());
		    comboBox.addItem(categories.get(i).getName());
		}
		
		
		//comboBox.addItem(new Categorie());
		comboBox.setBounds(186, 275, 144, 25);
		contentPane.add(comboBox);
		
		nameService = new JTextField();
		nameService.setBounds(186, 210, 144, 25);
		nameService.setBorder(null);
		contentPane.add(nameService);
		nameService.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setBounds(188, 273, 153, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JTextPane DescriptionService = new JTextPane();
		DescriptionService.setBounds(478, 206, 301, 108);
		contentPane.add(DescriptionService);
		
		nameDocument = new JTextField();
		nameDocument.setBounds(177, 401, 153, 25);
		nameDocument.setBorder(null);
		contentPane.add(nameDocument);
		nameDocument.setColumns(10);
		
		JTextPane descriptionDocument = new JTextPane();
		descriptionDocument.setBounds(478, 397, 301, 108);
		contentPane.add(descriptionDocument);
		
		JLabel addService = new JLabel("");
		addService.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				s= new Service();
				s.setName(nameService.getText());
				s.setDescription(DescriptionService.getText());
				s.setEtablishment(null);
				s.setCategorie(mngCategory.doFindCategorieByName((String)comboBox.getSelectedItem()));
				mngServ.doAddService(s);
				
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
		addService.setBounds(221, 526, 109, 36);
		contentPane.add(addService);
		
		JLabel addDocument = new JLabel("");
		addDocument.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				s= new Service();
				s.setName(nameService.getText());
				s.setDescription(DescriptionService.getText());
				s.setEtablishment(null);
				s.setCategorie(mngCategory.doFindCategorieByName((String)comboBox.getSelectedItem()));
				mngServ.doAddService(s);
				
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
				new AddDocumentToService(employee).setVisible(true);
			}
		});
		addDocument.setBounds(499, 526, 144, 36);
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, -13, 893, 624);
		lblNewLabel.setIcon(new ImageIcon(AddServiceAndDocument.class.getResource("/edu/esprit/image/AddService.jpg")));
		contentPane.add(lblNewLabel);
		mngCategory= new GestionCategorieDelegater();
	}
}
