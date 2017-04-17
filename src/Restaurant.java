import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class Restaurant {
	
	
	private HashMap<Integer, Table> tablesHashMap;
	private int restaurantID;
	
	/***
	 * 
	 * @param restaurantID
	 * @param numTables - To initialize the tables
	 */
	public Restaurant(int restaurantID, int numTables){
		
		this.restaurantID = restaurantID;
		
		tablesHashMap = new HashMap<Integer,Table>();
		
		
		for(int num=1; num<=numTables;num++){
			
			Table newTable = new Table(num);
			tablesHashMap.put(num, newTable);
			
		}
		
	}
	
	
	public int getID(){
		return restaurantID;
	}
	
	/***
	 * 
	 * @return Returns a string with all the tables and the corr waiters
	 */
	public String viewTables(){
		String result = "";
		
		
		
		Set set = tablesHashMap.entrySet();
	    Iterator iterator = set.iterator();
	    while(iterator.hasNext()) {
	    	Map.Entry mentry = (Map.Entry)iterator.next();
	    	
	    	//Get table instance
	    	Table thisTable = (Table)mentry.getValue();
	    	
	    	//Convert table to string (Table tableNum : WaiterName) 
	    	result += thisTable.toString() + "\n";
	    	
	    	
	    	
	    	
	    }
		
		return result;
	}
	
	/***
	 * 
	 * @return returns a list of all the unassigned tables
	 */
	
	public ArrayList<Integer> viewUnassignedTables(){
		ArrayList<Integer> unassignedTables = new ArrayList<Integer>();
		
		Set set = tablesHashMap.entrySet();
	    Iterator iterator = set.iterator();
	    while(iterator.hasNext()) {
	    	Map.Entry mentry = (Map.Entry)iterator.next();
	    	
	    	Table thisTable = (Table)mentry.getValue();
	    	
	    	//isAssigned checks if the table is assigned to a waiter or not
	    	if (thisTable.isAssigned() == false){
	    		unassignedTables.add((Integer)mentry.getKey());
	    	}
	    	
	    	
	    }
	   
	    
	    return unassignedTables;
		
		
	}
	
	/***
	 * 
	 * @param tableNum
	 * @param waiter
	 * To assign the waiter to the table
	 */
	public void assignWaiter(int tableNum, Waiter waiter){
		
		(tablesHashMap.get(tableNum)).assignWaiter(waiter);
		
	}
	
	
	
	

}
