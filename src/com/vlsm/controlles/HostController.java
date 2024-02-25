package com.vlsm.controlles;

import java.util.Vector;

import com.vlsm.models.Host;

public class HostController {
	
	/**
	 * Prepare the values in the Host table
	 * @param number
	 * @return
	 */
	public Vector<Object[]> prepareVlans(int number){
		Vector<Object[]> vlans = new Vector<Object[]>();

		try {
			
			for(int i = 0; i < number; i++) {			
				vlans.addElement(new Object[] {i,"Host " + i, ""});
			}
			
			return vlans;
			
		}catch(Exception er){
			er.printStackTrace();
			return null;
		}
		
	}
	
}
