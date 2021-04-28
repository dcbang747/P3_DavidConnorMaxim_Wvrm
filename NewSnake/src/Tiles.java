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
	int[][] tileId = new int[10][10];
	int[][] tileTime = new int[10][10];
	int length = 5;
	int rot = 1;
	int ttd = 10; // time to death
	/* IDs: 
	 * 0: empty
	 * 1: Head
	 * 2: food ()
	 * 3: body: 1 = up 2 = down 3= left 4 = right//
	 * 4: obstacle //
	 * */
	public Tiles() {
		ttd = 10;
		tileId[4][4] = 1; // sets head tile to center of 10X10 grid
		for(int i = 0; i < tileId.length; i++) {
			for(int j = 0; j < tileId.length; j++) {
				//Initializes body based on length
				if(i > 4 && i < 4+length && j == 7) {
					tileId[i][j] = 2;
				}else {
					tileId[i][j] = 0;
				}
				
			}
		}
	}
	
	//-----------------------------------------------------------------------------------------------
	
	public void move(int dir) { // moves depending on the button input
		if(dir != rot) {
			rot = dir;
			if(dir == 1) { 
				check(0,-1);
				// TODO sets body to up direction (UP)
			}else if(dir == 2) {
				check(0,1);
				// TODO sets body to down direction (DOWN)
			}else if(dir == 3) { 
				check(-1,0);
				// TODO sets body to left direction (LEFT)
			}else{
				check(1,0);
				// TODO sets body to right direction (RIGHT)
			}
		}else{
			length --; // IF unable to move, ROT will be the same as before which incurs a penalty
		}
	}
	
	//-----------------------------------------------------------------------------------------------
	
	public void check(int x, int y){ // checks for collision from movement and moves the head
		int r = 0, c = 0;
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) { // iterates through the entire array to find the head
				if(tileId[i][j] == 1) {
					r = i;
					c = j;
				}
			}
		}
		if(tileId[r+x][c+y] == 0) { // if Id of 0 replaces and moves head in the predefined direction
			tileId[r+x][c+y] = 1; // Moves Head in correct direction
			tileId[r][c] = 3; // Sets old head to body in direction
		}else if(tileId[r+x][c+y] == 2) { // same first operation but add 1 length (FOOD CONSUMED)
			tileId[r+x][c+y] = 1;
			tileId[r][c] = 3;
			length++;
		}else{ // checks for id 2+ which leads to death
			
			// TODO game over screen 
		}
		
	}
	
	//-----------------------------------------------------------------------------------------------
	
	public void food(){
		//TODO food timer
	}
	
	//-----------------------------------------------------------------------------------------------
	
	public void body(){
		//TODO Body timer and sprite direction setter
	}
	
	//-----------------------------------------------------------------------------------------------
	
	public void timeAdv() {
		// TODO updates all decay timings
	}
	
}	

	


