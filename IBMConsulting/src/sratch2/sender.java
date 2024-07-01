package sratch2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class sender extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sender frame = new sender();
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
	public sender() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 435, 481);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea toname = new JTextArea();
		toname.setBounds(52, 80, 333, 41);
		panel.add(toname);
		
		JTextArea message = new JTextArea();
		message.setBounds(52, 162, 333, 41);
		panel.add(message);
		
		JButton sendbtn = new JButton("New button");
		sendbtn.setBounds(155, 281, 89, 23);
		panel.add(sendbtn);
	}
}
