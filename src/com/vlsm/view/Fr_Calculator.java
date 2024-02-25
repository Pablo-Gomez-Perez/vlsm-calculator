package com.vlsm.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class Fr_Calculator extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem opt_newScketch;
	private JMenuItem opt_OpenScketch;
	private JMenuItem opt_saveScketch;
	private JSeparator separator;
	private JMenuItem opt_exit;
	private JPanel panelNorth_Labels;
	private JLabel lblNewLabel;
	private JPanel panelCenter_Form;
	private JPanel panelCenter_North_TextFields;
	private JLabel lblNewLabel_1;
	private Component horizontalStrut;
	private JTextField txf_ipBaseAddress;
	private Component horizontalStrut_1;
	private JLabel lblNewLabel_2;
	private Component horizontalStrut_2;
	private JTextField txf_netPrefix;
	private Component horizontalStrut_3;
	private JLabel lblNewLabel_3;
	private JTextField textField;
	private Component horizontalStrut_4;
	private Component horizontalStrut_5;
	private JButton btn_setIpAddress;
	private JPanel panelCenter_Center_Data;
	private Box verticalBox;
	private Box horizontalBox;
	private Box horizontalBox_1;
	private JScrollPane scrollPaneTableRequiredHosts;
	private JScrollPane scrollPaneTxaVLSMData;
	private JTextArea txa_VLSMSchema;
	private JTable tableDataHostRequired;
	private DefaultTableModel tableDataHostModel;	
	private JPanel panelSouth_buttons;
	private JButton btn_ShowFullData;
	private JButton btn_ClearAll;
	private JButton btn_Calculate;
	

	/**
	 * Create the frame.
	 */
	public Fr_Calculator() {
		setBackground(new Color(238, 232, 170));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fr_Calculator.class.getResource("/com/vlsm/resources/5412-network-switch-icon-iconbunny.jpg")));
		setTitle("VLSM Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 580);
		this.setResizable(false);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		opt_newScketch = new JMenuItem("New Scketch");
		mnFile.add(opt_newScketch);
		
		opt_OpenScketch = new JMenuItem("Open Scketch");
		mnFile.add(opt_OpenScketch);
		
		opt_saveScketch = new JMenuItem("Save Scketch");
		mnFile.add(opt_saveScketch);
		
		separator = new JSeparator();
		mnFile.add(separator);
		
		opt_exit = new JMenuItem("Exit");
		mnFile.add(opt_exit);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 232, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelNorth_Labels = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelNorth_Labels.getLayout();
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(0);
		panelNorth_Labels.setBackground(new Color(224, 255, 255));
		contentPane.add(panelNorth_Labels, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("VLSM Free Calculator");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelNorth_Labels.add(lblNewLabel);
		
		panelCenter_Form = new JPanel();
		contentPane.add(panelCenter_Form, BorderLayout.CENTER);
		panelCenter_Form.setLayout(new BorderLayout(0, 0));
		
		panelCenter_North_TextFields = new JPanel();
		panelCenter_North_TextFields.setBackground(new Color(238, 232, 170));
		panelCenter_Form.add(panelCenter_North_TextFields, BorderLayout.NORTH);
		panelCenter_North_TextFields.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		lblNewLabel_1 = new JLabel("IP Adress");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setToolTipText("");
		panelCenter_North_TextFields.add(lblNewLabel_1);
		
		horizontalStrut = Box.createHorizontalStrut(5);
		panelCenter_North_TextFields.add(horizontalStrut);
		
		txf_ipBaseAddress = new JTextField();
		txf_ipBaseAddress.setToolTipText("Insert the ip base address to start calculate");
		panelCenter_North_TextFields.add(txf_ipBaseAddress);
		txf_ipBaseAddress.setColumns(15);
		this.txf_ipBaseAddress.setMaximumSize(this.txf_ipBaseAddress.getPreferredSize());
		
		horizontalStrut_1 = Box.createHorizontalStrut(10);
		panelCenter_North_TextFields.add(horizontalStrut_1);
		
		lblNewLabel_2 = new JLabel("Prefix");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCenter_North_TextFields.add(lblNewLabel_2);
		
		horizontalStrut_2 = Box.createHorizontalStrut(5);
		panelCenter_North_TextFields.add(horizontalStrut_2);
		
		txf_netPrefix = new JTextField();
		panelCenter_North_TextFields.add(txf_netPrefix);
		txf_netPrefix.setColumns(5);
		this.txf_netPrefix.setMaximumSize(this.txf_netPrefix.getPreferredSize());
		
		horizontalStrut_3 = Box.createHorizontalStrut(10);
		panelCenter_North_TextFields.add(horizontalStrut_3);
		
		lblNewLabel_3 = new JLabel("Number of subnets");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCenter_North_TextFields.add(lblNewLabel_3);
		
		horizontalStrut_4 = Box.createHorizontalStrut(5);
		panelCenter_North_TextFields.add(horizontalStrut_4);
		
		textField = new JTextField();
		panelCenter_North_TextFields.add(textField);
		textField.setColumns(5);
		
		horizontalStrut_5 = Box.createHorizontalStrut(10);
		panelCenter_North_TextFields.add(horizontalStrut_5);
		
		btn_setIpAddress = new JButton("Set");
		btn_setIpAddress.setBackground(new Color(152, 251, 152));
		panelCenter_North_TextFields.add(btn_setIpAddress);
		
		btn_Calculate = new JButton("Start");
		btn_Calculate.setBackground(new Color(135, 206, 235));
		panelCenter_North_TextFields.add(btn_Calculate);
		
		panelCenter_Center_Data = new JPanel();
		panelCenter_Form.add(panelCenter_Center_Data, BorderLayout.CENTER);
		panelCenter_Center_Data.setLayout(new BoxLayout(panelCenter_Center_Data, BoxLayout.X_AXIS));
		
		verticalBox = Box.createVerticalBox();
		panelCenter_Center_Data.add(verticalBox);
		
		horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		scrollPaneTableRequiredHosts = new JScrollPane();
		horizontalBox.add(scrollPaneTableRequiredHosts);
		
		this.scrollPaneTableRequiredHosts.setPreferredSize(new Dimension(760, 180));
		this.scrollPaneTableRequiredHosts.setMaximumSize(this.scrollPaneTableRequiredHosts.getPreferredSize());
		
		this.tableDataHostModel = new DefaultTableModel();
		
		tableDataHostModel.addColumn("Host ID");
		tableDataHostModel.addColumn("Host Name");
		tableDataHostModel.addColumn("Directions required");
		
		tableDataHostRequired = new JTable(this.tableDataHostModel);
		scrollPaneTableRequiredHosts.setViewportView(tableDataHostRequired);
		
		horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		scrollPaneTxaVLSMData = new JScrollPane();
		horizontalBox_1.add(scrollPaneTxaVLSMData);
		
		txa_VLSMSchema = new JTextArea();
		scrollPaneTxaVLSMData.setViewportView(txa_VLSMSchema);
		
		panelSouth_buttons = new JPanel();
		panelSouth_buttons.setBackground(new Color(255, 228, 196));
		FlowLayout flowLayout = (FlowLayout) panelSouth_buttons.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panelSouth_buttons, BorderLayout.SOUTH);
		
		btn_ShowFullData = new JButton("Show Full Data");
		btn_ShowFullData.setBackground(new Color(135, 206, 235));
		panelSouth_buttons.add(btn_ShowFullData);
		
		btn_ClearAll = new JButton("Clear");
		btn_ClearAll.setBackground(new Color(250, 128, 114));
		panelSouth_buttons.add(btn_ClearAll);
	}

}
