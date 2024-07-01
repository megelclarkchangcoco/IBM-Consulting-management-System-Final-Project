package sratch2;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class notifications extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel notificationTab;
	private boolean isNotificationTabVisible = false;  // Track visibility state

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					notifications frame = new notifications();
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
	public notifications() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 962, 602);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 946, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel notificationButton = new JPanel();
		notificationButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
     			tottgleNoticationPanel();
				
			}
		});
		notificationButton.setBounds(767, 11, 40, 34);
		panel.add(notificationButton);
		notificationButton.setLayout(null);
		
		notificationTab = new JPanel();
		notificationTab.setBackground(new Color(128, 0, 255));
		notificationTab.setOpaque(false);  // Initially transparent
		notificationTab.setLayout(null);
	}
	
	private void tottgleNoticationPanel() {
		if(notificationTab.isShowing()) {
			contentPane.remove(notificationTab);
		}else {
		notificationTab.setBounds(736, 59, 200, 298);
		contentPane.add(notificationTab);
		fetchAndDisplayNotifications();

		}
		 contentPane.revalidate();
	     contentPane.repaint();
	}
	
	private void fetchAndDisplayNotifications() {
		try {
            String url = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false";
            Connection connection = DriverManager.getConnection(url);
            
            String query ="SELECT notification_id, new Schedule FROM notification ORDER BY notification_id DESC";
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            
//            notificationsContainer.removeAll();

            
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
