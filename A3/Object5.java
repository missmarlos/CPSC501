import java.util.*;
public class Object5 {
	//Stack<Object> stack = new Stack<Object>();
	ArrayList<Object> arrList = new ArrayList<Object>();
	
	public Object5() {
		
	}
	
	
	public Object5(Object1 first, Object3 second) {
		arrList.add(first);
		arrList.add(second);
		System.out.println("Collection instance refers to other objects Object5");
	}
	
	public ArrayList<Object> getArrList(){
		return arrList;
	}
	
	public void setArrList(ArrayList<Object> val) {
		arrList = val;
	}
}
