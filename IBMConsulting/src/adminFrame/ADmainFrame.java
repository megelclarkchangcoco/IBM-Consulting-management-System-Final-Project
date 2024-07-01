package adminFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import LoginFrame.loginSignUpFrame;

import javax.swing.ImageIcon;

public class ADmainFrame extends JFrame {

	private JPanel contentPane;
	private JLabel profilenamelbl;
	private JLabel ibmlogo;
	private JLabel iconlbl;
	private JPanel selectedPanel;
	private JPanel bodyPanel; 
	
    static final String dbURL = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";
    static String email;
    static String senderEmail;
	
	public static final long serialVersionUID = 1L;
	
	
	public static BDashboardPanel dashP;
	public static CInquiryPanel inquireP;
	public static DClientsPanel clientP;
	public static EConsultantsPanel consultantP;
	public static FServicesPanel serviceP;
	public static GContractsPanel contractP;
	public static HTransactionsPanel transactionP;
	public static IDocumentationPanel docuP;
	public static JCalendarPanel calendarP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ADmainFrame frame = new ADmainFrame(email);
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
	public ADmainFrame(String email) {
		this.senderEmail = email;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1880, 980);
		setTitle("Admin Frame");
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(100, 100, 1880, 980);
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//create an instance panel
        dashP = new BDashboardPanel(email);
        inquireP = new CInquiryPanel();
        clientP = new DClientsPanel();
        consultantP= new EConsultantsPanel();
        serviceP = new FServicesPanel();
        contractP = new GContractsPanel();
        transactionP = new HTransactionsPanel();
        docuP = new IDocumentationPanel(email);
        calendarP = new JCalendarPanel(email);
        
        //set bounds for the panel class
        dashP.setBounds(304, 77, 1560, 864); 
        inquireP.setBounds(304, 77, 1560, 864);
        clientP.setBounds(304, 77, 1560, 864);
        consultantP.setBounds(304, 77, 1560, 864);
        serviceP.setBounds(304, 77, 1560, 864);
        contractP.setBounds(304, 77, 1560, 864);
        transactionP.setBounds(304, 77, 1560, 864);
        docuP.setBounds(304, 77, 1560, 864);
        calendarP.setBounds(304, 77, 1560, 864);
        
        
       
        
        //set instance to the content pane of the panel
        contentPane.add(dashP);
        contentPane.add(inquireP);
        contentPane.add(clientP);
        contentPane.add(consultantP);
        contentPane.add(serviceP);
        contentPane.add(contractP);
        contentPane.add(transactionP);
        contentPane.add(docuP);
        contentPane.add(calendarP);
        
        //setting initial visibility
        dashP.setVisible(true);
        inquireP.setVisible(false);
        clientP.setVisible(false);
        consultantP.setVisible(false);
        serviceP.setVisible(false);
        contractP.setVisible(false);
        transactionP.setVisible(false); 
        docuP.setVisible(false);
        calendarP.setVisible(false);
        
        //call revalidate() and repaint() to update the frame
        contentPane.revalidate();
        contentPane.repaint();
		
		
		JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(0, 0, 1865, 941); 
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
        
        iconlbl = new JLabel("");
        iconlbl.setIcon(new ImageIcon(ADmainFrame.class.getResource("/LoginFrameImg/samplepic.png")));
//        iconlbl.setIcon(new ImageIcon(AmainFrame.class.getResource("/assets/samplepic.png")));
        iconlbl.setBounds(10, 11, 107, 102);
        iconPanel.add(iconlbl);
        
        JLabel joblbl = new JLabel("Admin");
        joblbl.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 14));
        joblbl.setBounds(107, 266, 97, 20);
        leftPanel.add(joblbl);
        
        ibmlogo = new JLabel("");
//        ibmlogo.setIcon(new ImageIcon(AmainFrame.class.getResource("/assets/bigIBM.png")));
        ibmlogo.setBounds(83, 35, 128, 59);
        leftPanel.add(ibmlogo);
        
        profilenamelbl = new JLabel("");
        profilenamelbl.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 24));
        profilenamelbl.setBounds(65, 236, 179, 31);
        setFullName(profilenamelbl);
        leftPanel.add(profilenamelbl);
        
        JPanel menuPanel = new JPanel();
        menuPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(125, 125, 125)));
        menuPanel.setBackground(new Color(255, 255, 255));
        menuPanel.setBounds(0, 297, 305, 644);
        leftPanel.add(menuPanel);
        menuPanel.setLayout(null);
        
        
        
        JLabel lblNewLabel = new JLabel("Menu");
        lblNewLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 16));
        lblNewLabel.setBounds(10, 11, 85, 21);
        menuPanel.add(lblNewLabel);
        
        JPanel dashboardbtnPanel = new JPanel();
        dashboardbtnPanel.addMouseListener(new PanelButtonMouseAdapter(dashboardbtnPanel) {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		menuClicked(dashboardbtnPanel);
        		
        		dashP.setVisible(true);
        		inquireP.setVisible(false);
        		clientP.setVisible(false);
        		consultantP.setVisible(false);
        		serviceP.setVisible(false);
        		contractP.setVisible(false);
        		transactionP.setVisible(false);
        		docuP.setVisible(false);
        		calendarP.setVisible(false);

        		
        	}
        });
        dashboardbtnPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(125, 125, 125)));
        dashboardbtnPanel.setBackground(new Color(255, 255, 255));
        dashboardbtnPanel.setBounds(0, 40, 305, 51);
        menuPanel.add(dashboardbtnPanel);
        dashboardbtnPanel.setLayout(null);
        
        JLabel dashboardlbl = new JLabel("   Dashboard");
        dashboardlbl.setIcon(new ImageIcon(ADmainFrame.class.getResource("/LoginFrameImg/dashboard_icon.png")));
//        dashboardlbl.setIcon(new ImageIcon(AmainFrame.class.getResource("/assets/dashboard_icon.png")));
        dashboardlbl.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        dashboardlbl.setBounds(24, 19, 165, 21);
        dashboardbtnPanel.add(dashboardlbl);
        
        JPanel inquiryPanel = new JPanel();
        inquiryPanel.addMouseListener(new PanelButtonMouseAdapter(inquiryPanel) {	
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		menuClicked(inquiryPanel);
        		
        		dashP.setVisible(false);
        		inquireP.setVisible(true);
        		clientP.setVisible(false);
        		consultantP.setVisible(false);
        		serviceP.setVisible(false);
        		contractP.setVisible(false);
        		transactionP.setVisible(false);
        		docuP.setVisible(false);
        		calendarP.setVisible(false);

        	}
        });
        inquiryPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(125, 125, 125)));
        inquiryPanel.setBackground(Color.WHITE);
        inquiryPanel.setBounds(0, 102, 305, 51);
        menuPanel.add(inquiryPanel);
        inquiryPanel.setLayout(null);
        
        JLabel lblInquiry = new JLabel("    Inquiry");
        lblInquiry.setIcon(new ImageIcon(ADmainFrame.class.getResource("/LoginFrameImg/inquiry_icon.png")));
//        lblInquiry.setIcon(new ImageIcon(AmainFrame.class.getResource("/assets/inquiry_icon.png")));
        lblInquiry.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        lblInquiry.setBounds(21, 11, 165, 21);
        inquiryPanel.add(lblInquiry);
        
        JPanel clientbtnPanel = new JPanel();
        clientbtnPanel.addMouseListener( new PanelButtonMouseAdapter(clientbtnPanel)  {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		menuClicked(clientbtnPanel);
        		
        		dashP.setVisible(false);
        		inquireP.setVisible(false);
        		clientP.setVisible(true);
        		consultantP.setVisible(false);
        		serviceP.setVisible(false);
        		contractP.setVisible(false);
        		transactionP.setVisible(false);
        		docuP.setVisible(false);
				calendarP.setVisible(false);
				
        	}
        });
        clientbtnPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
        clientbtnPanel.setBackground(Color.WHITE);
        clientbtnPanel.setBounds(0, 164, 305, 51);
        menuPanel.add(clientbtnPanel);
        clientbtnPanel.setLayout(null);
        
        JLabel lblClients = new JLabel(" Clients");
        lblClients.setIcon(new ImageIcon(ADmainFrame.class.getResource("/LoginFrameImg/clients_icon.png")));
//        lblClients.setIcon(new ImageIcon(AmainFrame.class.getResource("/assets/clients_icon.png")));
        lblClients.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        lblClients.setBounds(20, 11, 165, 21);
        clientbtnPanel.add(lblClients);
        
        JPanel consultantbtnPanel = new JPanel();
        consultantbtnPanel.addMouseListener(new PanelButtonMouseAdapter(consultantbtnPanel) {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		menuClicked(consultantbtnPanel);
   
        		dashP.setVisible(false);
        		inquireP.setVisible(false);
        		clientP.setVisible(false);
        		consultantP.setVisible(true);
        		serviceP.setVisible(false);
        		contractP.setVisible(false);
        		transactionP.setVisible(false);
        		docuP.setVisible(false);
        	   calendarP.setVisible(false);
        		
        	}
        });
        consultantbtnPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(125, 125, 125)));
        consultantbtnPanel.setBackground(Color.WHITE);
        consultantbtnPanel.setBounds(0, 226, 305, 51);
        menuPanel.add(consultantbtnPanel);
        consultantbtnPanel.setLayout(null);
        
        JLabel lblConsultant = new JLabel("  Consultants");
        lblConsultant.setIcon(new ImageIcon(ADmainFrame.class.getResource("/LoginFrameImg/consultant_icons.png")));
//        lblConsultant.setIcon(new ImageIcon(AmainFrame.class.getResource("/assets/consultant_icons.png")));
        lblConsultant.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        lblConsultant.setBounds(20, 11, 165, 21);
        consultantbtnPanel.add(lblConsultant);
        
        JPanel servicesbtnPanel = new JPanel();
        servicesbtnPanel.addMouseListener(new PanelButtonMouseAdapter(servicesbtnPanel) {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		menuClicked(servicesbtnPanel);
        		
        		dashP.setVisible(false);
        		inquireP.setVisible(false);
        		clientP.setVisible(false);
        		consultantP.setVisible(false);
        		serviceP.setVisible(true);
        		contractP.setVisible(false);
        		transactionP.setVisible(false);
        		docuP.setVisible(false);
        	    calendarP.setVisible(false);
        
        	}
        });
        servicesbtnPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(125, 125, 125)));
        servicesbtnPanel.setBackground(Color.WHITE);
        servicesbtnPanel.setBounds(0, 288, 305, 51);
        menuPanel.add(servicesbtnPanel);
        servicesbtnPanel.setLayout(null);
        
        JLabel lblServices = new JLabel("   Services");
        lblServices.setIcon(new ImageIcon(ADmainFrame.class.getResource("/LoginFrameImg/service_icon.png")));
//        lblServices.setIcon(new ImageIcon(AmainFrame.class.getResource("/assets/service_icon.png")));
        lblServices.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        lblServices.setBounds(20, 11, 165, 21);
        servicesbtnPanel.add(lblServices);
        
        JPanel contractbtnPanel = new JPanel();
        contractbtnPanel.addMouseListener(new PanelButtonMouseAdapter(contractbtnPanel) {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		menuClicked(contractbtnPanel);
        		
        		dashP.setVisible(false);
        		inquireP.setVisible(false);
        		clientP.setVisible(false);
        		consultantP.setVisible(false);
        		serviceP.setVisible(false);
        		contractP.setVisible(true);
        		transactionP.setVisible(false);
        		docuP.setVisible(false);
        		calendarP.setVisible(false);
        		
        	}
        });
        contractbtnPanel.setLayout(null);
        contractbtnPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(125, 125, 125)));
        contractbtnPanel.setBackground(Color.WHITE);
        contractbtnPanel.setBounds(0, 350, 305, 51);
        menuPanel.add(contractbtnPanel);
        
        JLabel lblContract = new JLabel("   Contract");
        lblContract.setIcon(new ImageIcon(ADmainFrame.class.getResource("/LoginFrameImg/transaction_icon.png")));
//        lblContract.setIcon(new ImageIcon(AmainFrame.class.getResource("/assets/contract_icon.png")));
        lblContract.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        lblContract.setBounds(20, 11, 165, 21);
        contractbtnPanel.add(lblContract);
        
        JPanel transactionbtnPanel = new JPanel();
        transactionbtnPanel.setLayout(null);
        transactionbtnPanel.addMouseListener(new PanelButtonMouseAdapter(transactionbtnPanel) {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		menuClicked(transactionbtnPanel);
        		
        		dashP.setVisible(false);
        		inquireP.setVisible(false);
        		clientP.setVisible(false);
        		consultantP.setVisible(false);
        		serviceP.setVisible(false);
        		contractP.setVisible(false);
        		transactionP.setVisible(true);
        		docuP.setVisible(false);
        		calendarP.setVisible(false);
        		
        	}
        });
        transactionbtnPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(125, 125, 125)));
        transactionbtnPanel.setBackground(Color.WHITE);
        transactionbtnPanel.setBounds(0, 412, 305, 51);
        menuPanel.add(transactionbtnPanel);
        
        JLabel lbltransaction = new JLabel("  Transaction");
        lbltransaction.setIcon(new ImageIcon(ADmainFrame.class.getResource("/LoginFrameImg/transaction_icon.png")));
//        lbltransaction.setIcon(new ImageIcon(AmainFrame.class.getResource("/assets/transaction_icon.png")));
        lbltransaction.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        lbltransaction.setBounds(20, 11, 165, 21);
        transactionbtnPanel.add(lbltransaction);
        
        JPanel documentationbtnPanel = new JPanel();
        documentationbtnPanel.setLayout(null);
        documentationbtnPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(125, 125, 125)));
        documentationbtnPanel.setBackground(Color.WHITE);
        documentationbtnPanel.setBounds(0, 474, 305, 51);
        documentationbtnPanel.addMouseListener(new PanelButtonMouseAdapter(documentationbtnPanel) {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		menuClicked(documentationbtnPanel);
        		
        		dashP.setVisible(false);
        		inquireP.setVisible(false);
        		clientP.setVisible(false);
        		consultantP.setVisible(false);
        		serviceP.setVisible(false);
        		contractP.setVisible(false);
        		transactionP.setVisible(false);
        		docuP.setVisible(true);
        		calendarP.setVisible(false);
        		
        	}
        });
        menuPanel.add(documentationbtnPanel);
        
        JLabel lblDocumentation = new JLabel("  Documentation");
        lblDocumentation.setIcon(new ImageIcon(ADmainFrame.class.getResource("/LoginFrameImg/documentation_icon.png")));
//        lblDocumentation.setIcon(new ImageIcon(AmainFrame.class.getResource("/assets/documentation_icon.png")));
        lblDocumentation.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        lblDocumentation.setBounds(20, 11, 165, 21);
        documentationbtnPanel.add(lblDocumentation);
        
        JPanel signOutbtnPanel = new JPanel();
        signOutbtnPanel.addMouseListener(new MouseAdapter() {
        	@Override
        		public void mouseEntered(MouseEvent e) {
        			signOutbtnPanel.setBackground(new Color(229,229,229));
        		}
        		
        		public void mouseExited(MouseEvent e) {
        			signOutbtnPanel.setBackground(new Color(255,255,255));
        		}
        		
        		public void mousePressed(MouseEvent e) {
        			signOutbtnPanel.setBackground(new Color(229,229,229));
        			int response = JOptionPane.showConfirmDialog(null, 
        	                "Are you sure you want to sign out?", 
        	                "Sign Out Confirmation", 
        	                JOptionPane.YES_NO_OPTION, 
        	                JOptionPane.QUESTION_MESSAGE);

        	        if (response == JOptionPane.YES_OPTION) {
        	            // Code to sign out the user
        	        	loginSignUpFrame lsf = new loginSignUpFrame();
        	        	lsf.setVisible(true);
        	        	dispose();
        	        	
        	        }
        			
        		}
        		
        		public void mouseReleased(MouseEvent e) {
        			signOutbtnPanel.setBackground(new Color(255,255,255));
        		}
        	});
        
        signOutbtnPanel.setLayout(null);
        signOutbtnPanel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(125, 125, 125)));
        signOutbtnPanel.setBackground(Color.WHITE);
        signOutbtnPanel.setBounds(0, 593, 305, 51);
        menuPanel.add(signOutbtnPanel);
        
        JLabel lblSignOut = new JLabel("  Sign Out");
        lblSignOut.setIcon(new ImageIcon(ADmainFrame.class.getResource("/LoginFrameImg/signout_icon.png")));
//        lblSignOut.setIcon(new ImageIcon(AmainFrame.class.getResource("/assets/signout_icon.png")));
        lblSignOut.setFont(new Font("IBM Plex Sans", Font.PLAIN, 16));
        lblSignOut.setBounds(20, 11, 165, 21);
        signOutbtnPanel.add(lblSignOut);
		
		// ==================================== head panel
		JPanel headPanel = new JPanel();
        headPanel.setBounds(304, 0, 1567, 78);
        headPanel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(192, 192, 192)));
        headPanel.setBackground(new Color(255, 255, 255));
        panel.add(headPanel);
        headPanel.setLayout(null);
        
        JLabel naming = new JLabel("IBM Consulting");
        naming.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 24));
        naming.setBounds(28, 22, 198, 31);
        headPanel.add(naming);
        
         JPanel calendarPanel = new JPanel();
        calendarPanel.setBackground(Color.WHITE);
        calendarPanel.setBounds(1466, 23, 49, 44);
        calendarPanel.addMouseListener(new PanelButtonMouseAdapter(calendarPanel) {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		menuClicked(calendarPanel);
        		
        		dashP.setVisible(false);
        		inquireP.setVisible(false);
        		clientP.setVisible(false);
        		consultantP.setVisible(false);
        		serviceP.setVisible(false);
        		contractP.setVisible(false);
        		transactionP.setVisible(false);
        		docuP.setVisible(false);
        		calendarP.setVisible(true);
        		
        	}
        });
        calendarPanel.setLayout(null);
        headPanel.add(calendarPanel);
        
        
        JLabel calendardlbl = new JLabel("");
        calendardlbl.setIcon(new ImageIcon(ADmainFrame.class.getResource("/LoginFrameImg/calendar_icon.png")));
//        calendardlbl.setIcon(new ImageIcon(AmainFrame.class.getResource("/assets/calendar_icon.png")));
        calendardlbl.setBounds(5, 11, 44, 33);
        calendarPanel.add(calendardlbl);
        
        
        JPanel notifPanel = new JPanel();
        notifPanel.setLayout(null);
        notifPanel.setBackground(Color.WHITE);
        notifPanel.setBounds(1407, 23, 49, 44);
        headPanel.add(notifPanel);
        
        JLabel notifIcon = new JLabel(""); // icon for calendar
        notifIcon.setIcon(new ImageIcon(ADmainFrame.class.getResource("/LoginFrameImg/notif_icon.png")));
//        notifIcon.setIcon(new ImageIcon(AmainFrame.class.getResource("/assets/notif_icon.png")));
        notifIcon.setBounds(5, 11, 36, 33);
        notifPanel.add(notifIcon);
        
        JLabel notificationlbl = new JLabel(""); // icon for notif
        notificationlbl.setBounds(9, 11, 26, 30);
        notifPanel.add(notificationlbl);
        
     //   bodyPanel = new JPanel();
     //   bodyPanel.setBounds(304, 77, 1560, 864);
     //   panel.add(bodyPanel);
        
        
        
	}
	 private String[] setFullName(JLabel clnameLabel2) {
	    	String[] clientName = new String[2];
	        System.out.println("Searching for Username:" + senderEmail);
	        try(Connection conn = DriverManager.getConnection(dbURL)){
	        	PreparedStatement pstmt = conn.prepareStatement("SELECT Admin_fname, Admin_lname FROM Admin WHERE admin_email = ?");
	            pstmt.setString(1, senderEmail);
	            
	            try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    String firstName = rs.getString("Admin_fname");
	                    String lastName = rs.getString("Admin_lname");
	                    String fullName = firstName + " " + lastName;
	                    profilenamelbl.setText(fullName);
	                    System.out.println(senderEmail);
	                    
	                    clientName[0] = firstName;
	                    clientName[1] = lastName;
	                } else {
	                	profilenamelbl.setText("User not found");
	                    System.out.println("No user found for username" + senderEmail);
	                }
	            }
	        }catch(SQLException e) {
	        	e.printStackTrace();
	            System.out.println("SQL State: " + e.getSQLState());
	            System.out.println("Error Code:" + e.getErrorCode());
	            profilenamelbl.setText("Error fetching name");
	     	
	        }
	            return clientName;
		}
	
	private void menuClicked (JPanel selectedPanel) {
		
		dashP.setVisible(false);
		inquireP.setVisible(false);
		clientP.setVisible(false);
		consultantP.setVisible(false);
		serviceP.setVisible(false);
		contractP.setVisible(false);
		transactionP.setVisible(false);
		docuP.setVisible(false);
		calendarP.setVisible(false);
		
	
		
		
		this.selectedPanel = selectedPanel;
		selectedPanel.setVisible(true);
		
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter {
		
		JPanel panel;
		
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel=panel;
		}
		
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(229,229,229));
		}
		
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(255,255,255));
		}
		
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(229,229,229));
		}
		
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(255,255,255));
		}
	}
}
