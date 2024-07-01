package ConsultantFrame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class CCreateScheduleFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel buttonPanel;
    private JTextField clientfirstnamefield;
    private JTextField clientlastnamefield;
    private JTextField consultantfirstnamefield;
    private JTextField consultantlastnamefield;
    private JDateChooser dateChooser;
    private JSpinner timeSpinner;
    private JTextField meetinglinkfield;
    private JLabel scheduletxtlbl;
    
    static final String dbURL = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CCreateScheduleFrame frame = new CCreateScheduleFrame();
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
    public CCreateScheduleFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(1187, 49, 815, 472);
        setUndecorated(true);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel wholePanel = new JPanel();
        wholePanel.setBounds(0, 0, 815, 472);
        contentPane.add(wholePanel);
        wholePanel.setLayout(null);

        JPanel headPanel = new JPanel();
        headPanel.setBorder(new MatteBorder(2, 2, 2, 0, (Color) new Color(190, 190, 190)));
        headPanel.setBackground(new Color(255, 255, 255));
        headPanel.setBounds(0, 0, 815, 33);
        wholePanel.add(headPanel);
        headPanel.setLayout(null);

        JPanel minimezePanel = new JPanel();
        minimezePanel.setBorder(new MatteBorder(2, 0, 0, 2, (Color) new Color(192, 192, 192)));
        minimezePanel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		dispose();
        	}
        });
        minimezePanel.setBackground(new Color(255, 255, 255));
        minimezePanel.setBounds(740, 0, 75, 30);
        headPanel.add(minimezePanel);
        minimezePanel.setLayout(null);

        JLabel minimizeiconlbl = new JLabel("");
        minimizeiconlbl.setIcon(new ImageIcon(CCreateScheduleFrame.class.getResource("/CschedulepanelImg/window-minimize (1).png")));
        minimizeiconlbl.setBounds(27, 3, 25, 22);
        minimezePanel.add(minimizeiconlbl);

        JPanel bodyPanel = new JPanel();
        bodyPanel.setForeground(new Color(192, 192, 192));
        bodyPanel.setBorder(new MatteBorder(2, 2, 2, 0, (Color) new Color(190, 190, 190)));
        bodyPanel.setBackground(new Color(255, 255, 255));
        bodyPanel.setBounds(0, 33, 815, 439);
        wholePanel.add(bodyPanel);
        bodyPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Schedule");
        lblNewLabel.setFont(new Font("IBM Plex Sans", Font.PLAIN, 26));
        lblNewLabel.setBounds(57, 30, 154, 47);
        bodyPanel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Client First Name");
        lblNewLabel_1.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        lblNewLabel_1.setBounds(57, 90, 175, 21);
        bodyPanel.add(lblNewLabel_1);

        clientfirstnamefield = new JTextField();
        clientfirstnamefield.setBounds(57, 110, 329, 40);
        bodyPanel.add(clientfirstnamefield);
        clientfirstnamefield.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Client Last Name");
        lblNewLabel_1_1.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        lblNewLabel_1_1.setBounds(438, 90, 175, 21);
        bodyPanel.add(lblNewLabel_1_1);

        clientlastnamefield = new JTextField();
        clientlastnamefield.setColumns(10);
        clientlastnamefield.setBounds(438, 110, 329, 40);
        bodyPanel.add(clientlastnamefield);

        JLabel lblNewLabel_1_2 = new JLabel("Consultant First Name");
        lblNewLabel_1_2.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        lblNewLabel_1_2.setBounds(57, 175, 175, 21);
        bodyPanel.add(lblNewLabel_1_2);

        consultantfirstnamefield = new JTextField();
        consultantfirstnamefield.setColumns(10);
        consultantfirstnamefield.setBounds(57, 195, 329, 40);
        bodyPanel.add(consultantfirstnamefield);

        JLabel lblNewLabel_1_3 = new JLabel("Consultant Last Name");
        lblNewLabel_1_3.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        lblNewLabel_1_3.setBounds(438, 175, 175, 21);
        bodyPanel.add(lblNewLabel_1_3);

        consultantlastnamefield = new JTextField();
        consultantlastnamefield.setColumns(10);
        consultantlastnamefield.setBounds(438, 195, 329, 40);
        bodyPanel.add(consultantlastnamefield);

        JLabel lblNewLabel_1_4 = new JLabel("Date and Time");
        lblNewLabel_1_4.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        lblNewLabel_1_4.setBounds(57, 263, 175, 21);
        bodyPanel.add(lblNewLabel_1_4);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(57, 283, 150, 40);
        bodyPanel.add(dateChooser);

        SpinnerDateModel timeModel = new SpinnerDateModel();
        timeSpinner = new JSpinner(timeModel);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(new Date()); // set to current time
        timeSpinner.setBounds(217, 283, 150, 40);
        bodyPanel.add(timeSpinner);

        JLabel lblNewLabel_1_5 = new JLabel("Meeting Link");
        lblNewLabel_1_5.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        lblNewLabel_1_5.setBounds(438, 263, 175, 21);
        bodyPanel.add(lblNewLabel_1_5);

        meetinglinkfield = new JTextField();
        meetinglinkfield.setColumns(10);
        meetinglinkfield.setBounds(438, 283, 329, 40);
        bodyPanel.add(meetinglinkfield);
        
         buttonPanel = new JPanel();
         buttonPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(192, 192, 192)));
         buttonPanel.addMouseListener(new PanelButtonMouseAdapter(buttonPanel) {
         	@Override
         	public void mouseClicked(MouseEvent e) {
         		handleSubmitButton();
         	}
         });
        buttonPanel.setBackground(new Color(15, 98, 254));
        buttonPanel.setBounds(558, 378, 210, 44);
        bodyPanel.add(buttonPanel);
        buttonPanel.setLayout(null);
        
         scheduletxtlbl = new JLabel("Schedule");
        scheduletxtlbl.setForeground(new Color(255, 255, 255));
        scheduletxtlbl.setBackground(new Color(255, 255, 255));
        scheduletxtlbl.setFont(new Font("IBM Plex Sans", Font.PLAIN, 18));
        scheduletxtlbl.setBounds(67, 11, 170, 24);
        buttonPanel.add(scheduletxtlbl);
    }
    private void handleSubmitButton() {
        String clientFName = clientfirstnamefield.getText();
        String clientLName = clientlastnamefield.getText();
        String consultantFName = consultantfirstnamefield.getText();
        String consultantLName = consultantlastnamefield.getText();
        Date selectedDate = dateChooser.getDate();
        Date selectedTime = (Date) timeSpinner.getValue();
        String meetingLink = meetinglinkfield.getText();

        // Validate fields
        if (clientFName.isEmpty() || clientLName.isEmpty() || consultantFName.isEmpty()
                || consultantLName.isEmpty() || meetingLink.isEmpty() || selectedDate == null) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Combine date and time into one Date object
        Calendar cal = Calendar.getInstance();
        cal.setTime(selectedDate);
        Calendar timeCal = Calendar.getInstance();
        timeCal.setTime(selectedTime);
        cal.set(Calendar.HOUR_OF_DAY, timeCal.get(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, timeCal.get(Calendar.MINUTE));
        cal.set(Calendar.SECOND, timeCal.get(Calendar.SECOND));
        Date scheduleDateTime = cal.getTime();

        // Format date for SQL
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(scheduleDateTime);

        try {
            // Establish connection
            Connection conn = DriverManager.getConnection(dbURL);
            
            // SQL query to insert data
            String sql = "INSERT INTO Schedule (client_fname, client_lname, consultant_fname, consultant_lname, schedule_meetlink, schedule_date_time) "
                       + "VALUES (?, ?, ?, ?, ?, ?)";
            
            // Create prepared statement
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, clientFName);
            pstmt.setString(2, clientLName);
            pstmt.setString(3, consultantFName);
            pstmt.setString(4, consultantLName);
            pstmt.setString(5, meetingLink);
            pstmt.setString(6, formattedDate);
            
            // Execute the query
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Schedule saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                // Clear fields after successful insert
                clientfirstnamefield.setText("");
                clientlastnamefield.setText("");
                consultantfirstnamefield.setText("");
                consultantlastnamefield.setText("");
                dateChooser.setDate(null);
                timeSpinner.setValue(new Date());
                meetinglinkfield.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save schedule.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            // Close connection and statement
            pstmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(255, 255, 255));
	        scheduletxtlbl.setForeground(new Color(0, 0, 0));

		}
		
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(15, 98, 254));
	        scheduletxtlbl.setForeground(new Color(255, 255, 255));

		}
		
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(255, 255, 255));
	        scheduletxtlbl.setForeground(new Color(0, 0, 0));

		}
		
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(15, 98, 254));
	        scheduletxtlbl.setForeground(new Color(0, 0, 0));

		}
	}
}
