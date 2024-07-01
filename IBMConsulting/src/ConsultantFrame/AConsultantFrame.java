package ConsultantFrame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import LoginFrame.loginSignUpFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;

public class AConsultantFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane, notifPanel;
    private JLabel notificationlbl;
    private ImageIcon profileicon = new ImageIcon(
            new ImageIcon("C:\\Users\\megel\\Documents\\3rd Term\\IBM icons\\IMG_5142 (1).PNG")
                .getImage().getScaledInstance(107, 102, Image.SCALE_DEFAULT));
	private JPanel selectedPanel; 
    static final String dbURL = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";

    
    // Panel Class 
    public static BConsultingDashboardPanel dashboardpanel;
    public static CSChedulePanel schedulepanel;
    public static DClientsPanel clientpanel;
    public static EclientservicesPanel servicespanel;
    public static FDocumentationPanel documentationpanel;
    
    static String email;
    static String senderEmail;
    static int lastProcessedId = 0;

    
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AConsultantFrame frame = new AConsultantFrame(email);
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
    public AConsultantFrame(String email) {
    	this.senderEmail = email;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1886, 980);
        setLocationRelativeTo(null);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // create an instance panel class
        dashboardpanel = new BConsultingDashboardPanel(email);
        schedulepanel = new CSChedulePanel(email);
        clientpanel = new DClientsPanel(email);
        servicespanel = new EclientservicesPanel(email);
        documentationpanel = new FDocumentationPanel(email);
       
        
        
        
    	// set the bounds of the pane
        dashboardpanel.setBounds(304, 77, 1573, 907);
        schedulepanel.setBounds(304, 77, 1573, 907);
        clientpanel.setBounds(304, 77, 1573, 907);
        servicespanel.setBounds(304, 77, 1573, 907);
        documentationpanel.setBounds(304, 77, 1573, 907);
        
    	//add the all panel instance to the content pane of the admin frame
        contentPane.add(dashboardpanel);
        contentPane.add(schedulepanel);
        contentPane.add(clientpanel);
        contentPane.add(servicespanel);
        contentPane.add(documentationpanel);
        
 
    	// Call revalidate() and repaint to update the frame
    	contentPane.revalidate();
    	contentPane.repaint();
        

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(0, 0, 1920, 980);
        contentPane.add(panel);
        panel.setLayout(null);

        JPanel leftPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                int height = getHeight();
                int width = getWidth();

                // calculate height for blue and white sections
                int blueHeight = height * 20 / 100;
                int whiteHeight = height - blueHeight;

                g.setColor(new Color(0, 0, 255));
                g.fillRect(0, 0, width, blueHeight);

                // draw the bottom section white
                g.setColor(new Color(255, 255, 255));
                g.fillRect(0, blueHeight, width, whiteHeight);
            }
        };
        leftPanel.setBounds(0, 0, 305, 941);
        leftPanel.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(192, 192, 192)));
        panel.add(leftPanel);
        leftPanel.setLayout(null);
        
        JPanel iconPanel = new JPanel();
        iconPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(192, 192, 192)));
        iconPanel.setBackground(new Color(255, 255, 255));
        iconPanel.setBounds(87, 105, 124, 120);
        leftPanel.add(iconPanel);
        iconPanel.setLayout(null);
        
        JLabel iconlbl = new JLabel("");
        iconlbl.setIcon(new ImageIcon(AConsultantFrame.class.getResource("/MykieImga/image 10.png")));
        iconlbl.setBounds(10, 11, 107, 102);
        iconPanel.add(iconlbl);
        
        JLabel ibmlogo = new JLabel("");
        ibmlogo.setIcon(new ImageIcon("C:\\Users\\megel\\eclipse-workspace\\IBMconsulting\\image\\mainframeImg\\ibmlogo.png"));
        ibmlogo.setBounds(83, 35, 128, 59);
        leftPanel.add(ibmlogo);
        // name 
        JLabel profilenamelbl = new JLabel("");
        profilenamelbl.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 24));
        profilenamelbl.setBounds(65, 236, 179, 31);
        leftPanel.add(profilenamelbl);
        setFullName(profilenamelbl);
        
        JLabel joblbl = new JLabel("Consultant");
        joblbl.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 14));
        joblbl.setBounds(107, 266, 97, 20);
        leftPanel.add(joblbl);
        
        JPanel menuPanel = new JPanel();
        menuPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(125, 125, 125)));
        menuPanel.setBackground(new Color(255, 255, 255));
        menuPanel.setBounds(0, 297, 305, 644);
        leftPanel.add(menuPanel);
        menuPanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Menu");
        lblNewLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 16));
        lblNewLabel.setBounds(10, 8, 85, 21);
        menuPanel.add(lblNewLabel);
        
        JPanel dashboardbtnPanel = new JPanel();
        dashboardbtnPanel.addMouseListener(new PanelButtonMouseAdapter(dashboardbtnPanel) {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		menuClicked(dashboardbtnPanel);
        		dashboardpanel.setVisible(true);
        		schedulepanel.setVisible(false);
        		clientpanel.setVisible(false);
        		servicespanel.setVisible(false);
        		documentationpanel.setVisible(false);
        		
        		
        		
        	}
        });
        dashboardbtnPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(125, 125, 125)));
        dashboardbtnPanel.setBackground(new Color(255, 255, 255));
        dashboardbtnPanel.setBounds(0, 40, 305, 51);
        menuPanel.add(dashboardbtnPanel);
        dashboardbtnPanel.setLayout(null);
        
        JLabel dashboardlbl = new JLabel(" Dashboard");
        dashboardlbl.setIcon(new ImageIcon(AConsultantFrame.class.getResource("/AconsultantframeImg/dashboardIcon.png")));
        dashboardlbl.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        dashboardlbl.setBounds(24, 19, 165, 21);
        dashboardbtnPanel.add(dashboardlbl);
        
        JPanel schedulebtnPanel = new JPanel();
        schedulebtnPanel.addMouseListener(new PanelButtonMouseAdapter(schedulebtnPanel) {	
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		menuClicked(schedulebtnPanel);
        		dashboardpanel.setVisible(false);
        		schedulepanel.setVisible(true);
        		clientpanel.setVisible(false);
        		servicespanel.setVisible(false);
        		documentationpanel.setVisible(false);
        	}
        });
        schedulebtnPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(125, 125, 125)));
        schedulebtnPanel.setBackground(Color.WHITE);
        schedulebtnPanel.setBounds(0, 102, 305, 51);
        menuPanel.add(schedulebtnPanel);
        schedulebtnPanel.setLayout(null);
        
        JLabel lblSchedule = new JLabel(" Schedule");
        lblSchedule.setIcon(new ImageIcon(AConsultantFrame.class.getResource("/AconsultantframeImg/scheduleIcon.png")));
        lblSchedule.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        lblSchedule.setBounds(21, 11, 165, 21);
        schedulebtnPanel.add(lblSchedule);
        
        JPanel clientbtnPanel = new JPanel();
        clientbtnPanel.addMouseListener(new PanelButtonMouseAdapter(clientbtnPanel) {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		menuClicked(clientbtnPanel);
        		dashboardpanel.setVisible(false);
            	schedulepanel.setVisible(false);
        		clientpanel.setVisible(true);
            	servicespanel.setVisible(false);
            	documentationpanel.setVisible(false);
        	}
        });
        clientbtnPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
        clientbtnPanel.setBackground(Color.WHITE);
        clientbtnPanel.setBounds(0, 164, 305, 51);
        menuPanel.add(clientbtnPanel);
        clientbtnPanel.setLayout(null);
        
        JLabel lblClients = new JLabel(" Clients");
        lblClients.setIcon(new ImageIcon(AConsultantFrame.class.getResource("/AconsultantframeImg/peopleIcon.png")));
        lblClients.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        lblClients.setBounds(20, 11, 165, 21);
        clientbtnPanel.add(lblClients);
        
        JPanel servicesbtnPanel = new JPanel();
        servicesbtnPanel.addMouseListener(new PanelButtonMouseAdapter(servicesbtnPanel) {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		menuClicked(servicesbtnPanel);
        		dashboardpanel.setVisible(false);
        		schedulepanel.setVisible(false);
        		clientpanel.setVisible(false);
            	servicespanel.setVisible(true);
            	documentationpanel.setVisible(false);
        		
        	}
        });
        servicesbtnPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(125, 125, 125)));
        servicesbtnPanel.setBackground(Color.WHITE);
        servicesbtnPanel.setBounds(0, 226, 305, 51);
        menuPanel.add(servicesbtnPanel);
        servicesbtnPanel.setLayout(null);
        
        JLabel lblServices = new JLabel(" Services");
        lblServices.setIcon(new ImageIcon(AConsultantFrame.class.getResource("/AconsultantframeImg/servicesIcon.png")));
        lblServices.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        lblServices.setBounds(20, 11, 165, 21);
        servicesbtnPanel.add(lblServices);
        
        JPanel documentationbtnPanel = new JPanel();
        documentationbtnPanel.addMouseListener(new PanelButtonMouseAdapter(documentationbtnPanel) {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		menuClicked(documentationbtnPanel);
        		dashboardpanel.setVisible(false);
        		schedulepanel.setVisible(false);
        		clientpanel.setVisible(false);
            	servicespanel.setVisible(false);
        		documentationpanel.setVisible(true);
        	}
        });
        documentationbtnPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(125, 125, 125)));
        documentationbtnPanel.setBackground(Color.WHITE);
        documentationbtnPanel.setBounds(0, 288, 305, 51);
        menuPanel.add(documentationbtnPanel);
        documentationbtnPanel.setLayout(null);
        
        JLabel lblDocumentation = new JLabel(" Documentation");
        lblDocumentation.setIcon(new ImageIcon(AConsultantFrame.class.getResource("/AconsultantframeImg/documentationICon.png")));
        lblDocumentation.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        lblDocumentation.setBounds(20, 11, 165, 21);
        documentationbtnPanel.add(lblDocumentation);
        
        JPanel LogoutPanel = new JPanel();
        LogoutPanel.addMouseListener(new PanelButtonMouseAdapter(LogoutPanel) {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int n = JOptionPane.showConfirmDialog(null, "do you want Sign out?", "Signout", JOptionPane.YES_NO_OPTION);
        		if(n == JOptionPane.YES_OPTION) {
        			loginSignUpFrame loginSign = new loginSignUpFrame();
        			loginSign.setVisible(true);   
        			dispose();
        		}
        		
        	
        	}
        });
        LogoutPanel.setLayout(null);
        LogoutPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(125, 125, 125)));
        LogoutPanel.setBackground(Color.WHITE);
        LogoutPanel.setBounds(0, 558, 305, 51);
        menuPanel.add(LogoutPanel);
        
        JLabel lblLogout = new JLabel("Logout");
        lblLogout.setIcon(new ImageIcon(AConsultantFrame.class.getResource("/AconsultantframeImg/logout.png")));
        lblLogout.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        lblLogout.setBounds(20, 11, 165, 21);
        LogoutPanel.add(lblLogout);
        
        JPanel headPanel = new JPanel();
        headPanel.setBounds(304, 0, 1567, 78);
        headPanel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(192, 192, 192)));
        headPanel.setBackground(new Color(255, 255, 255));
        panel.add(headPanel);
        headPanel.setLayout(null);
        
        JLabel naming = new JLabel("IBM Consulting");
        naming.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 24));
        naming.setBounds(10, 23, 198, 31);
        headPanel.add(naming);
        
        JPanel calendarPanel = new JPanel();
        calendarPanel.addMouseListener(new PanelButtonMouseAdapter(calendarPanel) {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		menuClicked(schedulebtnPanel);
        		dashboardpanel.setVisible(false);
        		schedulepanel.setVisible(true);
        		clientpanel.setVisible(false);
        		servicespanel.setVisible(false);
        		documentationpanel.setVisible(false);
        	}
        });
        calendarPanel.setBackground(Color.WHITE);
        calendarPanel.setBounds(1466, 23, 49, 44);
        headPanel.add(calendarPanel);
        calendarPanel.setLayout(null);
        
        JLabel calendardlbl = new JLabel("");
        calendardlbl.setBounds(5, 11, 36, 30);
        calendarPanel.add(calendardlbl);
        calendardlbl.setIcon(new ImageIcon(AConsultantFrame.class.getResource("/AconsultantframeImg/calendardicon.png")));
        
        notifPanel = new JPanel();
        notifPanel.setLayout(null);
        notifPanel.setBackground(Color.WHITE);
        notifPanel.setBounds(1407, 23, 49, 44);
        
        JLabel calendardlbl_1 = new JLabel("");
        calendardlbl_1.setBounds(5, 11, 36, 30);
        notifPanel.add(calendardlbl_1);
        
         notificationlbl = new JLabel("");
        notificationlbl.setBounds(9, 11, 26, 30);
        notifPanel.add(notificationlbl);
        notificationlbl.setIcon(new ImageIcon(AConsultantFrame.class.getResource("/AconsultantframeImg/notifIcon.png")));
        
//        JPanel bodyPanel = new JPanel();
//        bodyPanel.setBackground(new Color(255, 255, 255));
//        bodyPanel.setBounds(304, 77, 1596, 864);
//        panel.add(bodyPanel);
//        bodyPanel.setLayout(null);
    }
    
    private String[] setFullName(JLabel fullnamelbl) {
        String[] consultantName = new String[2];
        System.out.println("Searching for Username:" + senderEmail);
        try (Connection conn = DriverManager.getConnection(dbURL)) {
            PreparedStatement pstmt = conn.prepareStatement("SELECT consultant_fname, consultant_lname FROM Consultant WHERE consultant_email = ?");
            pstmt.setString(1, senderEmail);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String firstName = rs.getString("consultant_fname");
                    String lastName = rs.getString("consultant_lname");
                    String fullName = firstName + " " + lastName;
                    fullnamelbl.setText(fullName);
                    System.out.println(senderEmail);
                    
                    consultantName[0] = firstName;
                    consultantName[1] = lastName;
                } else {
                    fullnamelbl.setText("User not found");
                    System.out.println("No user found for username" + senderEmail);
                }
            } 
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Error Code:" + e.getErrorCode());
            fullnamelbl.setText("Error fetching name");
        }
        return consultantName;
    }

    
    private void menuClicked(JPanel selectedPanel) {
    	dashboardpanel.setVisible(false);
    	schedulepanel.setVisible(false);
		clientpanel.setVisible(false);
    	servicespanel.setVisible(false);
    	documentationpanel.setVisible(false);

    	selectedPanel.setVisible(true);
    	
 		this.selectedPanel = selectedPanel;
    	
    }
    
    private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(192, 192, 192));
		}
		
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(255, 255, 255));
		}
		
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(192, 192, 192));
		}
		
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(192, 192, 192));
		}
	}
}
