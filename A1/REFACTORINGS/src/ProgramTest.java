import java.util.Scanner;
import org.junit.*;

public class ProgramTest {
	private Login l;
	private Login l2;
	private Login l3;
	private Login l4;
	private Diary d;
	private Scanner s;
	private Template t;

	private UserRecord loginValid;
	private UserRecord loginInvalid;

	private UserRecord signupValid;
	private UserRecord signupInvalid;
	private UserRecord signupInvalid2;
	
	private UserRecord usernameValid;
	private UserRecord usernameInvalid;
	
	private UserRecord passwordValid;
	private UserRecord passwordInvalid;
	
	private Validation v1;
	private Validation v2;
	private Validation v3;
	private Validation v4;
	private Validation v5;
	private Validation v6;
	private Validation v7;
	
	@Before
	public void init() {
		/*
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
		*/

		v1 = new Validation("marela", "1234567!Ab");
		v2 = new Validation("marela2", "a"); 
		d = new Diary();
		t = new Template();









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

