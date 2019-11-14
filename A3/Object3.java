
public class Object3 {
	int[] arr = new int[3];
	
	public Object3(int first, int second, int third) {
		this.arr[0] = first;
		this.arr[1] = second;
		this.arr[2] = third;
		System.out.println("Array of primitives made in Object3");
	}

	public int[] getArr() {
		return arr;
	}
}

