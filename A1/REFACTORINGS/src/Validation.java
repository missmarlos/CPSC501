package cpsc501a1;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Validation extends UserRecord{
	Validation(String u, String p){
		setUsername(u);
		setPassword(p);
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
	
	public boolean loginStatus() {
		boolean validLogin = false;
		loadHashMap();
		if(passwordMatches(getUsername(),getPassword())) {
			validLogin = true;
		}
		return validLogin;
	}
	
	public boolean createUser() {
		boolean userCreated = false;
		loadHashMap();
		
		//if username is not in the db and password passes rules
		if(validateNoUsername(getUsername()) && validatePassword(getPassword())) {
			System.out.println("username and password are good");
			setUsername(getUsername());
			setPassword(getPassword());
			String login = getUsername()+","+getPassword();
			userCreated = true;
			try {
				PrintWriter pw = new PrintWriter(new FileOutputStream("userDB.txt", true));;
				pw.append(login+"\n");
				pw.close();
			}catch(Exception e){
				
			}
		}else if(!validateNoUsername(getUsername())) {
			userCreated = false;
		}else{
			System.out.println("username or password invalid try again");
			userCreated = false;
		}
		return userCreated;
	}

		
}
