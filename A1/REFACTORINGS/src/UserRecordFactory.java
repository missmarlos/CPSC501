import java.util.Scanner;

public class UserRecordFactory {
	public UserRecord createUserRecord(String userInput, Scanner in) {
		UserRecord user = null;
		
		System.out.println("Enter a username");
		String u = in.nextLine();
		System.out.println("Enter a password");
		String p = in.nextLine();
		
		if(userInput.equals("signup")) {
			return new SignUp(u, p);
		}else if(userInput.equals("login")) {
			return new Login(u, p);
		}else return null;
	}
	
	
}
