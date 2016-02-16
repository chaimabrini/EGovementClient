package edu.esprit.gui.administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.delegater.GestionCategorieDelegater;
import edu.esprit.domain.Categorie;

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
	private JLabel lblHome;
	private JLabel lblEstablishment;
	private JLabel lblCategory;
	private JLabel lblEmloyee;
	private JLabel lblStatistic;
	private JLabel lblClaim;
	private Categorie category;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCategory frame = new AddCategory();
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
	public AddCategory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBackgroundimage = new JLabel("");
		lblBackgroundimage.setIcon(new ImageIcon(AddCategory.class.getResource("/edu/esprit/image/AddCategory.jpg")));
		lblBackgroundimage.setBounds(0, 0, 893, 600);
		contentPane.add(lblBackgroundimage);
		
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
		
		lblHome = new JLabel("");
		lblHome.setBounds(285, 37, 84, 47);
		contentPane.add(lblHome);
		
		lblEstablishment = new JLabel("");
		lblEstablishment.setBounds(376, 37, 76, 47);
		contentPane.add(lblEstablishment);
		
		lblCategory = new JLabel("");
		lblCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new ManageCategories().setVisible(true);
				setVisible(false);
			}
		});
		lblCategory.setBounds(454, 37, 76, 47);
		contentPane.add(lblCategory);
		
		lblEmloyee = new JLabel("");
		lblEmloyee.setBounds(537, 37, 76, 47);
		contentPane.add(lblEmloyee);
		
		lblStatistic = new JLabel("");
		lblStatistic.setBounds(623, 37, 76, 47);
		contentPane.add(lblStatistic);
		
		lblClaim = new JLabel("");
		lblClaim.setBounds(703, 37, 84, 47);
		contentPane.add(lblClaim);
	}

}
