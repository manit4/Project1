package com.hcl.to;

import java.util.Date;
import java.util.Map;

public class OrderTO {
	
	private String username;
	private Date date;
	private Map<Integer, Integer> foodItems;
	
	public OrderTO() {
		
	}
	public OrderTO(String username, Date date, Map<Integer, Integer> foodItems) {
		super();
		this.username = username;
		this.date = date;
		this.foodItems = foodItems;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Map<Integer, Integer> getFoodItems() {
		return foodItems;
	}
	public void setFoodItems(Map<Integer, Integer> foodItems) {
		this.foodItems = foodItems;
	}

}
