import java.lang.reflect.*;
public class Inspector {
    String tab = "";
    String tab2 = tab;
    String tab3 = "";

    public void inspect(Object obj, boolean recursive) {
        Class c = obj.getClass();
        inspectClass(c, obj, recursive, 0);
    }

    public Class[] inspectInterface(Class c, Object obj, boolean recursive, String tb){
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
        return interfaces;
    }

    public Method[] findMethods(Class c, String tb){
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
        return m;
    }

    public Constructor[] findConstructors(Class c, String tb){
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
        return constructors;
    }

    public void findFields(Class c, Object obj, boolean recursive, String tb, int depth){
        Field[] f = c.getDeclaredFields();
        if(f.length > 0){
            System.out.println(tb+"Fields for "+c.getName()+": ");
            for(int i = 0; i < f.length; i ++){
                System.out.println(tb+f[i].getName());

                //Type
                System.out.println(tb+"Type: ");
                System.out.println(tb+f[i].getType().getName());

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
                        }else{
                            System.out.println(c.getName()+"@"+Integer.toHexString(System.identityHashCode(obj)));
                        }
                    }else{
                            Object value = f[i].get(obj);
                            System.out.println(tb+"Value at "+f[i].getName()+": ");
                            System.out.println(tb+"("+c.getName()+")"+value);
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
    
    public void inspectClass(Class c, Object obj, boolean recursive, int depth) {
    	System.out.println(tab+"NEW CLASS "+c.getName());
    	Class superC = c.getSuperclass();
        if(c.getSuperclass() != null){
        	if(c.getName().equals("java.lang.Object")){
                if(depth == 0){
                    System.out.println("Declaring class is "+superC.getName());
                    callFuncs(c, obj, recursive, depth);
                }else{
                    
                    System.out.println(tab+"Superclass of "+c.getName()+": "+null);
                    callFuncs(c, obj, recursive, depth);
                }
        	}else{
        		if(depth == 0){
                    System.out.println("Declaring class is: "+c.getName());
                    System.out.println(tab+"Immediate superclass is "+c.getSuperclass().getName());
                    superC = c.getSuperclass();  		
    		    }else{
    		    	String superClass = c.getSuperclass().getName();
                    System.out.println(tab+"Superclass of "+c.getName()+": "+superClass);
    		    	superC = c.getSuperclass();
    		    }
                callFuncs(c, obj, recursive, depth);
    		    depth++;
                tab += "\t";
    		    inspectClass(superC, obj, recursive, depth);
        	}
        
        }else{
            callFuncs(c, obj, recursive, depth);
        }
        
    }

    public void callFuncs(Class c, Object obj, boolean recursive, int depth){
        inspectInterface(c, obj, recursive, tab);
        findMethods(c, tab);
        findConstructors(c, tab);
        findFields(c, obj, recursive, tab, depth);
    }

}