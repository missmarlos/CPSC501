package cpsc501a1;
import java.util.Scanner;
import java.io.*;

//shows the week's entries on the screen
public class Agenda extends Diary{
	public int week;
	//same functionality but there is a textfile for each day
	public void makeFileName(Scanner input) {
		System.out.println("Enter a month: ");
		int monthNum = input.nextInt();
		String month = convertMonth(monthNum);
		System.out.println("Enter a date");
		int date = input.nextInt();
		System.out.println("Enter the year");
		int year = input.nextInt();
		
		String file = month+"-"+date+"-"+year;
	}
	
	public String convertMonth(int m) {
		String month = null;
		switch(m) {
			case 1: 
				month = "January";
				break;
			case 2:
				month = "February";
				break;
			case 3: 
				month = "March";
				break;
			case 4: 
				month = "April";
				break;
			case 5: 
				month = "May";
				break;
			case 6: 
				month = "June";
				break;
			case 7: 
				month = "July";
				break;
			case 8: 
				month = "August";
				break;
			case 9: 
				month = "September";
				break;
			case 10: 
				month = "October";
				break;
			case 11: 
				month = "November";
				break;
			case 12: 
				month = "December";
				break;
			default: 
				System.out.println("Error that is not a month");
			return month;
		}
		return month;
	}
}
