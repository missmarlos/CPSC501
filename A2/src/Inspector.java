import java.lang.reflect.*;
public class Inspector {
    String tab = "";
    String tab2 = tab;

    public void inspect(Object obj, boolean recursive) {
        Class c = obj.getClass();
        inspectClass(c, obj, recursive, 0);
        //inspectInterface(c, obj, recursive, 0);
    }

    private void inspectInterface(Class c, Object obj, boolean recursive, String tb){

        Class[] interfaces = c.getInterfaces();
        if(interfaces.length > 0){
            System.out.println(tb+"Interfaces for"+c.getName()+": ");
            for(int i = 0; i < interfaces.length; i++){

                System.out.println(tb+interfaces[i]);
                tab2+="\t";
                findMethods(interfaces[i], tab2);
                findConstructors(interfaces[i], tab2);
                findFields(interfaces[i], obj, recursive, tab2);
                inspectInterface(interfaces[i], obj, recursive, tab2);
            }
        }else{
            System.out.println(tb+"No interfaces for "+c.getName());
        }
    }

    private void findMethods(Class c, String tb){
        Method[] m = c.getDeclaredMethods();
        if(m.length > 0){
            System.out.println(tb+"*Methods for "+c.getName()+": ");
            for(int i = 0; i < m.length; i ++){
                System.out.println(tb+"Method: "+m[i]);

                //Exceptions thrown
                Class[] e = m[i].getExceptionTypes();
                System.out.println(tb+"Exceptions: ");
                if(e.length == 0){
                    System.out.println(tb+"No exceptions");
                }
                for(int j = 0; j < e.length; j++){
                    System.out.println(tb+e[j]);
                }
                
                //Parameter types
                Class[] params = m[i].getParameterTypes();
                System.out.println(tb+"Parameter Types: ");
                if(params.length == 0){
                    System.out.println(tb+"No parameters");
                }
                for(int j = 0; j < params.length; j++){
                    System.out.println(tb+params[j]);
                }

                //Return type
                String returnType = m[i].getReturnType().getName();
                System.out.println(tb+"Return Type: "+returnType);

                //Modifiers
                int mod = m[i].getModifiers();
                System.out.println(tb+"Modifiers: "+Modifier.toString(mod));  
                System.out.println(" "); 
            }
        }else{
            System.out.println("No methods");
            System.out.println(" ");
        }
    }

    //refactored into another method
    private void findConstructors(Class c, String tb){
        Constructor[] constructors = c.getDeclaredConstructors();
        if(constructors.length > 0){
            System.out.println(tb+"Constructors for "+c.getName()+": ");
            for(int i = 0; i < constructors.length; i++){
                System.out.println(tb+constructors[i]);

                //Parameter types
                Class[] params = constructors[i].getParameterTypes();
                System.out.println(tb+"Parameter Types: ");
                if(params.length == 0){
                    System.out.println(tb+"No parameters");
                }
                for(int j = 0; j < params.length; j++){
                    System.out.println(tb+params[j]);
                }
                //Modifiers
                int mod = constructors[i].getModifiers();
                System.out.println(tb+"Modifiers: "+Modifier.toString(mod));   

                System.out.println(" ");
            }
        }else{
            System.out.println(tb+"No constructors");
            System.out.println(" ");
        }
    }

    private void findFields(Class c, Object obj, boolean recursive, String tb){
        //if recursive is false and the field is an object then no need to recurse
        
        //if field type is an object of another class and recursive == true, inspect field of that class
        //if field type is an object of another class and recursive == false, then no recursion 

        Field[] f = c.getDeclaredFields();
        if(f.length > 0){
            //Names

            //System.out.println(tb+"start field depth "+depth+" :");
            System.out.println(tb+"Fields: ");
            for(int i = 0; i < f.length; i ++){
                System.out.println(tb+f[i].getName());

                //Type
                System.out.println(tb+"Type: ");
                System.out.println(tb+f[i].getType().getName());

                //if field is an object of another class and recursive is true, recurse***
                /*
                if(!f[i].getType().isPrimitive()){
                    if(recursive == true){
                        depth++;
                        findFields(f[i].getType(), obj, recursive, depth);
                        System.out.println("hello");

                    }
                }
                */

                //Modifiers
                int mod = f[i].getModifiers();
                System.out.println(tb+"Modifiers: "+Modifier.toString(mod));   

                //Current values of each field
                f[i].setAccessible(true);
                try{
                    Object value = f[i].get(obj);
                    System.out.println(tb+"Value at "+f[i].getName()+": ");
                    System.out.println(tb+value);
                }catch(Exception e){
                    e.printStackTrace();
                }
                
                //6i


                System.out.println(" ");
            }
        }else{
            System.out.println(tb+"No fields");
        }
    }
    

    private void inspectClass(Class c, Object obj, boolean recursive, int depth) {
    	
    	Class superC = c.getSuperclass();
    	if(c.getName().equals("java.lang.Object")){
    		if(depth == 0){
    			System.out.println("Declaring class is "+superC.getName());
    			///////////////////////////
                inspectInterface(c, obj, recursive, tab);
                findMethods(c, tab);
                findConstructors(c, tab);
    			findFields(c, obj, recursive, tab);

    		}else{
                //String superClass = c.getSuperclass().getName();
    			System.out.println(tab+"Superclass of "+c.getName()+": "+null);
    		}
    	}else{
    		if(depth == 0){
                System.out.println("Declaring class is: "+c.getName());

				String superClass = c.getSuperclass().getName();
		    	System.out.println(tab+"Immediate superclass is "+superClass);
		    	superC = c.getSuperclass();
		    	//System.out.println(" ");    		
		    }else{
		    	String superClass = c.getSuperclass().getName();
                System.out.println(tab+"Superclass of "+c.getName()+": "+superClass);
		    	//System.out.println("Superclass at depth "+depth+" is: "+superClass);
		    	superC = c.getSuperclass();
		    	//System.out.println(" ");
		    }
    		///////////////////////////
            inspectInterface(c, obj, recursive, tab);
            findMethods(c, tab);
            findConstructors(c, tab);
   			findFields(c, obj, recursive, tab);

		    
		    depth++;
            tab += "\t";



		    inspectClass(superC, obj, recursive, depth);
    	}
    }

}