import java.util.*;
public class Object5 {
	Stack<Object> stack = new Stack<Object>();
	
	public Object5(Object1 first, Object3 second) {
		stack.push(first);
		stack.push(second);
		System.out.println("Collection instance refers to other objects Object5");
	}
	
	public Stack<Object> getStack(){
		return stack;
	}
}
