import java.lang.reflect.*;

public class Inspector {

    public void inspect(Object obj, boolean recursive) {
        Class c = obj.getClass();

        String className = c.getName();
        System.out.println("The declaring class name is: "+className);
        //findInterfaces(c, 0);
        inspectClass(c, obj, recursive, 0);

        //Declaring class
        /*
        
        

        */
    	
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
	   		//Names
	   		System.out.println("Fields: ");
	   		for(int i = 0; i < f.length; i ++){
	   			System.out.println(f[i].getName());

			    //Type
			    System.out.println("Type: ");
			    System.out.println(f[i].getType().getName());

			    //Modifiers
			    int mod = f[i].getModifiers();
	    		System.out.println("Modifiers: "+Modifier.toString(mod));	

			    //Current values of each field
			   	f[i].setAccessible(true);
			   	try{
			   		Object value = f[i].get(obj);
			   		System.out.println("Value: ");
			   		System.out.println(value);
			   	}catch(Exception e){
			   		e.printStackTrace();
			   	}
			   	
			    //6i


			    System.out.println(" ");
		    }
	   	}else{
	   		System.out.println("No fields");
	   	}
		    
    }

    private void findInterfaces(Class c, int depth){
    	Class[] interfaces = c.getInterfaces();
    	if(interfaces.length > 0){
    		System.out.println("Interfaces for"+c.getName()+" at depth "+depth+": ");
    		for(int i = 0; i < interfaces.length; i++){

    			System.out.println(interfaces[i]);
    		}
    	}else{
    		System.out.println("No interfaces at depth"+depth);
    	}
    	System.out.println(" ");
    }

    private void inspectClass(Class c, Object obj, boolean recursive, int depth) {
    	Class superC = c.getSuperclass();
    	if(c.getName().equals("java.lang.Object")){
    		if(depth == 0){
    			System.out.println("Declaring class is "+superC.getName());
    			findInterfaces(c, depth);

    		}else{
    			System.out.println("No immediate superclass ie top of the hierarchy");
    		}
    	}
    	/*
    	if(superC.getName().equals("java.lang.Object")){
    		String superClass = c.getSuperclass().getName();
    		superC = c.getSuperclass();
    		if(depth == 0){
    			System.out.println("Immediate superclass is "+superClass);
    		}else{
    			System.out.println("Superclass at depth "+depth+" is: "+superClass);
    		}
    		findInterfaces(c, depth);
	    	System.out.println(" ");
    	}
    	*/
    	else{
    		if(depth == 0){
				String superClass = c.getSuperclass().getName();
		    	System.out.println("Immediate superclass is "+superClass);
		    	superC = c.getSuperclass();
		    	System.out.println(" ");    		
		    }else{
		    	String superClass = c.getSuperclass().getName();
		    	System.out.println("Superclass at depth "+depth+" is: "+superClass);
		    	superC = c.getSuperclass();
		    	System.out.println(" ");
		    }
		    findInterfaces(c, depth);
		    depth++;



		    inspectClass(superC, obj, recursive, depth);
    	}
    	
    }
	   	

}