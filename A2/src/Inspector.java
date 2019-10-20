import java.lang.reflect.*;

public class Inspector {

    public void inspect(Object obj, boolean recursive) {
        Class c = obj.getClass();
        inspectClass(c, obj, recursive, 0);
    	
    	//Declaring class
    	String className = c.getName();
    	System.out.println("The class name is "+className);

    	//Name of immediate superclass
    	String superClass = c.getSuperclass().getName();
    	System.out.println("Immediate superclass is "+superClass);

    	//Name of each interface implemented by class
    	Class[] interfaces = c.getInterfaces();
    	if(interfaces.length > 0){
    		System.out.println("Interfaces:");
    		for(int i = 0; i < interfaces.length; i++){
    			System.out.println(interfaces[i]);
    		}
    	}else{
    		System.out.println("No interfaces");
    	}

    	//Constructors
    	Constructor[] constructors = c.getConstructors();
	    if(constructors.length > 0){
	    	System.out.println("Constructors: ");
	    	for(int i = 0; i < constructors.length; i++){
	    		System.out.println(constructors[i]);
	    	}
	    }else{
	    	System.out.println("No constructors");
	    }

    }

    private void inspectClass(Class c, Object obj, boolean recursive, int depth) {
    }

}