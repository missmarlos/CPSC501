import java.util.*;
public class Object5 {
	Stack<Object> stack = new Stack<Object>();
	
	public Object5(Object first, Object second, Object third) {
		stack.push(first);
		stack.push(second);
		stack.push(third);
		System.out.println("Collection instance refers to other objects Object5");
	}
}
