package com.tgt.redallure.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ItemParser extends DailyDealsDataParser  {

	/*
	public ItemParser() {
		super();
	}*/

	protected Object getData(Element dataEl) {
		//Create Item object for each <data> element.
		//<data vo="item" listingid="-2083530570" title="1-lb. pkg. fresh strawberries" description="" listingstart="6/26/2011 12:00:00 AM" listingend="7/2/2011 12:00:00 AM" actualpoststart="6/25/2011 11:00:00 PM" image="http://akimages.shoplocal.com/dyn_li/60.0.75.0/Retailers/Target/110526_p02mw1fg_12615_bn.jpg" price="$1.79" buynow="" pricequalifier="sale" originaldeal="" finalprice="1.7900" lowprice="" promotionstartdate="6/26/2011 12:00:00 AM" promotionenddate="7/2/2011 12:00:00 AM" promotionpoststartdate="6/25/2011 11:00:00 PM" promotionpostenddate="7/2/2011 10:59:00 PM" promotiontypeid="1" pretailerid="-99441" pretailername="SuperTarget" availableonline="N" AvailableOnlineProductCode="" promotioncode="Target-110626" additionaldealinfo="" fineprint="" retailerproductcode="" imageflag="3" productdescription=""/>
	//	String vo=dataEl.getAttribute("vo");
	//	String listingid=dataEl.getAttribute("listingid");
		
		NodeList nl = dataEl.getElementsByTagName("URL");
		Element el = (Element) nl.item(0);
		
		System.out.println(el.getNodeName());
		System.out.println(el.getTextContent());
		String image = el.getTextContent();
		
//		String price=dataEl.getAttribute("price");
		String title = null;
		NodeList nl2 = null;
		try {
			nl2 = dataEl.getElementsByTagName("Manufacturer");
		}
		catch (Exception e) {
			System.out.println("Error reading Manufacturer.");
		}
		
		if (nl2 != null && nl2.getLength() > 0) {
			Element el2 = (Element) nl2.item(0);
			
			System.out.println(el2.getNodeName());
			System.out.println(el2.getTextContent());
			title = el2.getTextContent();
		}

		
		String productdescription = null;
		NodeList nl3 = null;
		try {
			nl3 = dataEl.getElementsByTagName("Title");
		}
		catch (Exception e) {
			System.out.println("Error reading Title.");
		}

		if (nl3 != null) {
			Element el3 = (Element) nl3.item(0);
			
			System.out.println(el3.getNodeName());
			System.out.println(el3.getTextContent());
			productdescription = el3.getTextContent();
		}


		String price = null;
		String dscPrix = null;
		NodeList nl4 = null;
		try {
			nl4 = dataEl.getElementsByTagName("Attribute");
		}
		catch (Exception e) {
			System.out.println("Error reading Title.");
		}

		if (nl4 != null) {
			for (int i = 0 ; i < nl4.getLength();i++) { // Iterate through list
				Element attrEL = (Element) nl4.item(i);
				
				String priceAttr = attrEL.getAttribute("name");
				
				if ((priceAttr != null) && (priceAttr.compareTo("OFFER_RANGE_MAX") == 0) ) {
					price = attrEL.getAttribute("value");

					if (price != null && price.length() > 0) {
						System.out.println("PRICE: " + price);
						//subtract 30% from the price
						int prix = Integer.valueOf(price);
						
						double dblPrix = prix - (Integer.valueOf(price) * .30);
						
						dscPrix = String.format("$%3.2f", dblPrix);
								
						System.out.println("DISCOUNTED PRICE: " + dblPrix);
						System.out.println("DISCOUNTED PRICE: " + dscPrix);
						
						break;
					}
					else {
						System.out.println("PRICE: null or empty");
					}
				} // if
			} //for
		} //if
		
		String listingid = null;
		NodeList nl5 = null;
		try {
			nl5 = dataEl.getElementsByTagName("TCIN");
		}
		catch (Exception e) {
			System.out.println("Error reading TCIN.");
		}

		if (nl5 != null) {
			Element tcinEl = (Element) nl5.item(0);
			
			System.out.println(tcinEl.getNodeName());
			System.out.println(tcinEl.getTextContent());
			listingid = tcinEl.getTextContent();
		}



//		Item  item= new Item(vo, listingid, title, price, image, productdescription);
 
		Item  item= new Item(null, listingid, title, dscPrix, image, productdescription);
		
		return item;
	}
}
