package GUI;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends Canvas{
	
	int i = 0;
	BufferedImage img1 = null;
	BufferedImage img2 = null;
	
	public Drawing() {
		try {
		    img1 = ImageIO.read(new File("src/octopus1.png"));
		    img2 = ImageIO.read(new File("src/octopus2.png"));
		} catch (IOException e) {
		}
	}

	@Override
	public void paint(Graphics g) {
		
		//g.drawImage(img, 100, 100, 200, 200, getParent());
		
		//g.setColor(Color.BLUE);
		//g.fillOval(100, 100, 200, 200);	
		
		if(i%2 == 0) {
			//g.fillRect(0, 0, 100, 100);
			g.drawImage(img1, 72, 72, 256, 256, getParent());
		}  
		else {
			g.drawImage(img2, 72, 72, 256, 256, getParent());
		}
		
		i++;
	}
}
