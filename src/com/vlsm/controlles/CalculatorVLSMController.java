package com.vlsm.controlles;

import com.vlsm.models.CalculatorVLSM;

public class CalculatorVLSMController {
	
	public CalculatorVLSMController() {
		
	}
	
	public CalculatorVLSM setVlsmData(String ipBase, int prefix, int hostRequired) throws Exception{
		
		CalculatorVLSM calc = new CalculatorVLSM();
		
		calc.setIpBase(ipBase);
		calc.setIpClase(this.determineIpClase(ipBase));
		calc.setPrefix(prefix);
		calc.setHostRequired(hostRequired);
		
		return calc;
		
	}
	
	public char determineIpClase(String ipBase) throws Exception{
		
		String[] octets = ipBase.split("\\.");
		
		int value = Integer.parseInt(octets[0]);
		
		if(value >= 1 && value <= 126) {
			return 'A';
		}
		
		if(value >= 128 && value <= 191) {
			return 'B';
		}
		
		if(value >= 192 && value <= 223) {
			return 'C';
		}
		
		if(value < 1 || value > 223 ) {			
			throw new Exception("Invalid ip values");
		}
		
		return '0';
	}
	
	
	
}
