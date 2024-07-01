package ConsultantFrame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import scratchUsername.FBComposeFrames;

import javax.swing.JTextField;
import javax.swing.JButton;

public class AaExampleLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AaExampleLogin frame = new AaExampleLogin();
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
	public AaExampleLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(66, 132, 319, 51);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JButton submitbtn = new JButton("Submit");
		submitbtn.setBounds(184, 259, 89, 23);
		submitbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = usernameField.getText();
                AConsultantFrame ac = new AConsultantFrame(email); // get text and inherit to another class
                ac.setVisible(true);
                dispose(); // Close the login frame
            }
        });
		contentPane.add(submitbtn);
	}

}
