package sratch2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class notificationSender extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea toMessage;
    private JTextArea toName;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    notificationSender frame = new notificationSender();
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
    public notificationSender() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 566, 566);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 550, 527);
        contentPane.add(panel);
        panel.setLayout(null);

        toMessage = new JTextArea();
        toMessage.setBounds(56, 260, 431, 67);
        panel.add(toMessage);

        toName = new JTextArea();
        toName.setBounds(56, 168, 431, 67);
        panel.add(toName);

        JButton sendbtn = new JButton("send");
        sendbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String toNames = toName.getText();
                String toMessages = toMessage.getText();

                saveData(toNames, toMessages);
            }
        });
        sendbtn.setBounds(219, 399, 89, 23);
        panel.add(sendbtn);
    }

    private void saveData(String toName, String toMessages) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            String url = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=practiceSQL;integratedSecurity=true;encrypt=false;";
            connection = DriverManager.getConnection(url);

            String query = "INSERT INTO notifications(notification_name) VALUES (?)";
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, toMessages);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Notification saved to database successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

