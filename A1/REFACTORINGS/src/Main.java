import java.awt.EventQueue;
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
			UserRecordFactory factory = new UserRecordFactory();
			UserRecord user = null;
			user = factory.createUserRecord(input, in);
			
			if(user!=null) {
				hasLoggedIn = doSomething(user, hasLoggedIn);
				
			}else {
				System.out.println("Invalid please try again");
				hasLoggedIn = false;
				System.out.println("Login or Signup, please login if you have an account, otherwise signup");
				input = in.nextLine();
			}
		}
		
		if(hasLoggedIn == true) {
			System.out.println("MAIN MENU\n Where do you want to go?\n DIARY\n TODO\n AGENDA");
			input = in.nextLine();
			Diary d = new Diary();
			ToDo td = new ToDo();
			Agenda a = new Agenda();
			while(!(input.equals("exit"))) {
				if(input.equals("diary")) {
					System.out.println("MAKE FILE\n DISPLAY FILE\n REMOVE FILE\n EDIT FILE\n");
					input = in.nextLine();
					System.out.println("Enter file name");
					String filename = in.nextLine();
					//Diary d = new Diary();
					if(input.equals("make file")) {	
						d.newEntry(filename, in, "Append or overwrite file?");
					}else if(input.equals("edit file")) {
						if(d.newEntry(filename, in, "Append or overwrite file?")){
							d.appendOrOverwrite(filename, in);
						}
					}else if(input.equals("display file")){
						System.out.println(d.getFileContent(filename));
						
					}else if(input.equals("remove file")){
						d.removeFile(filename);
					}
				}else if(input.equals("todo")) {
					//load todo list
					td.loadTodoList("todo.txt");
					System.out.println("ADD A TASK\n COMPLETE A TASK\n");
					input = in.nextLine();
					//after adding, update the arraylist
					if(input.equals("add task")) {
						td.addTask("todo.txt", in);
					}else if(input.equals("complete task")) {
						td.completeTask("todo.txt", "completed.txt", in);
					}else {
						System.out.println("Invalid");
					}
				}else if(input.equals("agenda")){
					System.out.println("ADD ENTRY");
					input = in.nextLine();
					if(input.equals("add")) {
						a.newEntry("agenda.txt", in, "Entry");
						a.appendDate("agenda.txt", in);
					}else {
						System.out.println("invalid");
					}
				}else{
					System.out.println("MAIN MENU\n Where do you want to go?\n DIARY\n TODO\n AGENDA");
					input = in.nextLine();
				}
			}
			System.out.println("Thank you");			
		}
		
	}
	
	public boolean doSomething(UserRecord user, boolean hasLoggedIn) {
		Validation v = new Validation(user.getUsername(), user.getPassword());
		if(v.createUser()) {
			hasLoggedIn = true;
			System.out.println("User Created");
		}else if(v.loginStatus()) {
			hasLoggedIn = true;
			System.out.println("Logged in");
		}else {
			hasLoggedIn = false;
			System.out.println("Invalid");
		}
		return hasLoggedIn;
		
	}
	
}
