package edu.esprit.gui.agent;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.domain.Employee;
import edu.esprit.gui.authentification.Authentification;
import gui.agent.service.MainService;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class HomeAgent extends JFrame {

	private JPanel contentPane;
    static Employee employee;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeAgent frame = new HomeAgent(employee);
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
	public HomeAgent(Employee e) {
		employee=e;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel homeMenu = new JLabel("");
		homeMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomeAgent homeAgent=new HomeAgent(employee);
				setVisible(false);
				homeAgent.setVisible(true);
				
			}
		});
		homeMenu.setBounds(218, 117, 87, 37);
		contentPane.add(homeMenu);
		
		JLabel servicesMenu = new JLabel("");
		servicesMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainService mainService =new MainService(employee);
				setVisible(false);
				mainService.setVisible(true);
			}
		});
		servicesMenu.setBounds(315, 117, 72, 37);
		contentPane.add(servicesMenu);
		JLabel serviceReqMenu = new JLabel("");
		serviceReqMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TreatBirthReg birthReq=new TreatBirthReg(employee); 
				hide();
				birthReq.show();
			}
		});
		serviceReqMenu.setBounds(477, 117, 152, 38);
		contentPane.add(serviceReqMenu);
		
		JLabel statisticMenu = new JLabel("");
		statisticMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StatisticAgent statisticAgent=new StatisticAgent(employee);
				setVisible(false);
				statisticAgent.setVisible(true);
			}
		});
		statisticMenu.setBounds(394, 117, 72, 37);
		contentPane.add(statisticMenu);
		
		JLabel claimMenu = new JLabel("");
		claimMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageClaim mClaim=new ManageClaim();
				hide();
				mClaim.show();
			
			}
		});
		claimMenu.setBounds(639, 117, 80, 37);
		contentPane.add(claimMenu);
		
		JLabel deconnexionLabel = new JLabel("");
		deconnexionLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Authentification auth=new Authentification();
				setVisible(false);
				auth.setVisible(true);
			}
		});
		deconnexionLabel.setBounds(847, 22, 36, 25);
		contentPane.add(deconnexionLabel);
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setIcon(new ImageIcon(HomeAgent.class.getResource("/edu/esprit/image/AgentPaneeel.jpg")));
		imageLabel.setBounds(0, -16, 919, 632);
		contentPane.add(imageLabel);
	}
}
