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
import javax.swing.table.TableRowSorter;

import edu.esprit.delegater.GestionBirthResgistrationDelegater;
import edu.esprit.delegater.GestionCinRequestDelegater;
import edu.esprit.domain.BirthRegistration;
import edu.esprit.domain.CinRequest;
import edu.esprit.domain.Employee;
import edu.esprit.gui.authentification.Authentification;
import gui.agent.service.MainService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.Converter;

import java.util.Date;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TreatCinReq extends JFrame {

	private JPanel contentPane;
    static Employee employee;
    List<CinRequest> listCinRequest;
    private JTable table;
    private JTextField recherche; 
    int idCinRequest;
    CinRequest cinselected=null;
    TableModel dm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreatCinReq frame = new TreatCinReq(employee);
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
	public TreatCinReq(Employee e) {
		employee=e;
		listCinRequest=new ArrayList<CinRequest>();
		listCinRequest=GestionCinRequestDelegater.doFindAllCinRequest();
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(223, 197, 593, 332);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idCinRequest=listCinRequest.get(table.getSelectedRow()).getIdCinRequest();
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
		
		JLabel showlabel = new JLabel("");
		showlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        List<CinRequest> br=GestionCinRequestDelegater.doFindAllCinRequest();
				
				for(CinRequest b:br){
					if(b.getIdCinRequest()==idCinRequest)
						cinselected=b;
				}
				
				CinRequest cinReq=null;
				if((cinselected.getRequestState().equals("treated")))
					cinReq=cinselected;
			
			if(cinReq!=null)	{
		    ResponseRequest responseReq=new ResponseRequest(employee,cinReq);
			setVisible(false);
			responseReq.setVisible(true);	
		}
		else 
			JOptionPane.showMessageDialog(contentPane, "Request not treated"); 
			
			}
		});
		showlabel.setBounds(393, 546, 96, 36);
		contentPane.add(showlabel);
		
		recherche = new JTextField();
		recherche.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				filterTbale(recherche.getText());
				
				
			}
		});
		
		
		recherche.setBounds(650, 153, 144, 20);
		recherche.setBorder(null);
		
		contentPane.add(recherche);
		recherche.setColumns(10);
		
		JLabel treatlabel = new JLabel("");
		treatlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 List<CinRequest> br=GestionCinRequestDelegater.doFindAllCinRequest();
					
					for(CinRequest b:br){
						if(b.getIdCinRequest()==idCinRequest)
							cinselected=b;
					}
					CinRequest cinReq=null;
				if((cinselected.getRequestState().equals("untreated")))
					cinReq=cinselected;
			
			if(cinReq!=null)	{

				CinRequestRequest bRR=new CinRequestRequest(employee ,idCinRequest);
				setVisible(false);
				bRR.setVisible(true);
		}
		else 
			JOptionPane.showMessageDialog(contentPane, "Request is treated"); 
				
			}
		});
		treatlabel.setBounds(555, 546, 96, 36);
		contentPane.add(treatlabel);
		
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
		imageLabel.setIcon(new ImageIcon(TreatCinReq.class.getResource("/edu/esprit/image/listCIN1.jpg")));
		imageLabel.setBounds(0, 0, 893, 600);
		contentPane.add(imageLabel);
		initDataBindings();
	}

	protected void initDataBindings() {
		JTableBinding<CinRequest, List<CinRequest>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, listCinRequest, table);
		//
		BeanProperty<CinRequest, String> cinRequestBeanProperty = BeanProperty.create("citizen.firstName");
		jTableBinding.addColumnBinding(cinRequestBeanProperty).setColumnName("First Name");
		//
		
		BeanProperty<CinRequest, String> cinRequestBeanProperty_1 = BeanProperty.create("citizen.lastName");
		jTableBinding.addColumnBinding(cinRequestBeanProperty_1).setColumnName("Last Name");
		//
		BeanProperty<CinRequest, Date> cinRequestBeanProperty_2 = BeanProperty.create("requestDate");
		jTableBinding.addColumnBinding(cinRequestBeanProperty_2).setColumnName("Request Date");
		//
		BeanProperty<CinRequest, String> cinRequestBeanProperty_3 = BeanProperty.create("requestState");
		jTableBinding.addColumnBinding(cinRequestBeanProperty_3).setColumnName("State");
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
