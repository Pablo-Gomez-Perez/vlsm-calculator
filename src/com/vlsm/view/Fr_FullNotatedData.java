package com.vlsm.view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.vlsm.models.CalculatorVLSM;
import com.vlsm.models.Host;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Fr_FullNotatedData extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPaneTxaFullData;
	private JTextArea txa_FullData;
	private CalculatorVLSM calculator;
	private List<Host> hosts;
	/*
	 * 
	 * */

	/**
	 * Create the frame.
	 */
	public Fr_FullNotatedData(CalculatorVLSM calculator, List<Host> hosts) {
		
		this.calculator = calculator;
		this.hosts = hosts;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		scrollPaneTxaFullData = new JScrollPane();
		contentPane.add(scrollPaneTxaFullData, BorderLayout.CENTER);
		
		txa_FullData = new JTextArea();
		scrollPaneTxaFullData.setViewportView(txa_FullData);
		
		this.writeData();
	}
	
	private void writeData() {
		this.txa_FullData.append(this.calculator.toString());
		this.txa_FullData.append("+~~~~~~~~~~~~~~~~~~~~~~~~~+\n");
		this.txa_FullData.append("Hosts Information \n");
		this.txa_FullData.append("+~~~~~~~~~~~~~~~~~~~~~~~~~+\n");
		this.txa_FullData.append(this.hostsData());
	}
	
	private String hostsData() {
		
		StringBuilder sb = new StringBuilder();
		
		this.hosts.stream().forEach(h -> {
			sb.append(h.toString());
			sb.append("\n");
		});
		
		return sb.toString();
	}
	
}
