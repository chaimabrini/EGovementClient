package edu.esprit.gui.administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.delegater.GestionCategorieDelegater;
import edu.esprit.domain.Categorie;
import edu.esprit.domain.Employee;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddCategory extends JFrame {

	private JPanel contentPane;
	private JTextField nameCategory;
	private JTextArea descriptionCategory;
	private JLabel lblValidate;
	private JLabel lblCancel;
	private JLabel lblSignout;
	private JLabel lblProfile;
	private Categorie category;
    static Employee employee;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCategory frame = new AddCategory(employee);
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
	public AddCategory(Employee e) {
		employee=e;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nameCategory = new JTextField();
		nameCategory.setBounds(284, 236, 405, 37);
		nameCategory.setBorder(null);
		contentPane.add(nameCategory);
		nameCategory.setColumns(10);
		
		descriptionCategory = new JTextArea();
		descriptionCategory.setBounds(292, 315, 397, 170);
		contentPane.add(descriptionCategory);
		
		lblValidate = new JLabel("");
		lblValidate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				category = new Categorie();
				category.setName(nameCategory.getText());
				category.setDescription(descriptionCategory.getText());
				if (GestionCategorieDelegater.doAddCategorie(category)){
					JOptionPane.showMessageDialog(null, "Add Category : Success");
					nameCategory.setText("");
					descriptionCategory.setText("");
				}else{
					JOptionPane.showMessageDialog(null, "Add Category : Fail");
					nameCategory.setText("");
					descriptionCategory.setText("");
				}
			}
		});
		lblValidate.setBounds(316, 521, 91, 32);
		contentPane.add(lblValidate);
		
		lblCancel = new JLabel("");
		lblCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nameCategory.setText("");
				descriptionCategory.setText("");
			}
		});
		lblCancel.setBounds(566, 521, 91, 32);
		contentPane.add(lblCancel);
		
		lblSignout = new JLabel("");
		lblSignout.setBounds(856, 11, 35, 41);
		contentPane.add(lblSignout);
		
		lblProfile = new JLabel("");
		lblProfile.setBounds(812, 11, 41, 41);
		contentPane.add(lblProfile);
		
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
		
		JLabel lblBackgroundimage = new JLabel("");
		lblBackgroundimage.setIcon(new ImageIcon(AddCategory.class.getResource("/edu/esprit/image/AddCategory.jpg")));
		lblBackgroundimage.setBounds(0, 0, 893, 600);
		contentPane.add(lblBackgroundimage);
	}

}
