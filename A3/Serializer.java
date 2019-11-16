import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.lang.reflect.*;
import org.jdom2.*;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import java.io.*;
import java.util.*;

public class Serializer {
	IdentityHashMap objectMap = new IdentityHashMap<>();
	
	public Serializer() {
		
	}
	
	public Serializer(IdentityHashMap objMap) {
		this.objectMap = objMap;
		
	}
	
	public void Serialize() {
		try {
        	
        	Document doc = new Document();
            Element serialized = new Element("serialized");
            doc.setRootElement(serialized);
            
            //go through identityhashmap and print accordingly.
            for(int i = 0; i < objectMap.size(); i++) {
            	System.out.println(objectMap.get(i));
            	Object obj =  objectMap.get(i);
            	Class cl = obj.getClass();
            	
            	//findFields(cl, obj, true);
            	Element object = new Element("object");
            	
            	object.setAttribute(new Attribute("class", cl.getName()));
            	object.setAttribute(new Attribute("id", Integer.toString(i)));
            	Element objRef = new Element("object");

            	findFields(cl, obj, true, doc, object, objRef);
            	
            	objRef.setAttribute(new Attribute("class", obj.getClass().getName()));
            	objRef.setAttribute(new Attribute("id", Integer.toString(i)));
            	
            	//object.addContent(objRef);
            	
            	doc.getRootElement().addContent(object);
            	
            }
            System.out.println(objectMap.entrySet());
            System.out.println(objectMap.size());

            

            //////////////////////////////////////////
            new XMLOutputter().output(doc, System.out);
            XMLOutputter xmlOutput = new XMLOutputter();

            // Display in a readable format
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter("file.xml"));
            
            File file = new File("file.xml");

            System.out.println("File Saved!");
            
            //send over socket 
            
            
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
	}
	
	public void findFields(Class c, Object obj, boolean recursive, Document doc, Element el, Element el2){
        Field[] f = c.getDeclaredFields();
        if(f.length > 0){
            System.out.println("Fields for "+c.getName()+": ");
            for(int i = 0; i < f.length; i ++){
                System.out.println(f[i].getName());

                //Type
                System.out.println("Type: ");
                System.out.println(f[i].getType().getName());
                if(f[i].getType().isArray()) {
                	System.out.println("Array");
                	
                	try {
                     	el.setAttribute(new Attribute("length", Integer.toString(Array.getLength(f[i].get(obj)))));

                	}catch(Exception e) {
                		e.printStackTrace();
                	}
                	
                	Class componentType = f[i].getType().getComponentType();
                	if(componentType.isPrimitive()) {
                		try {
                    		int length = Array.getLength(f[i].get(obj));
                    		
                            for (int j= 0; j < length; j ++) {
                                Object arrayElement = Array.get(f[i].get(obj), j);
                                System.out.println("Array element: "+arrayElement);
                                //write to xml doc
                                Class arrayElementClass = arrayElement.getClass();
                                
                                Element val = new Element("value").setText(arrayElement.toString());
                                
                                el.addContent(val);
                                
                            }
                    	}catch(Exception e) {
                    		e.printStackTrace();
                    	}
                	}else {
                		System.out.println("not primitive");
                		try {
                			int length = Array.getLength(f[i].get(obj));
                    		for(int k = 0; k < length; k++) {
                    			Object arrayElement = Array.get(f[i].get(obj), k);
                    			Class arrayElementClass = arrayElement.getClass();
                        		findFields(arrayElementClass, arrayElement, true, doc, el, el2);
                    		}
                		}catch(Exception e){
                			e.printStackTrace();
                		}
                	}
                	
                }
                
                try{
                    f[i].setAccessible(true);

                    if(f[i].get(obj) == null){
                        System.out.println(f[i].getName()+" is null.");
                        return;
                    }
    				Object value = f[i].get(obj);

                    if(!f[i].getType().isPrimitive() && !f[i].getType().isArray()){
                        if(recursive == true){
                        	System.out.println("Value at "+f[i].getName()+": ");
                            System.out.println("("+c.getName()+")"+value);

                            Element field = new Element("field");
                        	field.setAttribute(new Attribute("name", f[i].getName()));
                        	//declaring class?
                        	field.setAttribute(new Attribute("declaringclass", obj.getClass().getName()));
                        	Element ref = new Element("reference").setText(Integer.toString(i));
                        	
                        	el2 = new Element("object");
                        	el2.setAttribute(new Attribute("class", f[i].getClass().getName()));
                        	el2.setAttribute(new Attribute("id", Integer.toString(i)));
                        	//print information about object reference
                        	
                        	field.addContent(ref);
                        	el.addContent(field);
                                            					
        					System.out.println("is not primitive");
                            findFields(f[i].getType(), f[i].get(obj), true, doc, el, el2);
                        }else{
                        	
                        	
          
                        	//doc.getRootElement().addContent(el);
                        	
                        	System.out.println(c.getName()+"@"+Integer.toHexString(System.identityHashCode(obj)));
                        }
                    }else if(f[i].getType().isPrimitive() && !f[i].getType().isArray()){
                    	
                    		
                    	//Object value = f[i].get(obj);
    				
    					System.out.println("Value at "+f[i].getName()+": ");
                        System.out.println("("+c.getName()+")"+value);
                    	
                        Element field = new Element("field");
                    	field.setAttribute(new Attribute("name", f[i].getName()));
                    	//declaring class?
                    	field.setAttribute(new Attribute("declaringclass", obj.getClass().getName()));
                    	Element val = new Element("value").setText(value.toString());
                    	
                    	field.addContent(val);
                    	el.addContent(field);
                    	
                    	System.out.println("is primitive");
                    }else if(f[i].getClass().isInterface()) {
                    	System.out.println("Collections class");
                    }
                    
                }catch(Exception e){
                    e.printStackTrace();
                }
                

                System.out.println(" ");
            }
        }else{
            System.out.println("No fields for "+c.getName());
        }

    }
	
}
