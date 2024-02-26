package com.vlsm.controlles;

import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.vlsm.models.CalculatorVLSM;
import com.vlsm.models.Host;
import com.vlsm.models.SubNet;

public class SubnetController {		
	
	private static final int MAX_A_CLASS_IP_HOSTS = 16387064;
	private static final int MAX_B_CLASS_IP_HOSTS = 64516;
	private static final int MAX_C_CLASS_IP_HOSTS = 254;
	
	public SubnetController() {
		
	}	
	
	public boolean validateAllowedHosts(char ipClass, int hostRequired) {
		
		
		switch(ipClass) {
		
		case 'A': if(hostRequired > MAX_A_CLASS_IP_HOSTS) return false; else return true;
		case 'B': if(hostRequired > MAX_B_CLASS_IP_HOSTS) return false; else return true;
		case 'C': if(hostRequired > MAX_C_CLASS_IP_HOSTS) return false; else return true;
		default: return true;
		
		}
	}
	
	
	
	public List<SubNet> listVlsmSchema (List<Host> data, CalculatorVLSM base) throws Exception{
		
		Vector<SubNet> sbNetList = new Vector<>();
		int required = data.stream().mapToInt(d -> d.getHostQuantity()).sum();
				
		if(validateAllowedHosts(base.getIpClase(), required) == false) {
			throw new Exception("The number of required hosts is to long");
		}
		
		data = data.stream().sorted(Comparator.comparingInt(Host::getHostQuantity).reversed()).collect(Collectors.toList());				
		
		return sbNetList;
		
	}
}
