package com.tgt.redallure.controller;

import java.util.Iterator;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tgt.redallure.service.InterestMapping;
import com.tgt.redallure.service.Item;
import com.tgt.redallure.service.ItemParser;
import com.tgt.redallure.service.DailyDealsDataParser;

@Controller
@RequestMapping("dailydeals.do")
public class DailyDealsController {
	
	@RequestMapping(method = RequestMethod.GET, params =  {"action=getDailyDeals"})
    public ModelAndView getDailyDeals(@RequestParam("interestName") String interestName) {
          System.out.println("getDailyDeals");
         
          System.out.println("interest = " + interestName);
         
          String categoryName = InterestMapping.getCategoryByInterestName(interestName);
         
          System.out.println("category = " + categoryName);

          String storeId = "";
          String deptId = "";
          String deptName = "";
         
          if (categoryName.equalsIgnoreCase("entertainment")) {
                storeId = "1764";
                deptId = "5118494";
                deptName = "entertainment";
          }
          else if (categoryName.equalsIgnoreCase("electronics")) {
                storeId = "1764";
                deptId = "5118498";
                deptName = "electronics";
          }
          else if (categoryName.equalsIgnoreCase("grocery")) {
                storeId = "1764";
                deptId = "5118487";
                deptName = "grocery";
          }
          else {
                storeId = "1764";
                deptId = "5118487";
                deptName = "grocery";
          }

          String url = "http://198.101.208.186:8000/rest/dailydeals";
          
          System.out.println(url);
          String responseBody = null;
          responseBody = getDataFromService(url);
          
          DailyDealsDataParser itemParser = new ItemParser();
          List recommendedItems = itemParser.getDataList(responseBody);
         
          ModelAndView mv = new ModelAndView("dailydeals-view");
          mv.addObject("itemList", recommendedItems);
 		  mv.addObject("storeId",storeId); 
 		  mv.addObject("deptId",deptId);
 		  mv.addObject("deptName",deptName);

          return mv;
    }
	
	@RequestMapping(method = RequestMethod.GET, params =  {"action=getItems"})
	public ModelAndView getItems(@RequestParam("storeId") String storeId,@RequestParam("deptId") String deptId,@RequestParam("deptName") String deptName){
		 System.out.println("getItems");
		//http://weeklyad.target.com/target/api.aspx?format=xmlsm&ver=v2&rpc=getitemlist&mode=dept&storeref=1764&cattreeid=5113372&campaignid=98b026a4c0801a2e&resultset=full	
		 String url="http://target.shoplocal.com/target/api.aspx?format=xmlsm&ver=v2&rpc=getitemlist&mode=dept&storeref="+storeId+"&cattreeid="+deptId+"&campaignid=98b026a4c0801a2e&resultset=full";
		 System.out.println(url);
		 String responseBody=null;
		 responseBody=getDataFromService(url);
		 DailyDealsDataParser itemParser=new ItemParser(); 
		 List itemList=itemParser.getDataList(responseBody);
		 Iterator it=itemList.iterator();
		 while(it.hasNext())
		 {
			 Item i =(Item)it.next();
			 System.out.println(i.getVo()+","+i.getListingid()+","+i.getTitle()+","+i.getPrice()+","+i.getProductdescription()+","+i.getImageURL());
		 }
		 ModelAndView mv=new ModelAndView("recommendations");
		 mv.addObject("storeId",storeId); 
		 mv.addObject("deptId",deptId);
		 mv.addObject("deptName",deptName);
		 mv.addObject("itemList",itemList); 
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, params =  {"action=getItemDetails"})
	public ModelAndView getItemDetails(@RequestParam("storeId") String storeId,@RequestParam("deptId") String deptId,@RequestParam("deptName") String deptName, @RequestParam("itemId") String itemId){
		 System.out.println("getItemDetails");
		//http://weeklyad.target.com/target/api.aspx?format=xmlsm&ver=v2&rpc=getitemlist&mode=listing&storeref=1764&listingid=-2083530570&campaignid=98b026a4c0801a2e	
		 String url="http://target.shoplocal.com/target/api.aspx?format=xmlsm&ver=v2&rpc=getitemlist&mode=listing&storeref="+storeId+"&listingid="+itemId+"&campaignid=98b026a4c0801a2e";
		 System.out.println(url);
		 String responseBody=null;
		 responseBody=getDataFromService(url);
		 ItemParser itemParser=new ItemParser(); 
		 List itemList=itemParser.getDataList(responseBody);
		 Item i =(Item)itemList.get(0);
		 System.out.println(i.getVo()+","+i.getListingid()+","+i.getTitle()+","+i.getPrice()+","+i.getProductdescription()+","+i.getImageURL());
		 ModelAndView mv=new ModelAndView("itemdetails");
		 mv.addObject("storeId",storeId); 
		 mv.addObject("deptId",deptId);
		 mv.addObject("deptName",deptName);
		 mv.addObject("item",i); 
		 return mv;
	}
	
	private String getDataFromService(String url) {
		HttpClient httpclient=new DefaultHttpClient();
		String responseBody=null;
		
		try	{
			
			 HttpGet httpget = new HttpGet(url);
			 System.out.println("executing request " + httpget.getURI());
			 ResponseHandler<String> responseHandler = new BasicResponseHandler();
			 responseBody = httpclient.execute(httpget, responseHandler);
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	        httpclient.getConnectionManager().shutdown();
	    }
		
		return responseBody;
	}

}
