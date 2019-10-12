import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserRecord {
	Map <String, String> userDB = new HashMap<>(); 
	private String username; 
	private String password;
	Scanner input = new Scanner(System.in);
		
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String u) {
		username = u;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String p) {
		password = p;
	}
	
	public void loadHashMap() {
		File file = new File("userDB.txt");
		boolean fileExists;
		if(file.exists()) {
			fileExists = true;
			System.out.println("File exists");
			String line;
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				while ((line = reader.readLine()) != null)
			    {
			        String[] parts = line.split(",", 2);
			        userDB.put(parts[0], parts[1]);
			    }
				reader.close();
			}catch(Exception e) {
				
			}
		}
		System.out.println(Arrays.asList(userDB));
	}
	
}
