package ClientFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import com.mindfusion.scheduling.Calendar;
import com.mindfusion.scheduling.ThemeType;
import com.mindfusion.scheduling.model.Appointment;

import ConsultantFrame.CCreateScheduleFrame;

public class DCalendar extends JPanel {

	private static final long serialVersionUID = 1L;
    private boolean isClicked = false;

    private JLabel appointmentlbl, createlbl, viewlbl,counttotalappointmentlbl;
    private JPanel calendarPanel;
    static String senderEmail;
    static final String dbURL = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";
	/**
	 * Create the panel.
	 */
	public DCalendar(String email) {
		this.senderEmail = email;
    	
        setBackground(new Color(255, 255, 255));
        setBounds(304, 77, 1557, 907);
        setLayout(null);
        setVisible(false);

        JPanel bodyPanel = new JPanel();
        bodyPanel.setBorder(new MatteBorder(0, 2, 0, 0, new Color(192, 192, 192)));
        bodyPanel.setBackground(new Color(255, 255, 255));
        bodyPanel.setBounds(0, 0, 1573, 907);
        add(bodyPanel);
        bodyPanel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Schedules");
        lblNewLabel.setBounds(48, 11, 180, 47);
        lblNewLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 36));
        bodyPanel.add(lblNewLabel);

        calendarPanel = new JPanel();
        calendarPanel.setBounds(48, 128, 1129, 732);
        calendarPanel.setBackground(new Color(255, 255, 255));
        calendarPanel.setVisible(true);
        calendarPanel.setLayout(null);
        bodyPanel.add(calendarPanel);

        loadAppointments();

        JPanel appointmentPanel = new JPanel();
        appointmentPanel.setBounds(971, 49, 206, 68);
        appointmentPanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
        appointmentPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	DCreateScheduleFrame cf= new DCreateScheduleFrame();
               cf.setLocation(1079, 525);
               cf.setVisible(true);
            }

            public void mouseEntered(MouseEvent e) {
                appointmentPanel.setBackground(new Color(255, 255, 255));
                createlbl.setForeground(new Color(0, 0, 0));
                appointmentlbl.setForeground(new Color(0, 0, 0));
            }

            public void mouseExited(MouseEvent e) {
                appointmentPanel.setBackground(new Color(18, 98, 254));
                createlbl.setForeground(new Color(255, 255, 255));
                appointmentlbl.setForeground(new Color(255, 255, 255));
            }
        });
        appointmentPanel.setBackground(new Color(18, 98, 254));
        bodyPanel.add(appointmentPanel);
        appointmentPanel.setLayout(null);

        createlbl = new JLabel("Create a new");
        createlbl.setForeground(new Color(255, 255, 255));
        createlbl.setFont(new Font("IBM Plex Sans", Font.PLAIN, 18));
        createlbl.setBounds(10, 11, 130, 24);
        appointmentPanel.add(createlbl);

        appointmentlbl = new JLabel("Appointment");
        appointmentlbl.setForeground(new Color(255, 255, 255));
        appointmentlbl.setFont(new Font("IBM Plex Sans", Font.PLAIN, 18));
        appointmentlbl.setBounds(10, 33, 105, 24);
        appointmentPanel.add(appointmentlbl);

        JPanel viewappointmenetPanel = new JPanel();
        viewappointmenetPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isClicked = !isClicked;

                if (isClicked) {
                    calendarPanel.setVisible(true);
                    loadAppointments();
                } else {
                    calendarPanel.setVisible(false);
                }
            }

            public void mouseEntered(MouseEvent e) {
                viewappointmenetPanel.setBackground(new Color(255, 255, 255));
                viewlbl.setForeground(new Color(0, 0, 0));
            }

            public void mouseExited(MouseEvent e) {
                viewappointmenetPanel.setBackground(new Color(18, 98, 254));
                viewlbl.setForeground(new Color(255, 255, 255));
            }
        });
        viewappointmenetPanel.setLayout(null);
        viewappointmenetPanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
        viewappointmenetPanel.setBackground(new Color(18, 98, 254));
        viewappointmenetPanel.setBounds(743, 49, 206, 68);
        bodyPanel.add(viewappointmenetPanel);

        viewlbl = new JLabel("View Appointment");
        viewlbl.setForeground(new Color(255, 255, 255));
        viewlbl.setFont(new Font("Dialog", Font.PLAIN, 18));
        viewlbl.setBounds(10, 11, 174, 24);
        viewappointmenetPanel.add(viewlbl);
     
        
      JPanel rigthPanel = new JPanel();
      rigthPanel.setBackground(new Color(255, 255, 255));
      rigthPanel.setBounds(1187, 49, 365, 811);
      bodyPanel.add(rigthPanel);
      rigthPanel.setLayout(null);
      
      JPanel totalappointmentPanel = new JPanel();
      totalappointmentPanel.setLayout(null);
      totalappointmentPanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
      totalappointmentPanel.setBackground(Color.WHITE);
      totalappointmentPanel.setBounds(38, 0, 305, 99);
      rigthPanel.add(totalappointmentPanel);
      
      JLabel lblNewLabel_1 = new JLabel("Number of Scheduled Appointments");
      lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 16));
      lblNewLabel_1.setBounds(10, 11, 264, 21);
      totalappointmentPanel.add(lblNewLabel_1);
      
       counttotalappointmentlbl = new JLabel("");
      counttotalappointmentlbl.setForeground(new Color(18, 98, 254));
      counttotalappointmentlbl.setFont(new Font("Dialog", Font.PLAIN, 48));
      counttotalappointmentlbl.setBounds(10, 33, 58, 55);
      countAppointment();
      totalappointmentPanel.add(counttotalappointmentlbl);
      
      // Panels to display today's meetings
      
      JLabel lblNewLabel_3 = new JLabel("Today’s Meetings ");
      lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 20));
      lblNewLabel_3.setBounds(38, 109, 180, 33);
      rigthPanel.add(lblNewLabel_3);

      JPanel meeting1Panel = createMeetingPanel(144);
      JLabel time1lbl = new JLabel("");
      JLabel clientname1 = new JLabel("");
      JTextPane textPane1 = new JTextPane();
      setupMeetingPanel(meeting1Panel, time1lbl, clientname1, textPane1);
      rigthPanel.add(meeting1Panel);

      JPanel meetingPanel2 = createMeetingPanel(321);
      JLabel time2lbl = new JLabel("");
      JLabel clientname2 = new JLabel("");
      JTextPane textPane2 = new JTextPane();
      setupMeetingPanel(meetingPanel2, time2lbl, clientname2, textPane2);
      rigthPanel.add(meetingPanel2);

      JPanel meetingPanel3 = createMeetingPanel(498);
      JLabel time3lbl = new JLabel("");
      JLabel clientname3 = new JLabel("");
      JTextPane textPane3 = new JTextPane();
      setupMeetingPanel(meetingPanel3, time3lbl, clientname3, textPane3);
      rigthPanel.add(meetingPanel3);

      
      // display all method create here
      loadAppointments();
      countAppointment();
      displayTodayMeetings(time1lbl, clientname1, textPane1, time2lbl, clientname2, textPane2, time3lbl, clientname3, textPane3);
      


    }
    private String[] getConsultantName() {
        String[] names = new String[2];
        try (Connection connection = DriverManager.getConnection(dbURL);
             PreparedStatement pstmt = connection.prepareStatement("SELECT client_fname, client_Iname FROM Client WHERE Client_email = ?")) {
            pstmt.setString(1, senderEmail);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                names[0] = rs.getString("Client_fname");
                names[1] = rs.getString("client_Iname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return names;
    }
    // method for creating panel for schedule link lbl and time lbl
    private JPanel createMeetingPanel(int yPosition) {
        JPanel meetingPanel = new JPanel();
        meetingPanel.setLayout(null);
        meetingPanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
        meetingPanel.setBackground(Color.WHITE);
        meetingPanel.setBounds(38, yPosition, 305, 166);
        return meetingPanel;
    }
    // method for setup dispaly get from displayTodayMettings() method
    private void setupMeetingPanel(JPanel meetingPanel, JLabel timeLbl, JLabel clientNameLbl, JTextPane textPane) {
        JLabel lblTime = new JLabel("Time");
        lblTime.setForeground(Color.LIGHT_GRAY);
        lblTime.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblTime.setBounds(10, 0, 34, 30);
        meetingPanel.add(lblTime);

        timeLbl.setFont(new Font("Dialog", Font.PLAIN, 20));
        timeLbl.setBounds(10, 28, 101, 26);
        meetingPanel.add(timeLbl);

        JLabel lblPH = new JLabel("PH+");
        lblPH.setForeground(Color.LIGHT_GRAY);
        lblPH.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblPH.setBounds(90, 28, 34, 30);
        meetingPanel.add(lblPH);

        JLabel lblClient = new JLabel("Client");
        lblClient.setForeground(Color.LIGHT_GRAY);
        lblClient.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblClient.setBounds(10, 50, 64, 30);
        meetingPanel.add(lblClient);

        clientNameLbl.setFont(new Font("Dialog", Font.PLAIN, 20));
        clientNameLbl.setBounds(10, 73, 285, 26);
        meetingPanel.add(clientNameLbl);

        JLabel lblMeetingLink = new JLabel("Meeting link");
        lblMeetingLink.setForeground(Color.LIGHT_GRAY);
        lblMeetingLink.setFont(new Font("Dialog", Font.PLAIN, 15));
        lblMeetingLink.setBounds(10, 94, 155, 30);
        meetingPanel.add(lblMeetingLink);

        textPane.setBounds(10, 123, 285, 20);
        meetingPanel.add(textPane);
    }
    // display or load schedule date in calendar
    private void loadAppointments() {
        String[] consultantName = getConsultantName();
        String consultantFname = consultantName[0];
        String consultantLname = consultantName[1];

        try (Connection connection = DriverManager.getConnection(dbURL);
             PreparedStatement pstmt = connection.prepareStatement(
                 "SELECT consultant_fname, consultant_lname, schedule_date_time FROM Schedule " +
                 "WHERE client_fname = ? AND client_lname = ?")) {

            pstmt.setString(1, consultantFname);
            pstmt.setString(2, consultantLname);
            ResultSet resultSet = pstmt.executeQuery();

            // Initialize the MindFusion Calendar outside the loop
            Calendar calendar = new Calendar();
            calendar.setTheme(ThemeType.Light);
            calendar.setBounds(0, 0, 1129, 732);
            
            // Clear previous calendar items if any
            calendarPanel.removeAll();

            // Fetching and displaying appointments from the SQL table on the calendar
            SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

            while (resultSet.next()) {
                String clientFname = resultSet.getString("consultant_fname");
                String clientLname = resultSet.getString("consultant_lname");
                Date scheduleDateTime = dateTimeFormat.parse(resultSet.getString("schedule_date_time"));

                // Format the time part of the schedule
                String formattedTime = timeFormat.format(scheduleDateTime);

                Appointment appointment = new Appointment();
                appointment.setStartTime(new com.mindfusion.common.DateTime(scheduleDateTime));
                appointment.setEndTime(new com.mindfusion.common.DateTime(scheduleDateTime));
                appointment.setHeaderText(clientFname + " " + clientLname + " at " + formattedTime);

                calendar.getSchedule().getItems().add(appointment);
            }

            // Add the calendar to the panel
            calendarPanel.add(calendar);
            calendarPanel.revalidate();
            calendarPanel.repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // method show count of schedule appointmnet;
    private void countAppointment() {
        String[] consultantName = getConsultantName();
        String consultantFname = consultantName[0];
        String consultantLname = consultantName[1];

        String query = "SELECT COUNT(*) AS total FROM Schedule WHERE client_fname = ? AND client_lname = ?";
        
        try (Connection connection = DriverManager.getConnection(dbURL);
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            
            pstmt.setString(1, consultantFname);
            pstmt.setString(2, consultantLname);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                int totalAppointments = rs.getInt("total");
                counttotalappointmentlbl.setText("" + totalAppointments);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // method to get data from sql table schedule and display it in lbl and textpane
    private void displayTodayMeetings(JLabel time1lbl, JLabel clientname1, JTextPane textPane1, JLabel time2lbl, JLabel clientname2, JTextPane textPane2, JLabel time3lbl, JLabel clientname3, JTextPane textPane3) {
        String[] consultantName = getConsultantName();
        String consultantFname = consultantName[0];
        String consultantLname = consultantName[1];

        try {
            Connection connection = DriverManager.getConnection(dbURL);
            PreparedStatement pstmt = connection.prepareStatement(
                "SELECT CONVERT(VARCHAR(8), schedule_date_time, 108) AS time, consultant_fname, consultant_lname, schedule_meetlink " +
                "FROM Schedule WHERE CONVERT(DATE, schedule_date_time) = CONVERT(DATE, ?) " +
                "AND client_fname = ? AND client_lname = ?");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String todayDate = dateFormat.format(new Date());

            pstmt.setString(1, todayDate);
            pstmt.setString(2, consultantFname);
            pstmt.setString(3, consultantLname);

            ResultSet resultSet = pstmt.executeQuery();

            int meetingCount = 0;

            while (resultSet.next() && meetingCount < 3) {
                String time = resultSet.getString("time");
                String clientFName = resultSet.getString("consultant_fname");
                String clientLName = resultSet.getString("consultant_lname");
                String meetingLink = resultSet.getString("schedule_meetlink");

                switch (meetingCount) {
                    case 0:
                        time1lbl.setText(time);
                        clientname1.setText(clientFName + " " + clientLName);
                        textPane1.setText(meetingLink);
                        break;
                    case 1:
                        time2lbl.setText(time);
                        clientname2.setText(clientFName + " " + clientLName);
                        textPane2.setText(meetingLink);
                        break;
                    case 2:
                        time3lbl.setText(time);
                        clientname3.setText(clientFName + " " + clientLName);
                        textPane3.setText(meetingLink);
                        break;
                }

                meetingCount++;
            }

            if (meetingCount == 0) {
                time1lbl.setText("");
                clientname1.setText("");
                textPane1.setText("");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
	// display or load schedule date in calendar
//    private void loadAppointments() {
//        String[] clientName = getConsultantName();
//        String clienFname = consultantName[0];
//        String clientLname = consultantName[1];
//
//        try (Connection connection = DriverManager.getConnection(dbURL);
//             PreparedStatement pstmt = connection.prepareStatement(
//                 "SELECT client_fname, client_lname, schedule_date_time FROM Schedule " +
//                 "WHERE consultant_fname = ? AND consultant_lname = ?")) {
//
//            pstmt.setString(1, consultantFname);
//            pstmt.setString(2, consultantLname);
//            ResultSet resultSet = pstmt.executeQuery();
//
//            // Initialize the MindFusion Calendar outside the loop
//            Calendar calendar = new Calendar();
//            calendar.setTheme(ThemeType.Light);
//            calendar.setBounds(0, 0, 1129, 732);
//            
//            // Clear previous calendar items if any
//            calendarPanel.removeAll();
//
//            // Fetching and displaying appointments from the SQL table on the calendar
//            SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
//
//            while (resultSet.next()) {
//                String clientFname = resultSet.getString("client_fname");
//                String clientLname = resultSet.getString("client_lname");
//                Date scheduleDateTime = dateTimeFormat.parse(resultSet.getString("schedule_date_time"));
//
//                // Format the time part of the schedule
//                String formattedTime = timeFormat.format(scheduleDateTime);
//
//                Appointment appointment = new Appointment();
//                appointment.setStartTime(new com.mindfusion.common.DateTime(scheduleDateTime));
//                appointment.setEndTime(new com.mindfusion.common.DateTime(scheduleDateTime));
//                appointment.setHeaderText(clientFname + " " + clientLname + " at " + formattedTime);
//
//                calendar.getSchedule().getItems().add(appointment);
//            }
//
//            // Add the calendar to the panel
//            calendarPanel.add(calendar);
//            calendarPanel.revalidate();
//            calendarPanel.repaint();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

