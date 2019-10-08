import java.io.PrintWriter;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.io.*;

//show all entries in a screen
public class Diary {

	//refactoring 1: rename
	public void newEntry(String filename, Scanner input) {
		//filename no spaces and needs to end in .txt.
		File file = new File(filename);
		if(!file.exists()) {
			System.out.println("Filename is "+filename);
			try {
				PrintWriter writer = new PrintWriter(filename, "UTF-8");
				//system date and time;
				writer.println(LocalDateTime.now());
				writer.close();
			}catch(Exception e) {
				
			}
		}else {
			boolean flag = false;
			System.out.println("This file already exists. Would you like to overwrite or append to this file/cancel?");
			String decision = input.nextLine();
			while(flag == false) {
				if(decision.equals("overwrite")) {
					flag = overwriteFile(filename, input);
				}else if(decision.equals("append")) {
					flag = appendToFile(filename, input);
				}else {
					System.out.println("Invalid command please try again");
					decision = input.nextLine();
				}
			}
			System.out.println("Changes made");
			
		}
		//input.close();
		
		
	}

	//refactoring 3: long method
	public boolean appendToFile(String filename, Scanner input){
		boolean flag = false;
		try {
			System.out.println("Enter text to append to the file: ");
			PrintWriter pw = new PrintWriter(new FileOutputStream(filename, true));
			pw.println(LocalDateTime.now());
			pw.append(input.nextLine()+"\n");
			pw.close();
			flag = true;
		}catch(Exception e) {}	
		return flag;
	}

	//refactoring 3: long method
	public boolean overwriteFile(String filename, Scanner input){
		boolean flag = false;
		try {
			System.out.println("Enter text to overwrite the file: ");
			PrintWriter pw = new PrintWriter(filename, "UTF-8");
			pw.println(LocalDateTime.now());
			pw.println(input.nextLine());
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
