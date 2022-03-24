package breakout;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
	
	Panel panel;
	
	Frame(){
		
		panel = new Panel();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panel);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Breakout");
	}
	
}
