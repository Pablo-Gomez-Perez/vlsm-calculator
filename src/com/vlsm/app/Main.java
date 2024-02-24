package com.vlsm.app;

import java.awt.EventQueue;

import javax.swing.JFrame;

import com.vlsm.view.Fr_Calculator;

public class Main {
	
	public static void main(String[] args) throws Exception{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fr_Calculator frame = new Fr_Calculator();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
