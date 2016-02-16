package edu.esprit.gui.agent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.delegater.GestionBirthResgistrationDelegater;
import edu.esprit.domain.Agent;
import edu.esprit.domain.BirthRegistration;
import edu.esprit.domain.Employee;

import javax.swing.JLabel;
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
    private JLabel marriagelabel;
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
		
		marriagelabel = new JLabel("");
		marriagelabel.setBounds(362, 354, 31, 22);
		contentPane.add(marriagelabel);
		
		reqDateText = new JLabel("New label");
		reqDateText.setBounds(767, 152, 87, 29);
		reqDateText.setForeground(Color.white);
		contentPane.add(reqDateText);
		
		JLabel imagelabel = new JLabel("");
		imagelabel.setIcon(new ImageIcon(BirthRegistrationRequest.class.getResource("/edu/esprit/image/BirthRegistration.jpg")));
		imagelabel.setBounds(0, -11, 893, 619);
		contentPane.add(imagelabel);
	}

}
