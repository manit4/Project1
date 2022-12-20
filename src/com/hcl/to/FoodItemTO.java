package com.hcl.to;

public class FoodItemTO {
	
	private int itemId;
	private String foodName;
	private int price;
	private String desc;
	
	public FoodItemTO() {
		
	}
	public FoodItemTO(int itemId, String foodName, int price, String desc) {
		super();
		this.itemId = itemId;
		this.foodName = foodName;
		this.price = price;
		this.desc = desc;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

}
