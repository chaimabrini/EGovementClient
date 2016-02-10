package gui.client.claim;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SendClaim extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblAboutUs;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendClaim frame = new SendClaim();
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
	public SendClaim() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1035, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(339, 27, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblAboutUs = new JLabel("About us");
		lblAboutUs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SendingClaim sendClaim =new SendingClaim();
				sendClaim.show();
			}
		});
		lblAboutUs.setBounds(213, 67, 46, 14);
		contentPane.add(lblAboutUs);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("oke");
			}
		});
		lblNewLabel_1.setBounds(427, 30, 46, 14);
		contentPane.add(lblNewLabel_1);
		
	}

}
