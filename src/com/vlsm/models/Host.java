package com.vlsm.models;

public class Host {
	
	private int idHost;
	private String hostName;
	private int hostQuantity;
	
	public Host(int idHost, String hostName, int hostQuantity) {
		this.idHost = idHost;
		this.hostName = hostName;
		this.hostQuantity = hostQuantity;
	}
	
	public Host() {
		
	}

	/**
	 * @return the idHost
	 */
	public int getIdHost() {
		return idHost;
	}

	/**
	 * @param idHost the idHost to set
	 */
	public void setIdHost(int idHost) {
		this.idHost = idHost;
	}

	/**
	 * @return the hostName
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * @param hostName the hostName to set
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	/**
	 * @return the hostQuantity
	 */
	public int getHostQuantity() {
		return hostQuantity;
	}

	/**
	 * @param hostQuantity the hostQuantity to set
	 */
	public void setHostQuantity(int hostQuantity) {
		this.hostQuantity = hostQuantity;
	}

	@Override
	public String toString() {
		return "Host [idHost=" + idHost + ", hostName=" + hostName + ", hostQuantity=" + hostQuantity + "]";
	}
	
	
	
}
