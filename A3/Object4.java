
public class Object4 {
	Object[] objArr = new Object[2];
	
	
	public Object4() {
		
	}
	
	
	public Object4(Object1 firstObj, Object3 secondObj) {
		objArr[0] = firstObj;
		objArr[1] = secondObj;
		System.out.println("Array of objects made Object4");
	}
	
	public Object[] getObjArr() {
		return objArr;
	}
	
	public void setObjArr(Object[] val) {
		objArr = val;
	}
}
