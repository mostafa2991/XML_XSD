package com.MElHagez.saxParser;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.MElHagez.dto.Address;
import com.MElHagez.dto.DriversLicense;

/**
 * @author Created by M_ElHagez on Mar 13, 2021 
 */
public class SAXParserDemo {

	/**
	 * @param args
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		
//		create the SAX parser
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
//		instance of sax handler 
		SAXHandler handler = new SAXHandler();
//		this why we create the handler
		parser.parse(ClassLoader.getSystemResourceAsStream("xml/DriversLicense.xml"), handler);
		
		
//		print 
		System.out.println(handler.getDriversLicense().getFirstName());
		System.out.println(handler.getDriversLicense().getNumber());
		System.out.println(handler.getDriversLicense().getLastName());
		
		
		
	}

}
