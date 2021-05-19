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
	int[][] tileId = new int[17][12];
	int[][] tileTime = new int[17][12];
	int length = 5;
	int rot = 1;
	int foodCount = 0;
	int prevX = 0, prevY = 0;
	int ttd = 10; // time to death
	boolean isGameOver = false;
	/* IDs: 
	 * 0: empty
	 * 1: Head
	 * 2: food ()
	 * 3: body: 1 = up 2 = down 3= left 4 = right//
	 * 4: obstacle //
	 * */
	public Tiles() {
		ttd = 10;
		for(int i = 0; i < tileId.length; i++) {
			for(int j = 0; j < tileId[0].length; j++) {
				//Initializes body based on length
				if(i > 4 && i < 4+length && j == 7) {
					tileId[i][j] = 3;
				}else {
					tileId[i][j] = 0;
				}
				
			}
		}
		tileId[4][7] = 1; // sets head tile to center of 10X10 grid
	}
	
	public int[][] getTileId(){
		return tileId;
	}
	public int[][] getTileTime(){
		return tileTime;
	}
	public void advTime() {
		for(int r = 0; r < tileTime.length; r++) {
			for(int c = 0; c <tileTime[r].length; c++) {
				if(tileTime[r][c] != 0 ) {
					tileTime[r][c] -= 1;	
					}
				int rand = (int)(Math.random()*2500);
				if(rand == 1 && tileId[r][c] == 0 && foodCount < 2) {
					tileId[r][c] = 2;
					foodCount++;
				}
				
			}
		}
	} 
	//-----------------------------------------------------------------------------------------------
	
	public void move(int dir) { // moves depending on the button input
		advTime();
		check();
		if(dir != rot) {
			rot = dir;
		}
			if(dir == 1) { 
				collision(0,-1);
				// TODO sets body to up direction (UP)
			}else if(dir == 2) {
				collision(0,1);
				// TODO sets body to down direction (DOWN)
			}else if(dir == 3) { 
				collision(-1,0);
				// TODO sets body to left direction (LEFT)
			}else{
				collision(1,0);
				// TODO sets body to right direction (RIGHT)
			}
			
	}
	
	//-----------------------------------------------------------------------------------------------
	
	public void collision(int x, int y){ // checks for collision from movement and moves the head
		int r = 0, c = 0;
		for(int i = 0; i < tileId.length; i++) {
			for(int j = 0; j < tileId[0].length; j++) { // iterates through the entire array to find the head
				if(tileId[i][j] == 1) {
					r = i;
					c = j;
				}
			}
		}
		System.out.println(r + " " + c);
		
		if(tileId[r+x][c+y] == 0 && (r+x < tileId.length-1 && r+x > 0 && c+y < tileId[r].length-1 && c+y > 0)) { // if Id of 0 replaces and moves head in the predefined direction
			tileId[r+x][c+y] = 1; // Moves Head in correct direction
			tileId[r][c] = 3; // Sets old head to body in direction
			tileTime[r][c] = length;
		}else if(tileId[r+x][c+y] == 2 && (r+x < tileId.length-1 && r+x > 0 && c+y < tileId[r].length-1 && c+y > 0)) { // same first operation but add 1 length (FOOD CONSUMED)
			tileId[r+x][c+y] = 1;
			tileId[r][c] = 3;
			tileTime[r][c] = length;
			length++;
			foodCount--;
		}
		else{ // checks for id 2+ which leads to death
			isGameOver();
			// TODO game over screen 
		}
		
	}
	
	//-----------------------------------------------------------------------------------------------
	
	public void check(){
		//TODO Body timer and sprite direction setter
		for(int r = 0; r < tileTime.length; r++) {
			for(int c = 0; c <tileTime[r].length; c++) {
				if(tileTime[r][c] == 0 ) {
					if(tileId[r][c] == 3) { // body timer
						tileId[r][c] = 0; 
					}
				}
			}
		}
	}
	
	public boolean isGameOver() {
		isGameOver = true;
		return isGameOver;
	}
	
}	

	


