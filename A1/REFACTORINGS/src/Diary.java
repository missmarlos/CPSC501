package cpsc501a1;

import java.io.PrintWriter;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.io.*;

//show all entries in a screen
public class Diary extends Template{

	public void appendOrOverwrite(String filename, Scanner input) {
		boolean flag = false;
		//System.out.println("This file already exists. Would you like to overwrite or append to this file/cancel?");
		String decision = userInput(input);
		System.out.println("Enter text: ");
		while(flag == false) {
			if(decision.equals("overwrite")) {
				flag = overwriteFile(filename, userInput(input));
			}else if(decision.equals("append")) {
				flag = appendToFile(filename, userInput(input), true);
			}else {
				System.out.println("Invalid command please try again");
				decision = input.nextLine();
			}
		}
		System.out.println("Changes made");
	}
	
	//refactoring 3: long method
	public boolean overwriteFile(String filename, String input){
		boolean flag = false;
		try {
			PrintWriter pw = new PrintWriter(filename, "UTF-8");
			pw.println(LocalDateTime.now());
			pw.println(input);
			pw.close();
			flag = true;
		}catch(Exception e){}
		return flag;
	}	
	
	
	public String getFileContent(String filename) {
		String fileContent = null;
		File file = new File(filename);
		StringBuilder stringBuild = new StringBuilder();
		if(file.exists()) {
			try (Scanner s = new Scanner(file)){
				while(s.hasNext()) {
					stringBuild.append(s.nextLine()+"\n");
				}
				fileContent = stringBuild.toString();
			}catch(FileNotFoundException e) {
				
			}
		}else {
			System.out.println("Error this file does not exist");
			fileContent = "Error";
		}
		return fileContent;
	}
	
	
	
	public void removeFile(String filename) {
		File file = new File(filename);
		if(file.exists()) {
			file.delete();
			System.out.println("File deleted");
		}else {
			System.out.println("Error: file does not exist");
		}
	}
	
	
}
