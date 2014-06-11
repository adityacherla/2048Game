/**
 * 
 */
package com.presentationlink.reader.models;

/**
 * This class represents the presentation arc tags in the presentation link base.
 * The members of this class are the attributes of the tag
 * @author Aditya Cherla
 *
 */
public class PresentationArc {
	
	private String type;
	private String arcrole;
	private String from;
	private String to;
	private String order;
	
	/**
	 * 
	 */
	public PresentationArc() {
		super();
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

	/**
	 * @return the arcrole
	 */
	public String getArcrole() {
		return arcrole;
	}

	/**
	 * @param arcrole the arcrole to set
	 */
	public void setArcrole(String arcrole) {
		this.arcrole = arcrole;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		int prime=31;
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
		PresentationArc arc = (PresentationArc) obj;
		if(this.getArcrole()!=null && arc.getArcrole()!=null && arc.getArcrole().equals(this.getArcrole())){
			if(this.getFrom()!=null && arc.getFrom()!=null && arc.getFrom().equals(this.getFrom())){
				if(this.getOrder()!=null && arc.getOrder()!=null && this.getOrder().equals(arc.getOrder())){
					if(this.getTo()!=null && arc.getTo()!=null && this.getTo().equals(arc.getTo())){
						if(this.getType()!=null && arc.getType()!=null && this.getType().equals(arc.getType())){
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
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * returns presentation object as string 
	*/
	@Override
	public String toString() {
		return "Presentation Arc link type:"+this.type+" arcrole:"+this.arcrole+" from:"
		+this.from+" to:"+this.to+" order:"+this.order;
	}
	
}
