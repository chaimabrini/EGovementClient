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

import edu.esprit.delegater.GestionBirthResgistrationDelegater;
import edu.esprit.domain.Agent;
import edu.esprit.domain.BirthRegistration;
import edu.esprit.domain.Employee;
import edu.esprit.gui.authentification.Authentification;
import gui.agent.service.MainService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class BirthRegistrationRequest extends JFrame {

	private JPanel contentPane;
    static Employee employee ;
    static int idService ;
    private JTextArea cintext;
    private JTextArea childnameText;
    private JTextArea birthdateText;
    private JTextArea regDateText;
    private JTextArea responseDateText;
    private JTextArea response;
    private JLabel treatlabel;
    BirthRegistration birthReg;
    TreatBirthReg  treatBR;
    private JLabel reqDateText;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BirthRegistrationRequest frame = new BirthRegistrationRequest(employee,idService);
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
	public BirthRegistrationRequest(Employee e , int id) {
		employee=e ; 
		idService=id ;
		
		 birthReg=new BirthRegistration();
		List<BirthRegistration> listBirthReg=GestionBirthResgistrationDelegater.doFindAllBirthRegistration();
		for(BirthRegistration br:listBirthReg){
			if(br.getIdBirthRegistration()==idService)
				birthReg=br;
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
		birthLabel.setBounds(24, 215, 114, 51);
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
		cinLabel.setBounds(24, 277, 114, 51);
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
		universitiesLabel.setBounds(24, 339, 114, 51);
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
		roadLabel.setBounds(24, 401, 114, 51);
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
		careerLabel.setBounds(24, 463, 114, 51);
		contentPane.add(careerLabel);
		
		cintext = new JTextArea();
		cintext.setEditable(false);
		cintext.setBounds(300, 232, 163, 29);
		cintext.setBorder(null);
		cintext.setText(birthReg.getCin());
		contentPane.add(cintext);
		cintext.setColumns(10);
		
		childnameText = new JTextArea();
		childnameText.setEditable(false);
		childnameText.setBounds(691, 232, 163, 29);
		childnameText.setBorder(null);
		childnameText.setText(birthReg.getChildName());
		contentPane.add(childnameText);
		childnameText.setColumns(10);
		
		birthdateText = new JTextArea();
		birthdateText.setEditable(false);
		birthdateText.setBounds(300, 304, 163, 29);
		birthdateText.setBorder(null);
		birthdateText.setText(birthReg.getBirthDate()+"");
		contentPane.add(birthdateText);
		birthdateText.setColumns(10);
		
		regDateText = new JTextArea();
		regDateText.setEditable(false);
		regDateText.setBounds(691, 304, 163, 29);
		regDateText.setBorder(null);
		regDateText.setText(birthReg.getRequestDate()+"");
		contentPane.add(regDateText);
		regDateText.setColumns(10);
		
		JLabel marriagelabel = new JLabel("");
		marriagelabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)  {
				
				byte[] bAvatar = birthReg.getMarriageContract();
				int i=1;
				String namefile="";
				try{
					 namefile="C:/temp/birthReg"+i+".jpg";
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
		

        marriagelabel.setBounds(360, 355, 48, 35);
	    contentPane.add(marriagelabel);
		
		
		response = new JTextArea();
		response.setBounds(182, 423, 528, 144);
		response.setBorder(null);
		contentPane.add(response);
		
		treatlabel = new JLabel("");
		treatlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Agent agent=(Agent)employee;
				birthReg.setAgent(agent);
				birthReg.setResponse(response.getText());
				birthReg.setResponseDate(new Date());
				birthReg.setRequestState("treated");
				GestionBirthResgistrationDelegater.doUpdateBirthRegistration(birthReg);
				treatBR=new TreatBirthReg(employee);
				setVisible(false);
				treatBR.setVisible(true);
			}
		});
		treatlabel.setBounds(745, 479, 99, 35);
		contentPane.add(treatlabel);
		
		reqDateText = new JLabel("New label");
		reqDateText.setBounds(767, 152, 87, 29);
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
		imagelabel.setIcon(new ImageIcon(BirthRegistrationRequest.class.getResource("/edu/esprit/image/BirthRegistration1.jpg")));
		imagelabel.setBounds(0, -11, 893, 619);
		contentPane.add(imagelabel);
	}

}
