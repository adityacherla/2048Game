/**
 * 
 */
package com.presentationlink.reader.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.presentationlink.reader.models.Locator;
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
	 * This method checks if the presentation node has any children present or not.
	 * It only checks if the element is present in the 'from' attribute of any presentation arc 
	 * @param nodeName (Name or label of current node)
	 * @param arcList (List of presentation arcs)
	 * @return boolean
	 * @author Aditya Cherla
	 */
	public static boolean hasChildren(String nodeName,List<PresentationArc> arcList){
		
		for(PresentationArc element: arcList){
			if(element.getFrom().equals(nodeName))
				return true;
		}
		return false;
	}
	
	/**
	 * This method arranges all the presentation link base nodes in a tree fashion.
	 * You have to supply the presentation node from where you have to start and list of 
	 * presentation arcs in the group. The returned presentation node will contain multiple levels
	 * of children in it. 
	 * @param currentNode
	 * @param arcList
	 * @return PresentationNode
	 * @author Aditya Cherla
	 */
	public static PresentationNode createTree(PresentationNode currentNode,List<PresentationArc> arcList){
		List<PresentationNode> children = new ArrayList<PresentationNode>();//List containing child nodes
		if(hasChildren(currentNode.getNodeName(), arcList)){//If the current node has children
			for(PresentationArc element : arcList){//From the list of arcs in the group check which are children
				if(element.getFrom().equals(currentNode.getNodeName())){//If match found
					PresentationNode node = new PresentationNode();//Create a child node 
					node.setNodeName(element.getTo()); 
					node.setParentNode(element.getFrom());
					node.setOrder(DoubleToInt(Double.parseDouble(element.getOrder())));
					if(hasChildren(element.getTo(), arcList)){//If the child node of current node has children then recursively call the method
						node = createTree(node, arcList);
						children.add(node);
					}
					else{
						children.add(node);
					}
				}
			}
			Collections.sort(children);//I sort the children on the basis of order provided in the presentaion arc
			currentNode.setChildren(children);
		}
		return currentNode;
	}
	
	/**
	 * This method prints the node tree structure on the console but you have provide the Presentation
	 * nodes in proper arranged format for the method to print 
	 * @param node (Current node)
	 * @param level (Level of the node with respect to it's children and other nodes)
	 * @param arcList (list of presentation arcs)
	 * @return void
	 * @author Aditya Cherla
	 */
	public static void printTreeToConsole(PresentationNode node,int level,List<PresentationArc> arcList){
		StringBuilder builder = new StringBuilder();//This stringbuilder is user for appending spaces before the node in the presentation hierarchy
		for(int i=0;i<level;i++){ //based on the level provided the spaces are added
			builder.append("  ");
		}
		System.out.println(builder.toString()+node.getNodeName());
		if(hasChildren(node.getNodeName(), arcList)){//Print all the children if there are any
			for(PresentationNode child : node.getChildren()){
				printTreeToConsole(child,level+1,arcList);//Recursively calling the method for printing the children
			}
		}
	}
	
	/**
	 * This method returns all the root elements in the presentation group.
	 * It checks if the element is not present in any of the children of any element in the presentation
	 * hierarchy
	 * @param arcList
	 * @return
	 * List<String>
	 */
	public static List<String> getAllRootElements(List<Locator> locatorList,List<PresentationArc> arcList){
		int count;
		List<String> rootElements = new ArrayList<String>();
		for(Locator locator : locatorList){
			count=0;
			for(PresentationArc arc : arcList){
				if(locator.getLabel().equals(arc.getTo()))
					count++;
			}
			if(count==0)
				rootElements.add(locator.getLabel());
		}
		return rootElements;
	}
	
	/**
	 * This method converts double to int.
	 * can throw an exception in uncertain situations
	 * @param order
	 * @return int
	 */
	public static int DoubleToInt(double order){
		long temp = (long) order;
		return (int) temp;
	}
}
