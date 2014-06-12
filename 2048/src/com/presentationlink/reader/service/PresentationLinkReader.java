/**
 * 
 */
package com.presentationlink.reader.service;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.presentationlink.reader.constants.ReaderConstants;
import com.presentationlink.reader.models.Locator;
import com.presentationlink.reader.models.PresentationArc;
import com.presentationlink.reader.models.PresentationGroup;

/**
 * This class is the extension of the {@link DefaultHandler} class of the SAX.
 * This class reads the presentation link base files and extracts all the locators and
 * arcs present.
 * @author Aditya Cherla
 *
 */
public class PresentationLinkReader extends DefaultHandler {
	
	/**
	 * 
	 */
	
	private List<PresentationGroup> presentationGroup = new ArrayList<PresentationGroup>();
	private List<Locator> locators;
	private List<PresentationArc> arcs;
	
	
	public PresentationLinkReader() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startDocument()
	 */
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
	}

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		PresentationGroup group = null;
		
		if(localName.equals(ReaderConstants.presentationLinkTag)){
			 group = new PresentationGroup();
			 locators = new ArrayList<Locator>();
			 arcs = new ArrayList<PresentationArc>();
		}
		if(localName.equals(ReaderConstants.presentationLocatorTag)){
			Locator locator = new Locator();
			locator.setHref(attributes.getValue(ReaderConstants.TagNameSpace,ReaderConstants.presentationLocHref));
			locator.setLabel(attributes.getValue(ReaderConstants.TagNameSpace,ReaderConstants.presentationLocLabel));
			locator.setTitle(attributes.getValue(ReaderConstants.TagNameSpace,ReaderConstants.presentationLocTitle));
			locator.setType(attributes.getValue(ReaderConstants.TagNameSpace,ReaderConstants.presentationLocType));
			locators.add(locator);
		}
		if(localName.equals(ReaderConstants.presentationArcTag)){
			PresentationArc arc = new PresentationArc();
			arc.setArcrole(attributes.getValue(ReaderConstants.TagNameSpace,ReaderConstants.ArcRole));
			arc.setFrom(attributes.getValue(ReaderConstants.TagNameSpace,ReaderConstants.presentationArcFrom));
			arc.setOrder(attributes.getValue(ReaderConstants.presentationArcOrder));
			arc.setTo(attributes.getValue(ReaderConstants.TagNameSpace,ReaderConstants.presentationArcTo));
			arc.setType(attributes.getValue(ReaderConstants.TagNameSpace,ReaderConstants.presentationLocType));
			arcs.add(arc);
		}
		if(group!=null){
			group.setArcList(arcs);
			group.setLocatorList(locators);
			presentationGroup.add(group);
		}
	}

	/**
	 * @return the presentationGroup
	 */
	public List<PresentationGroup> getPresentationGroup() {
		return presentationGroup;
	}

	/**
	 * @return the locators
	 */
	public List<Locator> getLocators() {
		return locators;
	}

	/**
	 * @return the arcs
	 */
	public List<PresentationArc> getArcs() {
		return arcs;
	}
	
}
