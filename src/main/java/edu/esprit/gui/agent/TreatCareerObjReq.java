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

import edu.esprit.delegater.GestionCareerObjectiveServiceDelegater;
import edu.esprit.delegater.GestionRoadTaxServiceDelegater;
import edu.esprit.domain.CareerObjectiveService;
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

public class TreatCareerObjReq extends JFrame {

	private JPanel contentPane;
	static Employee employee;
	List<CareerObjectiveService>  listCareerObjectiveService;
	private JTable table;
	int idCareerObj;
	CareerObjectiveService careerObjectiveServiceelected=null;

	private JTextField recherche;
	TableModel dm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreatCareerObjReq frame = new TreatCareerObjReq(employee);
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
	public TreatCareerObjReq(Employee e) {
		employee=e;
		listCareerObjectiveService=new ArrayList<CareerObjectiveService>();
		listCareerObjectiveService=GestionCareerObjectiveServiceDelegater.doFindAllCareerObjectiveService();
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
		scrollPane.setBounds(223, 197, 595, 331);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				idCareerObj=listCareerObjectiveService.get(table.getSelectedRow()).getIdCareer();
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


				List<CareerObjectiveService> br=GestionCareerObjectiveServiceDelegater.doFindAllCareerObjectiveService();
				
				for(CareerObjectiveService b:br){
					if(b.getIdCareer()==idCareerObj)
						careerObjectiveServiceelected=b;
				}
				
				CareerObjectiveService careerok=null;
				if((careerObjectiveServiceelected.getRequestState().equals("treated")))
					careerok=careerObjectiveServiceelected;
			
			if(careerok!=null)	{
		    ResponseRequest responseReq=new ResponseRequest(employee,careerok);
			setVisible(false);
			responseReq.setVisible(true);	
		}
		else 
			JOptionPane.showMessageDialog(contentPane, "Request not treated"); 
		
			
			}
		});
		showlabel.setBounds(390, 545, 101, 37);
		contentPane.add(showlabel);
		
		JLabel treatLabel = new JLabel("");
		treatLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
               List<CareerObjectiveService> br=GestionCareerObjectiveServiceDelegater.doFindAllCareerObjectiveService();
		       for(CareerObjectiveService b:br){
					if(b.getIdCareer()==idCareerObj)
						careerObjectiveServiceelected=b;
				}
				
				CareerObjectiveService careerok=null;
				if((careerObjectiveServiceelected.getRequestState().equals("untreated")))
					careerok=careerObjectiveServiceelected;
			
			if(careerok!=null)	{
		    CareerObjectifServiceRequest req=new CareerObjectifServiceRequest(employee,idCareerObj);
			setVisible(false);
			req.setVisible(true);	
		}
		else 
			JOptionPane.showMessageDialog(contentPane, "Request is treated"); 
		
				
			}
		});
		treatLabel.setBounds(556, 547, 95, 35);
		contentPane.add(treatLabel);
		
		recherche = new JTextField();
		recherche.setBorder(null);
		recherche.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				filterTbale(recherche.getText());
				
				
			}
		});
		recherche.setBounds(656, 149, 143, 20);
		contentPane.add(recherche);
		recherche.setColumns(10);
		
		JLabel imagelabel = new JLabel("");
		imagelabel.setIcon(new ImageIcon(TreatCareerObjReq.class.getResource("/edu/esprit/image/listCarrerObjective.jpg")));
		imagelabel.setBounds(0, 0, 896, 595);
		contentPane.add(imagelabel);
		initDataBindings();
	}

	protected void initDataBindings() {
		JTableBinding<CareerObjectiveService, List<CareerObjectiveService>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, listCareerObjectiveService, table);
		//
		BeanProperty<CareerObjectiveService, String> careerObjectiveServiceBeanProperty = BeanProperty.create("citizen.firstName");
		jTableBinding.addColumnBinding(careerObjectiveServiceBeanProperty).setColumnName("First Name");
		//
		BeanProperty<CareerObjectiveService, String> careerObjectiveServiceBeanProperty_1 = BeanProperty.create("citizen.lastName");
		jTableBinding.addColumnBinding(careerObjectiveServiceBeanProperty_1).setColumnName("Last Name");
		//
		BeanProperty<CareerObjectiveService, Date> careerObjectiveServiceBeanProperty_2 = BeanProperty.create("requestDate");
		jTableBinding.addColumnBinding(careerObjectiveServiceBeanProperty_2).setColumnName("Request Date");
		//
		BeanProperty<CareerObjectiveService, String> careerObjectiveServiceBeanProperty_3 = BeanProperty.create("requestState");
		jTableBinding.addColumnBinding(careerObjectiveServiceBeanProperty_3).setColumnName("State");
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
