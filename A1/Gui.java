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

/**
 * Contains the gui for the project
 * 
 * @author mar
 *
 */
public class Gui {
	
	
	private JFrame frame;

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
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel Opening = new JPanel();
		frame.getContentPane().add(Opening, "name_4027281122563");
		
		JLabel lblOrganizerApp = new JLabel("ORGANIZER APP");
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Hi");
			}
		});
		GroupLayout gl_Opening = new GroupLayout(Opening);
		gl_Opening.setHorizontalGroup(
			gl_Opening.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Opening.createSequentialGroup()
					.addGap(167)
					.addGroup(gl_Opening.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Opening.createSequentialGroup()
							.addGap(12)
							.addComponent(btnEnter))
						.addComponent(lblOrganizerApp))
					.addContainerGap(174, Short.MAX_VALUE))
		);
		gl_Opening.setVerticalGroup(
			gl_Opening.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Opening.createSequentialGroup()
					.addGap(102)
					.addComponent(lblOrganizerApp)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEnter)
					.addContainerGap(122, Short.MAX_VALUE))
		);
		Opening.setLayout(gl_Opening);
		
		JPanel Menu = new JPanel();
		frame.getContentPane().add(Menu, "name_4069282624559");
		
		JPanel Diary = new JPanel();
		frame.getContentPane().add(Diary, "name_4072403630136");
	}
}
