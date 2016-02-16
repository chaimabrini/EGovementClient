package edu.esprit.gui.agent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.portable.InputStream;

import edu.esprit.delegater.GestionEDinarServiceRequestDelegater;
import edu.esprit.delegater.GestionRoadTaxServiceDelegater;
import edu.esprit.domain.Agent;
import edu.esprit.domain.Employee;
import edu.esprit.domain.RoadTaxService;
import edu.esprit.gui.authentification.Authentification;
import gui.agent.service.MainService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class RoadTaxeServiceRequest extends JFrame {

	private JPanel contentPane;
	static Employee employee;
	static int idService;
	RoadTaxService road;
	JLabel reqDateText; 
    TreatRoadReq treatRoad;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoadTaxeServiceRequest frame = new RoadTaxeServiceRequest(employee,idService);
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
	public RoadTaxeServiceRequest(Employee e , int id ) {
		employee=e ;
		idService=id ;
		List<RoadTaxService> listRoad=GestionRoadTaxServiceDelegater.doFindAllRoadTaxService();
		for(RoadTaxService rsr:listRoad){
			if(rsr.getIdRoadTaxService()==idService)
				road=rsr;
		}
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
		JTextArea responseText = new JTextArea();
		responseText.setBounds(212, 368, 580, 159);
		contentPane.add(responseText);
		JLabel treatlabel = new JLabel("");
		treatlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Agent agent=(Agent) employee;
				road.setAgent(agent);
				road.setRequestState("treated");
				road.setResponseDate(new Date());
				road.setResponse(responseText.getText());
				GestionRoadTaxServiceDelegater.doUpdateRoadTaxService(road);
			    treatRoad=new TreatRoadReq(employee);
			    setVisible(false);
			    treatRoad.setVisible(true);
			}
		});
		
		JTextArea cinText = new JTextArea();
		cinText.setEditable(false);
		cinText.setBounds(662, 225, 167, 29);
		contentPane.add(cinText);
		cinText.setText(road.getCin());
		
		JTextArea idroad = new JTextArea();
		idroad.setEditable(false);
		idroad.setBounds(311, 225, 167, 29);
		idroad.setText(road.getIdRoadTaxService()+"");
		contentPane.add(idroad);
		treatlabel.setBounds(472, 547, 101, 35);
		contentPane.add(treatlabel);
		
		JLabel drivingLabel = new JLabel("");
		drivingLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)  {
				
				byte[] bAvatar = road.getDrivingLicense();
				int i=1;
				String namefile="";
				try{
					 namefile="C:/temp/image"+i+".jpg";
				    FileOutputStream fos = new FileOutputStream(namefile); 
				    fos.write(bAvatar);
				    fos.close();
				    i++;
				}catch(Exception e1){
				    e1.printStackTrace();
				}
				
		        JOptionPane.showMessageDialog(contentPane, "the file is download you will find it in"+namefile);
				
			}
		});
		

        drivingLabel.setBounds(346, 287, 48, 35);
	    contentPane.add(drivingLabel);
		
		reqDateText = new JLabel("New label");
		reqDateText.setBounds(767, 152, 87, 29);
		String datestring = new SimpleDateFormat("yyyy-MM-dd").format(road.getRequestDate());
		reqDateText.setText(datestring);
		reqDateText.setForeground(Color.white);
		contentPane.add(reqDateText);
		
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
		
		JLabel imagelabel = new JLabel("");
		imagelabel.setIcon(new ImageIcon(RoadTaxeServiceRequest.class.getResource("/edu/esprit/image/RoadTax1.jpg")));
		imagelabel.setBounds(0, -18, 909, 632);
		contentPane.add(imagelabel);
	}

}
