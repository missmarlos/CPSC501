import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.io.*;
import java.time.LocalDateTime;

public class Agenda extends Template{
	boolean fileExists;
	
	public boolean appendDate(String filename, Scanner input){
		boolean flag = false;
		String date = "2019-01-01";
		System.out.println("Enter the date or title you want for your entry: ");
		date = input.nextLine();
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(filename, true));
			pw.println(date);
			pw.close();
			System.out.println("Enter text: ");
			appendToFile(filename, userInput(input), false);
			flag = true;
		}catch(InputMismatchException e) {
			input.nextInt();
		}catch(FileNotFoundException fe) {}
		return flag;
	}
	
	
	
}
