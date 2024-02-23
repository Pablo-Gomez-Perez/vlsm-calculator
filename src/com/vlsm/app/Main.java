package com.vlsm.app;

import java.awt.EventQueue;

import com.vlsm.view.Fr_Calculator;

public class Main {
	
	public static void main(String[] args) throws Exception{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fr_Calculator frame = new Fr_Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
