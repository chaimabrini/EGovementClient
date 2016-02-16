package edu.esprit.gui.agent;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.domain.BirthRegistration;
import edu.esprit.domain.CareerObjectiveService;
import edu.esprit.domain.CinRequest;
import edu.esprit.domain.Employee;
import edu.esprit.domain.RoadTaxService;
import edu.esprit.gui.authentification.Authentification;
import gui.agent.service.MainService;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class ResponseRequest extends JFrame {

	private JPanel contentPane;
     RoadTaxService road ;
     CinRequest cin ; 
     CareerObjectiveService career;
     BirthRegistration birth; 
     static Object service ;
     static Employee employee;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResponseRequest frame = new ResponseRequest(employee,service);
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
	public ResponseRequest(Employee e ,Object obj) {
		employee=e;
		service=obj ;
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
		
		
		
		JTextArea citizen = new JTextArea();
		citizen.setEditable(false);
		citizen.setBounds(312, 221, 162, 31);
		contentPane.add(citizen);
		
		JTextArea agent = new JTextArea();
		agent.setEditable(false);
		agent.setBounds(685, 221, 162, 31);
		contentPane.add(agent);
		
		JTextArea reqDate = new JTextArea();
		reqDate.setEditable(false);
		reqDate.setBounds(312, 282, 162, 31);
		contentPane.add(reqDate);
		
		JTextArea responseDate = new JTextArea();
		responseDate.setEditable(false);
		responseDate.setBounds(685, 282, 162, 31);
		contentPane.add(responseDate);
		
		JTextArea response = new JTextArea();
		response.setEditable(false);
		response.setBounds(312, 348, 526, 182);
		contentPane.add(response);
		
		if(obj instanceof RoadTaxService){
			road=(RoadTaxService)obj;
			citizen.setText(road.getCitizen().getFirstName()+" "+road.getCitizen().getLastName());	
			agent.setText(road.getAgent().getLogin());
			String datestring = new SimpleDateFormat("yyyy-MM-dd").format(road.getRequestDate());
			reqDate.setText(datestring);
			String datestring1 = new SimpleDateFormat("yyyy-MM-dd").format(road.getResponseDate());
			responseDate.setText(datestring1);
			response.setText(road.getResponse());
		
		}
		else if(obj instanceof CinRequest){
			cin=(CinRequest)obj;
			citizen.setText(cin.getCitizen().getFirstName()+" "+cin.getCitizen().getLastName());	
			agent.setText(cin.getAgent().getLogin());
			String datestring = new SimpleDateFormat("yyyy-MM-dd").format(cin.getRequestDate());
			reqDate.setText(datestring);
			String datestring1 = new SimpleDateFormat("yyyy-MM-dd").format(cin.getResponseDate());
			responseDate.setText(datestring1);
			response.setText(cin.getResponse());
		
		    }
		else if (obj instanceof CareerObjectiveService){
			career=(CareerObjectiveService) obj ;
			citizen.setText(career.getCitizen().getFirstName()+" "+career.getCitizen().getLastName());	
			agent.setText(career.getAgent().getLogin());
			String datestring = new SimpleDateFormat("yyyy-MM-dd").format(career.getRequestDate());
			reqDate.setText(datestring);
			String datestring1 = new SimpleDateFormat("yyyy-MM-dd").format(career.getResponseDate());
			responseDate.setText(datestring1);
			response.setText(career.getResponse());	
		
		}
		else if(obj instanceof BirthRegistration){
			birth=(BirthRegistration)obj;
			citizen.setText(birth.getCitizen().getFirstName()+" "+birth.getCitizen().getLastName());	
			agent.setText(birth.getAgent().getLogin());
			String datestring = new SimpleDateFormat("yyyy-MM-dd").format(birth.getRequestDate());
			reqDate.setText(datestring);
			String datestring1 = new SimpleDateFormat("yyyy-MM-dd").format(birth.getResponseDate());
			responseDate.setText(datestring1);
			response.setText(birth.getResponse());		
		
		}
		
		

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
		imageLabel.setIcon(new ImageIcon(ResponseRequest.class.getResource("/edu/esprit/image/Response.jpg")));
		imageLabel.setBounds(0, -20, 919, 633);
		contentPane.add(imageLabel);
		
		
	}

	

}
