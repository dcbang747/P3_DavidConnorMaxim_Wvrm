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
	private int x = 0, y = 0;
	public static JFrame frame = new JFrame();
	public ImageIcon main = new ImageIcon();
	
	public void paint(Graphics g) {
		super.paintComponent(g);
	}
	
	public MainPanel(int bpm) {
		bg = new Color(0,0,0);
		frame.setSize(1200, 720);
		frame.getContentPane().setBackground(bg);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void setToMainMenu() {
		URL imageURL = getClass().getResource("gang gang.gif");
		ImageIcon image = new ImageIcon(imageURL);
		JLabel menu = new JLabel(image);
		menu.setVisible(true);
		frame.setLayout(new FlowLayout());
		frame.getContentPane().add(menu);
		System.out.println("Set to main menu!");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
