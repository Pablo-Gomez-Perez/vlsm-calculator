package com.vlsm.models;

public class SubNet {
	
	private int subNetId;
	private String subNetName;
	private int hostRequired;
	private int hostAviable;	
	private String netAddress;
	private int prefix;
	private String mask;
	private String firstAviable;
	private String lastAviable;
	private String broadcastDirection;
	
	public static class Builder{
		private SubNet snt;
		
		public Builder(int subNetId, String subNetName) {
			this.snt = new SubNet(subNetId, subNetName);
		}
		
		public Builder hostRequired(int hostRequired) {
			this.snt.setHostRequired(hostRequired);
			return this;
		}
		
		public Builder hostAviable(int hostAviable) {
			this.snt.setHostAviable(hostAviable);
			return this;
		}
		
		public Builder netAddress(String netAddress) {
			this.snt.setNetAddress(netAddress);
			return this;
		}
		
		public Builder prefix(int prefix) {
			this.snt.setPrefix(prefix);
			return this;
		}
		
		public Builder mask(String mask) {
			this.snt.setMask(mask);
			return this;
		}
		
		public Builder firstAviable(String firstAviable) {
			this.snt.setFirstAviable(firstAviable);
			return this;			
		}
		
		public Builder lasAviable(String lasAviable) {
			this.snt.setLastAviable(lasAviable);
			return this;
		}
		
		public Builder broadcastDirection(String broadcastDirection) {
			this.snt.setBroadcastDirection(broadcastDirection);
			return this;
		}
		
		public SubNet build() {
			return this.snt;
		}
	}
	
	public static Builder builder(int subNetId, String subNetName) {
		return new Builder(subNetId, subNetName);
	}
	
	/**
	 * @param subNetId
	 * @param subNetName
	 * @param hostRequired
	 * @param hostAviable
	 * @param netAddress
	 * @param prefix
	 * @param mask
	 * @param firstAviable
	 * @param lastAviable
	 * @param broadcastDirection
	 */
	public SubNet(int subNetId, String subNetName, int hostRequired, int hostAviable, String netAddress, int prefix,
			String mask, String firstAviable, String lastAviable, String broadcastDirection) {
		super();
		this.subNetId = subNetId;
		this.subNetName = subNetName;
		this.hostRequired = hostRequired;
		this.hostAviable = hostAviable;
		this.netAddress = netAddress;
		this.prefix = prefix;
		this.mask = mask;
		this.firstAviable = firstAviable;
		this.lastAviable = lastAviable;
		this.broadcastDirection = broadcastDirection;
	}

	public SubNet(int subNetId, String subNetName) {
		this.subNetId = subNetId;
		this.subNetName = subNetName;
	}

	/**
	 * @return the subNetId
	 */
	public int getSubNetId() {
		return subNetId;
	}

	/**
	 * @param subNetId the subNetId to set
	 */
	public void setSubNetId(int subNetId) {
		this.subNetId = subNetId;
	}

	/**
	 * @return the subNetName
	 */
	public String getSubNetName() {
		return subNetName;
	}

	/**
	 * @param subNetName the subNetName to set
	 */
	public void setSubNetName(String subNetName) {
		this.subNetName = subNetName;
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

	/**
	 * @return the hostAviable
	 */
	public int getHostAviable() {
		return hostAviable;
	}

	/**
	 * @param hostAviable the hostAviable to set
	 */
	public void setHostAviable(int hostAviable) {
		this.hostAviable = hostAviable;
	}

	/**
	 * @return the netAddress
	 */
	public String getNetAddress() {
		return netAddress;
	}

	/**
	 * @param netAddress the netAddress to set
	 */
	public void setNetAddress(String netAddress) {
		this.netAddress = netAddress;
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
	public void setPrefix(int prefix) {
		this.prefix = prefix;
	}

	/**
	 * @return the mask
	 */
	public String getMask() {
		return mask;
	}

	/**
	 * @param mask the mask to set
	 */
	public void setMask(String mask) {
		this.mask = mask;
	}

	/**
	 * @return the firstAviable
	 */
	public String getFirstAviable() {
		return firstAviable;
	}

	/**
	 * @param firstAviable the firstAviable to set
	 */
	public void setFirstAviable(String firstAviable) {
		this.firstAviable = firstAviable;
	}

	/**
	 * @return the lastAviable
	 */
	public String getLastAviable() {
		return lastAviable;
	}

	/**
	 * @param lastAviable the lastAviable to set
	 */
	public void setLastAviable(String lastAviable) {
		this.lastAviable = lastAviable;
	}

	/**
	 * @return the broadcastDirection
	 */
	public String getBroadcastDirection() {
		return broadcastDirection;
	}

	/**
	 * @param broadcastDirection the broadcastDirection to set
	 */
	public void setBroadcastDirection(String broadcastDirection) {
		this.broadcastDirection = broadcastDirection;
	}
	
	
	@Override
	public String toString() {
		String data = "";
		
		data = "\n===========================\n"
				+ "Id: " + this.subNetId + "\n"
				+ "Name: ";
		
		return data;
	}
	
}
