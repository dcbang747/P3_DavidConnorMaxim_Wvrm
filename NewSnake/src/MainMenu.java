import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JPanel {
	private ImageIcon menu = new ImageIcon("/NewSnake/src/gang gang.gif");
	
	
	public MainMenu() {
		URL imageURL = getClass().getResource("gang gang.gif");
		ImageIcon image =  new ImageIcon(imageURL);
		JLabel label = new JLabel(image);
		label.setBounds(getVisibleRect());
	}
}
