
import java.util.Scanner;

public class Login extends SignUp{
	//make this extend signup
	String username;
	String password;
	
	Login(String u, String pw){
		this.username = u;
		this.password = pw;
	}
	
	//use this method in Gui when login is pressed
	
	public boolean loginStatus() {
		boolean validLogin = false;
		loadHashMap();
		if(passwordMatches(username,password)) {
			validLogin = true;
		}
		return validLogin;
	}
	
	
}
