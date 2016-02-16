package edu.esprit.gui.agent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.delegater.GestionCareerObjectiveServiceDelegater;
import edu.esprit.delegater.GestionCinRequestDelegater;
import edu.esprit.domain.Agent;
import edu.esprit.domain.CinRequest;
import edu.esprit.domain.Employee;
import edu.esprit.gui.authentification.Authentification;
import gui.agent.service.MainService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class CinRequestRequest extends JFrame {

	private JPanel contentPane;
	static Employee employee;
    static int idService ;
    CinRequest cinRequest;
    JLabel reqDateText; 
    TreatCinReq treatcin;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CinRequestRequest frame = new CinRequestRequest(employee,idService);
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
	public CinRequestRequest(Employee e , int id ) {
		employee=e;
		idService=id;
		List<CinRequest> listCinReq =GestionCinRequestDelegater.doFindAllCinRequest();
		
		for(CinRequest cr:listCinReq){
			if(cr.getIdCinRequest()==idService)
				cinRequest=cr;
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
		birthLabel.setBounds(20, 217, 114, 51);
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
		cinLabel.setBounds(20, 279, 114, 51);
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
		universitiesLabel.setBounds(20, 341, 114, 51);
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
		roadLabel.setBounds(20, 403, 114, 51);
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
		careerLabel.setBounds(20, 465, 114, 51);
		contentPane.add(careerLabel);
		JLabel birthExplabel = new JLabel("");
		birthExplabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)  {
				
				byte[] bAvatar = cinRequest.getResidenceCertificate();
				int i=1;
				String namefile="";
				try{
					 namefile="C:/temp/birthReExp"+i+".jpg";
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
		

        birthExplabel.setBounds(342, 217, 48, 35);
	    contentPane.add(birthExplabel);
		
	    JLabel residenceLabel = new JLabel("");
	    residenceLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)  {
				
				byte[] bAvatar = cinRequest.getResidenceCertificate();
				int i=1;
				String namefile="";
				try{
					 namefile="C:/temp/ResidenceCertificate"+i+".jpg";
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
		

	    residenceLabel.setBounds(599, 211, 48, 41);
	    contentPane.add(residenceLabel);
	    
	    
	    JLabel photoIdLabel = new JLabel("");
	    photoIdLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)  {
				
				byte[] bAvatar = cinRequest.getPhotoId();
				int i=1;
				String namefile="";
				try{
					 namefile="C:/temp/photoId"+i+".jpg";
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
		

	    photoIdLabel.setBounds(599, 211, 48, 41);
	    contentPane.add(photoIdLabel);
		
		
		
		JTextArea responsetext = new JTextArea();
		responsetext.setBounds(223, 332, 573, 174);
		contentPane.add(responsetext);
		
		JLabel treatlabel = new JLabel("");
		treatlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cinRequest.setResponse(responsetext.getText());
				Agent agent =(Agent) employee;
				cinRequest.setAgent(agent);
				cinRequest.setResponseDate(new Date());
				cinRequest.setRequestState("treated");
				GestionCinRequestDelegater.doUpdateCinRequest(cinRequest); 
				treatcin=new TreatCinReq(employee);
				setVisible(false);
				treatcin.setVisible(true);
			}
		});
		treatlabel.setBounds(480, 542, 87, 29);
		contentPane.add(treatlabel);
		
		reqDateText = new JLabel("New label");
		reqDateText.setBounds(767, 152, 87, 29);
		reqDateText.setForeground(Color.white);
		contentPane.add(reqDateText);
		
		JLabel birthExecptLabel = new JLabel("");
		birthExecptLabel.setBounds(342, 217, 28, 20);
		contentPane.add(birthExecptLabel);
		
		
		
		JLabel photoIdlabel = new JLabel("");
		photoIdlabel.setBounds(767, 211, 29, 20);
		contentPane.add(photoIdlabel);
		
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
		imagelabel.setIcon(new ImageIcon(CinRequestRequest.class.getResource("/edu/esprit/image/CINRequest1.jpg")));
		imagelabel.setBounds(0, 0, 893, 600);
		contentPane.add(imagelabel);
	}

}
