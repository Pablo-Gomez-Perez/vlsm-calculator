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
	private int[] posValues = { 128, 64, 32, 16, 8, 4, 2, 1 };
	private int selectedValue;	
	private String currentIp;
	private int currentPrefix;

	public SubnetController() {

	}
	
	
	/**
	 * 
	 * Determinate if the quantity of the host required are permited by
	 * the class of the network address
	 * 
	 * 			Public IP Range			# of Hosts per Network
	 * Class A	1.0.0.0 to 127.0.0.0	16,777,214
	 * Class B	128.0.0.0 to 191.255.0.0	65,534
	 * Class C	192.0.0.0 to 223.255.255.0	254
	 * 
	 * @param ipClass
	 * @param hostRequired
	 * @return true if the hosts required are suported by the ip clase
	 */
	public boolean validateAllowedHosts(char ipClass, int hostRequired) {

		switch (ipClass) {

		case 'A':
			if (hostRequired > MAX_A_CLASS_IP_HOSTS)
				return false;
			else
				return true;
		case 'B':
			if (hostRequired > MAX_B_CLASS_IP_HOSTS)
				return false;
			else
				return true;
		case 'C':
			if (hostRequired > MAX_C_CLASS_IP_HOSTS)
				return false;
			else
				return true;
		default:
			return true;

		}
	}
	
	/**
	 * Finds the total number of host aviable for each
	 * subnet
	 * 
	 * @param required
	 * @return
	 */
	public int determinateHostAviable(int required, char ipClass) {
		int aviable = 0;
		int m = 0;
		int freeBits = -1;

		while (required >= aviable) {
			m++;
			aviable = (int) Math.pow(2, m) - 2;			
		}
		
		switch(ipClass) {
		case 'A': freeBits = 24; break;
		case 'B': freeBits = 16; break;
		case 'C': freeBits = 8; break;
		}
		
		this.currentPrefix = this.currentPrefix + (freeBits - m);

		return aviable;
	}

	public String determianteCurrentMask(int prefix) {
		String firstOctet = "255";
		String secondOctet = "000";
		String thirdOctet = "000";
		String fourthOctet = "000";
		int value = 0;
		int j = 0;
				
		
		if (prefix > 8 && prefix <= 16) {
			j = 0;
			for (int i = 8; i < prefix; i++) {
				value = value + posValues[j];
				j++;
			}
			
			secondOctet = String.valueOf(value);
		}

		if (prefix > 16 && prefix <= 24) {
			secondOctet = "255";
			j = 0;
			for (int i = 16; i < prefix; i++) {
				value = value + posValues[j];
				j++;
			}
			
			thirdOctet = String.valueOf(value);
		}

		if (prefix >= 24 && prefix <= 30) {
			secondOctet = "255";
			thirdOctet = "255";
			j = 0;
			for (int i = 24; i < prefix; i++) {
				value = value + posValues[j];
				j++;
			}			
			fourthOctet = String.valueOf(value);
		}		
		this.selectedValue = value;
		return firstOctet + "." + secondOctet + "." + thirdOctet + "." + fourthOctet;
	}

	public void determineNetAddress(String base, char ipClase) {
		String netAddress = "";
		String[] octets = base.split("\\.");

		switch (ipClase) {
		
		case 'A': {			
			octets[1] = String.valueOf(Integer.parseInt(octets[1]) + netJump());			
			break;
		}

		case 'B': {			
			octets[2] = String.valueOf(Integer.parseInt(octets[2]) + netJump());			
			break;
		}

		case 'C': {			
			octets[3] = String.valueOf(Integer.parseInt(octets[3]) + netJump());			
			break;
		}

		}

		netAddress = octets[0] + "." + octets[1] + "." + octets[2] + "." + octets[3];
				
		this.currentIp = netAddress;
	}		
	
	public int netJump() {
		int jump = 256 - this.selectedValue;
		return jump;
	}
	
	public List<SubNet> listVlsmSchema(List<Host> data, CalculatorVLSM base) throws Exception {
		
		this.selectedValue = 0;		
		Vector<SubNet> sbNetList = new Vector<>();
		this.currentPrefix = base.getPrefix();
		this.currentIp = base.getIpBase();		
		int required = data.stream().mapToInt(d -> d.getHostQuantity()).sum();

		if (validateAllowedHosts(base.getIpClase(), required) == false) {
			throw new Exception("The number of required hosts is to long");
		}

		data = data.stream().sorted(Comparator.comparingInt(Host::getHostQuantity).reversed())
				.collect(Collectors.toList());		
		
		data.stream().forEach(d -> {
			
			sbNetList.add(SubNet.builder(d.getIdHost(), d.getHostName()).hostRequired(d.getHostQuantity())
					.hostAviable(this.determinateHostAviable(d.getHostQuantity(), base.getIpClase()))
					.mask(this.determianteCurrentMask(this.currentPrefix))
					.netAddress(d.getIdHost() == 0 ? base.getIpBase() : this.currentIp)
					.prefix(this.currentPrefix)
					.build());
			
			this.determineNetAddress(this.currentIp, base.getIpClase());
			this.currentPrefix = base.getPrefix();
			
		});
		
		return sbNetList;

	}
}
