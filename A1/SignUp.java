package cpsc501a1;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.*;
import java.io.*;

public class SignUp {
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
	}
	
	public void createUser() {
		loadHashMap();
		String tempUsername;
		String tempPassword;
		System.out.println("Enter a username: ");
		tempUsername = input.nextLine();
		System.out.println("Enter a password: ");
		tempPassword = input.nextLine();
		
		if(validateUsername(tempUsername) && validatePassword(tempPassword)) {
			System.out.println("username and password are good");
			username = tempUsername;
			password = tempPassword;
			String login = username+","+password;
			try {
				PrintWriter pw = new PrintWriter(new FileOutputStream("userDB.txt", true));;
				pw.append(login+"\n");
				pw.close();
			}catch(Exception e){
				
			}
		}else {
			System.out.println("username or password invalid try again");
		}
	}
	
	public boolean validateUsername(String u) {
		boolean isValidUsername = false;
		//check that there is no whitespace
		if(u.contains(" ")) {
			isValidUsername = false;
		}if(fileExists == true) {
			if(userDB.containsKey(u)) {
				System.out.println("Flop");
				isValidUsername = false;
			}
		}else {
			isValidUsername = true;
		}
		return isValidUsername;
	}
	
	public boolean validatePassword(String p) {
		boolean isValidPassword = false;
		String[] symbols = {"!", "@", "#", "$", "%", "^", "&", "*", "-", "_", "+", "=", "."};
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
	public boolean passwordMatches() {
		return false;
	}
}
