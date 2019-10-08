
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

/**
 * Contains the gui for the project
 * 
 * @author mar
 *
 */
public class Gui {
	
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		
		JPanel panelCont = new JPanel();
		frame.getContentPane().add(panelCont);
		JPanel opening = new JPanel();
		JPanel login = new JPanel();
		JPanel signup = new JPanel();
		JPanel menu = new JPanel();
		JPanel diary = new JPanel();
		JPanel agenda = new JPanel();
		JPanel todo = new JPanel();
		JPanel fileCreate = new JPanel();
		
		//JLabel loginVerification;
		


		CardLayout cl = new CardLayout();
		
		panelCont.setLayout(cl);
		
		panelCont.add(opening, "1");
		panelCont.add(login, "2");
		panelCont.add(signup, "3");
		panelCont.add(menu, "4");
		panelCont.add(diary, "5");
		panelCont.add(fileCreate, "8");
		
		JLabel lblEnterFilename = new JLabel("Enter filename:");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JButton btnCreateFile_1 = new JButton("Create File");
		btnCreateFile_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Diary d = new Diary();
				String filename = textField_4.getText(); 
				//d.makeFile(filename);
			}
		});
		
		//JLabel lblError = new JLabel("");
		JLabel lblError = new JLabel("error");
		GroupLayout gl_fileCreate = new GroupLayout(fileCreate);
		gl_fileCreate.setHorizontalGroup(
			gl_fileCreate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_fileCreate.createSequentialGroup()
					.addGroup(gl_fileCreate.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_fileCreate.createSequentialGroup()
							.addGap(177)
							.addComponent(lblEnterFilename))
						.addGroup(gl_fileCreate.createSequentialGroup()
							.addGap(168)
							.addGroup(gl_fileCreate.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCreateFile_1)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(158, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_fileCreate.createSequentialGroup()
					.addContainerGap(196, Short.MAX_VALUE)
					.addComponent(lblError)
					.addGap(188))
		);
		gl_fileCreate.setVerticalGroup(
			gl_fileCreate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_fileCreate.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEnterFilename)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCreateFile_1)
					.addGap(55)
					.addComponent(lblError)
					.addContainerGap(117, Short.MAX_VALUE))
		);
		fileCreate.setLayout(gl_fileCreate);
		
		JLabel lblDiar = new JLabel("Diary");
		
		JButton btnCreateFile = new JButton("Create File");
		btnCreateFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cl.show(fileCreate, "8");
				
			}
		});
		GroupLayout gl_diary = new GroupLayout(diary);
		gl_diary.setHorizontalGroup(
			gl_diary.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_diary.createSequentialGroup()
					.addGroup(gl_diary.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_diary.createSequentialGroup()
							.addGap(185)
							.addComponent(lblDiar))
						.addGroup(gl_diary.createSequentialGroup()
							.addGap(150)
							.addComponent(btnCreateFile)))
					.addContainerGap(212, Short.MAX_VALUE))
		);
		gl_diary.setVerticalGroup(
			gl_diary.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_diary.createSequentialGroup()
					.addComponent(lblDiar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCreateFile)
					.addContainerGap(224, Short.MAX_VALUE))
		);
		diary.setLayout(gl_diary);
		panelCont.add(agenda, "6");
		panelCont.add(todo, "7");
		
		JLabel lblMenu_1 = new JLabel("Menu");
		
		JButton btnDiary = new JButton("Diary");
		btnDiary.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cl.show(diary, "5");
			}
		});
		
		JButton btnAgenda = new JButton("Agenda");
		btnAgenda.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cl.show(agenda, "6");
			}
		});
		
		JButton btnTodo = new JButton("To-Do");
		btnTodo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cl.show(todo, "7");
			}
		});
		GroupLayout gl_menu = new GroupLayout(menu);
		gl_menu.setHorizontalGroup(
			gl_menu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menu.createSequentialGroup()
					.addContainerGap(185, Short.MAX_VALUE)
					.addGroup(gl_menu.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_menu.createSequentialGroup()
							.addGroup(gl_menu.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnDiary)
								.addComponent(lblMenu_1))
							.addGap(190))
						.addGroup(Alignment.TRAILING, gl_menu.createSequentialGroup()
							.addGroup(gl_menu.createParallelGroup(Alignment.LEADING)
								.addComponent(btnTodo)
								.addComponent(btnAgenda))
							.addGap(179))))
		);
		gl_menu.setVerticalGroup(
			gl_menu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_menu.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMenu_1)
					.addGap(18)
					.addComponent(btnDiary)
					.addGap(26)
					.addComponent(btnAgenda)
					.addGap(18)
					.addComponent(btnTodo)
					.addContainerGap(106, Short.MAX_VALUE))
		);
		menu.setLayout(gl_menu);
		
		cl.show(panelCont, "1");
		

		
		
		
		//frame.getContentPane().add(opening, "name_4027281122563");
		
		JLabel lblOrganizerApp = new JLabel("ORGANIZER APP");
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Hi");
				cl.show(panelCont, "2");
				
			}
		});
		GroupLayout gl_opening = new GroupLayout(opening);
		gl_opening.setHorizontalGroup(
			gl_opening.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_opening.createSequentialGroup()
					.addGap(167)
					.addGroup(gl_opening.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_opening.createSequentialGroup()
							.addGap(12)
							.addComponent(btnEnter))
						.addComponent(lblOrganizerApp))
					.addContainerGap(174, Short.MAX_VALUE))
		);
		gl_opening.setVerticalGroup(
			gl_opening.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_opening.createSequentialGroup()
					.addGap(102)
					.addComponent(lblOrganizerApp)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEnter)
					.addContainerGap(122, Short.MAX_VALUE))
		);
		opening.setLayout(gl_opening);
		
		//JPanel menu = new JPanel();
		//frame.getContentPane().add(menu, "name_14029294282948");
		
		JLabel lblMenu = new JLabel("Login");
		
		JLabel lblNewLabel = new JLabel("Username:");
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("login");
		JLabel loginVerification = new JLabel("");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//check that username and password are valid
				String username = textField.getText();
				String password = textField_1.getText();
				Login login = new Login(username, password);
				if(!(login.loginStatus())) {
					loginVerification.setText("That login was invalid try again.");
				}else {
					cl.show(menu, "4");;
				}
				
				
			}
		});
		
		JLabel lblDontHaveAn = new JLabel("Don't have an account? Sign up.");
		
		JButton btnNewButton = new JButton("sign up");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				cl.show(panelCont, "3");
			}
		});
		
		GroupLayout gl_login = new GroupLayout(login);
		gl_login.setHorizontalGroup(
			gl_login.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_login.createSequentialGroup()
					.addGroup(gl_login.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_login.createSequentialGroup()
							.addGap(183)
							.addComponent(lblMenu))
						.addGroup(gl_login.createSequentialGroup()
							.addGap(98)
							.addGroup(gl_login.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_login.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_login.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnLogin)
										.addComponent(loginVerification)))
								.addGroup(gl_login.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(136, Short.MAX_VALUE))
				.addGroup(gl_login.createSequentialGroup()
					.addContainerGap(190, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(175))
				.addGroup(gl_login.createSequentialGroup()
					.addGap(109)
					.addComponent(lblDontHaveAn)
					.addContainerGap(119, Short.MAX_VALUE))
		);
		gl_login.setVerticalGroup(
			gl_login.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_login.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMenu)
					.addGap(18)
					.addGroup(gl_login.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_login.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLogin)
					.addGap(18)
					.addComponent(loginVerification)
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addComponent(lblDontHaveAn)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addGap(23))
		);
		login.setLayout(gl_login);
		
		//JPanel signup = new JPanel();
		//panelCont.add(signup, "name_15564726553418");
		
		JLabel lblSignUp = new JLabel("Sign Up");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblUsername = new JLabel("Pick a username: ");
		
		JLabel lblEnterAPassword = new JLabel("Enter a password:");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JButton btnSignUp = new JButton("Sign Up");
		JLabel checkUsername = new JLabel("");
		JLabel checkPassword = new JLabel("");
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//check if username/password are valid
				String username = textField_2.getText();
				String password = textField_3.getText();
				Login l = new Login(username, password);
				//if user cannot be created
				if(!(l.createUser(username, password))){
					checkUsername.setText("invalid username or password");
				
					//if username is taken
					if(!(l.validateNoUsername(username))) {
						checkUsername.setText("Username already taken");
					}if(!(l.validatePassword(password))) {
						checkPassword.setText("Password format wrong");
					}else {
						cl.show(menu, "4");
					}
			
				}
				
			}
		});
		JLabel lblNewLabel_2 = new JLabel();
		
		JLabel lblPasswordFormat = new JLabel("Password format (>=1 of each): uppercase,");
		
		JLabel lblLowercaseNumberSymbol = new JLabel("lowercase, number, symbol (!,@,#,$,%)");
		GroupLayout gl_signup = new GroupLayout(signup);
		gl_signup.setHorizontalGroup(
			gl_signup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_signup.createSequentialGroup()
					.addGroup(gl_signup.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_signup.createSequentialGroup()
							.addGap(193)
							.addComponent(lblSignUp))
						.addGroup(gl_signup.createSequentialGroup()
							.addGap(98)
							.addComponent(lblEnterAPassword)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_signup.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_signup.createSequentialGroup()
									.addGap(25)
									.addComponent(lblNewLabel_2)))))
					.addContainerGap(87, Short.MAX_VALUE))
				.addGroup(gl_signup.createSequentialGroup()
					.addContainerGap(202, Short.MAX_VALUE)
					.addComponent(btnSignUp)
					.addGap(160))
				.addGroup(gl_signup.createSequentialGroup()
					.addGap(134)
					.addGroup(gl_signup.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_signup.createSequentialGroup()
							.addComponent(checkUsername)
							.addContainerGap())
						.addGroup(gl_signup.createSequentialGroup()
							.addComponent(checkPassword, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
							.addGap(107))))
				.addGroup(gl_signup.createSequentialGroup()
					.addGap(100)
					.addGroup(gl_signup.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLowercaseNumberSymbol)
						.addComponent(lblPasswordFormat)
						.addGroup(gl_signup.createSequentialGroup()
							.addComponent(lblUsername)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		gl_signup.setVerticalGroup(
			gl_signup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_signup.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSignUp)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_signup.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(checkUsername)
					.addGap(13)
					.addComponent(lblNewLabel_2)
					.addGap(18)
					.addComponent(lblPasswordFormat)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLowercaseNumberSymbol)
					.addGap(29)
					.addComponent(checkPassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_signup.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterAPassword)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnSignUp)
					.addGap(30))
		);
		signup.setLayout(gl_signup);
				
	}
}