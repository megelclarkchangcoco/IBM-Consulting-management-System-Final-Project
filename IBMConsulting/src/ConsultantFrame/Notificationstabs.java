package ConsultantFrame;

import javax.swing.JPanel;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Notificationstabs extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel schedulePanel;
	private JLabel scheduleLabel;
	/**
	 * Create the panel.
	 */
	public Notificationstabs() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 395, 510);
		add(panel);
		panel.setLayout(null);
		
		 schedulePanel = new JPanel();
		schedulePanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		schedulePanel.setBackground(new Color(255, 255, 255));
		schedulePanel.setBounds(10, 11, 375, 97);
		panel.add(schedulePanel);
		schedulePanel.setLayout(null);
		
		JLabel iconlbl = new JLabel("");
		iconlbl.setIcon(new ImageIcon(Notificationstabs.class.getResource("/notifIcon/calendar-clock (1).png")));
		iconlbl.setBounds(36, 27, 32, 48);
		schedulePanel.add(iconlbl);
		
		 scheduleLabel = new JLabel("");
		scheduleLabel.setBounds(78, 35, 193, 40);
		schedulePanel.add(scheduleLabel);

}

public void fetchAndDisplayNotifications() {
    try {
        String url = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false";
        Connection connection = DriverManager.getConnection(url);

        String query = "SELECT * FROM Notification";
        PreparedStatement pstmt = connection.prepareStatement(query);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int notificationId = rs.getInt("notificitaion_id");
            String notificationContent = rs.getString("notification_content");

            // For demonstration, let's assume notification_id 1 is for schedule and 2 is for document
            if (notificationId == 1) {
                schedulePanel.setVisible(true);
                scheduleLabel.setText("New : " + notificationContent);
            } 
        }

        rs.close();
        pstmt.close();
        connection.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
