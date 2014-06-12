/**
 * 
 */
package com.presentationlink.reader.constants;

import java.util.ResourceBundle;

/**
 * @author Aditya Cherla
 *
 */
public class ReaderConstants {
	
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("conf");
	public static final String presentationArcTag = resourceBundle.getString("xml.tags.presentationArc");
	public static final String ArcRole = resourceBundle.getString("xml.tags.presentationArc.arcrole");
	public static final String presentationArcFrom = resourceBundle.getString("xml.tags.presentationArc.from");
	public static final String presentationArcOrder = resourceBundle.getString("xml.tags.presentationArc.order");
	public static final String presentationArcTo = resourceBundle.getString("xml.tags.presentationArc.to");
	public static final String presentationLocatorTag = resourceBundle.getString("xml.tags.presentationLocator");
	public static final String presentationLocHref = resourceBundle.getString("xml.tags.locator.href");
	public static final String presentationLocLabel = resourceBundle.getString("xml.tags.locator.label");
	public static final String presentationLocTitle = resourceBundle.getString("xml.tags.locator.title");
	public static final String presentationLocType = resourceBundle.getString("xml.tags.locator.type");
	public static final String presentationLinkTag = resourceBundle.getString("xml.tags.presentationLink");
	public static final String TagNameSpace = resourceBundle.getString("xml.tags.prefix.namespace");

}
