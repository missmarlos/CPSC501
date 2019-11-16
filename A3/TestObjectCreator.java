import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;
import org.junit.jupiter.api.Test;
import java.util.*;

class TestObjectCreator {
	Object1 object1;
	Object2 object2;
	Object3 object3;
	Object4 object4;
	Object5 object5;
	
	@Before
	public void init() {
		object1 = new Object1(1, 'b', 2.0);
		object2 = new Object2(object1);
		object3 = new Object3(1, 2, 3);
		object4 = new Object4(object1, object3);
		object5 = new Object5(object1, object3);
	}
	
	
	@Test
	void testObject1(){
		Assert.assertEquals(1, object1.getA());
		Assert.assertEquals('b', object1.getB());
		Assert.assertEquals(2.0, object1.getC());
	}
	
	@Test
	void testObject2(){
		Assert.assertEquals(object1, object2.getObject1());
	}
	
	@Test
	void testObject3(){
		int[] arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		Assert.assertArrayEquals(arr, object3.getArr());
	}
	
	@Test
	void testObject4(){
		Object[] arr = new Object[2];
		arr[0] = object1;
		arr[1] = object3;
		Assert.assertArrayEquals(arr, object4.getObjArr());
	}
	
	@Test
	void testObject5(){
		ArrayList<Object> arrList = new ArrayList<Object>();
		Assert.assertEquals(object1, arrList.get(0));
		Assert.assertEquals(object3, arrList.get(1));
	}
	
	
	

}
