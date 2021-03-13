package com.MElHagez.staxParser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.MElHagez.dto.DriversLicense;

/**
 * @author Created by M_ElHagez on Mar 13, 2021 
 */
public class STAXParserDemo {

	/**
	 * @param args
	 * @throws XMLStreamException 
	 */
	public static void main(String[] args) throws XMLStreamException {

		
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader xmlStreamReader = factory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream("xml/DriversLicense.xml"));
//		create object
		DriversLicense license = null;
//		content
		String content = null;
//		iterate with the cursor
		while (xmlStreamReader.hasNext()) {
			int event = xmlStreamReader.next();
//			start element
			switch (event) {
			case XMLStreamConstants.START_ELEMENT:
				if (xmlStreamReader.getLocalName().equals("DriversLicense")) {
					license = new DriversLicense();
					license.setStatus(xmlStreamReader.getAttributeValue(0));
				}
				break;
//				CHARACTERS
			case XMLStreamConstants.CHARACTERS:
				content = xmlStreamReader.getText().trim();
				break;
//				end element
			case XMLStreamConstants.END_ELEMENT:
						switch (xmlStreamReader.getLocalName()) {
						
						case "Number":
							license.setNumber(Long.parseLong(content));
							break;
						case "FirstName":
							license.setFirstName(content);
							break;
						case "LastName":
							license.setLastName(content);
							break;
		
						default:
							break;
						}
				break;

			default:
				break;
			}
		}
		
//		print ln
		System.out.println(license.getFirstName());
		System.out.println(license.getLastName());
		System.out.println(license.getNumber());
		System.out.println(license.getStatus());
		
		
		
		
	}

}
