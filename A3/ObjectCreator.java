import java.util.Scanner;

public class ObjectCreator {
	public void userInput() {
	
		System.out.println("Objects: ");
		System.out.println("Object1");
		System.out.println("Object2");
		System.out.println("Object3");
		System.out.println("Object4");
		System.out.println("Object5");
		System.out.println("Enter an object from the menu that you would like to create.");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		if(input.equals("Object1")) {
			System.out.println("Object1 entered");
		}else if(input.equals("Object2")) {
			System.out.println("Object2 entered");
		}else if(input.equals("Object3")) {
			System.out.println("Object3 entered");
		}else if(input.equals("Object4")) {
			System.out.println("Object4 entered");
		}else if(input.equals("Object5")) {
			System.out.println("Object5 entered");
		}else {
			System.out.println("Error: Input entered in the wrong format.");
		}
		
		
		
	}
}
