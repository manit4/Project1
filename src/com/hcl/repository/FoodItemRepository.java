package com.hcl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hcl.db.DBConnection;
import com.hcl.to.FoodItemTO;

public class FoodItemRepository {
	
	public List<FoodItemTO>  getFoodItems() {
		
		List<FoodItemTO> foodItems = new ArrayList<FoodItemTO>();
		
		try {
			
			Connection conn = DBConnection.getConnection();
			PreparedStatement statement = conn.prepareStatement("select * from food_item");
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				
				int itemId = rs.getInt(1);
				String foodName = rs.getString(2);
				int price = rs.getInt(3);
				String desc = rs.getString(4);
				
				FoodItemTO foodItemTO = new FoodItemTO(itemId, foodName, price, desc);
				
				foodItems.add(foodItemTO);
			}
		}
		catch(Exception e ) {
			
			System.out.println("inside catch  of getFoodItems...");
			e.printStackTrace();
		}
		
		return foodItems;
	}

}
