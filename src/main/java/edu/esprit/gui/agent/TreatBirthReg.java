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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import edu.esprit.delegater.GestionBirthResgistrationDelegater;
import edu.esprit.domain.Agent;
import edu.esprit.domain.BirthRegistration;
import edu.esprit.domain.Employee;
import edu.esprit.gui.authentification.Authentification;
import edu.esprit.services.gestion.birthregistration.GestionBirthRegistration;
import gui.agent.service.MainService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TreatBirthReg extends JFrame {

	private JPanel contentPane;
    static Employee employee;
    private JTable table; 
    List<BirthRegistration> listBirthRegistration;
    static int idBithReg;
	BirthRegistration birthselected=null;
	private JTextField recherche;
	TableModel dm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreatBirthReg frame = new TreatBirthReg(employee);
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
	public TreatBirthReg(Employee e) {
		employee=e;
		listBirthRegistration= new ArrayList<BirthRegistration>();
		listBirthRegistration=GestionBirthResgistrationDelegater.doFindAllBirthRegistration();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 197, 591, 328);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idBithReg=listBirthRegistration.get(table.getSelectedRow()).getIdBirthRegistration();
			}
		});
		scrollPane.setViewportView(table);
		
		
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
		Agent agent=(Agent)employee;
		
		JLabel birthLabel = new JLabel("");
		birthLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TreatBirthReg birthreg=new TreatBirthReg(employee );
				hide();
				birthreg.show();
				
			}
		});
		birthLabel.setBounds(21, 197, 114, 51);
		contentPane.add(birthLabel);
		
		JLabel cinLabel = new JLabel("");
		cinLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TreatCinReq cinreq =new TreatCinReq(employee);
				hide();
				cinreq.show();
				
			}
		});
		cinLabel.setBounds(21, 259, 114, 51);
		contentPane.add(cinLabel);
		
		JLabel universitiesLabel = new JLabel("");
		universitiesLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TreatUniversity univerReq=new TreatUniversity(employee);
				hide();
				univerReq.show();
			}
		});
		universitiesLabel.setBounds(21, 321, 114, 51);
		contentPane.add(universitiesLabel);
		
		JLabel roadLabel = new JLabel("");
		roadLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TreatRoadReq roadReq=new TreatRoadReq(employee);
				hide();
				roadReq.show();
			}
		});
		roadLabel.setBounds(21, 383, 114, 51);
		contentPane.add(roadLabel);
		
		JLabel careerLabel = new JLabel("");
		careerLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TreatCareerObjReq careerReq =new TreatCareerObjReq(employee);
				hide();
				careerReq.show();
			}
		});
		careerLabel.setBounds(21, 445, 114, 51);
		contentPane.add(careerLabel);
		
		JLabel showLabel = new JLabel("");
		showLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<BirthRegistration> br=GestionBirthResgistrationDelegater.doFindAllBirthRegistration();
				
				for(BirthRegistration b:br){
					if(b.getIdBirthRegistration()==idBithReg)
						birthselected=b;
				}
				
				BirthRegistration birthReg=null;
				if((birthselected.getRequestState().equals("treated")))
					birthReg=birthselected;
			
			if(birthReg!=null)	{
		    ResponseRequest responseReq=new ResponseRequest(employee,birthReg);
			setVisible(false);
			responseReq.setVisible(true);	
		}
		else 
			JOptionPane.showMessageDialog(contentPane, "Request not treated"); 
			
			
			}
		});
		showLabel.setBounds(392, 546, 103, 36);
		contentPane.add(showLabel);
		
		JLabel treatlabel = new JLabel("");
		treatlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<BirthRegistration> br=GestionBirthResgistrationDelegater.doFindAllBirthRegistration();
				
				for(BirthRegistration b:br){
					if(b.getIdBirthRegistration()==idBithReg)
						birthselected=b;
				} 
				BirthRegistration birthReg=null;
				if((birthselected.getRequestState().equals("untreated")))
					birthReg=birthselected;
			
			if(birthReg!=null)	{

				BirthRegistrationRequest bRR=new BirthRegistrationRequest(employee ,idBithReg);
				setVisible(false);
				bRR.setVisible(true);
		}
		else 
			JOptionPane.showMessageDialog(contentPane, "Request is treated"); 
			
			
			}
				
				
				
				
			
		});
		treatlabel.setBounds(560, 546, 80, 36);
		contentPane.add(treatlabel);
		
		recherche = new JTextField();
		recherche.setBorder(null);
		recherche.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				filterTbale(recherche.getText());
				
				
			}
		});
		recherche.setBounds(656, 149, 138, 20);
		contentPane.add(recherche);
		recherche.setColumns(10);
      /* if(agent.getEtablishment().getName().equals("")){
	         //  cinLabel.seta(false);
	           universitiesLabel.setEnabled(false);
	           roadLabel.setEnabled(false);
	           careerLabel.setEnabled(false);
            }*/
		
		
		
		
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
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setIcon(new ImageIcon(TreatBirthReg.class.getResource("/edu/esprit/image/listBirth1.jpg")));
		imageLabel.setBounds(0, 0, 893, 594);
		contentPane.add(imageLabel);
		initDataBindings();
	}

	protected void initDataBindings() {
		JTableBinding<BirthRegistration, List<BirthRegistration>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, listBirthRegistration, table);
		//
		BeanProperty<BirthRegistration, String> birthRegistrationBeanProperty = BeanProperty.create("citizen.firstName");
		jTableBinding.addColumnBinding(birthRegistrationBeanProperty).setColumnName("First Name");
		//
		BeanProperty<BirthRegistration, String> birthRegistrationBeanProperty_1 = BeanProperty.create("citizen.lastName");
		jTableBinding.addColumnBinding(birthRegistrationBeanProperty_1).setColumnName("Last Name");
		//
		BeanProperty<BirthRegistration, Date> birthRegistrationBeanProperty_3 = BeanProperty.create("requestDate");
		jTableBinding.addColumnBinding(birthRegistrationBeanProperty_3).setColumnName("Requeste date");
		//
		BeanProperty<BirthRegistration, String> birthRegistrationBeanProperty_4 = BeanProperty.create("requestState");
		jTableBinding.addColumnBinding(birthRegistrationBeanProperty_4).setColumnName("State");
		//
		jTableBinding.bind();
	}
	public void filterTbale(String recherche){
		initModel();
		TableRowSorter<TableModel> tableRow=new TableRowSorter<TableModel>(dm);
		table.setRowSorter(tableRow);
		tableRow.setRowFilter(RowFilter.regexFilter(recherche));
	}
	public void initModel()
	{
		dm=(TableModel)table.getModel();
	}
	
}
