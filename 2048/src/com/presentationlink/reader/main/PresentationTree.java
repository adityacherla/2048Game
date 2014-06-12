/**
 * 
 */
package com.presentationlink.reader.main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.ParserFactory;

import com.presentationlink.reader.models.PresentationGroup;
import com.presentationlink.reader.models.PresentationNode;
import com.presentationlink.reader.service.PresentationLinkReader;
import com.presentationlink.reader.service.PresentationUtils;

/**
 * *********************************************************************************************************************
 * 								PRESENTATION LINK BASE TREE PRINTER								   **
 * *********************************************************************************************************************
 * This program is related XBRL. XBRL is a standard business reporting language .which has a component known as       **
 * Presentation link base. The presentation link base is an xml file which contains different elements. For example if**
 * you have a balance sheet all the elements that have been reported will have some relationship with the other.      **
 * The presentation links base tell us how to present the elements in the sheet, what is the relationship between     **
 * different members and order in which each element should be displayed. In nutshell the presentation link base shows**
 * the hierarchy of the elements. This program reads the presentation XML file and prints all the elements in a tree  **
 * Structure.Be sure to keep the presentation link base in standard notations and forms otherwise the output will be  **
 * something else than expected. This program is written as of the present standards. The notation and standards may  **
 * change in the near future. 																	   **
 * In order to use this program put the full path of the presentation link base file in the file object of the main   **
 * method.  																					   **
 * *********************************************************************************************************************
 * 12 June 2014
 * This class kick starts the presentation link base reading process and prints 
 * the link base in to a tree on the console
 * @author Aditya Cherla
 *
 */
public class PresentationTree {
	
	public static void main(String[] args) {
		
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser = null;
		
		PresentationLinkReader reader = new PresentationLinkReader();
		File file = new File("C:\\Users\\user\\Desktop\\Java Practice\\pre_cmp_2014-12-31.xml");
		try {
			parser = parserFactory.newSAXParser();
			parser.parse(file, reader);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		System.out.println("The presentation linkbase of "+file.getName()+": \n");
		for(PresentationGroup group: reader.getPresentationGroup()){
			List<String> rootElements = PresentationUtils.getAllRootElements(group.getLocatorList(),group.getArcList());
			for(String rootElement : rootElements){
				PresentationNode rootNode = new PresentationNode();
				rootNode.setNodeName(rootElement);
				rootNode.setOrder(0);//Since it's the root node we set the order to 0
				rootNode = PresentationUtils.createTree(rootNode,group.getArcList());
				PresentationUtils.printTreeToConsole(rootNode, 0,group.getArcList());
			}
		}
	}
}
