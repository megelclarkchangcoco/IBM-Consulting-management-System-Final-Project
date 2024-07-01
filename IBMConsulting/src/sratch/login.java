package sratch;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	static String[] roles = {"Client", "Consultant", "Admin"};
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<>(roles);
		comboBox.setBounds(94, 94, 279, 49);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String selectedRole = (String) comboBox.getSelectedItem();
				
				switch (selectedRole) {
					case "Client":
						client a = new client();
						a.setVisible(true);
						dispose();
						break;
					case "Consultant":
						consultant c = new consultant();
						c.setVisible(true);
						dispose();
						break;
					case "Admin":
						admin ad = new admin();
						ad.setVisible(true);
						dispose();
						break;
					default:
						// Handle unexpected case if necessary
						break;
				}
			}
		});
		btnNewButton.setBounds(168, 352, 89, 23);
		contentPane.add(btnNewButton);
	}
}
