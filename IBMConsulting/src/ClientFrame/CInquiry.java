package ClientFrame;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.DebugGraphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CInquiry extends JPanel {


	private static final long serialVersionUID = 1L;
    private JPanel inquiryPanel, currentPanel, prevPanel1, prevPanel2;
    private JLabel inquiryLabel, currentLabel, previousLabel;
    private JTextField txtMay_1, txtMay_2;
    private JLabel lblNewLabel;
    private JTextField dateField;
    private JTextArea currentTextArea, prev1TextArea, prev2TextArea;
    
    static final String dbURL = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";
    static String senderEmail;

	/**
	 * Create the panel.
	 */
	public CInquiry(String email) {
		this.senderEmail = email;
        setBounds(0, 0, 1570, 877);
        setLayout(null);
        setBackground(new Color(255,255,255));
        setOpaque(true);

        inquiryPanel = new JPanel();
        inquiryPanel.setBackground(new Color(255, 255, 255));
        inquiryPanel.setBounds(0, 0, 1570, 877);
        inquiryPanel.setLayout(null);
        add(inquiryPanel);
        
        inquiryLabel = new JLabel();
        inquiryLabel.setText("Inquiry");
        inquiryLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 36));
        inquiryLabel.setBounds(57, 25, 256, 47);
        inquiryPanel.add(inquiryLabel);
        
        currentLabel = new JLabel();
        currentLabel.setText("Current");
        currentLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 25));
        currentLabel.setBounds(57, 116, 153, 33);
        currentLabel.setOpaque(true); 
        currentLabel.setBackground(Color.WHITE);
        inquiryPanel.add(currentLabel);
        
        previousLabel = new JLabel();
        previousLabel.setText("Previous");
        previousLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 25));
        previousLabel.setBounds(57, 375, 153, 33);
        inquiryPanel.add(previousLabel);
        
        currentPanel = new JPanel();
        currentPanel.setBackground(new Color(255, 255, 255));
        currentPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(104, 104, 104)));
        currentPanel.setBounds(57, 170, 1405, 154);
        currentPanel.setLayout(null);
        inquiryPanel.add(currentPanel);
        
        currentTextArea = new JTextArea();
        currentTextArea.setColumns(1);
        currentTextArea.setDisabledTextColor(new Color(0, 0, 0));
        currentTextArea.setEditable(false);
        currentTextArea.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 16));
        currentTextArea.setBounds(25, 59, 1355, 70);
        currentPanel.add(currentTextArea);       
        
        dateField = new JTextField();
        dateField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 16));
        dateField.setEditable(false);
        dateField.setColumns(1);
        dateField.setBorder(null);
        dateField.setBounds(25, 25, 122, 21);
        currentPanel.add(dateField);
		
//===================================================================   
        
        prevPanel1 = new JPanel();
        prevPanel1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(104, 104, 104)));
        prevPanel1.setBackground(Color.WHITE);
        prevPanel1.setBounds(57, 431, 1405, 154);
        prevPanel1.setLayout(null);
        inquiryPanel.add(prevPanel1);
        
        prev1TextArea = new JTextArea();
        prev1TextArea.setEditable(false);
        prev1TextArea.setColumns(1);
        prev1TextArea.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        prev1TextArea.setBounds(25, 59, 1355, 70);
        prevPanel1.add(prev1TextArea);
        
        JTextArea prev1TextArea = new JTextArea();
        prev1TextArea.setEditable(false);
        prev1TextArea.setColumns(1);
        prev1TextArea.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        prev1TextArea.setBounds(25, 59, 1355, 70);
        prevPanel1.add(prev1TextArea);
        
//===================================================================           
        
        prevPanel2 = new JPanel();
        prevPanel2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(104, 104, 104)));
        prevPanel2.setBackground(Color.WHITE);
        prevPanel2.setBounds(57, 621, 1405, 154);
        prevPanel2.setLayout(null);
        inquiryPanel.add(prevPanel2);
        
        prev2TextArea = new JTextArea();
        prev2TextArea.setColumns(1);
        prev2TextArea.setEditable(false);
        prev2TextArea.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        prev2TextArea.setBounds(25, 59, 1355, 70);
        prevPanel2.add(prev2TextArea);
        
        JTextArea prev2textArea = new JTextArea();
        prev2textArea.setColumns(1);
        prev2textArea.setEditable(false);
        prev2textArea.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        prev2textArea.setBounds(25, 59, 1355, 70);
        prevPanel2.add(prev2textArea);
	
//===================================================================   
        
        JPanel panel = new JPanel();
        panel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		CAInquiryFrame cai = new CAInquiryFrame(email);
        		cai.setVisible(true);
        		loadInquiryData();
        		
        	}
        	
        });
        panel.setBackground(new Color(15, 98, 254));
        panel.setForeground(new Color(255, 255, 255));
        panel.setBounds(1320, 90, 142, 41);
        panel.setLayout(null);
        inquiryPanel.add(panel);
        
        lblNewLabel = new JLabel("Inquire");
        lblNewLabel.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setLocation(0, 0);
        lblNewLabel.setSize(142, 40);
        panel.add(lblNewLabel);
        
        loadInquiryData();

	}
	private void loadInquiryData() {
	try (Connection conn = DriverManager.getConnection(dbURL)) {
		 String query = "SELECT TOP 3 problem, date FROM Inquiry WHERE client_email = ? ORDER BY inquiry_id DESC";
		 try (PreparedStatement pstmt = conn.prepareStatement(query)) {
		      pstmt.setString(1, senderEmail);
		        try (ResultSet rs = pstmt.executeQuery()) {
		             int count = 0;
		             while (rs.next() && count < 3) {
		                String problem = rs.getString("problem");
		                Date date = rs.getDate("date");
		                String dateString = (date != null) ? date.toString() : "";

		               switch (count) {
		                  case 0:
		                    // Current inquiry
		                   currentTextArea.setLineWrap(true);
		                   currentTextArea.setWrapStyleWord(true);
		                   currentTextArea.setText(problem);
		                   dateField.setText(dateString);
		                       break;
		                  case 1:
		                      // Previous inquiry 1
		                    prev1TextArea.setLineWrap(true);
		                    prev1TextArea.setWrapStyleWord(true);
		                    prev1TextArea.setText(problem);
		                    txtMay_1.setText(dateString);
		                       break;
		                  case 2:
		                        // Previous inquiry 2
		                        prev2TextArea.setLineWrap(true);
		                        prev2TextArea.setWrapStyleWord(true);
		                        prev2TextArea.setText(problem);
		                        txtMay_2.setText(dateString);
		                       break;
		                 }
		               count++;
		            }
		        }
		 }
	   } catch (SQLException e) {
		   e.printStackTrace();
		  JOptionPane.showMessageDialog(this, "Error loading inquiry data: " + e.getMessage());
	   }
	}
}