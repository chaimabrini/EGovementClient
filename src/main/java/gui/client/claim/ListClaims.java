package gui.client.claim;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import edu.esprit.delegater.GestionClaimDelegater;
import edu.esprit.domain.Claim;

import javax.swing.JTable;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.hibernate.metamodel.source.annotations.xml.mocker.MockHelper;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.ObjectProperty;

public class ListClaims extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<Claim> claims;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListClaims frame = new ListClaims();
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
	public ListClaims() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		TableModel model;
       
		claims =new ArrayList<Claim>();
		claims=GestionClaimDelegater.doFindAllClaim(); 
		for(int i=0;i<claims.size();i++){
			
		}
		table = new JTable();

		table.setBounds(0, 11, 434, 250);
		
		contentPane.add(table);
		initDataBindings();
	}

	protected void initDataBindings() {
		JTableBinding<Claim, List<Claim>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, claims, table);
		//
		BeanProperty<Claim, String> claimBeanProperty = BeanProperty.create("citizen.firstName");
		jTableBinding.addColumnBinding(claimBeanProperty).setColumnName("Citizen");
		//
		BeanProperty<Claim, String> claimBeanProperty_1 = BeanProperty.create("employee.login");
		jTableBinding.addColumnBinding(claimBeanProperty_1).setColumnName("Employee");
		//
		BeanProperty<Claim, String> claimBeanProperty_2 = BeanProperty.create("mail");
		jTableBinding.addColumnBinding(claimBeanProperty_2).setColumnName("Mail");
		//
		BeanProperty<Claim, String> claimBeanProperty_3 = BeanProperty.create("state");
		jTableBinding.addColumnBinding(claimBeanProperty_3).setColumnName("State");
		//
		BeanProperty<Claim, String> claimBeanProperty_4 = BeanProperty.create("subject");
		jTableBinding.addColumnBinding(claimBeanProperty_4).setColumnName("Subject");
		//
		BeanProperty<Claim, String> claimBeanProperty_5 = BeanProperty.create("textClaim");
		jTableBinding.addColumnBinding(claimBeanProperty_5).setColumnName("Description");
		//
		ObjectProperty<Claim> claimObjectProperty = ObjectProperty.create();
		jTableBinding.addColumnBinding(claimObjectProperty).setColumnName("New Column");
		//
		jTableBinding.bind();
	}
}
