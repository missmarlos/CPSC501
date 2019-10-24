import java.lang.reflect.*;
public class Inspector {
    String tab = "";
    String tab2 = tab;
    String tab3 = "";

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
                findFields(interfaces[i], obj, recursive, tab2, 0);
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
            System.out.println(tb+"No methods for "+c.getName());
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
            System.out.println(tb+"No constructors for "+c.getName());
        }
    }

    private void findFields(Class c, Object obj, boolean recursive, String tb, int depth){
        Field[] f = c.getDeclaredFields();
        if(f.length > 0){
            //Names

            //System.out.println(tb+"start field depth "+depth+" :");
            System.out.println(tb+"Fields for "+c.getName()+": ");
            for(int i = 0; i < f.length; i ++){
                System.out.println(tb+f[i].getName());

                //Type
                System.out.println(tb+"Type: ");
                System.out.println(tb+f[i].getType().getName());

                //Be sure you can also handle any array you might encounter, printing out its name, component type,
                //length, and all its contents.

                if(obj.getClass().isArray()){
                    System.out.println("array");
                }

                //Modifiers
                int mod = f[i].getModifiers();
                System.out.println(tb+"Modifiers: "+Modifier.toString(mod));   

                //Current values of each field

                try{
                    f[i].setAccessible(true);

                    if(f[i].get(obj) == null){
                        System.out.println(f[i].getName()+" is null.");
                        return;
                    }
                    if(!f[i].getType().isPrimitive()){
                        if(recursive == true){
                            inspectClass(f[i].getType(), f[i].get(obj), recursive, depth);
                            //inspectClass(f[i].getType(), c.getConstructor().newInstance(), recursive, depth);
                        }else{
                            System.out.println(c.getName()+"@"+Integer.toHexString(System.identityHashCode(obj)));
                        }
                    }else{
                        //try{
                            Object value = f[i].get(obj);
                            System.out.println(tb+"Value at "+f[i].getName()+": ");
                            System.out.println(tb+value);
                        //}catch(Exception e){
                        //    e.printStackTrace();
                        //}
                    }    
                }catch(Exception e){
                    e.printStackTrace();
                }
                

                System.out.println(" ");
            }
        }else{
            System.out.println(tb+"No fields for "+c.getName());
        }
    }
    

    private void inspectClass(Class c, Object obj, boolean recursive, int depth) {
    	System.out.println(tab+"NEW CLASS "+c.getName());
    	Class superC = c.getSuperclass();
        if(c.getSuperclass() != null){
        	if(c.getName().equals("java.lang.Object")){
                
                if(depth == 0){
                    System.out.println("Declaring class is "+superC.getName());
                    ///////////////////////////
                    inspectInterface(c, obj, recursive, tab);
                    findMethods(c, tab);
                    findConstructors(c, tab);
                    findFields(c, obj, recursive, tab, depth);

                }else{
                    //String superClass = c.getSuperclass().getName();
                    System.out.println(tab+"Superclass of "+c.getName()+": "+null);
                    inspectInterface(c, obj, recursive, tab);
                    findMethods(c, tab);
                    findConstructors(c, tab);
                    findFields(c, obj, recursive, tab, depth);
                }

        		
        	}else{
        		if(depth == 0){
                    System.out.println("Declaring class is: "+c.getName());

    				//String superClass = c.getSuperclass().getName();
    		    	//System.out.println(tab+"Immediate superclass is "+superClass);
                    System.out.println(tab+"Immediate superclass is "+c.getSuperclass().getName());
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
       			findFields(c, obj, recursive, tab, depth);

    		    
    		    depth++;
                tab += "\t";



    		    inspectClass(superC, obj, recursive, depth);
        	}
        }else{
            inspectInterface(c, obj, recursive, tab);
            findMethods(c, tab);
            findConstructors(c, tab);
            findFields(c, obj, recursive, tab, depth);
        }
        /*
        inspectInterface(c, obj, recursive, tab);
        findMethods(c, tab);
        findConstructors(c, tab);
        findFields(c, obj, recursive, tab, depth);
        */
    }

}