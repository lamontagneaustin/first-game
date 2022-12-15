package GUI;

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Drawing extends Canvas{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame("Test Frame");
		Canvas canvas = new Drawing();				
		canvas.setSize(600, 600);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
	}

	public void paint(Graphics g) {
		g.fillOval(100, 100, 200, 200);
	}
}
