package cpsc501a1;
import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * This is where the program gets run from
 * 
 * Easy Refactorings:
 * -rename
 * -long method
 * -speculative generality (calendar class)
 * 
 * Hard Refactorings:
 * 
 * 
 * @author mar
 *
 */
public class Main {
	public static void main(String arg[]) {
		//display GUI
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					//JFrame f = window.getFrame();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	
		
		
		//Diary d = new Diary();
		//d.makeFile();
		//d.removeFile("yolo.txt");
		//SignUp s = new SignUp();
		//s.createUser();
		
		//System.out.println(l.loginStatus());
	}
	
	public void RunProgram() {
		//this is where sequence of code will be run.
		
	}
}
