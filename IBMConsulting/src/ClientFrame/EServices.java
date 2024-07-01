package ClientFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EServices extends JPanel {

	private static final long serialVersionUID = 1L;
	static String senderEmail;
	

	/**
	 * Create the panel.
	 */
	public EServices(String email) {
		this.senderEmail=email;
		setBounds(0, 0, 1570, 877);
        setLayout(null);
        setOpaque(false);

        JPanel bodyPanel = new JPanel();
        bodyPanel.setBounds(0,0,1573,907);
        add(bodyPanel);
		bodyPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(0, 0, 1566, 907);
	    scrollPane.setBackground(new Color(225, 254, 253));
	    bodyPanel.add(scrollPane);
	    
	    JPanel scrollContent = new JPanel();
	    scrollContent.setBackground(new Color(255, 255, 255));
	    scrollContent.setPreferredSize(new Dimension(1001, 1400)); // increase the size of the panel to fit all 9 labels
	    scrollPane.setViewportView(scrollContent);
	    scrollContent.setLayout(null);

//===================================================================    
	    
	    JPanel head1panel = new JPanel();
	    head1panel.setBackground(new Color(255, 255, 255));
	    head1panel.setBounds(0, 0, 1537, 71);
	    scrollContent.add(head1panel);
	    head1panel.setLayout(null);
	    
	    JLabel lblNewLabel = new JLabel("Services");
		lblNewLabel.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 36));
		lblNewLabel.setBounds(48, 11, 180, 47);
		head1panel.add(lblNewLabel);
		
//===================================================================   
		
		JPanel body1panel = new JPanel();
		body1panel.setBackground(new Color(255, 255, 255));
		body1panel.setBounds(0, 72, 1537, 760);
		scrollContent.add(body1panel);
		body1panel.setLayout(null); 
		
		JLabel lblNewLabel_1 = new JLabel("Technology");
		lblNewLabel_1.setForeground(new Color(15, 98, 254));
		lblNewLabel_1.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(51, 11, 176, 33);
		body1panel.add(lblNewLabel_1);
		
		JPanel aipanel = new JPanel();
		aipanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		aipanel.setBackground(new Color(255, 255, 255));
		aipanel.setBounds(51, 55, 350, 210);
		body1panel.add(aipanel);
		aipanel.setLayout(null);
		
		JLabel aiIcon = new JLabel();
		aiIcon.setIcon(new ImageIcon(EServices.class.getResource("/MykieImga/hugeicons_artificial-intelligence-01.png")));
//		aiIcon.setIcon(new ImageIcon(EServices.class.getResource("hugeicons_artificial-intelligence-01.png")));
		aiIcon.setBounds(289, 25, 40, 40);
		aipanel.add(aiIcon);

//===================================================================    		
		
		JLabel artificiallbl = new JLabel("Artifical");
		artificiallbl.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 30));
		artificiallbl.setBounds(28, 13, 249, 40);
		aipanel.add(artificiallbl);
		
		JLabel intelegencelbl = new JLabel("Intellingence");
		intelegencelbl.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 30));
		intelegencelbl.setBounds(28, 50, 249, 40);
		aipanel.add(intelegencelbl);
		
		JLabel lblNewLabel_4 = new JLabel("Create intelligent workflows that utilize");
		lblNewLabel_4.setForeground(new Color(125, 125, 125));
		lblNewLabel_4.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(27, 97, 302, 23);
		aipanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("AI, data and analytics and turn AI ");
		lblNewLabel_4_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(27, 124, 302, 23);
		aipanel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("aspirations into tangible business ");
		lblNewLabel_4_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2.setBounds(27, 148, 302, 23);
		aipanel.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("outcomes");
		lblNewLabel_4_2_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_1.setBounds(27, 174, 302, 23);
		aipanel.add(lblNewLabel_4_2_1);
		
//===================================================================    		
		
		JPanel blockchainpanel = new JPanel();
		blockchainpanel.setLayout(null);
		blockchainpanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		blockchainpanel.setBackground(Color.WHITE);
		blockchainpanel.setBounds(411, 55, 350, 210);
		body1panel.add(blockchainpanel);
		
		JLabel blockchainIcon = new JLabel();
		blockchainIcon.setIcon(new ImageIcon(EServices.class.getResource("/MykieImga/eos-icons_blockchain.png")));
//		blockchainIcon.setIcon(new ImageIcon(EServices.class.getResource("eos-icons_blockchain.png")));
		blockchainIcon.setBounds(289, 25, 40, 40);
		blockchainpanel.add(blockchainIcon);
		
		JLabel blockchainlbl = new JLabel("Blockchain");
		blockchainlbl.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 30));
		blockchainlbl.setBounds(28, 33, 249, 39);
		blockchainpanel.add(blockchainlbl);
		
		JLabel lblNewLabel_4_3 = new JLabel("Tap into proven design methodologies and");
		lblNewLabel_4_3.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_3.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_3.setBounds(28, 109, 302, 23);
		blockchainpanel.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("composable capabilities that can ");
		lblNewLabel_4_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_1.setBounds(28, 132, 302, 23);
		blockchainpanel.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_2_2 = new JLabel("accelerate positive business outcomes.");
		lblNewLabel_4_2_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_2.setBounds(28, 154, 302, 23);
		blockchainpanel.add(lblNewLabel_4_2_2);

//===================================================================   
		
		JPanel cloudcomputingpanel = new JPanel();
		cloudcomputingpanel.setLayout(null);
		cloudcomputingpanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		cloudcomputingpanel.setBackground(Color.WHITE);
		cloudcomputingpanel.setBounds(771, 55, 350, 210);
		body1panel.add(cloudcomputingpanel);
		
		JLabel cloudcomputingicon = new JLabel();
		cloudcomputingicon.setIcon(new ImageIcon(EServices.class.getResource("/MykieImga/Vector (4).png")));
//		cloudcomputingicon.setIcon(new ImageIcon(EServices.class.getResource("Vector (4).png")));
		cloudcomputingicon.setBounds(284, 25, 45, 40);
		cloudcomputingpanel.add(cloudcomputingicon);
		
		JLabel cloudlbl = new JLabel("Cloud");
		cloudlbl.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 30));
		cloudlbl.setBounds(28, 13, 249, 40);
		cloudcomputingpanel.add(cloudlbl);
		
		JLabel computingll = new JLabel("Computing");
		computingll.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 30));
		computingll.setBounds(28, 53, 249, 40);
		cloudcomputingpanel.add(computingll);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Leverage hybrid, open and managed cloud");
		lblNewLabel_4_1_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_2.setBounds(28, 109, 302, 23);
		cloudcomputingpanel.add(lblNewLabel_4_1_2);
		
		JLabel lblNewLabel_4_2_3 = new JLabel("services across multiple security-rich ");
		lblNewLabel_4_2_3.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_3.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_3.setBounds(28, 132, 302, 23);
		cloudcomputingpanel.add(lblNewLabel_4_2_3);
		
		JLabel lblNewLabel_4_2_1_2 = new JLabel("cloud environments");
		lblNewLabel_4_2_1_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_1_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_1_2.setBounds(28, 154, 302, 23);
		cloudcomputingpanel.add(lblNewLabel_4_2_1_2);
		
//===================================================================   
		
		JPanel hybridcloudPanel = new JPanel();
		hybridcloudPanel.setLayout(null);
		hybridcloudPanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		hybridcloudPanel.setBackground(Color.WHITE);
		hybridcloudPanel.setBounds(1131, 55, 350, 210);
		body1panel.add(hybridcloudPanel);
		
		JLabel hybridcloudicon = new JLabel();
		hybridcloudicon.setIcon(new ImageIcon(EServices.class.getResource("/MykieImga/carbon_ibm-cloud-direct-link-2-connect.png")));
//		hybridcloudicon.setIcon(new ImageIcon(EServices.class.getResource("carbon_ibm-cloud-direct-link-2-connect.png")));
		hybridcloudicon.setBounds(289, 25, 40, 40);
		hybridcloudPanel.add(hybridcloudicon);
		
		JLabel lblNewLabel_4_5 = new JLabel("continuously modernize your applications ");
		lblNewLabel_4_5.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_5.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_5.setBounds(28, 129, 302, 23);
		hybridcloudPanel.add(lblNewLabel_4_5);
		
		JLabel lblNewLabel_4_1_3 = new JLabel("on any platform using a hybrid cloud ");
		lblNewLabel_4_1_3.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_3.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_3.setBounds(28, 152, 302, 23);
		hybridcloudPanel.add(lblNewLabel_4_1_3);
		
		JLabel lblNewLabel_4_2_4 = new JLabel("approach");
		lblNewLabel_4_2_4.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_4.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_4.setBounds(28, 174, 302, 23);
		hybridcloudPanel.add(lblNewLabel_4_2_4);
		
		JLabel hybridcloudlb = new JLabel("Hybrid Cloud");
		hybridcloudlb.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 30));
		hybridcloudlb.setBounds(28, 34, 249, 39);
		hybridcloudPanel.add(hybridcloudlb);
		
		JLabel lblNewLabel_4_5_1 = new JLabel("Accelerate business agility and growth—");
		lblNewLabel_4_5_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_5_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_5_1.setBounds(28, 107, 302, 23);
		hybridcloudPanel.add(lblNewLabel_4_5_1);
	
//===================================================================   
		
		JPanel appservicepanel = new JPanel();
		appservicepanel.setLayout(null);
		appservicepanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		appservicepanel.setBackground(Color.WHITE);
		appservicepanel.setBounds(51, 301, 350, 210);
		body1panel.add(appservicepanel);
		
		JLabel aiIcon_1 = new JLabel();
		aiIcon_1.setIcon(new ImageIcon(EServices.class.getResource("/MykieImga/Vector (5).png")));
//		aiIcon_1.setIcon(new ImageIcon(EServices.class.getResource("Vector (5).png")));
		aiIcon_1.setBounds(292, 25, 35, 40);
		appservicepanel.add(aiIcon_1);
		
		JLabel lblApplication = new JLabel("Application");
		lblApplication.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 30));
		lblApplication.setBounds(28, 11, 249, 40);
		appservicepanel.add(lblApplication);
		
		JLabel lblServices = new JLabel("Services");
		lblServices.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 30));
		lblServices.setBounds(28, 51, 249, 40);
		appservicepanel.add(lblServices);
		
		JLabel lblNewLabel_4_6 = new JLabel("Boost your cloud investment by ");
		lblNewLabel_4_6.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_6.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_6.setBounds(28, 102, 302, 23);
		appservicepanel.add(lblNewLabel_4_6);
		
		JLabel lblNewLabel_4_1_4 = new JLabel("transforming the way you manage ");
		lblNewLabel_4_1_4.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_4.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_4.setBounds(28, 125, 302, 23);
		appservicepanel.add(lblNewLabel_4_1_4);
		
		JLabel lblNewLabel_4_2_5 = new JLabel("applications.");
		lblNewLabel_4_2_5.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_5.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_5.setBounds(28, 149, 302, 23);
		appservicepanel.add(lblNewLabel_4_2_5);
				
//===================================================================   		
		
		JPanel cybersecpanel = new JPanel();
		cybersecpanel.setLayout(null);
		cybersecpanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		cybersecpanel.setBackground(Color.WHITE);
		cybersecpanel.setBounds(411, 301, 350, 210);
		body1panel.add(cybersecpanel);
		
		JLabel blockchainIcon_1 = new JLabel();
		blockchainIcon_1.setIcon(new ImageIcon(EServices.class.getResource("/MykieImga/Group (2).png")));
//		blockchainIcon_1.setIcon(new ImageIcon(EServices.class.getResource("Group (2).png")));
		blockchainIcon_1.setBounds(292, 25, 38, 40);
		cybersecpanel.add(blockchainIcon_1);
		
		JLabel lblCybersecurity = new JLabel("Cybersecurity");
		lblCybersecurity.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 30));
		lblCybersecurity.setBounds(28, 35, 249, 39);
		cybersecpanel.add(lblCybersecurity);
		
		JLabel lblNewLabel_4_5_2 = new JLabel("Transform your business and manage risk ");
		lblNewLabel_4_5_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_5_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_5_2.setBounds(28, 96, 302, 23);
		cybersecpanel.add(lblNewLabel_4_5_2);
		
		JLabel lblNewLabel_4_1_3_2 = new JLabel("with a global industry leader in ");
		lblNewLabel_4_1_3_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_3_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_3_2.setBounds(28, 119, 302, 23);
		cybersecpanel.add(lblNewLabel_4_1_3_2);
		
		JLabel lblNewLabel_4_2_4_2 = new JLabel("cybersecurity consulting, cloud and ");
		lblNewLabel_4_2_4_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_4_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_4_2.setBounds(28, 141, 302, 23);
		cybersecpanel.add(lblNewLabel_4_2_4_2);
		
		JLabel lblNewLabel_4_2_4_2_2 = new JLabel("managed-security services.");
		lblNewLabel_4_2_4_2_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_4_2_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_4_2_2.setBounds(28, 164, 302, 23);
		cybersecpanel.add(lblNewLabel_4_2_4_2_2);
		
//===================================================================   		
		
		JPanel itstructurepanel = new JPanel();
		itstructurepanel.setLayout(null);
		itstructurepanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		itstructurepanel.setBackground(Color.WHITE);
		itstructurepanel.setBounds(771, 301, 350, 210);
		body1panel.add(itstructurepanel);
		
		JLabel cloudcomputingicon_1 = new JLabel();
		cloudcomputingicon_1.setIcon(new ImageIcon(EServices.class.getResource("/MykieImga/teenyicons_computer-outline.png")));
//		cloudcomputingicon_1.setIcon(new ImageIcon(EServices.class.getResource("teenyicons_computer-outline.png")));
		cloudcomputingicon_1.setBounds(289, 25, 40, 40);
		itstructurepanel.add(cloudcomputingicon_1);
		
		JLabel hybridcloudlb_1_2 = new JLabel("IT Infrastructure");
		hybridcloudlb_1_2.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 30));
		hybridcloudlb_1_2.setBounds(28, 36, 249, 39);
		itstructurepanel.add(hybridcloudlb_1_2);
		
		JLabel lblNewLabel_4_1_3_2_1 = new JLabel("competitors to constant change. Perhaps");
		lblNewLabel_4_1_3_2_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_3_2_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_3_2_1.setBounds(28, 109, 302, 23);
		itstructurepanel.add(lblNewLabel_4_1_3_2_1);
		
		JLabel lblNewLabel_4_5_2_1 = new JLabel("Businesses face myriad challenges—from");
		lblNewLabel_4_5_2_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_5_2_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_5_2_1.setBounds(28, 86, 302, 23);
		itstructurepanel.add(lblNewLabel_4_5_2_1);
		
		JLabel lblNewLabel_4_2_4_2_1 = new JLabel("the biggest challenge is exploiting the ");
		lblNewLabel_4_2_4_2_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_4_2_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_4_2_1.setBounds(28, 130, 302, 23);
		itstructurepanel.add(lblNewLabel_4_2_4_2_1);
		
		JLabel lblNewLabel_4_2_4_2_1_1 = new JLabel("ever-expanding range of technologies ");
		lblNewLabel_4_2_4_2_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_4_2_1_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_4_2_1_1.setBounds(28, 152, 302, 23);
		itstructurepanel.add(lblNewLabel_4_2_4_2_1_1);
		
		JLabel lblNewLabel_4_2_4_2_1_1_1 = new JLabel("promising innovation.");
		lblNewLabel_4_2_4_2_1_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_4_2_1_1_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_4_2_1_1_1.setBounds(28, 176, 302, 23);
		itstructurepanel.add(lblNewLabel_4_2_4_2_1_1_1);
			
//===================================================================   		
		
		JPanel analysispanel = new JPanel();
		analysispanel.setLayout(null);
		analysispanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		analysispanel.setBackground(Color.WHITE);
		analysispanel.setBounds(1131, 301, 350, 210);
		body1panel.add(analysispanel);
		
		JLabel hybridcloudicon_1 = new JLabel();
		hybridcloudicon_1.setIcon(new ImageIcon(EServices.class.getResource("/MykieImga/Group 67.png")));
//		hybridcloudicon_1.setIcon(new ImageIcon(EServices.class.getResource("Group 67.png")));
		hybridcloudicon_1.setBounds(280, 25, 50, 40);
		analysispanel.add(hybridcloudicon_1);
		
		JLabel lblAnalytics = new JLabel("Analytics");
		lblAnalytics.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 30));
		lblAnalytics.setBounds(28, 38, 249, 39);
		analysispanel.add(lblAnalytics);
		
		JLabel lblNewLabel_4_1_2_1 = new JLabel("Unlock the strategic value of enterprise");
		lblNewLabel_4_1_2_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_2_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_2_1.setBounds(28, 104, 302, 23);
		analysispanel.add(lblNewLabel_4_1_2_1);
		
		JLabel lblNewLabel_4_2_3_1 = new JLabel("data and build an insight-driven");
		lblNewLabel_4_2_3_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_3_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_3_1.setBounds(28, 125, 302, 23);
		analysispanel.add(lblNewLabel_4_2_3_1);
		
		JLabel lblNewLabel_4_2_1_2_1 = new JLabel("organization.");
		lblNewLabel_4_2_1_2_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_1_2_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_1_2_1.setBounds(28, 148, 302, 23);
		analysispanel.add(lblNewLabel_4_2_1_2_1);
				
//===================================================================   		
		
		JPanel ecommpanel = new JPanel();
		ecommpanel.setLayout(null);
		ecommpanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		ecommpanel.setBackground(Color.WHITE);
		ecommpanel.setBounds(51, 541, 350, 210);
		body1panel.add(ecommpanel);
		
		JLabel hybridcloudicon_1_1 = new JLabel();
		hybridcloudicon_1_1.setIcon(new ImageIcon(EServices.class.getResource("/MykieImga/lucide_briefcase-business.png")));
//		hybridcloudicon_1_1.setIcon(new ImageIcon(EServices.class.getResource("lucide_briefcase-business.png")));
		hybridcloudicon_1_1.setBounds(289, 25, 40, 40);
		ecommpanel.add(hybridcloudicon_1_1);
		
		JLabel hybridcloudlb_1_1 = new JLabel("E-commerce");
		hybridcloudlb_1_1.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 30));
		hybridcloudlb_1_1.setBounds(28, 36, 249, 39);
		ecommpanel.add(hybridcloudlb_1_1);
		
		JLabel lblNewLabel_4_2_3_1_1 = new JLabel("experiences built on a seamless, industry-");
		lblNewLabel_4_2_3_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_3_1_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_3_1_1.setBounds(28, 125, 302, 23);
		ecommpanel.add(lblNewLabel_4_2_3_1_1);
		
		JLabel lblNewLabel_4_2_1_2_1_2 = new JLabel("specific e-commerce platform.");
		lblNewLabel_4_2_1_2_1_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_1_2_1_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_1_2_1_2.setBounds(28, 146, 302, 23);
		ecommpanel.add(lblNewLabel_4_2_1_2_1_2);
		
		JLabel lblNewLabel_4_1_2_1_1 = new JLabel("Engineer personalized customer ");
		lblNewLabel_4_1_2_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_2_1_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_2_1_1.setBounds(28, 105, 302, 23);
		ecommpanel.add(lblNewLabel_4_1_2_1_1);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CAInquiryFrame ea = new CAInquiryFrame(email);
				ea.setVisible(true);
			}
		});
		panel.setBackground(new Color(0, 0, 255));
		panel.setBounds(1303, 11, 176, 33);
		body1panel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Avail Service");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("IBM Plex Sans", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(23, 0, 143, 33);
		panel.add(lblNewLabel_2);
				
//===================================================================   		
		
		JPanel body2panel = new JPanel();
		body2panel.setBackground(new Color(255, 255, 255));
		body2panel.setBounds(0, 830, 1537, 526);
		scrollContent.add(body2panel);
		body2panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Business Needs");
		lblNewLabel_1_1.setForeground(new Color(15, 98, 254));
		lblNewLabel_1_1.setFont(new Font("IBM Plex Sans Medium", Font.PLAIN, 25));
		lblNewLabel_1_1.setBounds(52, 11, 264, 33);
		body2panel.add(lblNewLabel_1_1);
		
		JPanel operationpanel = new JPanel();
		operationpanel.setLayout(null);
		operationpanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		operationpanel.setBackground(Color.WHITE);
		operationpanel.setBounds(49, 55, 350, 210);
		body2panel.add(operationpanel);
		
		JLabel operationiconlbl = new JLabel();
		operationiconlbl.setIcon(new ImageIcon(EServices.class.getResource("/MykieImga/carbon_operations-field.png")));
//		operationiconlbl.setIcon(new ImageIcon(EServices.class.getResource("carbon_operations-field.png")));
		operationiconlbl.setBounds(289, 25, 40, 40);
		operationpanel.add(operationiconlbl);
		
		JLabel lblNewLabel_4_2_6 = new JLabel("Transform business operations at speed ");
		lblNewLabel_4_2_6.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_6.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_6.setBounds(28, 114, 302, 23);
		operationpanel.add(lblNewLabel_4_2_6);
		
		JLabel lblNewLabel_4_2_1_4 = new JLabel("and scale for growth, resilience and ");
		lblNewLabel_4_2_1_4.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_1_4.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_1_4.setBounds(28, 138, 302, 23);
		operationpanel.add(lblNewLabel_4_2_1_4);
		
		JLabel operatioblbl = new JLabel("Operations");
		operatioblbl.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		operatioblbl.setBounds(28, 38, 249, 39);
		operationpanel.add(operatioblbl);
		
		JLabel lblNewLabel_4_2_1_4_2 = new JLabel("competitive advantage.");
		lblNewLabel_4_2_1_4_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_1_4_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_1_4_2.setBounds(28, 162, 302, 23);
		operationpanel.add(lblNewLabel_4_2_1_4_2);
		
//===================================================================   		
		
		JPanel marketingpanel = new JPanel();
		marketingpanel.setLayout(null);
		marketingpanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		marketingpanel.setBackground(Color.WHITE);
		marketingpanel.setBounds(769, 55, 350, 210);
		body2panel.add(marketingpanel);
		
		JLabel marketingiconlbl = new JLabel();
		marketingiconlbl.setIcon(new ImageIcon(EServices.class.getResource("/MykieImga/nimbus_marketing.png")));
//		marketingiconlbl.setIcon(new ImageIcon(EServices.class.getResource("nimbus_marketing.png")));
		marketingiconlbl.setBounds(289, 25, 40, 40);
		marketingpanel.add(marketingiconlbl);
		
		JLabel hybridcloudlb_1_3 = new JLabel("Marketing");
		hybridcloudlb_1_3.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		hybridcloudlb_1_3.setBounds(28, 37, 249, 39);
		marketingpanel.add(hybridcloudlb_1_3);
		
		JLabel lblNewLabel_4_3_1_2 = new JLabel("that drives actions throughout the ");
		lblNewLabel_4_3_1_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_3_1_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_3_1_2.setBounds(28, 103, 302, 23);
		marketingpanel.add(lblNewLabel_4_3_1_2);
		
		JLabel lblNewLabel_4_1_1_1_2 = new JLabel("customer journey to deepen your ");
		lblNewLabel_4_1_1_1_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_1_1_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_1_1_2.setBounds(28, 126, 302, 23);
		marketingpanel.add(lblNewLabel_4_1_1_1_2);
		
		JLabel lblNewLabel_4_2_2_1_2 = new JLabel("customer engagement, and increase ");
		lblNewLabel_4_2_2_1_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_2_1_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_2_1_2.setBounds(28, 148, 302, 23);
		marketingpanel.add(lblNewLabel_4_2_2_1_2);
		
		JLabel lblNewLabel_4_2_2_1_2_1 = new JLabel("spend and loyalty.");
		lblNewLabel_4_2_2_1_2_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_2_1_2_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_2_1_2_1.setBounds(28, 170, 302, 23);
		marketingpanel.add(lblNewLabel_4_2_2_1_2_1);
		
		JLabel lblNewLabel_4_3_1_2_1 = new JLabel("Execute an end-to-end marketing strategy");
		lblNewLabel_4_3_1_2_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_3_1_2_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_3_1_2_1.setBounds(28, 80, 302, 23);
		marketingpanel.add(lblNewLabel_4_3_1_2_1);
		
//===================================================================   
		
		JPanel financepanel = new JPanel();
		financepanel.setLayout(null);
		financepanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		financepanel.setBackground(Color.WHITE);
		financepanel.setBounds(1129, 55, 350, 210);
		body2panel.add(financepanel);
		
		JLabel financeiconlbl = new JLabel();
//		financeiconlbl.setIcon(new ImageIcon(EServices.class.getResource("Group (3).png")));
		financeiconlbl.setBounds(289, 25, 40, 40);
		financepanel.add(financeiconlbl);
		
		JLabel hybridcloudlb_1 = new JLabel("Finance");
		hybridcloudlb_1.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		hybridcloudlb_1.setBounds(28, 35, 249, 39);
		financepanel.add(hybridcloudlb_1);
		
		JLabel lblNewLabel_4_3_1_1_1 = new JLabel("Leverage the right combination of people, ");
		lblNewLabel_4_3_1_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_3_1_1_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_3_1_1_1.setBounds(28, 92, 302, 23);
		financepanel.add(lblNewLabel_4_3_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("process and technology to transform your");
		lblNewLabel_4_1_1_1_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_1_1_1_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_1_1_1_1.setBounds(28, 115, 302, 23);
		financepanel.add(lblNewLabel_4_1_1_1_1_1);
		
		JLabel lblNewLabel_4_2_2_1_1_1 = new JLabel("finance function and discover new ways of");
		lblNewLabel_4_2_2_1_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_2_1_1_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_2_1_1_1.setBounds(28, 140, 302, 23);
		financepanel.add(lblNewLabel_4_2_2_1_1_1);
		
		JLabel lblGrowthWith = new JLabel("working.");
		lblGrowthWith.setForeground(new Color(125, 125, 125));
		lblGrowthWith.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblGrowthWith.setBounds(28, 165, 302, 23);
		financepanel.add(lblGrowthWith);
				
//===================================================================   		
		
		JPanel customerpanel = new JPanel();
		customerpanel.setLayout(null);
		customerpanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		customerpanel.setBackground(Color.WHITE);
		customerpanel.setBounds(409, 55, 350, 210);
		body2panel.add(customerpanel);
		
		JLabel marketiconlbl = new JLabel();
		marketiconlbl.setIcon(new ImageIcon(EServices.class.getResource("/MykieImga/carbon_customer.png")));
//		marketiconlbl.setIcon(new ImageIcon(EServices.class.getResource("carbon_customer.png")));
		marketiconlbl.setBounds(289, 25, 40, 40);
		customerpanel.add(marketiconlbl);
		
		JLabel lblNewLabel_4_3_1 = new JLabel("Envision, design and deliver smarter ");
		lblNewLabel_4_3_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_3_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_3_1.setBounds(28, 115, 302, 23);
		customerpanel.add(lblNewLabel_4_3_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("customer experiences that earn loyalty ");
		lblNewLabel_4_1_1_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_1_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_1_1.setBounds(28, 138, 302, 23);
		customerpanel.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_4_2_2_1 = new JLabel("and trust.");
		lblNewLabel_4_2_2_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_2_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_2_1.setBounds(28, 162, 302, 23);
		customerpanel.add(lblNewLabel_4_2_2_1);
		
		JLabel artificiallbl_1_1_1 = new JLabel("Customer");
		artificiallbl_1_1_1.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		artificiallbl_1_1_1.setBounds(28, 28, 249, 40);
		customerpanel.add(artificiallbl_1_1_1);
		
		JLabel intelegencelbl_1_1_1 = new JLabel("Experience");
		intelegencelbl_1_1_1.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		intelegencelbl_1_1_1.setBounds(28, 64, 249, 40);
		customerpanel.add(intelegencelbl_1_1_1);
			
//===================================================================   		
		
		JPanel supplypanel = new JPanel();
		supplypanel.setLayout(null);
		supplypanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		supplypanel.setBackground(Color.WHITE);
		supplypanel.setBounds(412, 283, 350, 210);
		body2panel.add(supplypanel);
		
		JLabel blockchainIcon_2_1 = new JLabel();
		blockchainIcon_2_1.setIcon(new ImageIcon(EServices.class.getResource("/MykieImga/carbon_scis-transparent-supply.png")));
//		blockchainIcon_2_1.setIcon(new ImageIcon(EServices.class.getResource("hugeicons_file-management.png")));
		blockchainIcon_2_1.setBounds(289, 25, 40, 40);
		supplypanel.add(blockchainIcon_2_1);
		
		JLabel blockchainlbl_1_1 = new JLabel("Supply Chain");
		blockchainlbl_1_1.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		blockchainlbl_1_1.setBounds(28, 38, 249, 39);
		supplypanel.add(blockchainlbl_1_1);
		
		JLabel lblNewLabel_4_2_6_2 = new JLabel("Build resilient, sustainable supply chains");
		lblNewLabel_4_2_6_2.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_6_2.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_6_2.setBounds(28, 109, 302, 23);
		supplypanel.add(lblNewLabel_4_2_6_2);
		
		JLabel lblNewLabel_4_2_1_4_3 = new JLabel("that prepare your business for the future ");
		lblNewLabel_4_2_1_4_3.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_1_4_3.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_1_4_3.setBounds(28, 135, 302, 23);
		supplypanel.add(lblNewLabel_4_2_1_4_3);
		
		JLabel lblNewLabel_4_2_1_4_2_1 = new JLabel("of work.");
		lblNewLabel_4_2_1_4_2_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_1_4_2_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_1_4_2_1.setBounds(28, 157, 302, 23);
		supplypanel.add(lblNewLabel_4_2_1_4_2_1);
		
//===================================================================   		
		
		JPanel talentmangmentpanel = new JPanel();
		talentmangmentpanel.setLayout(null);
		talentmangmentpanel.setBorder(new LineBorder(new Color(192, 192, 192), 2));
		talentmangmentpanel.setBackground(Color.WHITE);
		talentmangmentpanel.setBounds(52, 283, 350, 210);
		body2panel.add(talentmangmentpanel);
		
		JLabel aiIcon_2_1 = new JLabel();
		aiIcon_2_1.setIcon(new ImageIcon(EServices.class.getResource("/MykieImga/hugeicons_file-management.png")));
//		aiIcon_2_1.setIcon(new ImageIcon(EServices.class.getResource("carbon_scis-transparent-supply.png")));
		aiIcon_2_1.setBounds(289, 25, 40, 40);
		talentmangmentpanel.add(aiIcon_2_1);
		
		JLabel artificiallbl_1_1 = new JLabel("Talent");
		artificiallbl_1_1.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		artificiallbl_1_1.setBounds(28, 26, 249, 40);
		talentmangmentpanel.add(artificiallbl_1_1);
		
		JLabel intelegencelbl_1_1 = new JLabel("Managment");
		intelegencelbl_1_1.setFont(new Font("IBM Plex Sans Hebrew Medium", Font.PLAIN, 30));
		intelegencelbl_1_1.setBounds(28, 59, 249, 40);
		talentmangmentpanel.add(intelegencelbl_1_1);
		
		JLabel lblNewLabel_4_7_1 = new JLabel("Inspire your workforce with innovative ");
		lblNewLabel_4_7_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_7_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_7_1.setBounds(28, 110, 302, 23);
		talentmangmentpanel.add(lblNewLabel_4_7_1);
		
		JLabel lblNewLabel_4_1_5_1 = new JLabel("technologies and a people-centric approach ");
		lblNewLabel_4_1_5_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_1_5_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_1_5_1.setBounds(28, 133, 302, 23);
		talentmangmentpanel.add(lblNewLabel_4_1_5_1);
		
		JLabel lblNewLabel_4_2_6_1 = new JLabel("to talent management.");
		lblNewLabel_4_2_6_1.setForeground(new Color(125, 125, 125));
		lblNewLabel_4_2_6_1.setFont(new Font("IBM Plex Sans Hebrew", Font.PLAIN, 15));
		lblNewLabel_4_2_6_1.setBounds(28, 155, 302, 23);
		talentmangmentpanel.add(lblNewLabel_4_2_6_1);
		
        
        
	}
}
