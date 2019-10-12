import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Template {	
	public boolean newEntry(String filename, Scanner input, String message) {
		boolean fileExists = false;
		File file = new File(filename);
		if(!file.exists()) {
			System.out.println("Filename is "+filename);
			try {
				PrintWriter writer = new PrintWriter(filename, "UTF-8");
				//system date and time;
				writer.close();
				System.out.println("File created");
			}catch(Exception e) {
				
			}
		}else {
			System.out.println("File exists");
			System.out.println(message);
			fileExists = true;
		}
		return fileExists;
	}
	public boolean appendToFile(String filename, String input, boolean displayDate) {
		boolean flag = false;
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(filename, true));
			if(displayDate) {
				pw.println(LocalDateTime.now());
			}
			pw.append(input+"\n");
			pw.append("\n");
			pw.close();
			flag = true;
		}catch(Exception e) {}	
		return flag;
	}
	
	public String userInput(Scanner input) {
		String in = input.nextLine();
		return in;
	}

}
