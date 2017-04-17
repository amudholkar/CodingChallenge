import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/***
 * 
 * To write data passed, to the file
 *
 */
public class Writer {
	
	public Writer(){
		
	}
	
	
	public void writeFile(String fileName, ArrayList<String> data){
		try {
            
			
            FileWriter fileWriter = new FileWriter(fileName, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            String line = "";
            int i;
            for(i=0; i<data.size()-1; i++){
            	
            	line += data.get(i) + ",";
            	
            }
            
            line += data.get(i)+"\n";

            
            bufferedWriter.write(line);
            

            
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Error writing to file '"+ fileName + "'");
          
        }
		
		
	}

}
