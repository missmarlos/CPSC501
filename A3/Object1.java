
public class Object1 {
	int a;
	char b;
	double c;
	
	public Object1() {
		
	}
	
	public Object1(int first, char second, double third){
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
	
	public void setA(int val) {
		a = val;
	}
	
	public void setB(char val) {
		b = val;
	}

	public void setC(double val) {
		c = val;
	}
	
}
