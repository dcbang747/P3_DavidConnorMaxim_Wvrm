import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;

public class DisplayTile extends JLabel{

	private JLabel snakeHead = new JLabel(new ImageIcon(getClass().getResource("SnakeHead.png")));
	
	public DisplayTile() {
		setOpaque(true);
		this.setBackground(Color.black);
		MatteBorder matte = new MatteBorder(3, 3, 3, 3, Color.GRAY);
		this.setBorder(matte);
	}
	
	public void setValue(int n) {
		if(n == 1) {
			this.add(snakeHead);
		}
	}
	
}
