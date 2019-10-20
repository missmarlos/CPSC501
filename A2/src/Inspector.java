import java.lang.reflect.*;

public class Inspector {

    public void inspect(Object obj, boolean recursive) {
        Class c = obj.getClass();
        inspectClass(c, obj, recursive, 0);
    	
    	//Declaring class
    	String className = c.getName();
    	System.out.println("The class name is "+className);

    	//Name of immediate superclass
    	

    }

    private void inspectClass(Class c, Object obj, boolean recursive, int depth) {
    }

}