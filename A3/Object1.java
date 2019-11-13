import java.io.FileWriter;
import java.io.IOException;
import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Object1 {
	int a;
	char b;
	double c;
	
	Object1(int first, char second, double third){
		this.a = first;
		this.b = second;
		this.c = third;
		System.out.println("Primitives created in Object1");
	}
	
	public int getA(){
		return a;
	}
	
	public char getB() {
		return b;
	}
	
	public double getC() {
		return c;
	}
	
}
