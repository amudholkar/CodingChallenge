import java.awt.EventQueue;

public class RunManager {
	
	protected static final String FILENAME = "assignTables.txt";
	
	public static void main(String[] args) {
		//TODO Auto-generated method stub
		Writer writer = new Writer();
		Hotel hotel = new Hotel(writer);
		
		

		
		Reader reader = new Reader(hotel);
		reader.readFile(FILENAME);
		
	
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home(hotel);
					//frame.pack();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
