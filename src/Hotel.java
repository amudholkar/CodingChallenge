import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

//Controller
public class Hotel {

	private HashMap<Integer, Restaurant> restaurantHashMap;
	private HashMap<String, Waiter> waiterHashMap; 
	private Writer writer;
	
	private Manager manager;
	
	/***
	 * 
	 * @param writer - writer is the class that handles file writing
	 */
	
	public Hotel(Writer writer){
		
		this.writer = writer; 
		
		restaurantHashMap = new HashMap<Integer, Restaurant>();
		waiterHashMap =new HashMap<String, Waiter>();
		
		//Test values that will come from a database
		
		
		restaurantHashMap.put(1, new Restaurant(1,20));
		restaurantHashMap.put(2, new Restaurant(2,20));		
		
		//HashMap from name to instance - we receive the name from view
		//HashMap with O(1) is the most efficient way to retrieve the associated instance 
		waiterHashMap.put("Lee", new Waiter("Lee",2));
		waiterHashMap.put("Marcus", new Waiter("Marcus",2));
		
		manager = new Manager("Mark");		
		
	}
	
	
	

	/***
	 * 
	 * @param restaurantID - Hash map maps from Restaurant ID to Restaurant instance
	 * @return Returns a string of all the tables in the restaurant with their corresponding waiters
	 */
	public String viewTables(int restaurantID){
		
		String result = (restaurantHashMap.get(restaurantID)).viewTables();
		return result;
		
	}
	
	/***
	 * 
	 * @param waiterName - Name of the the waiter received from View
	 * @return Returns a string of all the tables assigned to that waiter
	 */
	public String viewAssignedTables(String waiterName){
		
		String result = waiterHashMap.get(waiterName).viewAssignedTables();
		return result;
	}

	/***
	 * 
	 * @param restaurantID - To HashMap to the instance
	 * @return Returns a list of all the waiters that can be assigned to another table 
	 * Availability of a waiter is based on the given constraint - no waiter can to assigned more than  
	 * 4 tables per restaurant
	 */
	public ArrayList<String> viewAvailableWaiters(int restaurantID){
		ArrayList<String> availableWaiters = new ArrayList<String>();

		Set set = waiterHashMap.entrySet();
	    Iterator iterator = set.iterator();
	    while(iterator.hasNext()) {
	    	Map.Entry mentry = (Map.Entry)iterator.next();
	    	
	    	Waiter thisWaiter = (Waiter)mentry.getValue();
	    	
	    	//checks if the waiter is available based on the given constraint
	    	if(thisWaiter.isAvailable(restaurantID)){
	    		availableWaiters.add((String)mentry.getKey());
	    		
	    	}
	    	
	    	
	    }

		return availableWaiters;
		
	}
	
	/***
	 * 
	 * @param restaurantID - Same as above
	 * @return - Returns a list of all the unassigned table numbers in the given restaurant
	 * 
	 */
	public ArrayList<Integer> viewUnassignedTables(int restaurantID){
		return (restaurantHashMap.get(restaurantID)).viewUnassignedTables();
	}
	
	/***
	 * 
	 * @param restaurantID - The three parameters are received from view 
	 * @param waiterName
	 * @param tableNum
	 * The function assigns the waiter corr. to the waiterName to the table corr. to the 
	 * tableNum in the restaurant corr. the restaurant ID
	 */
	public void assignWaiter(int restaurantID, String waiterName, int tableNum){
		
		Waiter thisWaiter = waiterHashMap.get(waiterName);
		
		(restaurantHashMap.get(restaurantID)).assignWaiter(tableNum, thisWaiter);
		
		//adds table to the waiter as per design model
		thisWaiter.addTableNum(restaurantID,tableNum);
		
		
		
	}
	
	/***
	 * 
	 * @param restaurantID
	 * @param waiterName
	 * @param tableNum
	 * Writes given params to file
	 */
	
	public void writeToFile(int restaurantID, String waiterName, int tableNum){
		ArrayList<String> data = new ArrayList<String>();
		
		data.add(Integer.toString(restaurantID));
		data.add(waiterName);
		System.out.print(waiterName);
		data.add(Integer.toString(tableNum));
		
		writer.writeFile(RunManager.FILENAME, data);
	}
	
	/***
	 * 
	 * @return Restaurant ID list for JList
	 */
	public ArrayList<String> restKeysToString(){
		
		ArrayList<String> strRestKeys = new ArrayList<String>();
		
		Set set = restaurantHashMap.entrySet();
	    Iterator iterator = set.iterator();
	    while(iterator.hasNext()) {
	    	Map.Entry mentry = (Map.Entry)iterator.next();
	    	
	    	strRestKeys.add("Restaurant " + mentry.getKey());
	    	
	    }
	    
	    return strRestKeys;
		
	}
	
	/***
	 * 
	 * @return Waiter list for JList
	 */
	
	public ArrayList<String> waiterKeys(){
		ArrayList<String> waiterKeys = new ArrayList<String>();
		
		Set set = waiterHashMap.entrySet();
	    Iterator iterator = set.iterator();
	    while(iterator.hasNext()) {
	    	Map.Entry mentry = (Map.Entry)iterator.next();
	    	
	    	waiterKeys.add((String)mentry.getKey());
	    	
	    }
	    
	    return waiterKeys;
		
	}





	

	
	
	
	
	

}
