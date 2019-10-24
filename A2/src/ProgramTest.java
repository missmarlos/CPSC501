import java.util.Scanner;
import org.junit.*;
import java.io.*;
import java.lang.reflect.*;


public class ProgramTest {
	private Inspector i;
	private TestClass tc;
	String text = "";
	
	@Before
	public void init() {
		i = new Inspector();
		tc = new TestClass();
		String filename = "test.txt";
		Object testObj = tc;
		boolean recursive = true;

		try {
            PrintStream old = System.out;
            File file = new File(filename);
            FileOutputStream fos = new FileOutputStream(file);
            PrintStream ps = new PrintStream(fos);
            System.setOut(ps);
            System.out.println("======================================================");
            System.out.println("Filename: " + filename);
            System.out.println("Running Test: " + testObj);
            System.out.println("Recursive: " + recursive);
            new Inspector().inspect(testObj, recursive);
            System.out.println("======================================================");
            ps.flush();
            fos.flush();
            ps.close();
            fos.close();
            System.setOut(old);

            Scanner scanner = new Scanner( new File("test.txt") );
			text = scanner.useDelimiter("\\A").next();
			scanner.close();


        } catch (IOException ioe) {
            System.err.println("Unable to open file: " + filename);
        } catch (Exception e) {
            System.err.println("Unable to compleatly run test: " + testObj);
            e.printStackTrace();
        }
	}

	
	@Test
	public void testInterface(){
		Class[] interfaces = i.inspectInterface(tc.getClass(), tc, true, "\t");
		int l = interfaces.length;
		Assert.assertEquals(0, l);
	}
	
	@Test
	public void testMethods(){
		Method[] m = i.findMethods(tc.getClass(), "\tb");
		int l = m.length;
		Assert.assertEquals(0, l);
	}

	@Test
	public void findConstructors(){
		Constructor[] c = i.findConstructors(tc.getClass(), "\t");
		int l = c.length;
		Assert.assertEquals(1, l);
	}

	@Test
	public void findSuperclass(){
		Assert.assertEquals("java.lang.Object", tc.getClass().getSuperclass().getName());
	}

	@Test 
	public void checkScript(){
		Assert.assertEquals(true, text.contains("NEW CLASS java.lang.Object"));
	}

	@Test
	public void checkScript2(){
		Assert.assertEquals(true, text.contains("Methods for java.lang.Object"));
	}

	@Test
	public void checkScript3(){
		Assert.assertEquals(true, text.contains("Declaring class"));
	}
	
}
