import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainPanel extends JPanel implements MouseListener, ActionListener{
	private Timer animationTimer;
	private Color bg;
	private int x = 0, y = 0, bpm = 0;
	public static JFrame frame = new JFrame("Snake");
	public JPanel main = new JPanel(), side1 = new JPanel(), side2 = new JPanel();
	
	public void paint(Graphics g) {
		super.paintComponent(g);
	}
	
	public MainPanel(int bpm) {
		bg = new Color(0,0,0);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1920, 1080);
		frame.add(main, BorderLayout.CENTER);
		frame.add(side1, BorderLayout.EAST);
		frame.add(side2, BorderLayout.WEST);
		side1.add(new JLabel("Side 1"));
		side2.add(new JLabel("Side 2"));
		side1.setBackground(bg);
		side2.setBackground(bg);
		this.bpm = bpm;
		setToMainMenu(bpm);
	}
	
	public void setToMainMenu(int b) {
		ImageIcon image =  new ImageIcon(getClass().getResource("gang gang.gif"));
		JLabel menu = new JLabel(image);
		menu.setSize(1020,20);
		main.add(menu);
		//frame.pack();
		animationTimer = new Timer(60000/bpm,this);
		animationTimer.start();
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("beat");
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

}
