package com.MElHagez.saxParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.MElHagez.dto.DriversLicense;

/**
 * @author Created by M_ElHagez on Mar 13, 2021 
 */
public class SAXHandler extends DefaultHandler {

	private DriversLicense driversLicense;
	private String content;
//   1st hit the <DriversLicense status="suspended">
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("DriversLicense")) {
			setDriversLicense(new DriversLicense());
		
		}
	}

// 2nd hit the 	<Number>12345</Number>
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		content = String.copyValueOf(ch, start, length).trim();
	}
	
	// 3rd hit the element get the content
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			switch (qName) {
			case "Number":
				getDriversLicense().setNumber(Long.parseLong(content));
				break;
			case "FirstName":
				getDriversLicense().setFirstName(content);
				break;
			case "LastName":
				getDriversLicense().setLastName(content);
				break;

			default:
				break;
			}
		}

		/**
		 * @return the driversLicense
		 */
		public DriversLicense getDriversLicense() {
			return driversLicense;
		}

		/**
		 * @param driversLicense the driversLicense to set
		 */
		public void setDriversLicense(DriversLicense driversLicense) {
			this.driversLicense = driversLicense;
		}
	 
}
