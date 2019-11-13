
public class Object2 {
	Object1 obj1;
	
	public Object2(Object1 obj) {
		this.obj1 = obj;
		System.out.println("Object created in Object2");
	}
	
	public Object1 getObject1() {
		return obj1;
	}
	
}
