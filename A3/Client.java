
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.io.*;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Client {
	
	public static void main(String[] args){
		
		ObjectCreator oc = new ObjectCreator();
		
		
		String serverAddress = "localhost";
		int serverPort = 8888;
		
		try {
			oc.userInput();
			byte[] b= new byte[4096];
			Socket socket = new Socket(serverAddress, serverPort);
			System.out.println("Socket connected");
			
			InputStream is = socket.getInputStream();
			FileOutputStream fos = new FileOutputStream("xmlFileReceived.xml");
			int count = 0;
			while ((count = is.read(b)) != -1) { 
			  fos.write(b, 0, count);
			}
			
			System.out.println("File transferred");
			is.close();			
			fos.flush();
			fos.close();
			socket.close();
			
			Deserializer d = new Deserializer();
		    d.deserialize();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
