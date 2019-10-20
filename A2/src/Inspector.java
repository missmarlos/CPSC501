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
    	System.out.println(" ");

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
    	System.out.println(" ");

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

	    		System.out.println(" ");
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
	    		Class[] params = m[i].getParameterTypes();
	    		System.out.println("Parameter Types: ");
	    		if(params.length == 0){
	    			System.out.println("No parameters");
	    		}
	    		for(int j = 0; j < params.length; j++){
	    			System.out.println(params[j]);
	    		}

	    		//Return type
	    		String returnType = m[i].getReturnType().getName();
	    		System.out.println("Return Type: "+returnType);

	    		//Modifiers
	    		int mod = m[i].getModifiers();
	    		System.out.println("Modifiers: "+Modifier.toString(mod));	

	    		System.out.println(" ");
	    	}
	    }else{
	    	System.out.println("No methods");
	    	System.out.println(" ");
	    }

	    //Fields
	    Field[] f = c.getDeclaredFields();
	   	if(f.length > 0){
	   		System.out.println("Fields: ");
	   		for(int i = 0; i < f.length; i ++){
	   			System.out.println(f[i].getName());
		    }
	   	}else{
	   		System.out.println("No fields");
	   	}
		    

    }

    private void inspectClass(Class c, Object obj, boolean recursive, int depth) {
    }
	   	

}