package ClientFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import LoginFrame.loginSignUpFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AMainFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane, left, toDashboard, toInquiry, toCalendar, toServices, toDocumentation, selectedPanel, headerPanel, bluePanel, profilePanel;
    private JPanel calendarPanel, panel_2, panel_3;
    private JLabel ibmlogo, ibmTitleLabel, clnameLabel, DPLabel, dashLabel, menuLabel, lblClient, inquLabel, caleLabel, servLabel, docuLabel;
    private JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4, lblNewLabel_5, lblNewLabel_6, lblNewLabel_7;
    private JButton signoutBtn;
    
    public static BDashboard dsh;
    public static CInquiry inq;
    public static DCalendar cal;
    public static EServices ser;
    public static FDocumentation doc;
    
    static final String dbURL = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";
    static String email;
    static String senderEmail;

    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AMainFrame frame = new AMainFrame(email);
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
    public AMainFrame(String email) {
    	this.senderEmail = email;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1880, 980);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane); 
        
        profilePanel = new JPanel();
        profilePanel.setBounds(91, 99, 124, 120);
        profilePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, new Color(204,204,204)));
        profilePanel.setLayout(null);
        contentPane.add(profilePanel);
        
        DPLabel = new JLabel();
        DPLabel.setIcon(new ImageIcon(AMainFrame.class.getResource("/MykieImga/image 9.png")));
//        DPLabel.setIcon(new ImageIcon(AMainFrame.class.getResource("image 9.png")));
        DPLabel.setSize(104, 98);
        DPLabel.setLocation(10, 10);
        profilePanel.add(DPLabel);
        
        //create an instance panel class
        dsh = new BDashboard(email);
        dsh.setBounds(305, 78, 1570, 877);
        dsh.setVisible(true); // the starting panel so should be visible
        contentPane.add(dsh); // add Dashboard to contentPane
        
        inq = new CInquiry(email);
        inq.setBounds(305, 78, 1570, 877);
        inq.setVisible(false); 
        contentPane.add(inq);
        
        cal = new DCalendar(email);
        cal.setBounds(305, 78, 1570, 877);
        cal.setVisible(false); 
        contentPane.add(cal);
        
        ser = new EServices(email);
        ser.setBounds(305, 78, 1570, 877);
        ser.setVisible(false); 
        contentPane.add(ser);
        
        doc = new FDocumentation(email);
        doc.setBounds(305, 78, 1570, 877);
        doc.setVisible(false); 
        contentPane.add(doc);
        
        //call revalidate() and repaint() to update the frame
        contentPane.revalidate();
        contentPane.repaint();
        
//===================================================================   
        
        left = new JPanel();
        left.setBackground(new Color(255, 255, 255));
        left.setBounds(0, 182, 305, 767);
        left.setLayout(null);
        left.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, new Color(224, 224, 224)));
        contentPane.add(left);      
        
        toDashboard = new JPanel();
        toDashboard.setBackground(new Color(255,255,255));
        toDashboard.setLayout(null);
        toDashboard.setBounds(0, 190, 303, 51);
        left.add(toDashboard);
        
        toDashboard.addMouseListener(new PanelButtonMouseAdapter(toDashboard) {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuclicked(toDashboard);
                
                dsh.setVisible(true);
                inq.setVisible(false);
                cal.setVisible(false);
                ser.setVisible(false);
                doc.setVisible(false);
            }
        });
     
        dashLabel = new JLabel("Dashboard");
        dashLabel.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        dashLabel.setLocation(70, 15);
        dashLabel.setSize(165, 21);
        toDashboard.add(dashLabel);
        
        lblNewLabel = new JLabel();
        lblNewLabel.setIcon(new ImageIcon(AMainFrame.class.getResource("/MykieImga/Vector.png")));
//        lblNewLabel.setIcon(new ImageIcon(AMainFrame.class.getResource("Vector.png"))); 
        lblNewLabel.setBounds(40, 15, 16, 18);
        toDashboard.add(lblNewLabel);        
        
        menuLabel = new JLabel("MENU");
        menuLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 16));
        menuLabel.setBounds(25, 151, 85, 21);
        left.add(menuLabel);
        
        lblClient = new JLabel("Client");
        lblClient.setForeground(new Color(0, 0, 0));
        lblClient.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 16));
        lblClient.setBounds(130, 88, 51, 21);
        lblClient.setHorizontalTextPosition(SwingConstants.CENTER);
        left.add(lblClient);
        /// fullname
        clnameLabel = new JLabel("");
        clnameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        setFullName(clnameLabel);
        clnameLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        clnameLabel.setForeground(Color.BLACK);
        clnameLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 24));
        clnameLabel.setBounds(63, 57, 179, 21);
        left.add(clnameLabel);
        
//===================================================================   
        
        toInquiry = new JPanel();
        toInquiry.setBackground(new Color(255,255,255));
        toInquiry.setBounds(0, 240, 303, 51);
        toInquiry.setLayout(null);
        left.add(toInquiry);
        
        toInquiry.addMouseListener(new PanelButtonMouseAdapter(toInquiry) {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuclicked(toInquiry);
                
                dsh.setVisible(false);
                inq.setVisible(true);
                cal.setVisible(false);
                ser.setVisible(false);
                doc.setVisible(false);
            }
        });
        
        inquLabel = new JLabel("Inquiry");
        inquLabel.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        inquLabel.setBounds(70, 15, 165, 21);
        toInquiry.add(inquLabel);
        
        lblNewLabel_1 = new JLabel();
        lblNewLabel_1.setIcon(new ImageIcon(AMainFrame.class.getResource("/MykieImga/Schedule (1).png")));
//        lblNewLabel_1.setIcon(new ImageIcon(AMainFrame.class.getResource("Vector (2).png"))); 
        lblNewLabel_1.setBounds(40, 15, 20, 18);
        toInquiry.add(lblNewLabel_1);
  
//===================================================================   
        
        toCalendar = new JPanel();
        toCalendar.setBackground(new Color(255,255,255));
        toCalendar.setBounds(0, 290, 303, 51);
        toCalendar.setLayout(null);
        left.add(toCalendar);
        
        toCalendar.addMouseListener(new PanelButtonMouseAdapter(toCalendar) {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuclicked(toCalendar);
                
                dsh.setVisible(false);
                inq.setVisible(false);
                cal.setVisible(true);
                ser.setVisible(false);
                doc.setVisible(false);
            }
        });
        
        caleLabel = new JLabel("Calendar");
        caleLabel.setSize(165, 21);
        caleLabel.setLocation(70, 15);
        caleLabel.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        toCalendar.add(caleLabel);
        
        lblNewLabel_2 = new JLabel();
        lblNewLabel_2.setIcon(new ImageIcon(AMainFrame.class.getResource("/MykieImga/Vector (1).png")));
//        lblNewLabel_2.setIcon(new ImageIcon(AMainFrame.class.getResource("Schedule (1).png"))); 
        lblNewLabel_2.setBounds(39, 15, 18, 18);
        toCalendar.add(lblNewLabel_2);
        
//===================================================================   
        
        toServices = new JPanel();
        toServices.setBackground(new Color(255,255,255));
        toServices.setBounds(0, 340, 303, 51);
        toServices.setLayout(null);
        left.add(toServices);
        
        toServices.addMouseListener(new PanelButtonMouseAdapter(toServices) {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuclicked(toServices);
                
                dsh.setVisible(false);
                inq.setVisible(false);
                cal.setVisible(false);
                ser.setVisible(true);
                doc.setVisible(false);
            }
        });
        
        servLabel = new JLabel("Services");
        servLabel.setSize(165, 21);
        servLabel.setLocation(70, 15);
        servLabel.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        toServices.add(servLabel);
        
        lblNewLabel_3 = new JLabel();
        lblNewLabel_3.setIcon(new ImageIcon(AMainFrame.class.getResource("/MykieImga/Vector (2).png")));
//        lblNewLabel_3.setIcon(new ImageIcon(AMainFrame.class.getResource("Vector (1).png"))); 
        lblNewLabel_3.setBounds(38, 15, 18, 18);
        toServices.add(lblNewLabel_3);
        
//===================================================================
        
        toDocumentation = new JPanel();
        toDocumentation.setBackground(new Color(255,255,255));
        toDocumentation.setBounds(0, 390, 303, 51);
        toDocumentation.setLayout(null);
        left.add(toDocumentation);
        
        toDocumentation.addMouseListener(new PanelButtonMouseAdapter(toDocumentation) {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuclicked(toDocumentation);
                
                dsh.setVisible(false);
                inq.setVisible(false);
                cal.setVisible(false);
                ser.setVisible(false);
                doc.setVisible(true);
            }
        });
        
        docuLabel = new JLabel("Documentation");
        docuLabel.setSize(165, 21);
        docuLabel.setLocation(70, 15);
        docuLabel.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        toDocumentation.add(docuLabel);
        
//===================================================================
        
        lblNewLabel_4 = new JLabel();
        lblNewLabel_4.setIcon(new ImageIcon(AMainFrame.class.getResource("/MykieImga/carbon_customer.png")));
//        lblNewLabel_4.setIcon(new ImageIcon(AMainFrame.class.getResource("Vector (2).png"))); 
        lblNewLabel_4.setBounds(40, 15, 16, 18);
        toDocumentation.add(lblNewLabel_4);
        
//        ImageIcon icon6 = new ImageIcon(AMainFrame.class.getResource("Vector (3).png"));
//        signoutBtn = new JButton("  Sign Out                             ", icon6);
        signoutBtn = new JButton("Sign Out");
        signoutBtn.setIcon(new ImageIcon(AMainFrame.class.getResource("/MykieImga/Vector (3).png")));
        signoutBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        signoutBtn.setFocusPainted(false);
        signoutBtn.setOpaque(false);
        signoutBtn.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        signoutBtn.setBounds(-2, 644, 305, 51);
        signoutBtn.setBackground(new Color (255,255,255));
        signoutBtn.setHorizontalAlignment(SwingConstants.CENTER);

        signoutBtn.addMouseListener(new MouseAdapter() {
        	@Override
        		public void mouseEntered(MouseEvent e) {
        			signoutBtn.setBackground(new Color(229,229,229));
        		}
        		
        		public void mouseExited(MouseEvent e) {
        			signoutBtn.setBackground(new Color(255,255,255));
        		}
        		
        		public void mousePressed(MouseEvent e) {
        			signoutBtn.setBackground(new Color(229,229,229));
        			int response = JOptionPane.showConfirmDialog(null, 
        	                "Are you sure you want to sign out?", 
        	                "Sign Out Confirmation", 
        	                JOptionPane.YES_NO_OPTION, 
        	                JOptionPane.QUESTION_MESSAGE);

        	        if (response == JOptionPane.YES_OPTION) {
        	            // Code to sign out the user
        	        	loginSignUpFrame lsup = new loginSignUpFrame();
        	        	lsup.setVisible(true);
        	        	dispose();
        	        	
        	        }
        			
        		}
        		
        		public void mouseReleased(MouseEvent e) {
        			signoutBtn.setBackground(new Color(255,255,255));
        		}
        	});
        
        signoutBtn.setLayout(null);
        signoutBtn.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(125, 125, 125)));
        signoutBtn.setBackground(Color.WHITE);
        signoutBtn.setBounds(0, 593, 305, 51);
        left.add(signoutBtn);

//===================================================================      
        
        headerPanel = new JPanel();
        headerPanel.setBackground(new Color(255, 255, 255));
        headerPanel.setBounds(305, 0, 1595, 78);
        headerPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(224, 224, 224)));
        headerPanel.setLayout(null);
        contentPane.add(headerPanel);
        
        ibmTitleLabel = new JLabel("IBM Consulting");
        ibmTitleLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 24));
        ibmTitleLabel.setSize(198, 31);
        ibmTitleLabel.setLocation(34, 21);
        headerPanel.add(ibmTitleLabel);
        
//===================================================================        
        
        calendarPanel = new JPanel();
        calendarPanel.addMouseListener(new PanelButtonMouseAdapter(calendarPanel) {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		 menuclicked(toCalendar);
                 
                 dsh.setVisible(false);
                 inq.setVisible(false);
                 cal.setVisible(true);
                 ser.setVisible(false);
                 doc.setVisible(false);
        	}
        });
        calendarPanel.setBackground(new Color(255, 255, 255));
        calendarPanel.setBounds(1468, 21, 40, 40);
        calendarPanel.setLayout(null);
        headerPanel.add(calendarPanel);
        
        lblNewLabel_7 = new JLabel();
        lblNewLabel_7.setIcon(new ImageIcon(AMainFrame.class.getResource("/MykieImga/clarity_calendar-line (1).png")));
//        lblNewLabel_7.setIcon(new ImageIcon(AMainFrame.class.getResource("clarity_calendar-line (1).png")));
        lblNewLabel_7.setBounds(2, 0, 37, 40);
        calendarPanel.add(lblNewLabel_7);
        
        panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBounds(1392, 21, 40, 40);
        panel_2.setLayout(null);
        headerPanel.add(panel_2);
        
        lblNewLabel_6 = new JLabel();
        lblNewLabel_6.setIcon(new ImageIcon(AMainFrame.class.getResource("/MykieImga/Group (1).png")));
//        lblNewLabel_6.setIcon(new ImageIcon(AMainFrame.class.getResource("Group (1).png")));
        lblNewLabel_6.setBounds(6, 0, 30, 40);
        panel_2.add(lblNewLabel_6);
        
//===================================================================
        
        panel_3 = new JPanel();
        panel_3.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		CAInquiryFrame cia = new CAInquiryFrame(email);
        		cia.setVisible(true);
        	}
        });
        panel_3.setBackground(new Color(255, 255, 255));
        panel_3.setBounds(1313, 21, 40, 40);
        panel_3.setLayout(null);
        headerPanel.add(panel_3);

        lblNewLabel_5 = new JLabel();
        lblNewLabel_5.setIcon(new ImageIcon(AMainFrame.class.getResource("/MykieImga/material-symbols-light_chat-outline.png")));
//        lblNewLabel_5.setIcon(new ImageIcon(AMainFrame.class.getResource("material-symbols-light_chat-outline.png")));
        lblNewLabel_5.setBounds(0, 0, 40, 40);
        panel_3.add(lblNewLabel_5);

//===================================================================
        
        bluePanel = new JPanel();
        bluePanel.setBounds(0, 0, 305, 182);
        bluePanel.setBackground(new Color(15, 98, 254));
        bluePanel.setLayout(null);
        contentPane.add(bluePanel);
        
        
        ibmlogo = new JLabel();
        ibmlogo.setIcon(new ImageIcon(AMainFrame.class.getResource("/MykieImga/ibm-logo-18914.png")));
        ibmlogo.setPreferredSize(new Dimension(128, 59));
        ibmlogo.setBounds(89, 30, 128, 59);
//        ibmlogo.setIcon(new ImageIcon(AMainFrame.class.getResource("white IBM logo.png"))); 
        bluePanel.add(ibmlogo);

    }
    
    private String[] setFullName(JLabel clnameLabel2) {
    	String[] clientName = new String[2];
        System.out.println("Searching for Username:" + senderEmail);
        try(Connection conn = DriverManager.getConnection(dbURL)){
        	PreparedStatement pstmt = conn.prepareStatement("SELECT Client_fname, Client_Iname FROM Client WHERE Client_email = ?");
            pstmt.setString(1, senderEmail);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String firstName = rs.getString("Client_fname");
                    String lastName = rs.getString("Client_Iname");
                    String fullName = firstName + " " + lastName;
                    clnameLabel.setText(fullName);
                    System.out.println(senderEmail);
                    
                    clientName[0] = firstName;
                    clientName[1] = lastName;
                } else {
                	clnameLabel.setText("User not found");
                    System.out.println("No user found for username" + senderEmail);
                }
            }
        }catch(SQLException e) {
        	e.printStackTrace();
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Error Code:" + e.getErrorCode());
            clnameLabel.setText("Error fetching name");
     	
        }
            return clientName;
	}

	private void menuclicked(JPanel selectedPanel) {
        
        dsh.setVisible(false);
        inq.setVisible(false);
        cal.setVisible(false);
        ser.setVisible(false);
        doc.setVisible(false);
        
        selectedPanel.setVisible(true);
        
        this.selectedPanel = selectedPanel;
    }
    
    private class PanelButtonMouseAdapter extends MouseAdapter {
        
        JPanel panel;
        
        public PanelButtonMouseAdapter(JPanel panel) {
            this.panel = panel;
        }
        
        public void mouseEntered(MouseEvent e) {
            panel.setBackground(new Color(229, 229, 229));
        }
        
        public void mouseExited(MouseEvent e) {
            panel.setBackground(new Color(255, 255, 255));
        }
        
        public void mousePressed(MouseEvent e) {
            panel.setBackground(new Color(229, 229, 229));
        }
        
        public void mouseReleased(MouseEvent e) {
            panel.setBackground(new Color(229, 229, 229));
        }
    }
}