package cpsc501a1;

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


		CardLayout cl = new CardLayout();
		
		panelCont.setLayout(cl);
		
		panelCont.add(opening, "1");
		panelCont.add(login, "2");
		panelCont.add(signup, "3");
		
		
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
			gl_login.createParallelGroup(Alignment.TRAILING)
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
										.addComponent(btnLogin)))
								.addGroup(gl_login.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(137, Short.MAX_VALUE))
				.addGroup(gl_login.createSequentialGroup()
					.addContainerGap(190, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(175))
				.addGroup(Alignment.LEADING, gl_login.createSequentialGroup()
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
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
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
							.addGroup(gl_signup.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_signup.createSequentialGroup()
									.addComponent(lblEnterAPassword)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_signup.createSequentialGroup()
									.addComponent(lblUsername)
									.addGap(20)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(87, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_signup.createSequentialGroup()
					.addContainerGap(202, Short.MAX_VALUE)
					.addComponent(btnSignUp)
					.addGap(160))
		);
		gl_signup.setVerticalGroup(
			gl_signup.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_signup.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSignUp)
					.addGap(36)
					.addGroup(gl_signup.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsername)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_signup.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterAPassword)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
					.addComponent(btnSignUp)
					.addGap(30))
		);
		signup.setLayout(gl_signup);
				
	}
}
