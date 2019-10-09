package cpsc501a1;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.*;
import java.io.*;

public class SignUp extends UserRecord{
	boolean fileExists = false;
	
	
	SignUp(String u, String p){
		setUsername(u);
		setPassword(p);
	}
	

	//check if login is valid.
	//abstract boolean loginStatus(); 

}
