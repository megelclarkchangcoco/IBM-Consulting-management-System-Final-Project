package sratch;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FDocumentationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private boolean isClicked = false;

	private JLabel exportlbl,importlbl;
	private JLabel exporttextlbl, importtextlbl;

	
	//for display panel
	private JPanel displayPanel;
	private JScrollPane scrollPane;
	private File selectedFile; // Store the selected file object	
	private JLabel  filelbl; // label for name send file
	
	
	
	 // JDBC URL,
    static final String url = "jdbc:sqlserver://MIGUEL\\SQLEXPRESS;databaseName=testDB;integratedSecurity=true;encrypt=false;";

    // JDBC variables for opening and managing connection
    static Connection connection;
    static PreparedStatement statement;
    static ResultSet resultSet;
    
	/**
	 * Create the panel.
	 */
	public FDocumentationPanel() {
		setBackground(new Color(255, 255, 255));
        setBounds(304, 77,  1557, 907);
        setLayout(null); // Consider using a layout manager
        
        JPanel bodyPanel = new JPanel();
        bodyPanel.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(192, 192, 192)));
        bodyPanel.setBackground(new Color(255, 255, 255));
        bodyPanel.setBounds(0, 0, 1573, 907);
        add(bodyPanel);
        bodyPanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Documentation");
        lblNewLabel.setBounds(48, 11, 391, 47);
        lblNewLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 36));
        bodyPanel.add(lblNewLabel);
        
        JTextField textField = new JTextField();
        textField.setBounds(55, 80, 384, 41);
        bodyPanel.add(textField);
        textField.setColumns(10);
        
        JPanel searchPanel = new JPanel();
        searchPanel.setBounds(449, 80, 100, 41);
        searchPanel.setBackground(new Color(18, 98, 254));
        bodyPanel.add(searchPanel);
        searchPanel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Search");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(22, 11, 60, 20);
        searchPanel.add(lblNewLabel_1);
        
        JComboBox comboBox = new JComboBox(); 
        comboBox.setBounds(559, 80, 142, 41);
        comboBox.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 15));
        comboBox.setForeground(new Color(18, 98, 254));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"         Filter by"}));
        comboBox.setOpaque(false);
        bodyPanel.add(comboBox);
        
        JLabel recentlbl = new JLabel("Recent");
        recentlbl.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 16));
        recentlbl.setBounds(55, 154, 81, 33);
        bodyPanel.add(recentlbl);
        // Panel button for import and export 
        JPanel importPanel = new JPanel();
        importPanel.addMouseListener(new MouseAdapter() { 
        	public void mouseClicked(MouseEvent e) {
        		openFileChooser();
        	}
        	
        	public void mouseEntered(MouseEvent e) {
        		importPanel.setBackground(new Color(15, 98, 254));
        		importtextlbl.setForeground(new Color(255, 255, 255));
        		importlbl.setIcon(new ImageIcon(FDocumentationPanel.class.getResource("/FdocumentationpanelImg/importwhiteiconm.png")));
        	}
        	
        	public void mouseExited(MouseEvent e) {
        		importPanel.setBackground(new Color(255, 255, 255));
        		importtextlbl.setForeground(new Color(15, 98, 254));
        		importlbl.setIcon(new ImageIcon(FDocumentationPanel.class.getResource("/FdocumentationpanelImg/importicon.png")));
        	}
        	
        });
        importPanel.setBorder(new LineBorder(new Color(15, 98, 254), 2));
        importPanel.setBackground(new Color(255, 255, 255));
        importPanel.setBounds(1183, 139, 141, 42);
        bodyPanel.add(importPanel);
        importPanel.setLayout(null);
        
        importtextlbl = new JLabel("Import");
        importtextlbl.setFont(new Font("IBM Plex Sans", Font.PLAIN, 15));
        importtextlbl.setForeground(new Color(15, 98, 254));
        importtextlbl.setBounds(35, 11, 58, 20);
        importPanel.add(importtextlbl);
        
        importlbl = new JLabel("");
        importlbl.setIcon(new ImageIcon(FDocumentationPanel.class.getResource("/FdocumentationpanelImg/importicon.png")));
        importlbl.setBounds(90, 10, 22, 22);
        importPanel.add(importlbl);
        
        JPanel exportPanel = new JPanel();
        exportPanel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		saveFileToDatabase();
        	}
        	
        	public void mouseEntered(MouseEvent e) {
        		exportPanel.setBackground(new Color(255, 255, 255));
        		exporttextlbl.setForeground(new Color(15,98,254));
        		exportlbl.setIcon(new ImageIcon(FDocumentationPanel.class.getResource("/FdocumentationpanelImg/exportblueicon.png")));
        		exportPanel.setBorder(new LineBorder(new Color(15, 98, 254), 2));
        	}
        	
        	public void mouseExited(MouseEvent e) {
        		exportPanel.setBackground(new Color(15,98,254));
        		exporttextlbl.setForeground(new Color(255, 255, 255));
        		exportlbl.setIcon(new ImageIcon(FDocumentationPanel.class.getResource("/FdocumentationpanelImg/exporticon.png")));
        	}
        });
        exportPanel.setBorder(new LineBorder(new Color(255, 255, 255), 2));
        exportPanel.setBackground(new Color(15, 98, 254));
        exportPanel.setBounds(1334, 139, 141, 42);
        bodyPanel.add(exportPanel);
        exportPanel.setLayout(null);
        
        exporttextlbl = new JLabel("Export");
        exporttextlbl.setForeground(new Color(255, 255, 255));
        exporttextlbl.setFont(new Font("IBM Plex Sans", Font.PLAIN, 15));
        exporttextlbl.setBounds(35, 11, 58, 20);
        exportPanel.add(exporttextlbl);
        
        exportlbl = new JLabel("");
        exportlbl.setIcon(new ImageIcon(FDocumentationPanel.class.getResource("/FdocumentationpanelImg/exporticon.png")));
        exportlbl.setBounds(90, 10, 22, 22);
        exportPanel.add(exportlbl);
        
        filelbl = new JLabel("");
        filelbl.setBounds(1183, 107, 141, 27);
        filelbl.setVisible(false);
        bodyPanel.add(filelbl);
        
        // display panel for img and pdf file 
        
        displayPanel = new JPanel();
        displayPanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
        displayPanel.setBackground(new Color(255, 255, 255));
        displayPanel.setLayout(null);

        scrollPane = new JScrollPane(displayPanel);
        scrollPane.setBounds(48, 198, 1427, 210);
        bodyPanel.add(scrollPane);
        // call method for display the pdf and img in display panel
        loadFilesFromDatabase();
        
         


	}
	
	// Method to load files from the database and display them
    private void loadFilesFromDatabase() {
        try {
            connection = DriverManager.getConnection(url);
            String query = "SELECT pdf, pdfname, img, imgname FROM pdfandimg";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            int x = 0;
            int y = 0;
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.gridx = x;
            gbc.gridy = y;

            while (resultSet.next()) {
                byte[] pdfBytes = resultSet.getBytes("pdf");
                String pdfName = resultSet.getString("pdfname");
                byte[] imgBytes = resultSet.getBytes("img");
                String imgName = resultSet.getString("imgname");

                if (pdfBytes != null && pdfName != null) {
                    JLabel pdfIconLabel = createPdfIconLabel(pdfName);
                    displayPanel.add(pdfIconLabel, gbc);
                    gbc.gridx++;
                    if (gbc.gridx > 3) {
                        gbc.gridx = 0;
                        gbc.gridy++;
                    }
                }
                if (imgBytes != null && imgName != null) {
                    JLabel imgIconLabel = createImageIconLabel(imgName);
                    displayPanel.add(imgIconLabel, gbc);
                    gbc.gridx++;
                    if (gbc.gridx > 3) {
                        gbc.gridx = 0;
                        gbc.gridy++;
                    }
                }
            }

            displayPanel.revalidate();
            displayPanel.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
  
    private JLabel createPdfIconLabel(String pdfName) {
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("C:\\Users\\megel\\eclipse-workspace\\IBMconsulting\\img\\FdocumentationpanelImg\\pdficon.png"));
        label.setText(pdfName);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openPdf(pdfName);
            }
        });
        return label;
    }

    private JLabel createImageIconLabel(String imgName) {
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("C:\\Users\\megel\\eclipse-workspace\\IBMconsulting\\img\\FdocumentationpanelImg\\jpegicon.png"));
        label.setText(imgName);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openImage(imgName);
            }
        });
        return label;
    }
    
    private void openFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            filelbl.setText(selectedFile.getName());
        }
    }
    
    // method to open pdf file 
    private void openPdf(String fileName) {
    	byte[] fileContent = retrieveFileContentFromDatabase(fileName);
    	if(fileContent != null){
    		try {
				File tempFile = File.createTempFile("temp_pdf_", ".pdf");
				try(FileOutputStream fos = new FileOutputStream(tempFile)){
					fos.write(fileContent);
				}
				Desktop.getDesktop().open(tempFile);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error opening PDF file" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
    	}else {
    		JOptionPane.showMessageDialog(null, "File not found: " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
    	}
    }
     

	// method to open image
    private void openImage(String fileName) {
    	byte[] fileContent = retrieveFileContentFromDatabase(fileName);
    	if(fileContent != null) {
    		try {
				File tempFile = File.createTempFile("temp_image_", ".png");
				try(FileOutputStream fos = new FileOutputStream(tempFile)){
					fos.write(fileContent);
				}
				Desktop.getDesktop().open(tempFile);
				} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error opening Image : " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
    	}else {
    		JOptionPane.showMessageDialog(null, "File not found: " + fileName, "Error", JOptionPane.ERROR_MESSAGE);
    	}
    }
    
    private byte[] retrieveFileContentFromDatabase(String fileName) {
    	byte[] fileContent = null;
    	try {
			Connection connection = DriverManager.getConnection(url);
			String query = "SELECT pdf, pdfname, img, imgname FROM pdfandimg WHERE pdfname = ? OR imgname = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, fileName);
			statement.setString(2, fileName);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				if(fileName.equals(resultSet.getString("pdfname"))) {
					fileContent = resultSet.getBytes("pdf");
				}else {
					fileContent = resultSet.getBytes("img");
				}
			}
			
			resultSet.close();
			statement.close();
			connection.close();
			
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
  		return fileContent;
  	}
    
    private void saveFileToDatabase() {
    	if(selectedFile != null && selectedFile.exists()) {
    		try {
				FileInputStream fis = new FileInputStream(selectedFile);
				Connection con = DriverManager.getConnection(url);
				
				String sql;
				if(selectedFile.getName().toLowerCase().endsWith(".pdf") || selectedFile.getName().toLowerCase().endsWith(".docx")) {
					sql = "INSERT INTO pdfandimg (pdf, pdfname) values(?,?)";
				}else if (selectedFile.getName().toLowerCase().endsWith(".jpeg")|| selectedFile.getName().toLowerCase().endsWith(".jpeg") ||selectedFile.getName().toLowerCase().endsWith(".png")) {
					sql = "INSERT INTO pdfandimg (img, imgname) VALUES (?, ?)";
				}else {
					System.out.print("Unsupported file format.");
					JOptionPane.showMessageDialog(null, "Unsupported file format.");
					return;
				}
				
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setBinaryStream(1, fis, (int) selectedFile.length());
				pstmt.setString(2, selectedFile.getName());
				pstmt.executeUpdate();
				
				pstmt.close();
				fis.close();
				con.close();
				
				System.out.println("File saved to Database Successfully.");
				JOptionPane.showMessageDialog(null, "File saved to database successfully");
				displayPanel.removeAll();
				loadFilesFromDatabase();
			} catch (Exception ex) {
				ex.printStackTrace();
			
			}
    	}else {
			System.out.println("No file selected or files does not exist");
			JOptionPane.showMessageDialog(null, "No file selected or files does not exist");
    	}
    }
}

//JLabel pdficonlbl = new JLabel("");
//pdficonlbl.setIcon(new ImageIcon(FDocumentationPanel.class.getResource("/FdocumentationpanelImg/pdficon.png")));
//pdficonlbl.setBounds(81, 41, 66, 78);
//displayPanel.add(pdficonlbl);
//
//JLabel jpgiconlbl = new JLabel("");
//jpgiconlbl.setIcon(new ImageIcon(FDocumentationPanel.class.getResource("/FdocumentationpanelImg/jpegicon.png")));
//jpgiconlbl.setBounds(235, 41, 74, 74);
//displayPanel.add(jpgiconlbl);
//
//JLabel lblNewLabel_2 = new JLabel("contract1.pdf");
//lblNewLabel_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
//lblNewLabel_2.setBounds(65, 130, 116, 20);
//displayPanel.add(lblNewLabel_2);
//
//JLabel lblNewLabel_2_1 = new JLabel("image1.jpeg");
//lblNewLabel_2_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
//lblNewLabel_2_1.setBounds(227, 126, 116, 20);
//displayPanel.add(lblNewLabel_2_1);
//
//JLabel pdficonlbl_1 = new JLabel("");
//pdficonlbl_1.setIcon(new ImageIcon(FDocumentationPanel.class.getResource("/FdocumentationpanelImg/pdficon.png")));
//pdficonlbl_1.setBounds(428, 41, 66, 78);
//displayPanel.add(pdficonlbl_1);
//
//JLabel lblNewLabel_2_2 = new JLabel("contract1.pdf");
//lblNewLabel_2_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
//lblNewLabel_2_2.setBounds(412, 130, 116, 20);
//displayPanel.add(lblNewLabel_2_2);
//
//JLabel lblNewLabel_2_1_1 = new JLabel("image1.jpeg");
//lblNewLabel_2_1_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
//lblNewLabel_2_1_1.setBounds(574, 126, 116, 20);
//displayPanel.add(lblNewLabel_2_1_1);
//
//JLabel jpgiconlbl_1 = new JLabel("");
//jpgiconlbl_1.setIcon(new ImageIcon(FDocumentationPanel.class.getResource("/FdocumentationpanelImg/jpegicon.png")));
//jpgiconlbl_1.setBounds(582, 41, 74, 74);
//displayPanel.add(jpgiconlbl_1);
//
//JLabel pdficonlbl_2 = new JLabel("");
//pdficonlbl_2.setIcon(new ImageIcon(FDocumentationPanel.class.getResource("/FdocumentationpanelImg/pdficon.png")));
//pdficonlbl_2.setBounds(744, 41, 66, 78);
//displayPanel.add(pdficonlbl_2);
//
//JLabel lblNewLabel_2_3 = new JLabel("contract1.pdf");
//lblNewLabel_2_3.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
//lblNewLabel_2_3.setBounds(728, 130, 116, 20);
//displayPanel.add(lblNewLabel_2_3);
//
//JLabel lblNewLabel_2_1_2 = new JLabel("image1.jpeg");
//lblNewLabel_2_1_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
//lblNewLabel_2_1_2.setBounds(890, 126, 116, 20);
//displayPanel.add(lblNewLabel_2_1_2);
//
//JLabel jpgiconlbl_2 = new JLabel("");
//jpgiconlbl_2.setIcon(new ImageIcon(FDocumentationPanel.class.getResource("/FdocumentationpanelImg/jpegicon.png")));
//jpgiconlbl_2.setBounds(898, 41, 74, 74);
//displayPanel.add(jpgiconlbl_2);
//
//JLabel pdficonlbl_3 = new JLabel("");
//pdficonlbl_3.setIcon(new ImageIcon(FDocumentationPanel.class.getResource("/FdocumentationpanelImg/pdficon.png")));
//pdficonlbl_3.setBounds(1080, 41, 66, 78);
//displayPanel.add(pdficonlbl_3);
//
//JLabel lblNewLabel_2_4 = new JLabel("contract1.pdf");
//lblNewLabel_2_4.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
//lblNewLabel_2_4.setBounds(1064, 130, 116, 20);
//displayPanel.add(lblNewLabel_2_4);
//
//JLabel lblNewLabel_2_1_3 = new JLabel("image1.jpeg");
//lblNewLabel_2_1_3.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
//lblNewLabel_2_1_3.setBounds(1226, 126, 116, 20);
//displayPanel.add(lblNewLabel_2_1_3);
//
//JLabel jpgiconlbl_3 = new JLabel("");
//jpgiconlbl_3.setIcon(new ImageIcon(FDocumentationPanel.class.getResource("/FdocumentationpanelImg/jpegicon.png")));
//jpgiconlbl_3.setBounds(1234, 41, 74, 74);
//displayPanel.add(jpgiconlbl_3);
