package gui.client.claim;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class GestionClaim extends JPanel {

	/**
	 * Create the panel.
	 */
	public GestionClaim() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\FBI\\workspace\\E-Govement-Client\\src\\main\\java\\edu\\esprit\\image\\AgentInterface2.jpg"));
		lblNewLabel.setBounds(0, -15, 1035, 653);
		add(lblNewLabel);
		

	}

}
