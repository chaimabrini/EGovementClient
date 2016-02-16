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

import edu.esprit.delegater.GestionCareerObjectiveServiceDelegater;
import edu.esprit.delegater.GestionCinRequestDelegater;
import edu.esprit.domain.Agent;
import edu.esprit.domain.CinRequest;
import edu.esprit.domain.Employee;

import javax.swing.JLabel;
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
		
		JLabel residenceLabel = new JLabel("");
		residenceLabel.setBounds(599, 217, 34, 20);
		contentPane.add(residenceLabel);
		
		JLabel photoIdlabel = new JLabel("");
		photoIdlabel.setBounds(767, 211, 29, 20);
		contentPane.add(photoIdlabel);
		
		JLabel imagelabel = new JLabel("");
		imagelabel.setIcon(new ImageIcon(CinRequestRequest.class.getResource("/edu/esprit/image/CINRequest.jpg")));
		imagelabel.setBounds(0, 0, 893, 600);
		contentPane.add(imagelabel);
	}

}
