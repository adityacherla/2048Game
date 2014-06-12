/**
 * 
 */
package com.presentationlink.reader.models;

import java.util.List;
/**
 * This class represents a node in the presentation link base hierarchy
 * @author Aditya Cherla
 * 
 */
public class PresentationNode implements Comparable<PresentationNode> {
	
	private String nodeName; //current node name
	private String parentNode; //The parent node
	private List<PresentationNode> children; //The children of a node in the tree
	private int order;
	
	/**
	 * 
	 */
	public PresentationNode() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}

	/**
	 * @return the nodeName
	 */
	public String getNodeName() {
		return nodeName;
	}

	/**
	 * @param nodeName the nodeName to set
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	/**
	 * @return the parentNode
	 */
	public String getParentNode() {
		return parentNode;
	}

	/**
	 * @param parentNode the parentNode to set
	 */
	public void setParentNode(String parentNode) {
		this.parentNode = parentNode;
	}

	/**
	 * @return the children
	 */
	public List<PresentationNode> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<PresentationNode> children) {
		this.children = children;
	}

	
	@Override
	public int compareTo(PresentationNode node) {
		return this.order-node.order;
	}
	
}
