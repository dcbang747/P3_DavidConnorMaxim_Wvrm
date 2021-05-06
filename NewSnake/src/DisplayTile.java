import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

public class DisplayTile extends JLabel{

	private JLabel snakeHead = new JLabel(new ImageIcon(getClass().getResource("SnakeHead.png")));
	private Color headColor = new Color(211,47,47);
	
	
	public DisplayTile() {
		setOpaque(true);
		this.setBackground(Color.black);
		MatteBorder matte = new MatteBorder(2, 2, 2, 2, Color.BLACK);
		this.setBorder(matte);
	}
	
	public void setValue(int n) {
		if(n == 1) {
			this.setBackground(headColor);
		}
		if(n == 3) {
			this.setBackground(Color.WHITE);
		}
	}
	
}
