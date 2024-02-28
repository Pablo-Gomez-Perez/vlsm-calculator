package com.vlsm.controlles;

import java.util.ArrayList;
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
	private String currentMask;
	private String currentIpAddress;
	private String firstIpAviable;
	private int currentPrefix;
	private int currentSum;
	private String lastIpAviable;
	private String broadcastAddress;
	
	public SubnetController() {

	}

	/**
	 * 
	 * Determinate if the quantity of the host required are permited by the class of
	 * the network address
	 * 
	 * Public IP Range # of Hosts per Network Class A 1.0.0.0 to 127.0.0.0
	 * 16,777,214 Class B 128.0.0.0 to 191.255.0.0 65,534 Class C 192.0.0.0 to
	 * 223.255.255.0 254
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
	 * Finds the total number of host aviable for each subnet
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

		switch (ipClass) {
		case 'A':
			freeBits = 24;
			break;
		case 'B':
			freeBits = 16;
			break;
		case 'C':
			freeBits = 8;
			break;
		}

		this.currentPrefix = this.currentPrefix + (freeBits - m);

		return aviable;
	}

	public void determianteCurrentMask(int prefix) {
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

		this.currentSum = value;
		this.currentMask = firstOctet + "." + secondOctet + "." + thirdOctet + "." + fourthOctet;
	}

	private void calculateIpSubNetAddress(char ipClass) {
		String[] octets = this.currentIpAddress.split("\\.");

		switch (ipClass) {

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
		this.currentIpAddress = octets[0] + "." + octets[1] + "." + octets[2] + "." + octets[3];
	}

	private void calculateFirstSubnetAviable(char ipClass) {
		String[] octets = this.currentIpAddress.split("\\.");

		switch (ipClass) {

		case 'A': {
			octets[3] = String.valueOf(Integer.parseInt(octets[3]) + 1);
			break;
		}

		case 'B': {
			octets[3] = String.valueOf(Integer.parseInt(octets[3]) + 1);
			break;
		}

		case 'C': {
			octets[3] = String.valueOf(Integer.parseInt(octets[3]) + 1);
			break;
		}

		}
		
		this.firstIpAviable = octets[0] + "." + octets[1] + "." + octets[2] + "." + octets[3];
	}
	
	private void calculateLastAddress(char ipClass) {
		
		String[] octets = this.currentIpAddress.split("\\.");

		switch (ipClass) {

		case 'A': {
			octets[1] = String.valueOf(Integer.parseInt(octets[1]) - 1);
			octets[2] = "255";
			octets[3] = "254";			
			break;
		}

		case 'B': {
			octets[2] = String.valueOf(Integer.parseInt(octets[2]) - 1);
			octets[3] = String.valueOf("254");			
			break;
		}

		case 'C': {
			octets[3] = String.valueOf(Integer.parseInt(octets[3]) - 1);
			break;
		}

		}
		
		this.lastIpAviable = octets[0] + "." + octets[1] + "." + octets[2] + "." + octets[3];
		
	}

	private int netJump() {
		return 256 - currentSum;
	}

	public List<SubNet> listVlsmSchema(List<Host> data, CalculatorVLSM base) throws Exception {

		List<SubNet> sbNetList = new ArrayList<>();

		int required = data.stream().mapToInt(d -> d.getHostQuantity()).sum();

		if (validateAllowedHosts(base.getIpClase(), required) == false) {
			throw new Exception("The number of required hosts is to long");
		}
		
		this.currentPrefix = base.getPrefix();
		this.currentIpAddress = base.getIpBase();
		//this.determianteCurrentMask(base.getPrefix());
		
		data.stream().sorted(Comparator.comparingInt(Host::getHostQuantity).reversed()).collect(Collectors.toList())
		.forEach(d -> {

			SubNet.Builder net = SubNet.builder(d.getIdHost(), d.getHostName());
			net.hostRequired(d.getHostQuantity());
			net.hostAviable(this.determinateHostAviable(d.getHostQuantity(), base.getIpClase()));
			this.determianteCurrentMask(this.currentPrefix);
			net.mask(this.currentMask);
			net.prefix(this.currentPrefix);
			net.netAddress(d.getIdHost() == 0 ? base.getIpBase() : this.currentIpAddress);					
			this.calculateFirstSubnetAviable(base.getIpClase());					
			net.firstAviable(this.firstIpAviable);								
			this.calculateIpSubNetAddress(base.getIpClase());
			this.calculateLastAddress(base.getIpClase());					
			net.lasAviable(this.lastIpAviable);									
			
			sbNetList.add(net.build());
								
			this.currentSum = 0;
			this.currentPrefix = base.getPrefix();
		});		

		return sbNetList;

	}
}
