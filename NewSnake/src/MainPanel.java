import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

public class MainPanel extends JPanel implements MouseListener, ActionListener, KeyListener{
	//private Timer animationTimer;
	private Color bg;
	private int x = 0, y = 0, bpm = 130;
	private JButton exitButton = new JButton(new ImageIcon(getClass().getResource("ExitButton.png")));
	private JButton optionsButton = new JButton(new ImageIcon(getClass().getResource("OptionsButton.png")));
	private JButton startButton = new JButton(new ImageIcon(getClass().getResource("StartButton.png")));
	public static JFrame frame = new JFrame("Snake");
	//creating panels for the sides.
	public JPanel main = new JPanel(), side1 = new JPanel(), side2 = new JPanel();
	//creating board
	Tiles mainBoard = new Tiles();
	
	public void paint(Graphics g) {
		super.paintComponent(g);
	}
	
	public MainPanel() {
		bg = new Color(0,0,0);
		
		// setting up the main frame
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(main, BorderLayout.CENTER);
		frame.add(side1, BorderLayout.EAST);
		frame.add(side2, BorderLayout.WEST);
		side1.setPreferredSize(new Dimension(480,0));
		side2.setPreferredSize(new Dimension(480,0));
		side1.setBackground(bg);
		side2.setBackground(bg);
		main.setBackground(bg);
		setToMainMenu();
	}
	
	public void setToMainMenu() {
		// initializing the menu; making the central panel display 
		GridBagLayout g = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		main.setLayout(g);
		
		ImageIcon image =  new ImageIcon(getClass().getResource("gang gang.gif"));
		JLabel menu = new JLabel(image);
		menu.setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
		c.fill = GridBagConstraints.NONE;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		main.add(menu, c);
		
		startButton.setBorder(BorderFactory.createEmptyBorder());
		startButton.setBackground(bg);
		c.gridwidth = 1;
		c.weightx = 0.3;
		c.gridy = 1;
		c.gridx = 0;
		main.add(startButton, c);
		
		optionsButton.setBorder(BorderFactory.createEmptyBorder());
		optionsButton.setBackground(bg);
		c.gridwidth = 1;
		c.weightx = 0.3;
		c.gridy = 1;
		c.gridx = 1;
		main.add(optionsButton, c);
		
		exitButton.setBorder(BorderFactory.createEmptyBorder());
		exitButton.setBackground(bg);
		exitButton.addActionListener(this);
		c.weightx = 0.3;
		c.gridwidth = 1;
		c.gridy = 1;
		c.gridx = 2;
		main.add(exitButton, c);
		
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		
	}
	
	public void setToOptions() {
		
	}
	public void setToGame() {
		
	} 
	
	public void setUp(int bpm) {
		this.bpm = bpm;
		Timer animationTimer = new Timer(60000/bpm,this);
		animationTimer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("beat");
		if(e.getSource().equals(exitButton)) {
			frame.dispose();
		}
		if(e.getSource().equals(startButton)) {
			this.setUp(bpm);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getKeyCode()) { //recives button input and asks for movement
		case 38: //up
			mainBoard.move(1);			
			break;
		case 40: //down
			mainBoard.move(2);
			break;
		case 37: //left
			mainBoard.move(3);
			break;
		case 39://right
			mainBoard.move(4);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
