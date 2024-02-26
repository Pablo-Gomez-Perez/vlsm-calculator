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
	private String lastOctectIpValue;
	private String currentIp;
	private int currentPrefix;

	public SubnetController() {

	}

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

	public int determinateHostAviable(int required) {
		int aviable = 0;
		int m = 0;

		while (required >= aviable) {
			m++;
			aviable = (int) Math.pow(2, m);
			System.out.println(m + "  " + aviable);

		}

		this.currentPrefix = this.currentPrefix + (24 - m);

		return aviable - 2;
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

		if (prefix > 24 && prefix <= 30) {
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

	public String determineNetAddress(String base, char ipClase) {
		String netAddress = "";
		String[] octets = base.split("\\.");

		switch (ipClase) {

		case 'A': {
			octets[1] = String.valueOf(Integer.parseInt(lastOctectIpValue) + (256 - this.selectedValue));
			lastOctectIpValue = octets[1];
			break;
		}

		case 'B': {
			octets[2] = String.valueOf(Integer.parseInt(lastOctectIpValue) + (256 - this.selectedValue));
			lastOctectIpValue = octets[2];
			break;
		}

		case 'C': {
			octets[3] = String.valueOf(Integer.parseInt(lastOctectIpValue) + (256 - this.selectedValue));
			lastOctectIpValue = octets[3];
			break;
		}

		}

		netAddress = octets[0] + "." + octets[1] + "." + octets[2] + "." + octets[3];
		return netAddress;
	}

	public void setFirstOctateAfectedValue(char ipClase, String base) {
		
		String[] octets = base.split("\\.");
		
		switch (ipClase) {

		case 'A': {			
			lastOctectIpValue = octets[1];
			break;
		}

		case 'B': {			
			lastOctectIpValue = octets[2];
			break;
		}

		case 'C': {			
			lastOctectIpValue = octets[3];
			break;
		}

		}
	}

	public List<SubNet> listVlsmSchema(List<Host> data, CalculatorVLSM base) throws Exception {

		Vector<SubNet> sbNetList = new Vector<>();
		this.currentPrefix = base.getPrefix();
		this.currentIp = base.getIpBase();
		this.setFirstOctateAfectedValue(base.getIpClase(), base.getIpBase());
		int required = data.stream().mapToInt(d -> d.getHostQuantity()).sum();

		if (validateAllowedHosts(base.getIpClase(), required) == false) {
			throw new Exception("The number of required hosts is to long");
		}

		data = data.stream().sorted(Comparator.comparingInt(Host::getHostQuantity).reversed())
				.collect(Collectors.toList());

		data.stream().forEach(d -> {
			sbNetList.add(SubNet.builder(d.getIdHost(), d.getHostName()).hostRequired(d.getHostQuantity())
					.hostAviable(this.determinateHostAviable(d.getHostQuantity()))
					.netAddress(this.determineNetAddress(currentIp, base.getIpClase())).prefix(this.currentPrefix)
					.mask(this.determianteCurrentMask(this.currentPrefix)).build());
			this.currentPrefix = base.getPrefix();
		});

		return sbNetList;

	}
}
