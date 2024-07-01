package adminFrame;

import java.awt.*;    
import javax.swing.*;   
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import sratch.trys;

public class EConsultantsPanel extends JPanel {
    static final String dbUrl = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";

	private JTable consultantMasterFileTBL;
	private JPanel consultantExpertise;
	private JPanel consultantMasterFile;
	private  DefaultTableModel model,EXPmodel;


	
	 
	public EConsultantsPanel() {
		setBounds(0, 0, 1560, 864);
		setLayout(null);
		setOpaque(false);
		
		//create a bodyPanel
		JPanel bodyPanel = new JPanel();
		bodyPanel.setBounds(0, 0, 1560, 864);
		//bodyPanel.setBackground(new Color (255,255,255));
		bodyPanel.setBorder(new LineBorder(new Color(104, 104, 104)));
		add(bodyPanel);
		bodyPanel.setLayout(null);
		
		
		//create the cardPanel inside the bodyPanel
		JPanel cardPanel = new JPanel();
		cardPanel.setBounds(0, 0, 1560, 864);
		cardPanel.setBackground(new Color (255,255,255));
		cardPanel.setBorder(new LineBorder(new Color(104, 104, 104)));
		bodyPanel.add(cardPanel);
		//cardPanel.setLayout(null);
		
		//cardlayout for the consultant exp panel and consultant masterfile
		CardLayout cardlayout  = new CardLayout();
		cardPanel.setLayout(cardlayout);
		
		
		
		//create the panel for consultant's master file, this should be included inside the cardPanel###########################
		consultantMasterFile = new JPanel();
		consultantMasterFile.setBounds(0, 0, 1560, 864);
		consultantMasterFile.setBackground(new Color(255, 255, 255));
		cardPanel.add(consultantMasterFile);
		consultantMasterFile.setLayout(null);
		
		//big header "consultant"
		JLabel consultantLabel = new JLabel("Consultants");
		consultantLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 36));
		consultantLabel.setBounds(41, 44, 522, 58);
		consultantMasterFile.add(consultantLabel);
		
		//searchfield for the consultants' master file
		JTextField searchField = new JTextField();
		searchField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		searchField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(22, 22, 22)));
		searchField.setBackground(new Color(244, 244, 244));
		searchField.setBounds(41, 113, 425, 39);
		searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String searchText = searchField.getText();
                searchAttendanceData(searchText);
            }
        });
		consultantMasterFile.add(searchField);
		searchField.setColumns(10);
		
		//search button
		JButton searchButton = new JButton("Search");
		searchButton.setBackground(new Color(15, 98, 254));
		searchButton.setForeground(new Color(255, 255, 255));
		searchButton.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		searchButton.setBounds(476, 113, 112, 39);
		searchButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String search = searchField.getText();
        		searchAttendanceData(search);
        	}
        });
		consultantMasterFile.add(searchButton);
		
		
		//button to redirect in the expertise page
		JButton consultantbyExpertiseBtn = new JButton("Consultant by Expertise");
		consultantbyExpertiseBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardlayout.show(cardPanel, "consultantBtn");
				
			}
		});
		consultantbyExpertiseBtn.setBackground(new Color(15, 98, 254));
		consultantbyExpertiseBtn.setForeground(new Color(255, 255, 255));
		consultantbyExpertiseBtn.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		consultantbyExpertiseBtn.setBounds(1265, 0, 234, 50);
		consultantMasterFile.add(consultantbyExpertiseBtn);
		
		//consultant table
		consultantMasterFileTBL = new JTable();
		consultantMasterFileTBL.setBounds(41, 845, 1458, -656);
		consultantMasterFile.add(consultantMasterFileTBL);
		
		//add new consultant
		JButton addButton = new JButton("   Add new consultant");
		addButton.setIcon(new ImageIcon(EConsultantsPanel.class.getResource("/LoginFrameImg/add_button.png")));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddConsultantFrame frame = new AddConsultantFrame();
				frame.setVisible(true);
			}
		});
//		addButton.setIcon(new ImageIcon(GContractsPanel.class.getResource("/assets/add_button.png")));
		addButton.setBorder(new LineBorder(new Color(15, 98, 254)));
		addButton.setForeground(new Color(15, 98, 254));
		addButton.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		addButton.setBackground(new Color(255, 255, 255));
		addButton.setBounds(640, 112, 201, 39);
		consultantMasterFile.add(addButton);
		
		//edit consultant
		JButton editBtn = new JButton("  Edit");
		editBtn.setIcon(new ImageIcon(EConsultantsPanel.class.getResource("/LoginFrameImg/edit_button.png")));
//		editBtn.setIcon(new ImageIcon(EConsultantsPanel.class.getResource("/assets/edit_button.png")));
		editBtn.setBorder(new LineBorder(new Color(15, 98, 254)));
		editBtn.setForeground(new Color(15, 98, 254));
		editBtn.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		editBtn.setBackground(new Color(255, 255, 255));
		editBtn.setBounds(851, 112, 112, 39);
		consultantMasterFile.add(editBtn);
		
		//panel for consultant's expertise #################################################
		consultantExpertise = new JPanel();
		consultantExpertise.setBounds(0, 0,  1560, 864);
		consultantExpertise.setBackground(new Color(255, 255, 255));
		consultantExpertise.setLayout(null);
		cardPanel.add(consultantExpertise);
		
		//big header for expertise
		JLabel consultantByExpertiseLabel = new JLabel("Consultants by Expertise");
		consultantByExpertiseLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 36));
		consultantByExpertiseLabel.setBounds(41, 44, 568, 58);
		consultantExpertise.add(consultantByExpertiseLabel);
		
		//searchfield for the consultants' expertise
		JTextField searchExpField = new JTextField();
		searchExpField.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		searchExpField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(22, 22, 22)));
		searchExpField.setBackground(new Color(244, 244, 244));
		searchExpField.setBounds(41, 113, 425, 39);
		searchExpField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String searchText = searchField.getText();
                searchAttendanceData2(searchText);
            }
        });
		consultantExpertise.add(searchExpField);
		searchExpField.setColumns(10);
		
		//search button
		JButton searchExpButton = new JButton("Search");
		searchExpButton.setBackground(new Color(15, 98, 254));
		searchExpButton.setForeground(new Color(255, 255, 255));
		searchExpButton.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		searchExpButton.setBounds(476, 113, 112, 39);
		consultantExpertise.add(searchExpButton);
		
		
		//button to redirect in the masterfile page
		JButton consultantBtn = new JButton("Consultants' Masterfile");
		consultantBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardlayout.show(cardPanel, "consultantbyExpertiseBtn");
				
			}
		});
		consultantBtn.setBackground(new Color(15, 98, 254));
		consultantBtn.setForeground(new Color(255, 255, 255));
		consultantBtn.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		consultantBtn.setBounds(1265, 0, 234, 50);
		consultantExpertise.add(consultantBtn);
		
		//consultant expertise table
		JTable consultantExpTBL = new JTable();
		consultantExpTBL.setBounds(41, 845, 1458, -656);
		consultantExpertise.add(consultantExpTBL);
		
		//add new consultant's expertise
		JButton addExpButton = new JButton("   Add new consultant expertise");
		addExpButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddConsultantFrame acf = new AddConsultantFrame();
				acf.setVisible(true);
			}
		});
		addExpButton.setIcon(new ImageIcon(EConsultantsPanel.class.getResource("/LoginFrameImg/add_button.png")));
//		addExpButton.setIcon(new ImageIcon(GContractsPanel.class.getResource("/assets/add_button.png")));
		addExpButton.setBorder(new LineBorder(new Color(15, 98, 254)));
		addExpButton.setForeground(new Color(15, 98, 254));
		addExpButton.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		addExpButton.setBackground(new Color(255, 255, 255));
		addExpButton.setBounds(640, 112, 286, 39);
		consultantExpertise.add(addExpButton);
		
		//edit expertise
		JButton editExpBtn = new JButton("  Edit");
		editExpBtn.setIcon(new ImageIcon(EConsultantsPanel.class.getResource("/LoginFrameImg/edit_button.png")));
//		editExpBtn.setIcon(new ImageIcon(EConsultantsPanel.class.getResource("/assets/edit_button.png")));
		editExpBtn.setBorder(new LineBorder(new Color(15, 98, 254)));
		editExpBtn.setForeground(new Color(15, 98, 254));
		editExpBtn.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		editExpBtn.setBackground(new Color(255, 255, 255));
		editExpBtn.setBounds(936, 112, 112, 39);
		consultantExpertise.add(editExpBtn);
		
		//add the panels
		cardPanel.add(consultantMasterFile, "consultantbyExpertiseBtn");
		cardPanel.add(consultantExpertise, "consultantBtn");
		
		//show the initial panel
		cardlayout.show(cardPanel, "consultantbyExpertiseBtn");
		
	   model = new DefaultTableModel();
	   model.setColumnIdentifiers(new String[] {"Employee number", "First Name", "Last name", "Signed Contract", "Status"});
        fetchData();
        
        JTable table = new JTable(model);
        table.setRowHeight(52);
        
        // Custom renderer for alternating row colors
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            private static final Color COLOR1 = new Color(244, 244, 244);
            private static final Color COLOR2 = new Color(255, 255, 255);

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? COLOR1 : COLOR2);
                }
                return c;
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(41, 191, 1489, 641);
        consultantMasterFile.add(scrollPane);
        
        
        EXPmodel = new DefaultTableModel();
        EXPmodel.setColumnCount(3); 
        EXPmodel.setColumnIdentifiers(new String[] {"Expertise ID", "Service Name", "Consultant"});
        fetchData2();
      
        
        JTable EXPtable = new JTable(EXPmodel);
        EXPtable.setRowHeight(52);
        
        // Custom renderer for alternating row colors
        EXPtable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            private static final Color COLOR1 = new Color(244, 244, 244);
            private static final Color COLOR2 = new Color(255, 255, 255);

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? COLOR1 : COLOR2);
                }
                return c;
            }
        });
        
        JScrollPane ExpScrollPane = new JScrollPane(EXPtable);
        ExpScrollPane.setBounds(41, 191, 1489, 641);
        consultantExpertise.add(ExpScrollPane);
        
		
	}
	
	private void fetchData() {
		try {
            Connection connection = DriverManager.getConnection(dbUrl);
            String query = "SELECT * FROM Consultant";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                model.addRow(new Object[] {
                	rs.getInt("Consultant_id"),
                    rs.getString("consultant_lname"),
                    rs.getString("consultant_fname"),
                    rs.getString("signed_contract"),
                    rs.getString("consultant_status"), 
                });
                
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
	}
	 private void searchAttendanceData(String searchText) {
	        try {
	            Connection connection = DriverManager.getConnection(dbUrl);
	            String query = "SELECT * FROM Consultant WHERE Consultant_id LIKE ? OR consultant_lname LIKE ? OR consultant_fname LIKE ? OR signed_contract LIKE ? OR consultant_status LIKE ?";
	            PreparedStatement pstmt = connection.prepareStatement(query);
	            
	            String searchPattern = "%" + searchText + "%";
	            for (int i = 1; i <= 5; i++) {
	                pstmt.setString(i, searchPattern);
	            }
	            ResultSet rs = pstmt.executeQuery();
	            model.setRowCount(0);
	            while (rs.next()) {
	                model.addRow(new Object[] {
	                		rs.getInt("Consultant_id"),
	                        rs.getString("consultant_lname"),
	                        rs.getString("consultant_fname"),
	                        rs.getString("signed_contract"),
	                        rs.getString("consultant_status"),
	                });
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	 private void fetchData2() {
		 try {
	            Connection connection = DriverManager.getConnection(dbUrl);
	            String query = "SELECT s.service_name, c.expertise_id, c.consultant_lname FROM service s JOIN consultant c ON s.service_id = c.expertise_id;";
	            Statement stmt = connection.createStatement();
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	            	EXPmodel.addRow(new Object[] {
	                	rs.getInt("expertise_id"),
	                    rs.getString("service_name"),
	                    rs.getString("consultant_lname"),

	                });
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
	 private void searchAttendanceData2(String searchText) {
	        try {
	            Connection connection = DriverManager.getConnection(dbUrl);
	            String query = "SELECT * FROM Consultant WHERE expertise_id LIKE ? OR consultant_lname LIKE ? ";
	            PreparedStatement pstmt = connection.prepareStatement(query);
	            String searchPattern = "%" + searchText + "%";
	            for (int i = 1; i <= 2; i++) {
	                pstmt.setString(i, searchPattern);
	            }
	            ResultSet rs = pstmt.executeQuery();
	            model.setRowCount(0);
	            while (rs.next()) {
	                model.addRow(new Object[] {
	                		rs.getInt("expertise_id"),
	                        rs.getString("consultant_lname"),
	                });
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
