package edu.esprit.gui.administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.domain.Employee;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditProfilAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField login;
	private JTextField pwd;
    static Employee employee;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditProfilAdmin frame = new EditProfilAdmin(employee);
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
	public EditProfilAdmin(Employee e) {
		employee=e;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(EditProfilAdmin.class.getResource("/edu/esprit/image/editProfil.jpg")));
		lblNewLabel.setBounds(0, 0, 900, 600);
		contentPane.add(lblNewLabel);

		login = new JTextField();
		login.setBounds(186, 260, 176, 35);
		contentPane.add(login);
		login.setColumns(10);

		pwd = new JTextField();
		pwd.setBounds(575, 260, 176, 35);
		contentPane.add(pwd);
		pwd.setColumns(10);

		JLabel edit = new JLabel("New label");
		edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Employee emp = new Employee();
				emp.setLogin(login.getText());
				emp.setPassword(pwd.getText());

			}
		});
		edit.setBounds(269, 373, 115, 46);
		contentPane.add(edit);

		JLabel cancel = new JLabel("New label");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		cancel.setBounds(520, 373, 125, 46);
		contentPane.add(cancel);

		JLabel Home = new JLabel("New label");
		Home.setBounds(291, 41, 82, 46);
		contentPane.add(Home);

		JLabel Establishment = new JLabel("New label");
		Establishment.setBounds(375, 39, 82, 48);
		contentPane.add(Establishment);

		JLabel Category = new JLabel("New label");
		Category.setBounds(458, 39, 82, 48);
		contentPane.add(Category);

		JLabel Employee = new JLabel("New label");
		Employee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new GestionEmployees(employee).setVisible(true);
			}
		});
		Employee.setBounds(538, 41, 82, 46);
		contentPane.add(Employee);

		JLabel Statistic = new JLabel("New label");
		Statistic.setBounds(619, 42, 82, 45);
		contentPane.add(Statistic);

		JLabel Claim = new JLabel("New label");
		Claim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new listClaims(employee).setVisible(true);

			}
		});
		Claim.setBounds(700, 40, 88, 47);
		contentPane.add(Claim);
		
		JLabel profil = new JLabel("New label");
		profil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new EditProfilAdmin(employee).setVisible(true);
			}
		});
		profil.setBounds(817, 11, 31, 35);
		contentPane.add(profil);
		
		JLabel logout = new JLabel("New label");
		logout.setBounds(858, 11, 31, 35);
		contentPane.add(logout);

	}
}
