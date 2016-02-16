package edu.esprit.gui.authentification;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.delegater.GestionEmployeeDelegater;
import edu.esprit.domain.Admin;
import edu.esprit.domain.Agent;
import edu.esprit.domain.Employee;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Authentification extends JFrame {

	private JPanel contentPane;
	private JPasswordField pwd;
	private JTextField login;
	private JLabel connect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification frame = new Authentification();
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
	public Authentification() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pwd = new JPasswordField();
		pwd.setBounds(157, 187, 189, 20);
		pwd.setBorder(null);
		contentPane.add(pwd);
		
		JLabel lblBackgroundimage = new JLabel("");
		lblBackgroundimage.setIcon(new ImageIcon(Authentification.class.getResource("/edu/esprit/image/Authentification.jpg")));
		lblBackgroundimage.setBounds(0, 0, 450, 300);
		contentPane.add(lblBackgroundimage);
		
		login = new JTextField();
		login.setBounds(157, 124, 189, 20);
		login.setBorder(null);
		contentPane.add(login);
		login.setColumns(10);
		
		connect = new JLabel("");
		connect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Employee employee=GestionEmployeeDelegater.doAuthentificate(login.getText(), new String (pwd.getPassword()));
				if (employee!=null){
					if (employee instanceof Admin){
						System.out.println("Admin");
					}
					else
						if (employee instanceof Agent)
							System.out.println("Agent");
					setVisible(false);
				}
			}
		});
		connect.setBounds(202, 241, 105, 31);
		contentPane.add(connect);
	}
}
