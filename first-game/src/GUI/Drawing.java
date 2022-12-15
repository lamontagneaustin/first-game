package GUI;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends Canvas{
	
	int i = 0;
	
	public Drawing() {
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(100, 100, 200, 200);	
		
		if(i > 5) {
			g.fillRect(0, 0, 100, 100);
		}  
		
		i++;
	}
}
