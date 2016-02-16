package edu.esprit.gui.administrator;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.esprit.delegater.GestionCategorieDelegater;
import edu.esprit.domain.Categorie;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ManageCategories extends JFrame {

	private JPanel contentPane;
	private JLabel lblSignout;
	private JLabel lblProfile;
	private JLabel lblHome;
	private JLabel lblEstablishment;
	private JLabel lblCategory;
	private JLabel lblEmloyee;
	private JLabel lblStatistic;
	private JLabel lblClaim;
	private JLabel lblAddCategory;
	private JTable table;
	public List<Categorie> categories;
	private JTextField nameCategory;
	private JTextArea descriptionCategory;
	private Categorie category;
	private JLabel lblUpdate;
	private JLabel lblDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageCategories frame = new ManageCategories();
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
	public ManageCategories() {
		categories=GestionCategorieDelegater.doFindAllCategorie();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(119, 187, 668, 157);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				category=categories.get(table.getSelectedRow());
				nameCategory.setText(category.getName());
				descriptionCategory.setText(category.getDescription());
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblBackgroundimage = new JLabel("");
		lblBackgroundimage.setIcon(new ImageIcon(ManageCategories.class.getResource("/edu/esprit/image/Categories.jpg")));
		lblBackgroundimage.setBounds(0, 0, 893, 600);
		contentPane.add(lblBackgroundimage);
		
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
				new ManageCategories().setVisible(true);;
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
		
		lblAddCategory = new JLabel("");
		lblAddCategory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AddCategory().setVisible(true);;
				setVisible(false);
			}
		});
		lblAddCategory.setBounds(584, 520, 103, 36);
		contentPane.add(lblAddCategory);
		
		nameCategory = new JTextField();
		nameCategory.setBounds(199, 393, 156, 26);
		nameCategory.setBorder(null);
		contentPane.add(nameCategory);
		nameCategory.setColumns(10);
		
		descriptionCategory = new JTextArea();
		descriptionCategory.setBounds(493, 394, 300, 105);
		contentPane.add(descriptionCategory);
		
		lblUpdate = new JLabel("");
		lblUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				category.setName(nameCategory.getText());
				category.setDescription(descriptionCategory.getText());
				if (GestionCategorieDelegater.doUpdateCategorie(category)){
					categories=GestionCategorieDelegater.doFindAllCategorie();
					initDataBindings();
					JOptionPane.showMessageDialog(null, "Update Category : Success");
					nameCategory.setText("");
					descriptionCategory.setText("");
				}else{
					JOptionPane.showMessageDialog(null, "Update Category : Fail");
					nameCategory.setText("");
					descriptionCategory.setText("");
				}
			}
		});
		lblUpdate.setBounds(191, 521, 103, 35);
		contentPane.add(lblUpdate);
		
		lblDelete = new JLabel("");
		lblDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				category.setName(nameCategory.getName());
				category.setDescription(descriptionCategory.getText());
				if (GestionCategorieDelegater.doDeleteCategorie(category)){
					categories=GestionCategorieDelegater.doFindAllCategorie();
					initDataBindings();
					JOptionPane.showMessageDialog(null, "Delete Category : Success");
					nameCategory.setText("");
					descriptionCategory.setText("");
				}else{
					JOptionPane.showMessageDialog(null, "Delete Category : Fail");
					nameCategory.setText("");
					descriptionCategory.setText("");
				}
			}
		});
		lblDelete.setBounds(382, 520, 103, 36);
		contentPane.add(lblDelete);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Categorie, List<Categorie>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, categories, table);
		//
		BeanProperty<Categorie, String> categorieBeanProperty = BeanProperty.create("name");
		jTableBinding.addColumnBinding(categorieBeanProperty).setColumnName("Name");
		//
		BeanProperty<Categorie, String> categorieBeanProperty_1 = BeanProperty.create("description");
		jTableBinding.addColumnBinding(categorieBeanProperty_1).setColumnName("Description");
		//
		jTableBinding.bind();
	}
}
