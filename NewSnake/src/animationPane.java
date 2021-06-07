import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class animationPane extends JPanel {
	Image imh = null;
	
	public animationPane() {
		try {
		imh = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("visualframe6real.png"));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	
	}
	  @Override 
	    public void paint(Graphics g) {
	        super.paintComponent(g);
	       g.drawImage(imh, 0, 0, null);
	       System.out.print("painint");
	    }

	
	
}
