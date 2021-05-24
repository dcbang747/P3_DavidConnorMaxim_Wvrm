import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class MainPanel extends JPanel implements MouseListener, ActionListener, KeyListener{
	//private Timer animationTimer;
	private int mus = 0;
	private URL music = this.getClass().getResource("MainMenua.wav");
	private Color bg, sideColor = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
	private int x = 0, y = 0, bpm = 130, upPress = 0;
	private ImageIcon image =  new ImageIcon(getClass().getResource("gang gang.gif"));
	private ImageIcon ending = new ImageIcon(getClass().getResource("Game over screen.gif"));
	private JLabel menu = new JLabel(image);
	private JLabel snakeHead = new JLabel(new ImageIcon(getClass().getResource("SnakeHead.png")));
	private JLabel snakeBody = new JLabel(new ImageIcon(getClass().getResource("SnakeBody.png")));
	private JButton optionsButton = new JButton(new ImageIcon(getClass().getResource("OptionsButton (1).png")));
	private JButton startButton = new JButton(new ImageIcon(getClass().getResource("StartButton.png")));
	private JButton exitButton = new JButton(new ImageIcon(getClass().getResource("ExitButton.png")));
	private DisplayTile[][] b = new DisplayTile[15][10];
	public static JFrame frame = new JFrame("Snake");
	//creating panels for the sides.
	public JPanel main = new JPanel(), side1 = new JPanel(), side2 = new JPanel(), options = new JPanel(), game = new JPanel(), end = new JPanel();
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
		//frame.add(side1, BorderLayout.EAST);
		// .add(side2, BorderLayout.WEST);
		side1.setPreferredSize(new Dimension(480,0));
		side2.setPreferredSize(new Dimension(480,0));
		main.setPreferredSize(new Dimension(1440,800));
		side1.setBackground(bg);
		side2.setBackground(bg);
		main.setBackground(bg);
		initOptions();
		initMainMenu();
	}
	
	public void playIntro() {
		 
		try{
		     AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(music);
		     Clip clip = AudioSystem.getClip();
		     clip.open(audioInputStream);
		     clip.setMicrosecondPosition(43000000);
		     clip.loop(clip.LOOP_CONTINUOUSLY);
		     clip.start();
//		     while(true) {
//		    	 if(mus != 0) {
//		    		 break;
//		    	 }
//		     }
//		     clip.stop();
		    }
		   catch(Exception ex)
		   {  ex.printStackTrace();}
		
	}
	
	public void initMainMenu() {
		// initializing the menu; making the central panel display 
		
		GridBagLayout g = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		main.setLayout(g);
		 
		 menu.setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
		c.fill = GridBagConstraints.NONE;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		main.add(menu, c);
		System.out.println(image.getIconWidth() + " "+ image.getIconHeight());
		
		startButton.setBorder(BorderFactory.createEmptyBorder());
		startButton.setBackground(bg);
		startButton.addActionListener(this);
		c.gridwidth = 1;
		c.weightx = 0.25;
		c.gridy = 1;
		c.gridx = 0;
		main.add(startButton, c);
		
		optionsButton.setBorder(BorderFactory.createEmptyBorder());
		optionsButton.setBackground(bg);
		optionsButton.addActionListener(this);
		c.gridwidth = 1;
		c.weightx = 0.25;
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
		
		//playIntro();
		
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		
	}
	
	public void initOptions() {
		options.setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
		options.setBackground(bg);
		GridBagLayout g = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		options.setLayout(g);
		
		JButton back = new JButton(new ImageIcon(getClass().getResource("BackButton.png")));
		back.setBorder(BorderFactory.createEmptyBorder());
		back.setBackground(bg);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setToMainMenu();
			}
		});
		c.gridx = 0;
		c.gridy = 0;
		options.add(back, c);
		
	}
	public void setToOptions() {
		frame.remove(main);
		frame.add(options);
		frame.revalidate();
	}
	public void setToMainMenu() {
		frame.remove(options);
		frame.add(main);
		frame.revalidate();
	}
	public void setUp(int bpm, Tiles f) {
		frame.remove(main);
		
		mus++;
		
		this.bpm = bpm;
		Timer animationTimer = new Timer(60000/bpm,this);
		animationTimer.start();
		GridLayout g = new GridLayout(15, 10);
		BorderLayout e = new BorderLayout();
		frame.setLayout(e);
		frame.setFocusable(true);
		frame.requestFocusInWindow();
		
		game.setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
		game.addKeyListener(this);
		game.setFocusable(true);
		
		game.setMaximumSize(game.getPreferredSize());
		game.setMinimumSize(game.getPreferredSize());
		game.setBorder(new MatteBorder(3,3,3, 3, sideColor));
		game.setBackground(bg);
		game.setLayout(g);
		
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[0].length; j++) {
				b[i][j] = new DisplayTile();
				b[i][j].setValue(f.getTileId()[i+1][j+1]);
				game.add(b[i][j]);
			}
		}
		frame.add(game);
		frame.add(side1, BorderLayout.WEST);
		frame.add(side2, BorderLayout.EAST);
		frame.revalidate();
		game.requestFocusInWindow();
		
	}
	
	public void update(Tiles f) {
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[0].length; j++) {
				b[i][j].setValue(f.getTileId()[i+1][j+1]);
			}
			sideColor = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
			game.setBorder(new MatteBorder(3,3,3, 3, sideColor));
		}
		if(f.isGameOver == true) {
			gameOver();
		}
	}
	
	public void gameOver() {
		mainBoard = new Tiles();
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(optionsButton)) {
			this.setToOptions();
		}
		if(e.getSource().equals(exitButton)) {
			frame.dispose();
		}
		if(e.getSource().equals(startButton)) {
			this.setUp(bpm, mainBoard);
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
			mainBoard.move(3);
			update(mainBoard);
			break;
		case 40: //down
			mainBoard.move(4);
			update(mainBoard);
			break;
		case 37: //left
			mainBoard.move(1);
			update(mainBoard);
			break;
		case 39://right
			mainBoard.move(2);
			update(mainBoard);
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
