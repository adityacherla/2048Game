/**
 * 
 */
package com.presentationlink.reader.service;

import java.util.List;

import com.presentationlink.reader.models.PresentationArc;
import com.presentationlink.reader.models.PresentationNode;

/**
 * Utility class for presentation link base processes
 * All the utility methods go here
 * @author Aditya Cherla
 *
 */
public class PresentationUtils {
	
	/**
	 * This method checks if the node has any children present or not 
	 * @param nodeName
	 * @param arcList
	 * @return
	 * boolean
	 */
	public static boolean hasChildren(String nodeName,List<PresentationArc> arcList){
		
		for(PresentationArc element: arcList){
			if(element.getFrom().equals(nodeName))
				return true;
		}
		
		return false;
	}
	
	
	public static PresentationNode createTree(PresentationNode currentNode,List<PresentationArc> arcList){
		List<PresentationNode> children
		if(hasChildren(currentNode.getNodeName(), arcList)){
			
		}
		return null;
	}
	
	public static void printTree(node)
	
	
	
}
