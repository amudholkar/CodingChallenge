import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;


public class Waiter {
	
	String name;
	//The keys correspond to the rest ID and the values correspond to the tables assigned to the waiter 
	//in the restaurant
	private HashMap<Integer, ArrayList<Integer>> tablesAssignedHashMap;
	
	public Waiter(String name, int numRest){
		// only the first name for now
		// we could have two people with the same first name
		// talk about this in assumptions
		
		this.name = name;
		
		tablesAssignedHashMap = new HashMap<Integer, ArrayList<Integer>>();
		
		//for loop here
		for(int num=1; num<=numRest; num++){
			tablesAssignedHashMap.put(num,new ArrayList<Integer>());
			
		}
			
		
	}
	
	public String getName(){
		return name;
	}
	
	/***
	 * 
	 * @param restaurantID
	 * @param tableNum
	 * Adds table to the corresponding Rest ID
	 */
	public void addTableNum(int restaurantID, int tableNum){
		(tablesAssignedHashMap.get(restaurantID)).add(tableNum);
		
	}
	
	/***
	 * 
	 * @return Returns a String of all the tables assigned to the waiter
	 */
	
	public String viewAssignedTables(){
		
		String result = "";
		int num;
		
		Set set = tablesAssignedHashMap.entrySet();
	    Iterator iterator = set.iterator();
	    while(iterator.hasNext()) {
	    	Map.Entry mentry = (Map.Entry)iterator.next();
	    	
	    	ArrayList<Integer> tablesAssigned = (ArrayList<Integer>)mentry.getValue();
	    	
	    	result += "Restaurant " + mentry.getKey() + ": " ;
//	    	for (int tableNum : tablesAssigned){
//				result += "Table " + tableNum + ",";
//			}
			
	    	
	    	for (num=0; num < tablesAssigned.size()-1;num++){
				result += "Table " + tablesAssigned.get(num) + ", ";
			}
	    	
			result += "Table " + tablesAssigned.get(num)+"\n";
	    	
	    	
	    	
	    }
		
		return result;
		
	}
	
	
	public boolean isAvailable(int restaurantID){
		
		if(tablesAssignedHashMap.get(restaurantID).size() < 4){
			return true;
		}
		
		return false;
	}

}
