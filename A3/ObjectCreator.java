import java.util.*;
import java.lang.reflect.*;


public class ObjectCreator {
	ArrayList<Object> objArrList = new ArrayList<Object>();
	Scanner in = new Scanner(System.in);
	
	public void userInput() {
		
			System.out.println("Objects: ");
			System.out.println("Object1");
			System.out.println("Object2");
			System.out.println("Object3");
			System.out.println("Object4");
			System.out.println("Object5");
			System.out.println("Enter an object from the menu that you would like to create.");
			System.out.println("Enter 'exit' to end program.");
			
			
			String input = in.nextLine();
			while(!input.equals("exit")) {
				System.out.println("Objects: ");
				System.out.println("Object1");
				System.out.println("Object2");
				System.out.println("Object3");
				System.out.println("Object4");
				System.out.println("Object5");
				System.out.println("Enter an object from the menu that you would like to create.");
				System.out.println("Enter 'exit' to end program.");
				makeObject(input);
				System.out.println("Objects: ");
				System.out.println("Object1");
				System.out.println("Object2");
				System.out.println("Object3");
				System.out.println("Object4");
				System.out.println("Object5");
				System.out.println("Enter an object from the menu that you would like to create.");
				System.out.println("Enter 'exit' to end program.");
				input = in.nextLine();
			}if(input.equals("exit")) {
				//serialize
				Serializer ser = new Serializer();
				ser.Serialize();
			}
	}
	
	public void makeObject(String input) {
		int integer;
		char character;
		double doubles;
		
		if(input.equals("Object1")) {			
			System.out.println("Object1 entered");
			
			System.out.println("Enter an int:");
			String firstInt = in.nextLine();
			
			System.out.println("Enter a char:");
			String secondChar = in.nextLine();
			
			System.out.println("Enter a double:");
			String thirdDouble = in.nextLine();
			
			if(isInt(firstInt) && isChar(secondChar) && isDouble(thirdDouble)) {
				integer = Integer.parseInt(firstInt);
				character = secondChar.charAt(0);
				doubles = Double.parseDouble(thirdDouble);
				
				Object1 obj1 =  new Object1(integer, character, doubles);
				objArrList.add(obj1);
			}else {
				System.out.println("Invalid input try again.");
			}
		}else if(input.equals("Object2")) {
			System.out.println("Object1 entered");
			
			System.out.println("Enter an int:");
			String firstInt = in.nextLine();
			
			System.out.println("Enter a char:");
			String secondChar = in.nextLine();
			
			System.out.println("Enter a double:");
			String thirdDouble = in.nextLine();
			
			if(isInt(firstInt) && isChar(secondChar) && isDouble(thirdDouble)) {
				integer = Integer.parseInt(firstInt);
				character = secondChar.charAt(0);
				doubles = Double.parseDouble(thirdDouble);
				
				Object1 obj2to1 =  new Object1(integer, character, doubles);
				Object2 obj2 = new Object2(obj2to1);
				
				objArrList.add(obj2to1);
				objArrList.add(obj2);
			}else {
				System.out.println("Invalid input try again.");
			}
			
		}else if(input.equals("Object3")) {			
			System.out.println("Object3 entered");
			System.out.println("Enter first integer");
			String intFirst = in.nextLine();
			System.out.println("Enter second integer");
			String intSecond = in.nextLine();
			System.out.println("Enter third integer");
			String intThird = in.nextLine();
			
			if(isInt(intFirst) && isInt(intSecond) && isInt(intThird)) {
				int first = Integer.parseInt(intFirst);
				int second = Integer.parseInt(intSecond);
				int third = Integer.parseInt(intThird);
				
				Object3 obj3 = new Object3(first, second, third);
				objArrList.add(obj3);
				
			}
			
		}else if(input.equals("Object4")) {
			Object1 obj1;
			Object3 obj3;
			Object4 obj4;
			
			System.out.println("Object4 entered");
			
			System.out.println("Object1 entered");
			
			System.out.println("Enter an int:");
			String firstInt = in.nextLine();
			
			System.out.println("Enter a char:");
			String secondChar = in.nextLine();
			
			System.out.println("Enter a double:");
			String thirdDouble = in.nextLine();
			
			if(isInt(firstInt) && isChar(secondChar) && isDouble(thirdDouble)) {
				integer = Integer.parseInt(firstInt);
				character = secondChar.charAt(0);
				doubles = Double.parseDouble(thirdDouble);
				
				System.out.println("Object3 entered");
				System.out.println("Enter first integer");
				String intFirst = in.nextLine();
				System.out.println("Enter second integer");
				String intSecond = in.nextLine();
				System.out.println("Enter third integer");
				String intThird = in.nextLine();
				
				if(isInt(intFirst) && isInt(intSecond) && isInt(intThird)) {
					int first = Integer.parseInt(intFirst);
					int second = Integer.parseInt(intSecond);
					int third = Integer.parseInt(intThird);
					
					obj1 = new Object1(integer, character, doubles);
					obj3 = new Object3(first, second, third);
					obj4 = new Object4(obj1, obj3);
					
					objArrList.add(obj1);
					objArrList.add(obj3);
					objArrList.add(obj4);
					
				}
				
			}else {
				System.out.println("Invalid input try again.");
			}
			
		}else if(input.equals("Object5")) {
			System.out.println("Object5 entered");
			Object1 obj1;
			Object3 obj3;
			Object5 obj5;
						
			System.out.println("Object1 entered");
			
			System.out.println("Enter an int:");
			String firstInt = in.nextLine();
			
			System.out.println("Enter a char:");
			String secondChar = in.nextLine();
			
			System.out.println("Enter a double:");
			String thirdDouble = in.nextLine();
			
			if(isInt(firstInt) && isChar(secondChar) && isDouble(thirdDouble)) {
				integer = Integer.parseInt(firstInt);
				character = secondChar.charAt(0);
				doubles = Double.parseDouble(thirdDouble);
				
				System.out.println("Object3 entered");
				System.out.println("Enter first integer");
				String intFirst = in.nextLine();
				System.out.println("Enter second integer");
				String intSecond = in.nextLine();
				System.out.println("Enter third integer");
				String intThird = in.nextLine();
				
				if(isInt(intFirst) && isInt(intSecond) && isInt(intThird)) {
					int first = Integer.parseInt(intFirst);
					int second = Integer.parseInt(intSecond);
					int third = Integer.parseInt(intThird);
					
					obj1 = new Object1(integer, character, doubles);
					obj3 = new Object3(first, second, third);
					obj5 = new Object5(obj1, obj3);
					
					objArrList.add(obj1);
					objArrList.add(obj3);
					objArrList.add(obj5);
					
				
			
				}else {
					System.out.println("Error: Input entered in the wrong format.");
				}
			}
		}
	}
	

	
	public boolean isInt(String s)
	{
	    try{
	        Integer.parseInt(s);
	        return true;
	    }catch (NumberFormatException ex){
	        System.out.println("Error: "+s+" is not an int");
	    	return false;
	    }
	}
	
	public boolean isChar(String s) {
        if(s.length() == 1 && (!isInt(s)) && (!isDouble(s))) {
        	return true;
        }else {
	        System.out.println("Error: "+s+" is not a char");
        	return false;
        }
	}
	
	public boolean isDouble(String s) {
		try{
	        Double.parseDouble(s);
	        return true;
	    }catch (NumberFormatException e){
	    	//e.printStackTrace();
	        System.out.println("Error: "+s+" is not an double");
	    	return false;
	    }
	}
}
