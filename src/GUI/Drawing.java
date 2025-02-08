package GUI;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.imageio.ImageIO;

/**
 * The drawing class for the octopus game.
 * 
 * @author Austin LaMontagne
 * @version 1.0, December 15, 2022
 */
public class Drawing extends Canvas{
	
	int frame = 0;
	int bubbleFrame = 0;
	int i = 0;
	BufferedImage octFrame1;
	BufferedImage octFrame2;
	Dictionary<Integer, BufferedImage> octopusAnimation;
	Dictionary<Integer, BufferedImage> bubbleAnimation;
	Dictionary<Integer, BufferedImage> badges;
	
	/**
	 * Constructor for Drawing object. Reads image files.
	 */
	public Drawing() {
		// Read Image Files to objects to be drawn.
		try {
			octopusAnimation = new Hashtable<Integer, BufferedImage>();
		    octopusAnimation.put(0, ImageIO.read(new File("src/images/octopus1.png")));
		    octopusAnimation.put(1, ImageIO.read(new File("src/images/octopus2.png")));
		    octopusAnimation.put(10, ImageIO.read(new File("src/images/octopusBlowing.png")));
		    bubbleAnimation = new Hashtable<Integer, BufferedImage>();
		    bubbleAnimation.put(4, ImageIO.read(new File("src/images/bubbleFrame1.png")));
		    bubbleAnimation.put(3, ImageIO.read(new File("src/images/bubbleFrame2.png")));
		    bubbleAnimation.put(2, ImageIO.read(new File("src/images/bubbleFrame3.png")));
		    bubbleAnimation.put(1, ImageIO.read(new File("src/images/bubbleFrame4.png")));
		    badges = new Hashtable<Integer, BufferedImage>();
		    badges.put(20, ImageIO.read(new File("src/images/badge20.png")));
		    badges.put(40, ImageIO.read(new File("src/images/badge40.png")));
		    badges.put(60, ImageIO.read(new File("src/images/badge60.png")));
		    badges.put(80, ImageIO.read(new File("src/images/badge80.png")));
		    badges.put(100, ImageIO.read(new File("src/images/badge100.png")));
		} catch (IOException e) {
		}
	}

	/**
	 * The overridden paint method from Canvas to draw on our Drawing object.
	 * 
	 * @param g : Graphics object passed.
	 */
	public void paint(Graphics g) {
		  
	    // Draw and update bubbles for 4 frames every 25 clicks.
		if(frame % 25 == 0 && frame != 0) {
		    g.drawImage(octopusAnimation.get(10), 72, 72, 256, 256, getParent());
			bubbleFrame += 4;		
		}
		else {
			// Draw and update octopus each frame per click.
		    g.drawImage(octopusAnimation.get(frame %2), 72, 72, 256, 256, getParent());
		}
		if(bubbleFrame > 0) {
			g.drawImage(bubbleAnimation.get(bubbleFrame), 92, 124, 128, 128, getParent());
			bubbleFrame--;
		}
		
		// Draw and continuously update badges.
		int yPos = 0;
		for(int i = 20; i <= frame; i+=20) {	
			g.drawImage(badges.get(i), 368, yPos, 32, 32, getParent());
			yPos = yPos+32;
		}
		
		
		if (i!=0) 	
			frame++;	
		else
			i++;
	}
}
