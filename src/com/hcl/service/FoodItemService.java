package com.hcl.service;

import java.util.List;

import com.hcl.repository.FoodItemRepository;
import com.hcl.to.FoodItemTO;

public class FoodItemService {
	
	public List<FoodItemTO> getAllFoodItems() {
		
		FoodItemRepository repository = new FoodItemRepository();
		
		return repository.getFoodItems();
	}

}
