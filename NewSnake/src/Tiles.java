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
public class Tiles {
	int Length;
	int rotiation;
	int ttd; // time to death
	/* ids: 
	 * 0: empty
	 * 1: Head
	 * 2: body: 1 = up 2 = down 3= left 4 = right 5 = barrier//
	 * 6: food ()
	 * 7: obstacle //
	 * */
	public Tiles() {
		ttd = 10;
		int[][] tileId = new int[16][16];
		int[][] tileTime = new int[16][16];
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 16; j++) {
				tileId[i][j] = 0;
			}
		}
	}
	
	public void move() {
		
	}
	public void empty(){
		
	}
	public void head(){
		
	}
	public void food(){
		
	}
	public void body(){
		
	}
	
}	

	


