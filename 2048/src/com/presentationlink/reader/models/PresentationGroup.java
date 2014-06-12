/**
 * 
 */
package com.presentationlink.reader.models;

import java.util.List;

/**
 * This class represents a presentation group that groups together
 * link locators and presentation arcs.
 * @author Aditya Cherla
 *
 */
public class PresentationGroup {
	
	private List<PresentationArc> arcList;
	private List<Locator> locatorList;
	private String role;
	private String type;
	
	/**
	 * @return the arcList
	 */
	public List<PresentationArc> getArcList() {
		return arcList;
	}

	/**
	 * @param arcList the arcList to set
	 */
	public void setArcList(List<PresentationArc> arcList) {
		this.arcList = arcList;
	}

	/**
	 * @return the locatorList
	 */
	public List<Locator> getLocatorList() {
		return locatorList;
	}

	/**
	 * @param locatorList the locatorList to set
	 */
	public void setLocatorList(List<Locator> locatorList) {
		this.locatorList = locatorList;
	}

	/**
	 * 
	 */
	public PresentationGroup() {
		super();
	}

	public PresentationGroup(List<PresentationArc> arcList,
			List<Locator> locatorList, String role, String type) {
		super();
		this.arcList = arcList;
		this.locatorList = locatorList;
		this.role = role;
		this.type = type;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	public PresentationGroup(List<PresentationArc> arcList,
			List<Locator> locatorList) {
		super();
		this.arcList = arcList;
		this.locatorList = locatorList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PresentationGroup [arcList=" + arcList + ", locatorList="
				+ locatorList + ", role=" + role + ", type=" + type + "]";
	}
	
	
	
}
