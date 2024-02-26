package com.vlsm.models;

import java.util.Objects;

public class Host {

	private int idHost;
	private String hostName;
	private int hostQuantity;

	/**
	 * 
	 * @param idHost
	 * @param hostName
	 * @param hostQuantity
	 */
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
	public int hashCode() {
		return Objects.hash(hostQuantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Host)) {
			return false;
		}
		Host other = (Host) obj;
		return hostQuantity == other.hostQuantity;
	}

	@Override
	public String toString() {
		return "=====================\n" + "Hosts Data\n" + "-♦--♦--♦--♦--♦--♦--♦--♦--♦-\n" + "idHost: " + idHost + "\n"
				+ "hostName: " + hostName + "\n" + "hostQuantity: " + hostQuantity + "\n" + "=====================\n";
	}

}
