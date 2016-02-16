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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee frame = new AddEmployee();
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
	public AddEmployee() {

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
					
					new GestionEmployees().setVisible(true);
				
					

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
				new GestionEmployees().setVisible(true);

			}
		});
		cancel.setBounds(517, 423, 116, 41);
		contentPane.add(cancel);

		JLabel home = new JLabel("New label");
		home.setBounds(286, 39, 86, 41);
		contentPane.add(home);

		JLabel establishment = new JLabel("New label");
		establishment.setBounds(371, 39, 86, 41);
		contentPane.add(establishment);

		JLabel category = new JLabel("New label");
		category.setBounds(456, 39, 78, 41);
		contentPane.add(category);

		JLabel employee = new JLabel("New label");
		employee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new GestionEmployees().setVisible(true);
				System.out.println("Clicked ! ! ! ");
			}
		});

		employee.setBounds(620, 39, -83, 41);
		contentPane.add(employee);

		JLabel statistics = new JLabel("New label");
		statistics.setBounds(620, 39, 78, 41);
		contentPane.add(statistics);

		JLabel claim = new JLabel("New label");
		claim.setBounds(708, 39, 76, 41);
		contentPane.add(claim);

		JLabel profil = new JLabel("New label");
		profil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EditProfilAdmin().setVisible(true);
			}
		});
		profil.setBounds(817, 0, 33, 41);
		contentPane.add(profil);

		JLabel logout = new JLabel("New label");
		logout.setBounds(860, 0, 28, 41);
		contentPane.add(logout);

		login = new JTextField();
		login.setBounds(232, 259, 155, 25);
		contentPane.add(login);
		login.setColumns(10);

		pwd = new JPasswordField();
		pwd.setBounds(566, 259, 155, 22);
		contentPane.add(pwd);

		role = new JTextField();
		role.setBounds(566, 346, 155, 20);
		contentPane.add(role);
		role.setColumns(10);

	}

}
