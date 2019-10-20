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

	    		//Parameter types
	    		Class[] params = constructors[i].getParameterTypes();
	    		System.out.println("Parameter Types: ");
	    		for(int j = 0; j < params.length; j++){
	    			System.out.println(params[j]);
	    		}

	    		//Modifiers
	    		int mod = constructors[i].getModifiers();
	    		System.out.println("Modifiers: "+Modifier.toString(mod));	
	    	}
	    }else{
	    	System.out.println("No constructors");
	    }

	    //Methods
	    Method[] m = c.getMethods();
	    if(m.length > 0){
	    	System.out.println("Methods: ");
	    	for(int i = 0; i < m.length; i ++){
	    		System.out.println(m[i]);

	    		//Exceptions thrown
	    		Class[] e = m[i].getExceptionTypes();
	    		System.out.println("Exceptions: ");
	    		if(e.length == 0){
	    			System.out.println("No exceptions");
	    		}
	    		for(int j = 0; j < e.length; j++){
	    			System.out.println(e[j]);
	    		}
	    		//Parameter types

	    		//Return type

	    		//Modifiers
	    	}
	    }else{
	    	System.out.println("No methods");
	    }


    }

    private void inspectClass(Class c, Object obj, boolean recursive, int depth) {
    }

}