
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.*;
import java.io.*;

public abstract class SignUp {
	Map <String, String> userDB = new HashMap<>(); 
	String username; 
	String password;
	Scanner input = new Scanner(System.in);
	boolean fileExists = false;
	
	
	public void loadHashMap() {
		File file = new File("userDB.txt");
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
	
	public boolean createUser(String u, String p) {
		boolean userCreated = false;
		loadHashMap();
		String tempUsername = u;
		String tempPassword = p;
		/*
		System.out.println("Enter a username: ");
		tempUsername = input.nextLine();
		System.out.println("Enter a password: ");
		tempPassword = input.nextLine();
		*/
		
		
		
		
		//if username is not in the db and password passes rules
		if(validateNoUsername(tempUsername) && validatePassword(tempPassword)) {
			System.out.println("username and password are good");
			username = tempUsername;
			password = tempPassword;
			String login = username+","+password;
			userCreated = true;
			try {
				PrintWriter pw = new PrintWriter(new FileOutputStream("userDB.txt", true));;
				pw.append(login+"\n");
				pw.close();
			}catch(Exception e){
				
			}
		}else {
			//System.out.println(validateNoUsername(tempUsername));
			//System.out.println(validatePassword(tempPassword));
			System.out.println("username or password invalid try again");
			userCreated = false;
		}
		return userCreated;
	}
	
	public boolean validateNoUsername(String u) {
		boolean isValidUsername = false;
		if(u.contains(" ")) {
			isValidUsername = false;
			System.out.println("This contains white space");
		}else if(userDB.containsKey(u)) {
			System.out.println("This username is already in the file");
			isValidUsername = false;
		}else{
			System.out.println("Username does not exist yet");
			isValidUsername = true;
		}
		return isValidUsername;
	}
	
	public boolean validatePassword(String p) {
		boolean isValidPassword = false;
		String[] symbols = {"!", "@", "#", "$", "%"};
		String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
		String[] uppercase = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", 
				"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		String[] lowercase = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", 
				"q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

		int count = 0;
		//check that the password is at least of length 8
		if(p.length() >= 8) {
			count++;
		}
		//check that it has at least one symbol
		for(int i = 0; i < symbols.length; i++) {
			if(p.contains(symbols[i])) {
				count++;
				break;
			}
		}
		//check that it has at least one number
		for(int i = 0; i < numbers.length; i++) {
			if(p.contains(numbers[i])) {
				count++;
				break;
			}
		}
		//check that it has at least one uppercase
		for(int i = 0; i < uppercase.length; i++) {
			if(p.contains(uppercase[i])) {
				count++;
				break;
			}
		}
		
		//check that it has at least one lowercase
		for(int i = 0; i < lowercase.length; i++) {
			if(p.contains(lowercase[i])) {
				count++;
				break;
			}
		}
		
		if(count == 5) {
			isValidPassword = true;
		}
		return isValidPassword;
	}
	
	//this class will check if the password matches the username given
	public boolean passwordMatches(String username, String password) {
		String tempUsername = username;
		String tempPassword = password;
		boolean pwMatch = false;
		
		if(userDB.containsKey(username)) {
			if(userDB.get(tempUsername).equals(tempPassword)) {
				pwMatch = true;
			}
		}
		
		return pwMatch;
	}
	
	//check if login is valid.
	abstract boolean loginStatus(); 

}
