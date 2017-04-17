import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
/***
 * 
 * To read contents of the file and assign it to the corresponding variables in the program
 *
 */
public class Reader {
	
	private Hotel hotel;
	private static final int ID = 0;
	private static final int WAITER_NAME = 1;
	private static final int TABLE_NUM = 2;
	
	public Reader(Hotel hotel){
		this.hotel = hotel;
		
	}
	
	public void readFile(String fileName){
		String line = null;

        try {
            
            FileReader fileReader = new FileReader(fileName);
           
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
               String[] tokens = line.split(",");
               
               int restID = Integer.parseInt(tokens[ID]);
               String waiterName = tokens[WAITER_NAME];
               int tableNum = Integer.parseInt(tokens[TABLE_NUM]);
               
               hotel.assignWaiter(restID, waiterName, tableNum);
               
               
            }   

            
            bufferedReader.close();         
        }
        catch(FileNotFoundException e) {
            System.out.println("Unable to open file '" + fileName + "'");                
        }
        catch(IOException e) {
            System.out.println("Error reading file '" + fileName + "'");                  
            
        }
    
	}

}
