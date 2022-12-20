import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.hcl.repository.OrderRepository;
import com.hcl.service.FoodItemService;
import com.hcl.service.UserService;
import com.hcl.to.FoodItemTO;
import com.hcl.to.OrderTO;
import com.hcl.to.UserTO;

public class Runner {

	public static void main(String[] args) {
		
		UserTO userTo = null;

		Scanner sc = new Scanner(System.in);

		boolean loginFlag = true;

		while(loginFlag) {
			
			System.out.println("Press 1 for Login and 2 to Register and 0 for Logout!!");

			int value = sc.nextInt();

			switch(value) {

			case 1:

				userTo = login();

				if(userTo != null) {

					loginFlag  = false;

					displayAllFoodItems();	
					
					System.out.println("Press 1 for Order Food item and 0 for Logout");
					
					int orderOrNot = sc.nextInt();
					
					switch(orderOrNot) {
					
					case 0:
						
						loginFlag = false;
						break;
						
					case 1:
						
						Map<Integer, Integer> order = takeOrder();
						
						OrderTO orderTo = new OrderTO(userTo.getUsername(), new Date(), order);
				
						OrderRepository orderRepository = new OrderRepository();
						
						orderRepository.saveOrder(orderTo);
						
					}
				}
				else {

					System.out.println("Wrong Credentials, please try again!!");
				}
				break;

			case 2:

				register();

				break;

			case 0:

				System.out.println("Good Bye and hoping to See you Again...");

				loginFlag = false;
				break;
			}
		}


	}

	static public void register() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your username!!");
		String username = sc.next();

		System.out.println("Enter your Password");
		String password = sc.next();

		System.out.println("Enter your Name!!");
		String name = sc.next();

		System.out.println("Enter your Email!!");
		String email = sc.next();

		System.out.println("Enter your Role, press 1 as Admin and 2 for Customer!!");

		int roleValue = sc.nextInt();

		UserTO to = new UserTO(username, password, name, email, null);

		if(roleValue == 1) {
			to.setRole("Admin");
		}
		else {
			to.setRole("Customer");
		}

		UserService service = new UserService();

		service.saveUser(to);

		System.out.println("Thanks for Registering with us!!");
	}

	static public UserTO login() {

		UserService service = new UserService();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your Username!!");	
		String uname = sc.next();

		System.out.println("Enter your Password!!");
		String pwd = sc.next();

		UserTO userTo = service.validate(uname, pwd);

		return userTo;
	}

	static public void displayAllFoodItems() {

		FoodItemService foodItemService = new FoodItemService();

		List<FoodItemTO> foodItemTOs = foodItemService.getAllFoodItems();

		foodItemTOs.forEach(value1 -> System.out.println(value1.getItemId()+", "+value1.getFoodName()+", "+value1.getPrice()+", "+value1.getDesc()));
	}
	
	static public Map<Integer, Integer> takeOrder() {
		
		Scanner sc = new Scanner(System.in);
		
		boolean orderNotFinishedFlag = true;
		
		Map<Integer, Integer> foodItems = new HashMap<Integer, Integer>();
		
		while(orderNotFinishedFlag) {
			
			System.out.println("Enter your FoodItem Id");
			int foodItem = sc.nextInt();
			
			System.out.println("Enter the quantity");
			int quantity = sc.nextInt();
			
			foodItems.put(foodItem, quantity);
			
			System.out.println("Press 1 to finalize the order and 2 to continue ordering...");
			
			int orderContinue = sc.nextInt();
			
			if(orderContinue == 1) {
				orderNotFinishedFlag = false;
			}
		}
		
		return foodItems;
	}

}
