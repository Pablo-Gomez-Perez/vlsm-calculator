package com.vlsm.controlles;

import com.vlsm.models.CalculatorVLSM;

public class CalculatorVLSMController {
	
	public CalculatorVLSMController() {
		
	}
	
	public CalculatorVLSM setVlsmData(String ipBase, int prefix, int hostRequired) throws Exception{
		
		CalculatorVLSM calc = new CalculatorVLSM();
		
		calc.setIpBase(ipBase);
		calc.setPrefix(prefix);
		calc.setHostRequired(hostRequired);
		
		return calc;
		
	}
	
}
