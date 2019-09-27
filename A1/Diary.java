package cpsc501a1;

import java.io.PrintWriter;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.io.*;

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
			System.out.println("This file already exists. Would you like to overwrite or append to this file/cancel?");
			String decision = input.nextLine();
			while(flag == false) {
				if(decision.equals("overwrite")) {
					try {
						System.out.println("Enter text to overwrite the file: ");
						PrintWriter pw = new PrintWriter(filename, "UTF-8");
						pw.println(LocalDateTime.now());
						pw.println(input.nextLine());
						pw.close();
						flag = true;
					}catch(Exception e){}
				}else if(decision.equals("append")) {
					try {
						System.out.println("Enter text to append to the file: ");
						PrintWriter pw = new PrintWriter(new FileOutputStream(filename, true));
						pw.println(LocalDateTime.now());
						pw.append(input.nextLine()+"\n");
						pw.close();
						flag = true;
					}catch(Exception e) {
						
					}
				}else {
					System.out.println("Invalid command please try again");
					decision = input.nextLine();
				}
			}
			System.out.println("outside of loop");
			
		}
		input.close();
		
		
	}
	
	/*
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
	*/
	
	public void removeFile(String filename) {
		File file = new File(filename);
		if(file.exists()) {
			file.delete();
		}else {
			System.out.println("Error: file does not exist");
		}
	}
}
