/**
 * 
 */
package com.presentationlink.reader.models;

import java.util.List;
/**
 * This class represents a node in the presentation hierarchy
 * @author Aditya Cherla
 */
public class PresentationNode {
	
	private String nodeName; //current node name
	private String parentNode; //The parent node
	private List<PresentationNode> children; //The children of a node in the tree
	
	/**
	 * 
	 */
	public PresentationNode() {
		// TODO Auto-generated constructor stub
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
	
}
