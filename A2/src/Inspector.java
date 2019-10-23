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

                
                /*
                }if(f[i].getType().isArray()){
                    ////////array stuff//////
                }
                */

                //Modifiers
                int mod = f[i].getModifiers();
                System.out.println(tb+"Modifiers: "+Modifier.toString(mod));   

                //Current values of each field


                f[i].setAccessible(true);
                if(!f[i].getType().isPrimitive()){
                    if(recursive == true){
                        inspectClass(f[i].getType(), obj, recursive, depth);
                    }else{
                        System.out.println(c.getName()+"@"+Integer.toHexString(System.identityHashCode(obj)));
                    }
                }else{
                    try{
                        Object value = f[i].get(obj);
                        System.out.println(tb+"Value at "+f[i].getName()+": ");
                        System.out.println(tb+value);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
                
                /*
                f[i].setAccessible(true);
                if(!f[i].getType().isPrimitive()){
                    if(recursive == true){
                        tab3 = tb + "\t";
                        System.out.println(tb+"The field is a reference object to "+f[i].getType());
                        inspectClass(f[i].getType(), obj, recursive, depth);
                        //inspectClass(f[i].getType(), f[i].getType(), recursive, 0, tab3);
                        //findFields(f[i].getType(), f[i].getType(), recursive, tab3);
                        //tab = tab3;
                    }else if(recursive == false){
                        //print out the reference value 
                        //ie print out objects class and identity hash code
                        System.out.println(c.getName()+"@"+Integer.toHexString(System.identityHashCode(obj)));
                    }
                }
                */
                //6i


                System.out.println(" ");
            }
        }else{
            System.out.println(tb+"No fields");
        }
    }
    

    private void inspectClass(Class c, Object obj, boolean recursive, int depth) {
    	System.out.println(tab+"NEW CLASS "+c.getName());
    	Class superC = c.getSuperclass();
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
   			findFields(c, obj, recursive, tab, depth);

		    
		    depth++;
            tab += "\t";



		    inspectClass(superC, obj, recursive, depth);
    	}
    }

}