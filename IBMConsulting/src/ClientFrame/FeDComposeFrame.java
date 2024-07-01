package ClientFrame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import ConsultantFrame.FBComposeFrame;

public class FeDComposeFrame extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField toTextField;
    private JTextField subjecttextField;  
    private JLabel filelbl;    
    private JLabel iconLbl;
    private JTextPane textPane;
    private File selectedFile;  
    

    private String senderEmail;  
    
    private ImageIcon pdfIcon = new ImageIcon(
            new ImageIcon("C:\\Users\\MOMSIE BETSKIE\\eclipse-workspace\\IBMconsulting\\IBMconsulting\\img\\FdocumentationpanelImg\\pdficon.png")
                .getImage().getScaledInstance(80, 73, Image.SCALE_DEFAULT));

    static final String dbURL = "jdbc:sqlserver://LAPTOP-C5593DBG\\SQLEXPRESS;databaseName=IBMDatabase;integratedSecurity=true;encrypt=false;";
    static String email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeDComposeFrame frame = new FeDComposeFrame(email);
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
	public FeDComposeFrame(String email) {
		this.senderEmail = email;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(1019, 412, 634, 543);
        setBackground(new Color(255,255,255));
        setUndecorated(true);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel composePanel = new JPanel();
        composePanel.setBackground(new Color(255, 255, 255));
        composePanel.setBounds(0, 0, 634, 543);
        contentPane.add(composePanel);
        composePanel.setLayout(null);
        
        JPanel headPanel = new JPanel();
        headPanel.setBackground(new Color(255, 255, 255));
        headPanel.setBorder(new MatteBorder(2, 2, 2, 0, (Color) new Color(190, 190, 190)));
        headPanel.setBounds(0, 0, 634, 54);
        composePanel.add(headPanel);
        headPanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("File Upload");
        lblNewLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 24));
        lblNewLabel.setBounds(20, 11, 125, 31);
        headPanel.add(lblNewLabel);
        
        JPanel minimezePanel = new JPanel();
        minimezePanel.addMouseListener(new PanelButtonMouseAdapter(minimezePanel) {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		dispose();
        	}
        });
        minimezePanel.setLayout(null);
        minimezePanel.setBackground(Color.WHITE);
        minimezePanel.setBounds(570, 12, 39, 30);
        headPanel.add(minimezePanel);
        
        JLabel minimizeiconlbl = new JLabel("");
        minimizeiconlbl.setIcon(new ImageIcon(FBComposeFrame.class.getResource("/CschedulepanelImg/window-minimize (1).png")));
        minimizeiconlbl.setBounds(8, 3, 25, 22);
        minimezePanel.add(minimizeiconlbl);
        
        JPanel bodyPanel = new JPanel();
        bodyPanel.setBorder(new MatteBorder(2, 2, 2, 0, (Color) new Color(190, 190, 190)));
        bodyPanel.setBackground(new Color(255, 255, 255));
        bodyPanel.setBounds(0, 52, 634, 491);
        composePanel.add(bodyPanel);
        bodyPanel.setLayout(null);
        
        JLabel totxtlb = new JLabel("To");
        totxtlb.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        totxtlb.setBounds(10, 21, 51, 20);
        bodyPanel.add(totxtlb);
        
        JLabel subjecttxtlbl = new JLabel("Subject");
        subjecttxtlbl.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
        subjecttxtlbl.setBounds(10, 71, 66, 20);
        bodyPanel.add(subjecttxtlbl);
        
        toTextField = new JTextField();
        toTextField.setBounds(85, 11, 521, 42);
        bodyPanel.add(toTextField);
        toTextField.setColumns(10);
        
        subjecttextField = new JTextField();
        subjecttextField.setColumns(10);
        subjecttextField.setBounds(85, 62, 521, 42);
        bodyPanel.add(subjecttextField);
        
        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(192, 192, 192)));
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 150, 614, 278);
        bodyPanel.add(panel);
        panel.setLayout(null);
        
        JPanel uploadPanel = new JPanel();
        uploadPanel.setBackground(new Color(0, 0, 255));
        uploadPanel.setBounds(482, 439, 142, 41);
        bodyPanel.add(uploadPanel);
        uploadPanel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("Upload");
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("IBM Plex Sans", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(48, 11, 73, 19);
        uploadPanel.add(lblNewLabel_1);
        
        uploadPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                uploadFile();
            }
        });
        
        JLabel lblNewLabel_2 = new JLabel("you can only upload");
        lblNewLabel_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 12));
        lblNewLabel_2.setBounds(10, 125, 111, 14);
        bodyPanel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel(".pdf, .docx, .jpeg, .jpg\r\n");
        lblNewLabel_3.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 12));
        lblNewLabel_3.setForeground(new Color(0, 0, 255));
        lblNewLabel_3.setBounds(120, 125, 135, 14);
        bodyPanel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("and");
        lblNewLabel_4.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 12));
        lblNewLabel_4.setBounds(240, 125, 46, 14);
        bodyPanel.add(lblNewLabel_4);
        
        JLabel lblNewLabel_4_1 = new JLabel(".png files");
        lblNewLabel_4_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 12));
        lblNewLabel_4_1.setForeground(new Color(0, 0, 255));
        lblNewLabel_4_1.setBounds(265, 125, 58, 14);
        bodyPanel.add(lblNewLabel_4_1);
        
        JPanel editPanel = new JPanel();
        editPanel.addMouseListener(new PanelButtonMouseAdapter(editPanel) {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	}
        });
        editPanel.setBackground(new Color(255, 255, 255));
        editPanel.setBounds(510, 115, 32, 31);
        bodyPanel.add(editPanel);
        editPanel.setLayout(null);
        
        JLabel edittxtlbl = new JLabel("");
        edittxtlbl.setIcon(new ImageIcon(FBComposeFrame.class.getResource("/FdocumentationpanelImg/editicon.png")));
        edittxtlbl.setBounds(0, 0, 32, 31);
        editPanel.add(edittxtlbl);
        
        JPanel deletepanel = new JPanel();
        deletepanel.addMouseListener(new PanelButtonMouseAdapter(deletepanel) {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	}
        });
        deletepanel.setLayout(null);
        deletepanel.setBackground(Color.WHITE);
        deletepanel.setBounds(590, 114, 32, 31);
        bodyPanel.add(deletepanel);
        
        JLabel edittxtlbl_1 = new JLabel("");
        edittxtlbl_1.setIcon(new ImageIcon(FBComposeFrame.class.getResource("/FdocumentationpanelImg/edeleteicon.png")));
        edittxtlbl_1.setBounds(0, 0, 40, 31);
        deletepanel.add(edittxtlbl_1);
        
        JPanel editPanel_2 = new JPanel();
        editPanel_2.addMouseListener(new PanelButtonMouseAdapter(editPanel_2) {
            @Override
            public void mouseClicked(MouseEvent e) {
                openFileChooser();
            }
        });
        editPanel_2.setLayout(null);
        editPanel_2.setBackground(Color.WHITE);
        editPanel_2.setBounds(550, 115, 32, 31);
        bodyPanel.add(editPanel_2);
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon(FBComposeFrame.class.getResource("/FdocumentationpanelImg/ping2.png")));
        lblNewLabel_5.setBounds(5, 0, 22, 31);
        editPanel_2.add(lblNewLabel_5);
        
        filelbl = new JLabel("");
        filelbl.setBounds(10, 242, 136, 25);
        panel.add(filelbl);
        
        iconLbl = new JLabel("");
        iconLbl.setBounds(34, 167, 80, 73);
        panel.add(iconLbl);
        
        textPane = new JTextPane();
        textPane.setBounds(10, 11, 594, 114);
        panel.add(textPane);
    }
    
    private void openFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getName();
            ImageIcon fileIcon = null;

            if (fileName.endsWith(".pdf")) {
                fileIcon = pdfIcon;
            } else if (fileName.endsWith(".docx")) {
                fileIcon = pdfIcon;
            } // Add more conditions for other file types if needed
            
            // else-if for icon change if pdf or img
            if (fileIcon != null) {
                iconLbl.setIcon(fileIcon);
                filelbl.setText(fileName);
            } else {
                filelbl.setText(fileName);
            }
        }
    }
    // method for save date from data base
    private void uploadFile() {
        String recipientEmail = toTextField.getText();
        String subject = subjecttextField.getText();
        String docuText = textPane.getText();
        
        if (selectedFile != null) {
            try (Connection connection = DriverManager.getConnection(dbURL)) {
                String sql = "INSERT INTO Documentation (docu_sender_email, docu_recipient_email, docu_filename, docu_file, docu_date, docu_text) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, senderEmail);
                    statement.setString(2, recipientEmail);
                    statement.setString(3, selectedFile.getName());
                    statement.setBinaryStream(4, new FileInputStream(selectedFile));
                    statement.setDate(5, new Date(System.currentTimeMillis()));
                    statement.setString(6, docuText);
                    int rowsAffected = statement.executeUpdate();
                    
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "File sent successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("Documentation Successfully Send");
                        dispose(); // Close the current frame
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to send file. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException | FileNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a file to send.", "No File Selected", JOptionPane.WARNING_MESSAGE);
        }
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


