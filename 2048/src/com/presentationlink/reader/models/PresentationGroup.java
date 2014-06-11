/**
 * 
 */
package com.presentationlink.reader.models;

import java.util.List;

/**
 * @author acherla
 *
 */
public class PresentationGroup {
	
	private List<PresentationArc> arcList;
	private List<Locator> locatorList;
	
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
			List<Locator> locatorList) {
		super();
		this.arcList = arcList;
		this.locatorList = locatorList;
	}
	
	
	
}
