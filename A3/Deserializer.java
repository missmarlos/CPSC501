import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;



public class Deserializer {
	
	
	
	public void deserialize() {
		
        String fileName = "xmlFileReceived.xml";
        SAXBuilder builder = new SAXBuilder();
        List<Object> objectList = new LinkedList<Object>();

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
                    
                    
                    if((child.getAttribute("class").toString()).contains("Object3") || (child.getAttribute("class").toString()).contains("Object4") ) {
                    	System.out.println(child.getAttribute("length"));
                    	if((child.getAttribute("class").toString()).contains("Object3")) {
                    		List values = child.getChildren();
                        	for(Object value_ : values) {
                        		Element value = (Element) value_;
                        		System.out.println("Value is "+value);
                        		System.out.println(value.getText());
                        	}
                    	}else if((child.getAttribute("class").toString()).contains("Object4")) {
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
                            	}
                            }
                            
                            List vals = child.getChildren();
                        	for(int i = 3; i < vals.size(); i++) {
                        		Element val = (Element) vals.get(i);
                        		System.out.println("Value is "+val);
                        		System.out.println(val.getText());
                        	}
                        	
                    	}
                    }else {
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
                    }
                    
                   
                    
            	
                
                
            }
            




        } catch (IOException | JDOMException ex) {
            ex.printStackTrace();
        }

        //Company company = new Company(new ArrayList(employeeList));
        //System.out.println(company.toString());




    }
}
