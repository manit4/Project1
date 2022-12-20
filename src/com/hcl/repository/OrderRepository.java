package com.hcl.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.hcl.db.DBConnection;
import com.hcl.to.OrderTO;

public class OrderRepository {

	public void saveOrder(OrderTO orderTO) {

		try {

			Connection conn = DBConnection.getConnection();
			PreparedStatement statement = conn.prepareStatement("insert into food_order(date)values(?)");

			statement.setString(1, orderTO.getDate()+"");

			statement.executeUpdate();

			PreparedStatement statement2 = conn.prepareStatement("select max(order_id) from food_order");

			ResultSet rs = statement2.executeQuery();
			
			rs.next();
			
			int orderId = rs.getInt(1);
			
			Map<Integer, Integer> foodItems = orderTO.getFoodItems();
			
			Set<Integer> itemsKey = foodItems.keySet();
			
			Iterator it = itemsKey.iterator();
			
			while(it.hasNext()) {
				
				int foodItem = (Integer)it.next();
				
				int quantity = foodItems.get(foodItem);
				
				PreparedStatement statement3 = conn.prepareStatement("insert into user_order values(?, ?, ?, ?)");

				statement3.setString(1, orderTO.getUsername());
				statement3.setInt(2, orderId);
				statement3.setInt(3, foodItem);
				statement3.setInt(4, quantity);

				statement3.executeUpdate();	
			}

		}
		catch(Exception e) {

			System.out.println("inside catch of saveOrder...");
			e.printStackTrace();
		}
	}

}
