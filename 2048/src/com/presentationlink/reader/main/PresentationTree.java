/**
 * 
 */
package com.presentationlink.reader.main;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.ParserFactory;

import com.presentationlink.reader.service.PresentationLinkReader;

/**
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The presentation linkbase: \n");
		System.out.println();
		
		
	}
	
}
