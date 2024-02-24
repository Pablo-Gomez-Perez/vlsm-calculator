package com.vlsm.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;

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

	

	/**
	 * Create the frame.
	 */
	public Fr_Calculator() {
		setTitle("VLSM Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 580);
		
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelNorth_Labels = new JPanel();
		contentPane.add(panelNorth_Labels, BorderLayout.NORTH);
		
		lblNewLabel = new JLabel("VLSM Free Calculator");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		panelNorth_Labels.add(lblNewLabel);
		
		panelCenter_Form = new JPanel();
		contentPane.add(panelCenter_Form, BorderLayout.CENTER);
		panelCenter_Form.setLayout(new BorderLayout(0, 0));
		
		panelCenter_North_TextFields = new JPanel();
		panelCenter_Form.add(panelCenter_North_TextFields, BorderLayout.NORTH);
		panelCenter_North_TextFields.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		lblNewLabel_1 = new JLabel("IP Adress");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setToolTipText("");
		panelCenter_North_TextFields.add(lblNewLabel_1);
		
		horizontalStrut = Box.createHorizontalStrut(10);
		panelCenter_North_TextFields.add(horizontalStrut);
		
		txf_ipBaseAddress = new JTextField();
		txf_ipBaseAddress.setToolTipText("Insert the ip base address to start calculate");
		panelCenter_North_TextFields.add(txf_ipBaseAddress);
		txf_ipBaseAddress.setColumns(25);
		this.txf_ipBaseAddress.setMaximumSize(this.txf_ipBaseAddress.getPreferredSize());
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		panelCenter_North_TextFields.add(horizontalStrut_1);
		
		lblNewLabel_2 = new JLabel("Prefix");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCenter_North_TextFields.add(lblNewLabel_2);
		
		horizontalStrut_2 = Box.createHorizontalStrut(10);
		panelCenter_North_TextFields.add(horizontalStrut_2);
		
		txf_netPrefix = new JTextField();
		panelCenter_North_TextFields.add(txf_netPrefix);
		txf_netPrefix.setColumns(10);
		this.txf_netPrefix.setMaximumSize(this.txf_netPrefix.getPreferredSize());
		
		horizontalStrut_3 = Box.createHorizontalStrut(20);
		panelCenter_North_TextFields.add(horizontalStrut_3);
		
		lblNewLabel_3 = new JLabel("Number of subnets");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelCenter_North_TextFields.add(lblNewLabel_3);
		
		textField = new JTextField();
		panelCenter_North_TextFields.add(textField);
		textField.setColumns(10);
	}

}
