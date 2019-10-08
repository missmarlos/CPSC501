import java.awt.EventQueue;

import javax.swing.JFrame;
import java.util.Scanner;

/**
 * This is where the program gets run from
 *
 * @author mar
 *
 */
public class Main {
	
	public static void main(String arg[]) {
		Main r = new Main();
		r.RunProgram();
	}
	
	public void RunProgram() {
		//this is where sequence of code will be run.
		System.out.println("Login or Signup, please login if you have an account, otherwise signup");
		
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		boolean hasLoggedIn = false;
		while(hasLoggedIn == false) {
			if(input.equals("login")) {
				System.out.println("Enter your username");
				String username = in.nextLine();
				System.out.println("Enter your password");
				String password = in.nextLine();
				Login l = new Login(username, password);
				if(l.loginStatus()) {
					System.out.println("Login successful");
					hasLoggedIn = true;
				}else {
					System.out.println("Invalid login please try again");
					hasLoggedIn = false;
					System.out.println("Login or Signup, please login if you have an account, otherwise signup");
					input = in.nextLine();
				}
				
			}else if(input.equals("signup")) {
				System.out.println("Enter a username");
				String tempUsername = in.nextLine();
				System.out.println("Enter a password");
				String tempPassword = in.nextLine();
				Login l = new Login(tempUsername, tempPassword);
				if(l.createUser(tempUsername, tempPassword)) {
					System.out.println("Account created");
					hasLoggedIn = true;
				}else {
					System.out.println("Try again");
					hasLoggedIn = false;
					System.out.println("Login or Signup, please login if you have an account, otherwise signup");
					input = in.nextLine();
				}
				
				
			}else {
				System.out.println("Command unrecognized, please type again");
				System.out.println("Login or Signup, please login if you have an account, otherwise signup");
				input = in.nextLine();
			}
		}
	
		System.out.println("MAIN MENU\n Where do you want to go?\n DIARY\n TODO\n");
		input = in.nextLine();
		Diary d = new Diary();
		ToDo td = new ToDo();
		while(!(input.equals("exit"))) {
			if(input.equals("diary")) {
				System.out.println("MAKE FILE\n DISPLAY FILE\n REMOVE FILE\n");
				input = in.nextLine();
				System.out.println("Enter file name");
				String filename = in.nextLine();
				//Diary d = new Diary();
				if(input.equals("make file")) {
					d.newEntry(filename, in);
				}else if(input.equals("display file")){
					System.out.println(d.getFileContent(filename));
					
				}else if(input.equals("remove file")){
					d.removeFile(filename);
				}
			}else if(input.equals("todo")) {
				System.out.println("ADD A TASK\n COMPLETE A TASK\n");
				input = in.nextLine();
				if(input.equals("add task")) {
					td.addTask("todo.txt", in);
				}else if(input.equals("complete task")) {
					td.completeTask("todo.txt", "completed.txt", in);
				}else {
					System.out.println("Invalid");
				}
				
			}else{
				System.out.println("MAIN MENU\n Where do you want to go?\n DIARY\n AGENDA\n TODO\n");
				input = in.nextLine();
			}
		}
		System.out.println("Thank you");
	}
}
