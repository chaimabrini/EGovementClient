package edu.esprit.gui.administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.esprit.delegater.GestionEmployeeDelegater;
import edu.esprit.delegater.GestionEtablishmentDelegater;
import edu.esprit.domain.Agent;
import edu.esprit.domain.Employee;
import edu.esprit.domain.Etablishment;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.enterprise.inject.Default;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.ObjectProperty;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Choice;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import javax.swing.JComboBox;

public class GestionEmployees extends JFrame {

	private JPanel contentPane;
	private JTextField login;
	private JTable table;
	private JPasswordField pwd;
	private JLabel delete;
	private JLabel add;

	public List<Employee> employees;
	public List<Etablishment> establishments;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionEmployees frame = new GestionEmployees();
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
	public GestionEmployees() {

		// init list
		employees = new ArrayList<Employee>();
		employees = GestionEmployeeDelegater.doFindAllEmployee();

		establishments = new ArrayList<Etablishment>();
		establishments = GestionEtablishmentDelegater.doFindAllEtablishment();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(117, 183, 678, 174);
		contentPane.add(scrollPane);
		scrollPane.setBackground(null);

		JComboBox estList = new JComboBox();
		estList.setBounds(258, 451, 154, 20);
		contentPane.add(estList);
		for (int i = 0; i < establishments.size(); i++) {
			estList.addItem(establishments.get(i).getName());
		}

		JLabel role = new JLabel("");
		role.setBounds(605, 451, 145, 20);
		contentPane.add(role);

		// Table
		table = new JTable();

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Agent agent = (Agent) employees.get(table.getSelectedRow());
				
				login.setText(agent.getLogin());
				pwd.setText(agent.getPassword());
				estList.setSelectedItem(agent.getEtablishment().getName());
				role.setText("Agent");
			}
		});
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\AnwerZa\\git\\EGovementClient\\src\\main\\java\\edu\\esprit\\gui\\images\\Employees.jpg"));
		lblNewLabel.setBounds(0, 0, 894, 600);
		contentPane.add(lblNewLabel);

		login = new JTextField();
		login.setBounds(258, 394, 154, 25);
		login.setBorder(null);
		contentPane.add(login);
		login.setColumns(10);

		pwd = new JPasswordField();
		pwd.setBounds(596, 394, 154, 22);
		pwd.setBorder(null);
		contentPane.add(pwd);

		// Update
		JLabel update = new JLabel("New label");
		update.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				Agent agent = (Agent) employees.get(table.getSelectedRow());

				agent.setLogin(login.getText());
				agent.setPassword(pwd.getText().toString());

				if (GestionEmployeeDelegater.doUpdateEmployee(agent)) {
					System.out.println("UPDATE REUSSITE");
					employees = GestionEmployeeDelegater.doFindAllEmployee();
					initDataBindings();
					JOptionPane.showMessageDialog(null, "Employee Updated");
				} else {
					System.out.println("FAILURE ");
				}

			}
		});
		update.setBounds(218, 515, 118, 47);
		contentPane.add(update);

		delete = new JLabel("New label");
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Agent agent = (Agent) employees.get(table.getSelectedRow());

				agent.setLogin(login.getText());
				agent.setPassword(pwd.getText().toString());

				if (GestionEmployeeDelegater.doDeleteEmployee(agent)) {
					System.out.println("Employee Deleted ! !");
					JOptionPane.showMessageDialog(null, "Employee Deleted");
					login.setText(null);
					pwd.setText(null);

					employees = GestionEmployeeDelegater.doFindAllEmployee();
					initDataBindings();

				} else {
					System.out.println("FAILURE");
				}

			}
		});
		delete.setBounds(407, 515, 125, 47);
		contentPane.add(delete);

		add = new JLabel("New label");
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new AddEmployee().setVisible(true);

			}
		});
		add.setBounds(607, 515, 125, 47);
		contentPane.add(add);

		JLabel Home = new JLabel("New label");
		Home.setBounds(287, 41, 81, 47);
		contentPane.add(Home);

		JLabel Establishment = new JLabel("New label");
		Establishment.setBounds(378, 41, 73, 47);
		contentPane.add(Establishment);

		JLabel Category = new JLabel("New label");
		Category.setBounds(454, 41, 78, 47);
		contentPane.add(Category);

		JLabel Employee = new JLabel("New label");
		Employee.setBounds(534, 40, 81, 48);
		contentPane.add(Employee);

		JLabel statistic = new JLabel("New label");
		statistic.setBounds(620, 41, 81, 47);
		contentPane.add(statistic);

		JLabel claim = new JLabel("New label");
		claim.setBounds(704, 41, 81, 47);
		contentPane.add(claim);
		initDataBindings();

	}

	protected void initDataBindings() {
		JTableBinding<Employee, List<Employee>, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, employees, table);
		//
		BeanProperty<Employee, String> employeeObjectProperty_1 = BeanProperty.create("idEmployee");
		jTableBinding.addColumnBinding(employeeObjectProperty_1).setColumnName("id");
		//
		BeanProperty<Employee, String> employeeObjectProperty_2 = BeanProperty.create("login");
		jTableBinding.addColumnBinding(employeeObjectProperty_2).setColumnName("Login");
		//
		BeanProperty<Employee, String> employeeObjectProperty_3 = BeanProperty.create("password");
		jTableBinding.addColumnBinding(employeeObjectProperty_3).setColumnName("Password");
		//
		
		jTableBinding.bind();
	}
}
