package cpsc501a1;

import java.io.PrintWriter;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.io.*;


/**
 * Diary for user's personal thoughts, to be used like the notes app
 * -Access previous entries
 * -Edit previous entries
 * -Delete previous entries
 * 
 * @author mar
 *
 */
public class Diary {
	
	public void makeFile() {
		//filename no spaces and needs to end in .txt.
		System.out.println("Enter file name");
		Scanner input = new Scanner(System.in);
		String preFileName = input.nextLine();
		String[] preFileName2 = preFileName.split("\\s+");
		String filename = preFileName2[0];
		if(preFileName2.length > 1) {
			for(int i = 1; i < preFileName2.length; i++) {
				filename=filename+"-"+preFileName2[i];
			}
		}
		filename = filename + ".txt";
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
			System.out.println("This file already exists. Would you like to edit instead?");
			String decision = input.nextLine();
			while(flag == false) {
				System.out.println("Something went wrong. Type yes or no.");
				decision = input.nextLine();
				if(decision.equals("yes")){
					editFile(filename);
					flag = true;
				}else if(decision.equals("no")){
					System.out.println("Return to main menu.");
					flag = true;
				}else {
					flag = false;
				}
			}
			
		}
		
		
	}
	
	public void editFile(String filename) {
		try {
			//copy current file to temp file
			//make edits
			//overwrite old file
			//delete tempfile
			PrintWriter writer = new PrintWriter(filename, "UTF-8");
			writer.println();
			writer.close();
		}catch(Exception e) {
			System.out.println("File has not been found.");
		}
	}
	
	public void removeFile(String filename) {
		File file = new File(filename);
		if(file.exists()) {
			file.delete();
		}else {
			System.out.println("Error: file does not exist");
		}
	}
}
