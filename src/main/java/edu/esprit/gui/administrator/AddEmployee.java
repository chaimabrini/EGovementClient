package edu.esprit.gui.administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ScrollPaneUI;

import edu.esprit.delegater.GestionEmployeeDelegater;
import edu.esprit.delegater.GestionEtablishmentDelegater;
import edu.esprit.domain.Agent;
import edu.esprit.domain.Employee;
import edu.esprit.domain.Etablishment;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Choice;
import java.awt.Label;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JPasswordField;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

public class AddEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField login;
	private JPasswordField pwd;
	private JTextField role;
	private List<Etablishment> establishments;
    static Employee employee;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee frame = new AddEmployee(employee);
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
	public AddEmployee(Employee e) {
        employee=e;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox estList = new JComboBox();
		estList.setBounds(232, 346, 155, 20);
		estList.setBorder(null);
		contentPane.add(estList);

		establishments = new ArrayList<>();
		establishments = GestionEtablishmentDelegater.doFindAllEtablishment();

		for (int i = 0; i < establishments.size(); i++) {
			estList.addItem(establishments.get(i).getName());
		}

		JLabel homeMenu = new JLabel("");
		homeMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HomeAdmin homeA=new HomeAdmin(employee);
				setVisible(false);
				homeA.setVisible(true);
			}
		});
		homeMenu.setBounds(284, 42, 89, 37);
		contentPane.add(homeMenu);
		
		JLabel establishmentMenu = new JLabel("");
		establishmentMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		establishmentMenu.setBounds(377, 42, 72, 37);
		contentPane.add(establishmentMenu);
		JLabel categoryMenu = new JLabel("");
		categoryMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			   ManageCategories manageCat=new ManageCategories(employee);
			   setVisible(false);
			   manageCat.setVisible(true);
			}
		});
		categoryMenu.setBounds(453, 42, 80, 38);
		contentPane.add(categoryMenu);
		
		JLabel employeeMenu = new JLabel("");
		employeeMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GestionEmployees gestionEmp =new GestionEmployees(employee);
				setVisible(false);
				gestionEmp.setVisible(true);
			}
		});
		employeeMenu.setBounds(540, 42, 72, 37);
		contentPane.add(employeeMenu);
		
		JLabel statisticMenu = new JLabel("");
		statisticMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StatisticAdmin statisticAdm=new StatisticAdmin(employee);
				setVisible(false);
				statisticAdm.setVisible(true);
			}
		});
		statisticMenu.setBounds(622, 42, 72, 37);
		contentPane.add(statisticMenu);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(AddEmployee.class.getResource("/edu/esprit/image/AddEmployee.jpg")));
		lblNewLabel.setBounds(0, 0, 894, 591);
		contentPane.add(lblNewLabel);

		JLabel add = new JLabel("New label");
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				Agent agent = new Agent();
				agent.setLogin(login.getText());
				agent.setPassword(pwd.getText());
				agent.setEtablishment(
						GestionEtablishmentDelegater.doFindAllEtablishmentByName(estList.getSelectedItem().toString()));

				if (GestionEmployeeDelegater.doAddEmployee((Employee) agent)) {
					System.out.println("Emloyee Ajouté avec Succées");
					setVisible(false);
					new GestionEmployees(employee).setVisible(true);
				
					

				} else {
					System.out.println("Failure ! ! !");
				}

			}
		});
		add.setBounds(286, 423, 116, 41);
		contentPane.add(add);

		JLabel cancel = new JLabel("New label");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				new GestionEmployees(employee).setVisible(true);

			}
		});
		cancel.setBounds(517, 423, 116, 41);
		contentPane.add(cancel);

		JLabel profil = new JLabel("New label");
		profil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				new EditProfilAdmin(AddEmployee.employee).setVisible(true);
			}
		});
		profil.setBounds(817, 0, 33, 41);
		contentPane.add(profil);

		JLabel logout = new JLabel("New label");
		logout.setBounds(860, 0, 28, 41);
		contentPane.add(logout);

		login = new JTextField();
		login.setBounds(232, 259, 155, 25);
		login.setBorder(null);
		contentPane.add(login);
		login.setColumns(10);

		pwd = new JPasswordField();
		pwd.setBounds(566, 259, 155, 22);
		contentPane.add(pwd);

		role = new JTextField();
		role.setBorder(null);
		role.setBounds(566, 346, 155, 20);
		contentPane.add(role);
		role.setColumns(10);

	}

}
