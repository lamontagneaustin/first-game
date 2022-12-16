package GUI;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * The drawing class for the octopus game.
 * 
 * @author Austin LaMontagne
 * @version 1.0, December 15, 2022
 */
@SuppressWarnings("serial")
public class Drawing extends Canvas{
	
	int frame = 0;
	BufferedImage octFrame1;
	BufferedImage octFrame2;
	
	/**
	 * Constructor for Drawing object. Reads image files.
	 */
	public Drawing() {
		// Read Image Files to objects to be drawn.
		try {
		    octFrame1 = ImageIO.read(new File("src/octopus1.png"));
		    octFrame2 = ImageIO.read(new File("src/octopus2.png"));
		} catch (IOException e) {
		}
	}

	/**
	 * The overridden paint method from Canvas to draw on our Drawing object.
	 * 
	 * @param g : Graphics object passed.
	 */
	public void paint(Graphics g) {
		
		// Draw and update octopus each frame per click.
		if(frame % 2 == 0) {
			g.drawImage(octFrame1, 72, 72, 256, 256, getParent());
		}  
		else {
			g.drawImage(octFrame2, 72, 72, 256, 256, getParent());
		}
		
		frame++;
	}
}
