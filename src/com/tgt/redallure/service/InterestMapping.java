package com.tgt.redallure.service;

import java.util.Properties;

public class InterestMapping {

	/*
	From URL:  http://sites.target.com/site/en/spot/mobile_weekly_ad.jsp?zip=55419&searchType=weeklyad
	
	grocery
	home
	men
	sports & outdoors
	toys
	entertainment
	health & beauty
	baby
	women
	electronics
	Weekly WOW
	Target brands
	kids
	furniture
	*/
	
	public static String getCategoryByInterestName(String interestName) {
		String categoryName = "";
		
		if (interestName.equalsIgnoreCase("Video Games")) {
			categoryName = "electronics";
		}
		else if (interestName.equalsIgnoreCase("Movies")) {
			categoryName = "entertainment";
		}
		else if (interestName.equalsIgnoreCase("Books")) {
			categoryName = "entertainment";
		}
		else if (interestName.equalsIgnoreCase("Cooking")) {
			categoryName = "grocery";
		}
		else {
			categoryName = "unknown";
		}
		return categoryName;
	}
	
}
