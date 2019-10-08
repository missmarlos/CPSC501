import org.junit.*;
import java.util.Scanner;

public class ProgramTest {
	private Login l;
	private Login l2;
	private Login l3;
	private Login l4;
	private Diary d;
	private Scanner s;
	private Template t;
	
	@Before
	public void init() {
		//old
		l = new Login("marela","1234567!Ab");
		//new
		l2 = new Login("nathan","1234567!Ab");
		l4 = new Login("claire", "7654321Ab!");
		//wrong
		l3 = new Login("pablo","a");
		
		//filecontent
		d = new Diary();
		
		s = new Scanner(System.in);

		t = new Template();
	}
	
	@Test
	public void testCreateUser() {
		l.loadHashMap();
		l2.loadHashMap();
		l3.loadHashMap();
		Assert.assertEquals(false, l.createUser("marela", "1234567!Ab"));
		Assert.assertEquals(true, l2.createUser("nate", "1234567!Ab"));
		Assert.assertEquals(false, l3.createUser("pablo", "a"));
	}
	
	@Test
	public void testValidateNoUsername() {
		l.loadHashMap();
		l4.loadHashMap();
		Assert.assertEquals(false, l.validateNoUsername("marela"));
		Assert.assertEquals(true, l4.validateNoUsername("claire"));
	}
	@Test
	public void testValidatePassword() {
		Assert.assertEquals(false, l3.validatePassword("a"));
		Assert.assertEquals(true, l4.validatePassword("7654321Ab!"));
	}
	@Test	
	public void testgetFileContent() {
		Assert.assertEquals("test", d.getFileContent("testTextFile.txt").trim());
	}
	@Test
	public void testLoginStatus() {
		Assert.assertEquals(true, l.loginStatus());
		Assert.assertEquals(false, l3.loginStatus());
	}
	@Test
	public void testPasswordMatches(){
		l.loadHashMap();
		Assert.assertEquals(true, l.passwordMatches("marela","1234567!Ab"));
		Assert.assertEquals(false, l.passwordMatches("marela","1234567Ab!"));

	}
	@Test
	public void testFileExist(){
		Assert.assertEquals(true, t.newEntry("testTextFile.txt", s, "message"));
	}

}

