import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.lang.reflect.*;



public class Deserializer {
	
	
	
	public void deserialize() {
		
        String fileName = "xmlFileReceived.xml";
        SAXBuilder builder = new SAXBuilder();
        List<Object> objectList = new ArrayList<Object>();

        try {
            Document doc = builder.build(new File(fileName));
            Element rootElement = doc.getRootElement();

            System.out.println("Root element is: "+rootElement);
            
            
            List children = rootElement.getChildren();
            for(Object child_ : children){
            	
            		Element child = (Element) child_;
                    System.out.println("Child is "+ child);
                    
                    System.out.println(child.getAttribute("class"));
                    System.out.println(child.getAttribute("id"));
                    
                    if((child.getAttribute("class").toString()).contains("Object1")){
                    	Object1 obj1 = new Object1();
		                //Object obj = objClass.getConstructor().newInstance();
		                List fields = child.getChildren();
                        for(int k = 0; k < fields.size(); k++) {
                        	Element field = (Element) fields.get(k);
                        	System.out.println("Field is "+field+" at "+k);
                        	System.out.println(field.getAttribute("name"));
                        	System.out.println(field.getAttribute("declaringclass"));
                        	
                        	
                        	List values = field.getChildren();
                        	for(Object value_ : values) {
                        		Element value = (Element) value_;
                        		System.out.println("Value is "+value);
                        		System.out.println(value.getText());
                        		if(k == 0) {
                        			obj1.setA(Integer.parseInt(value.getText()));
                        		}if(k == 1) {
                        			obj1.setB(value.getText().charAt(0));
                        		}if(k == 2) {
                        			obj1.setC(Double.parseDouble(value.getText()));
                        		}
                        	}
                        }
                        objectList.add(obj1);
                    	/*
                    	List fields = child.getChildren();
                        for(Object field_: fields) {
                        	Element field = (Element) field_;
                        	System.out.println("Field is "+field);
                        	System.out.println(field.getAttribute("name"));
                        	System.out.println(field.getAttribute("declaringclass"));
                        	List values = field.getChildren();
                        	for(Object value_ : values) {
                        		Element value = (Element) value_;
                        		System.out.println("Value is "+value);
                        		System.out.println(value.getText());
                        	}
                        }
                        */
                    	/*
                    	 * 	
                    	 * 
                    	 */
                    	
                    	
                    }else if((child.getAttribute("class").toString()).contains("Object2")) {
                    	Object2 obj2 = new Object2();
                    	Object1 obj1 = new Object1();
                    	
                    	List fields = child.getChildren();
                    	for(int k = 0; k < fields.size(); k++) {
                        	Element field = (Element) fields.get(k);
                        	System.out.println("Field is "+field+" at "+k);
                        	System.out.println(field.getAttribute("name"));
                        	System.out.println(field.getAttribute("declaringclass"));
                        	
                        	
                        	List values = field.getChildren();
                        	for(Object value_ : values) {
                        		Element value = (Element) value_;
                        		System.out.println("Value is "+value);
                        		System.out.println(value.getText());
                        		if(k == 0) {
                        			obj2.setObject1(obj1);
                        		}if(k == 1) {
                        			obj1.setA(Integer.parseInt(value.getText()));
                        		}if(k == 2) {
                        			obj1.setB(value.getText().charAt(0));
                        		}if(k == 3) {
                        			obj1.setC(Double.parseDouble(value.getText()));
                        		}
                        	}
                        }
                    	objectList.add(obj2);
                    	
                    }else if((child.getAttribute("class").toString()).contains("Object3") || (child.getAttribute("class").toString()).contains("Object4") ) {
                    	System.out.println(child.getAttribute("length"));
                    	if((child.getAttribute("class").toString()).contains("Object3")) {
                    		Object3 obj3 = new Object3();
                    		
                    		List values = child.getChildren();
                    		int[] arr = new int[3];
                    		
                        	for(int k = 0; k < values.size(); k++) {
                        		Element value = (Element) values.get(k);
                        		System.out.println("Value is "+value+ " at "+k);
                        		System.out.println(value.getText());
                        		arr[k] = Integer.parseInt(value.getText());
                        	}
                        	obj3.setArr(arr);
                        	objectList.add(obj3);
                    	}else if((child.getAttribute("class").toString()).contains("Object4")) {
                    		Object4 obj4 = new Object4();
                    		Object1 obj1 = new Object1();
                    		Object3 obj3 = new Object3();
                    		
                    		List fields = child.getChildren();
                            for(int i = 0; i < 3; i++) {
                            	Element field = (Element) fields.get(i);
                            	System.out.println("Field is "+field);
                            	System.out.println(field.getAttribute("name"));
                            	System.out.println(field.getAttribute("declaringclass")); 
                            	List values = field.getChildren();
                            	for(Object value_ : values) {
                            		Element value = (Element) value_;
                            		System.out.println("Value is "+value);
                            		System.out.println(value.getText());
                            		if(i == 0) {
                            			obj1.setA(Integer.parseInt(value.getText()));
                            		}if(i == 1) {
                            			obj1.setB(value.getText().charAt(0));
                            		}if(i == 2) {
                            			obj1.setC(Double.parseDouble(value.getText()));
                            		}
                            	}
                            }
                            
                            List vals = child.getChildren();
                            System.out.println("Value size "+vals.size());
                            int[] arr = new int[3];
               
                    		
                        	for(int k = 3; k < vals.size(); k++) {
                        		Element value = (Element) vals.get(k);
                        		System.out.println("Value is "+value+ " at "+k);
                        		System.out.println(value.getText());
                        		arr[k-3] = Integer.parseInt(value.getText());
                        	}
                        	obj3.setArr(arr);
                        	//objectList.add(obj3);
                        	
                        	Object[] arr2 = new Object[2];
                        	arr2[0] = obj1;
                        	arr2[1] = obj3;
                        	
                        	obj4.setObjArr(arr2);
                        	objectList.add(obj4);
                    	}
                    	
                    }
                    
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        Visualizer v = new Visualizer();
        v.begin(objectList);


    }
}
