package cpsc501a1;
import java.util.Scanner;

public class Menu {
	Diary d = new Diary();
	Agenda a = new Agenda();
	ToDo td = new ToDo();
	Scanner in = new Scanner(System.in);

		
	
	public void displayMenu() {
		System.out.println("MAIN MENU:");
		System.out.println("============");
		System.out.println("|| Diary  ||");
		System.out.println("|| Agenda ||");
		System.out.println("|| To-Do  ||");
		System.out.println("============");
		System.out.println("Please select one of the above");
		System.out.println("*Note: input is case-sensitve*");

		getInput();
	}
	
	public void getInput() {
		String input = in.nextLine();
		processInput(input);
	}
	
	public void processInput(String input) {
		if(input.equals("Diary")) {
			
		}else if(input.equals("Agenda")) {
			
		}else if(input.equals("To-Do")) {
			
		}
	}
}
