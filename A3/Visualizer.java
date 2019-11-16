import java.util.*;
import java.lang.reflect.*;

public class Visualizer {
	public void begin(List<Object> list) {
		System.out.println("In visualizer");
		
		System.out.println("Size of list "+list.size());
		for(int i = 0; i < list.size(); i++) {
			System.out.println(" ");
			System.out.println(list.get(i).getClass().getName());
			visualize(list.get(i));
		}
	}
	
	
	public void visualize(Object obj) {
		try {
			Field[] f = obj.getClass().getDeclaredFields();
			for(int i = 0; i < f.length; i++) {
				System.out.println("Name "+f[i].getName());
				if(f[i].getType().isPrimitive()) {
					f[i].setAccessible(true);
					Object value = f[i].get(obj);
					System.out.println("Value: "+value);
				}else {
					
					if(f[i].getType().isArray()) {
						
						System.out.println("Length of array: "+Array.getLength(f[i].get(obj)));
						for(int j = 0; j < Array.getLength(f[i].get(obj)); j++) {
							if(f[i].getType().getComponentType().isPrimitive()) {
								Object value = Array.get(f[i].get(obj), j);
								System.out.println("Value in array: "+value);
							}else {
								Object value = Array.get(f[i].get(obj), j).getClass().getName();
								Object val = Array.get(f[i].get(obj), j);
								System.out.println("Value in array: "+value);
								visualize(val);
							}
							
						}
					}else {
						System.out.println("Declaring class: "+f[i].getDeclaringClass());
						visualize(f[i].get(obj));
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
