package com.tgt.redallure.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public abstract class  DailyDealsDataParser {

	protected List dataList;
	protected Document dom;

	public DailyDealsDataParser() {
		dataList=new ArrayList();
	}
	public List getDataList(String xmlString){
		parseXmlString(xmlString);
		parseDocument();
		
		return dataList;
	}

	protected void parseXmlString(String xmlString) {
		//get the factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			
			DocumentBuilder db = dbf.newDocumentBuilder();
			dom= db.parse(new ByteArrayInputStream( xmlString.getBytes("UTF-8")));
	
		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	private void parseDocument(){
		//get the root elememt
		Element docEle = dom.getDocumentElement();
		
		//get a nodelist of <Items> elements
		NodeList nl = docEle.getElementsByTagName("Item");
		
		if(nl != null && nl.getLength() > 0) {
			for (int i = 0 ; i < nl.getLength();i++) { // Iterate through list
				//get the <data> element
				Element el = (Element)nl.item(i);
				
				System.out.println(el.getNodeName());
				
				//get the Department object
				Object d = getData(el);
				//add it to list
				dataList.add(d);
			}
		}
	}
	
	protected abstract Object getData(Element dataEl);
}