
public class Table {
	
	private int tableNum;
	private Waiter waiterAssigned;
	private static final String UNASSIGNED = "UNASSIGNED";

	public Table(int tableNum){
		this.tableNum = tableNum;
		//Instead of implementing null object pattern
		this.waiterAssigned = new Waiter(UNASSIGNED,0);
		
		
	}
	
	public Waiter getAssignedWaiter(){
			
		return this.waiterAssigned;	
		
	}
	

	public int getTableNum(){
		return tableNum;
	}
	
	public void assignWaiter(Waiter waiter){
		waiterAssigned = waiter;
		
		
	}
	
	public boolean isAssigned(){
		
		if(waiterAssigned.getName() == UNASSIGNED){
			return false;
		}
		
		return true;
	}
	
	public String toString(){
		return "Table "+ Integer.toString(tableNum) + ": " + waiterAssigned.getName();
	}
	

}
