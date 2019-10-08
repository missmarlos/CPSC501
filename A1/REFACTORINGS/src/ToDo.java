import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.*;

//show all in a screen
public class ToDo extends Diary{
	ArrayList<String> todoList = new ArrayList<String>();
	ArrayList<String> completed = new ArrayList<String>();
	ArrayList<String> difference = new ArrayList<String>();
	
	public void loadTodoList(String filename) {
		File file = new File("todo.txt");
		if(file.exists()) {
			System.out.println("File exists");
			String line;
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				while ((line = reader.readLine()) != null)
			    {
					if(!(todoList.contains(line))) {
						todoList.add(line);
					}
			    }
				reader.close();
			}catch(Exception e) {
				
			}
		}else {
			System.out.println("'todo.txt' does not exist, please add it");
		}
		System.out.println(Arrays.asList(todoList));
	}
	
	public void addTask(String filename, Scanner input) {
		loadTodoList(filename);
		System.out.println("Enter a task");
		String in = input.nextLine();
		todoList.add(in);
		System.out.println("todo"+Arrays.toString(todoList.toArray()));
		//write todolist to a file
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(filename, true));
			pw.append(in+"\n");
			pw.close();
		}catch(Exception e){}
	}
	
	public void completeTask(String filename, String completeFilename, Scanner input){
		
		System.out.println("Enter completed task");
		String in = input.nextLine();
		if(todoList.contains(in)) {
			completed.add(in);
			System.out.println("0"+Arrays.toString(todoList.toArray()));
			System.out.println("complete"+Arrays.toString(completed.toArray()));

			try {
				PrintWriter pw = new PrintWriter(new FileOutputStream(completeFilename, true));
				pw.append(in+"\n");
				pw.close();
			}catch(Exception e){}
			updateTaskList(filename, completeFilename);
		}else {
			System.out.println("That is not a task in the todo list");
		}
		
		
	}
	
	public void updateTaskList(String filename, String completeFilename) {
		//for every element in todolist
		boolean realTask = false;
		for(int i = 0; i < todoList.size(); i++) {
			if(completed.contains(todoList.get(i))) {
				todoList.remove(i);
				realTask = true;
			}
		}
		if(realTask == false) {
			System.out.println("The task completed is not present in todolist");
		}
		System.out.println("1"+Arrays.toString(todoList.toArray()));

		
		//write todolist to a file	
		//remove completed tasks but keep tasks that are not completed
		try {
			System.out.println("Enter text to overwrite the file: ");
			PrintWriter pw = new PrintWriter(filename, "UTF-8");
			for(int i = 0; i < todoList.size(); i++) {
				pw.println(todoList.get(i));
			}
			pw.close();
			System.out.println(Arrays.toString(todoList.toArray()));
		}catch(Exception e) {}
	}
	
}
