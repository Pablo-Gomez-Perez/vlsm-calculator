package com.vlsm.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorVLSM {

	private String ipBase;
	private int prefix;
	private int hostRequired;
	private char ipClase;

	/**
	 * @param ipBase
	 * @param prefix
	 * @param hostRequired
	 */
	public CalculatorVLSM(String ipBase, int prefix, int hostRequired) {
		super();
		this.ipBase = ipBase;
		this.prefix = prefix;
		this.hostRequired = hostRequired;
	}

	public CalculatorVLSM() {

	}

	/**
	 * @return the ipBase
	 */
	public String getIpBase() {
		return ipBase;
	}

	/**
	 * @param ipBase the ipBase to set
	 */
	public void setIpBase(String ipBase) throws Exception{
		
		String rgex = "^(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(?:\\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$";
		Pattern pattern = Pattern.compile(rgex);		
		Matcher matcher = pattern.matcher(ipBase);
		
		if(matcher.matches()) {
			this.ipBase = ipBase;
			return;
		}
		
		if(!matcher.matches()) {
			this.ipBase = "";
			throw new Exception("Invalid ip address format");			
		}
	}

	/**
	 * @return the prefix
	 */
	public int getPrefix() {
		return prefix;
	}

	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(int prefix) throws Exception{
		
		
		if(this.ipClase == 'A' && (prefix < 8 || prefix > 30)) {
			this.prefix = -1;
			throw new Exception("Invalid prefix value for this Ip Clase");
		}
		
		if(this.ipClase == 'B' && (prefix < 16 || prefix > 30)) {
			this.prefix = -1;
			throw new Exception("Invalid prefix value for this Ip Clase");
		}
		
		if(this.ipClase == 'C' && (prefix < 24 || prefix > 30)) {
			this.prefix = -1;
			throw new Exception("Invalid prefix value for this Ip Clase");
		}
		
		this.prefix = prefix;
		
	}

	/**
	 * @return the hostRequired
	 */
	public int getHostRequired() {
		return hostRequired;
	}

	/**
	 * @param hostRequired the hostRequired to set
	 */
	public void setHostRequired(int hostRequired) {
		this.hostRequired = hostRequired;
	}
	
	public void setIpClase(char ipClase) {
		this.ipClase = ipClase;
	}
	
	public char getIpClase() {
		return this.ipClase;
	}

	@Override
	public String toString() {
		return "=====================\n"
				+ "CalculatorVLSM\n"
				+ "-♦--♦--♦--♦--♦--♦--♦--♦--♦-\n"
				+ "ipBase: " + ipBase +"\n"
				+ "prefix: " + prefix + "\n"
				+ "ipClase: " + ipClase + "\n"
				+ "hostRequired: " + hostRequired + "\n"
				+ "=====================\n";
	}

}
