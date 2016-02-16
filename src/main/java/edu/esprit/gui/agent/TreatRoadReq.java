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

import edu.esprit.delegater.GestionBirthResgistrationDelegater;
import edu.esprit.delegater.GestionRoadTaxServiceDelegater;
import edu.esprit.domain.BirthRegistration;
import edu.esprit.domain.Employee;
import edu.esprit.domain.RoadTaxService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import java.util.Date;

public class TreatRoadReq extends JFrame {

	private JPanel contentPane;
    static Employee employee; 
    private JTable table;
    List<RoadTaxService>  listRoadTaxService;
    int idRoadReq;
    RoadTaxService RoadTaxServiceselected=null;
    private JTextField recherche;
	TableModel dm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreatRoadReq frame = new TreatRoadReq(employee);
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
	public TreatRoadReq(Employee e) {
		employee=e;
		listRoadTaxService=new ArrayList<RoadTaxService>();
		listRoadTaxService=GestionRoadTaxServiceDelegater.doFindAllRoadTaxService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel homeMenu = new JLabel("");
		homeMenu.setBounds(291, 47, 80, 37);
		homeMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(225, 197, 592, 333);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idRoadReq=listRoadTaxService.get(table.getSelectedRow()).getIdRoadTaxService();
			}
		});
		scrollPane.setViewportView(table);
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
			

				List<RoadTaxService> br=GestionRoadTaxServiceDelegater.doFindAllRoadTaxService();
				
				for(RoadTaxService b:br){
					if(b.getIdRoadTaxService()==idRoadReq)
						RoadTaxServiceselected=b;
				}
				
				RoadTaxService roadService=null;
				if((RoadTaxServiceselected.getRequestState().equals("treated")))
					roadService=RoadTaxServiceselected;
			
			if(roadService!=null)	{
		    ResponseRequest responseReq=new ResponseRequest(employee,roadService);
			setVisible(false);
			responseReq.setVisible(true);	
		}
		else 
			JOptionPane.showMessageDialog(contentPane, "Request not treated"); 
		
			}
		});
		showlabel.setBounds(391, 553, 100, 29);
		contentPane.add(showlabel);
		
		JLabel treatLabel = new JLabel("");
		treatLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	List<RoadTaxService> br=GestionRoadTaxServiceDelegater.doFindAllRoadTaxService();
				
				for(RoadTaxService b:br){
					if(b.getIdRoadTaxService()==idRoadReq)
						RoadTaxServiceselected=b;
				}
				
				RoadTaxService roadService=null;
				if((RoadTaxServiceselected.getRequestState().equals("untreated")))
					roadService=RoadTaxServiceselected;
			
			if(roadService!=null)	{
		    RoadTaxeServiceRequest responseReq=new RoadTaxeServiceRequest(employee,idRoadReq);
			setVisible(false);
			responseReq.setVisible(true);	
		}
		else 
			JOptionPane.showMessageDialog(contentPane, "Request is treated"); 
		
			
				
				
			}
		});
		treatLabel.setBounds(559, 550, 92, 32);
		contentPane.add(treatLabel);
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
		
		
		JLabel imagelabel = new JLabel("");
		imagelabel.setIcon(new ImageIcon(TreatRoadReq.class.getResource("/edu/esprit/image/ListRoadTax.jpg")));
		imagelabel.setBounds(0, 0, 893, 600);
		contentPane.add(imagelabel);
		initDataBindings();
	}

	protected void initDataBindings() {
		JTableBinding<RoadTaxService, List<RoadTaxService>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, listRoadTaxService, table);
		//
		BeanProperty<RoadTaxService, String> roadTaxServiceBeanProperty = BeanProperty.create("citizen.firstName");
		jTableBinding.addColumnBinding(roadTaxServiceBeanProperty).setColumnName("First Name");
		//
		BeanProperty<RoadTaxService, String> roadTaxServiceBeanProperty_1 = BeanProperty.create("citizen.lastName");
		jTableBinding.addColumnBinding(roadTaxServiceBeanProperty_1).setColumnName("Last Name");
		//
		BeanProperty<RoadTaxService, Date> roadTaxServiceBeanProperty_2 = BeanProperty.create("requestDate");
		jTableBinding.addColumnBinding(roadTaxServiceBeanProperty_2).setColumnName("Request Date");
		//
		BeanProperty<RoadTaxService, String> roadTaxServiceBeanProperty_3 = BeanProperty.create("requestState");
		jTableBinding.addColumnBinding(roadTaxServiceBeanProperty_3).setColumnName("State");
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
