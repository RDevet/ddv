package com.tgt.redallure.service;


public class Item {
	
	private String vo = "";
	private String listingid = "";
	private String title = "";
	private String imageURL = "";
	private String price = "";
	private String productdescription = "";
	
	public Item(){
		
	}

	public Item(String vo, String listingid, String title,String price, String imageURL,String productdescription) {

		this.vo = vo;
		this.listingid = listingid;
		this.title = title;
		if(imageURL!=null){
			this.imageURL = imageURL.replaceAll("60.0.75.0", "300.0.300.0");
		}
		this.price = price;
		this.productdescription = productdescription;
	}

	public void setVo(String vo) {
		this.vo = vo;
	}

	public String getVo() {
		return vo;
	}

	public void setListingid(String listingid) {
		this.listingid = listingid;
	}

	public String getListingid() {
		return listingid;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getImageURL() {
		return imageURL;
	}


	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrice() {
		return price;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public String getProductdescription() {
		return productdescription;
	}

}
