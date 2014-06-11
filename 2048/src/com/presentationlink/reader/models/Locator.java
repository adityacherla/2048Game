/**
 * 
 */
package com.presentationlink.reader.models;

/**
 * This class represents the locator tag in the presentation link base.
 * The members of the class are the attributes of the tag.
 * @author Aditya Cherla
 * 
 */
public class Locator {
	
	
	private String type;
	private String href;
	private String label;
	private String title;
	
	
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


	/**
	 * @return the href
	 */
	public String getHref() {
		return href;
	}


	/**
	 * @param href the href to set
	 */
	public void setHref(String href) {
		this.href = href;
	}


	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}


	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 */
	public Locator() {
		super();
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int prime=17;
		return super.hashCode()*prime;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj==null)
			return false;
		if(!(obj.getClass().equals(this.getClass())))
			return false;
		if(this==obj)
			return true;
		Locator locator = (Locator) obj;
		if(this.getHref()!=null && locator.getHref()!=null && this.getHref().equals(locator.getHref())){
			if(this.getLabel()!=null && locator.getLabel()!=null && this.getLabel().equals(locator.getLabel())){
				if(this.getTitle()!=null && locator.getTitle()!=null && this.getTitle().equals(locator.getTitle())){
					if(this.getType()!=null && locator.getType()!=null && this.getType().equals(locator.getType())){
						return true;
					}
					return false;
				}
				return false;
			}
			return false;
		}
		return false;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Locator object href: "+this.getHref()+" type:"+this.getType()+" label:"+this.getLabel()+" title:"+this.getTitle();
	}
	
	
	
}
