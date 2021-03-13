package com.MElHagez.domParser;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
public class DOMParserDemo {

	/**
	 * @param args
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		
//		create the dom parser
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse(ClassLoader.getSystemResourceAsStream("xml/DriversLicense.xml"));
//		create object
		DriversLicense license = new DriversLicense();
//		get the element
		NodeList numberList = document.getElementsByTagName("Number");
		Node numberItem = numberList.item(0);
		license.setNumber(Long.parseLong(numberItem.getTextContent()));
//		get another element
		NodeList firstNameList = document.getElementsByTagName("FirstName");
		Node firstNameItem = firstNameList.item(0);
		license.setFirstName(firstNameItem.getTextContent());
//		get another element
		NodeList lastNameList = document.getElementsByTagName("LastName");
		Node lastNameItem = lastNameList.item(0);
		license.setLastName(lastNameItem.getTextContent());
//		get to the attribute root element
		Element documentElement = document.getDocumentElement();
		license.setStatus(documentElement.getAttribute("status"));
//		get another element
		NodeList AddressElement = document.getElementsByTagName("Address");
		Node addressNode = AddressElement.item(0);
		NodeList addressChildNodes = addressNode.getChildNodes();
//		create address object
		Address address = new Address();
		for (int i = 0; i < addressChildNodes.getLength(); i++) {
			Node item = addressChildNodes.item(i);
			if (item instanceof Element) {
				switch (item.getNodeName()) {
				case "street":
					address.setStreet(item.getTextContent());
					break;
				case "city":
					address.setCity(item.getTextContent());
					break;
				case "state":
					address.setState(item.getTextContent());
					break;
				case "country":
					address.setCountry(item.getTextContent());
					break;
				case "zipcode":
					address.setZipcode(item.getTextContent());
					break;

				default:
					break;
				}
			}
			
		}
		license.setAddress(address);
//		print ln
		System.out.println(license.getFirstName());
		System.out.println(license.getLastName());
		System.out.println(license.getNumber());
		System.out.println(license.getStatus());
		System.out.println(license.getAddress().getCity());
		
		
		
	}

}
