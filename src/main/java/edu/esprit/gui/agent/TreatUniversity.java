package edu.esprit.gui.agent;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.w3c.dom.ls.LSInput;

import edu.esprit.delegater.GestionBirthResgistrationDelegater;
import edu.esprit.delegater.GestionEDinarServiceRequestDelegater;
import edu.esprit.delegater.GestionUniversityDelegater;
import edu.esprit.domain.EDinarServiceRequest;
import edu.esprit.domain.Employee;
import edu.esprit.domain.University;
import gui.agent.service.MainService;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
// 4alta lezim edinar 
public class TreatUniversity extends JFrame {
 
	
	
	
	private JPanel contentPane;
    static Employee employee ;
    private JTable table;
    List<EDinarServiceRequest> listUniversity;
	private JTextField recherche;
	TableModel dm;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreatUniversity frame = new TreatUniversity(employee);
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
	public TreatUniversity(Employee e) {
		employee=e;
		listUniversity=new ArrayList<EDinarServiceRequest>();
		listUniversity=GestionEDinarServiceRequestDelegater.doFindAlleDinarServiceRequest();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(222, 197, 594, 332);
		contentPane.add(scrollPane);
		
		table = new JTable();
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
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setIcon(new ImageIcon(TreatUniversity.class.getResource("/edu/esprit/image/Listedinar1.jpg")));
		imageLabel.setBounds(0, 0, 893, 600);
		contentPane.add(imageLabel);
		initDataBindings();
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

	protected void initDataBindings() {
		JTableBinding<EDinarServiceRequest, List<EDinarServiceRequest>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, listUniversity, table);
		//
		BeanProperty<EDinarServiceRequest, String> eDinarServiceRequestBeanProperty = BeanProperty.create("citizen.cin");
		jTableBinding.addColumnBinding(eDinarServiceRequestBeanProperty).setColumnName("Cin");
		//
		BeanProperty<EDinarServiceRequest, String> eDinarServiceRequestBeanProperty_1 = BeanProperty.create("eDinarCard.numeroCard");
		jTableBinding.addColumnBinding(eDinarServiceRequestBeanProperty_1).setColumnName("Card Number");
		//
		BeanProperty<EDinarServiceRequest, String> eDinarServiceRequestBeanProperty_2 = BeanProperty.create("transportLine.numeroLine");
		jTableBinding.addColumnBinding(eDinarServiceRequestBeanProperty_2).setColumnName("Transport");
		//
		BeanProperty<EDinarServiceRequest, String> eDinarServiceRequestBeanProperty_3 = BeanProperty.create("university.name");
		jTableBinding.addColumnBinding(eDinarServiceRequestBeanProperty_3).setColumnName("University");
		//
		BeanProperty<EDinarServiceRequest, String> eDinarServiceRequestBeanProperty_4 = BeanProperty.create("requestState");
		jTableBinding.addColumnBinding(eDinarServiceRequestBeanProperty_4).setColumnName("State");
		//
		jTableBinding.bind();
	}
}
