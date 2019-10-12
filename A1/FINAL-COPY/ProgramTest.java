import java.util.Scanner;
import org.junit.*;

public class ProgramTest {
	private Diary d;
	private Template t;
	
	private Validation v1;
	private Validation v2;

	Scanner s;
	
	@Before
	public void init() {
		v1 = new Validation("marela", "1234567!Ab");
		v2 = new Validation("marela2", "a"); 
		d = new Diary();
		t = new Template();
		s = new Scanner(System.in);
	}

	@Test
	public void testLoginUser(){
		v1.loadHashMap();
		Assert.assertEquals(true, v1.loginStatus());

		v2.loadHashMap();
		Assert.assertEquals(false, v2.loginStatus());

	}
	
	@Test
	public void testCreateUser() {
		v1.loadHashMap();
		Assert.assertEquals(false, v1.createUser());

		v2.loadHashMap();
		Assert.assertEquals(false, v2.createUser());
	}
	@Test
	public void testValidateNoUsername() {
		v1.loadHashMap();
		Assert.assertEquals(false, v1.validateNoUsername(v1.getUsername()));

		v2.loadHashMap();
		Assert.assertEquals(true, v2.validateNoUsername(v2.getUsername()));
	}
	
	@Test
	public void testValidatePassword() {
		Assert.assertEquals(false, v2.validatePassword(v2.getPassword()));
		Assert.assertEquals(true, v1.validatePassword(v1.getPassword()));
	}
	
	@Test	
	public void testgetFileContent() {
		Assert.assertEquals("test", d.getFileContent("testTextFile.txt").trim());
	}
	
	@Test
	public void testPasswordMatches(){
		v1.loadHashMap();
		Assert.assertEquals(true, v1.passwordMatches("marela","1234567!Ab"));
		Assert.assertEquals(false, v1.passwordMatches("marela","1234567Ab!"));

	}
	@Test
	public void testFileExist(){
		Assert.assertEquals(true, t.newEntry("testTextFile.txt", s, "message"));
	}
	

}

