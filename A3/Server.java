import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.*;

public class Server {
	
	
	public static void main(String[] args){
		try {
			int port = 8888;
			ServerSocket serverSocket = new ServerSocket(port);
			Socket socket = serverSocket.accept();
			
			
			FileInputStream fis = new FileInputStream("file.xml");
			OutputStream os = socket.getOutputStream();

			byte[] b = new byte[4096];
			int count = 0;
			while ((count = fis.read(b)) != -1) { // returns numOfBytesRead or -1 at EOF
			  // parse, or write to output stream as
			  os.write(b, 0, count); // (byte[], offset, numOfBytesToWrite)
			}
			//fis.read(b, 0, b.length);
		//	os.write(b, 0, b.length);

			fis.close();
			os.flush();
			os.close();
			socket.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
