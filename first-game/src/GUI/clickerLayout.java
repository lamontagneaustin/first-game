package GUI;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The layout and main method of the Octopus clicker game.
 * 
 * @author Austin LaMontagne
 * @version 1.0, December 15, 2022
 */
public class clickerLayout implements ActionListener{
	
	// Declare variables and objects.
	int count = 0;
	int removeCongrats = 0;
	int nextGoal = 0;
	static int goalSpacing = 25;
	boolean congratsBool = false;
	JFrame frame;
	JPanel panel;
	JButton clickButton;
	JLabel noClicksLabel;
	JLabel responseLabel;
	Canvas canvas;
	GridBagConstraints c;
	
	/**
	 * Constructor for clickerLayout object. Creates framing of game.
	 */
	public clickerLayout(){
		
		// Initialize objects.
		frame = new JFrame("Octopus Game");
		panel = new JPanel();
		panel.setBackground(new Color(210, 210, 210));
		clickButton = new JButton("Click me");
		clickButton.addActionListener(this);
		clickButton.setBackground(new Color(190, 190, 190));
		clickButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		clickButton.setFocusPainted(false);
		noClicksLabel = new JLabel("Number of clicks: 0");
		responseLabel = new JLabel("Octopus Game: Click to win!");
		canvas = new Drawing();
		canvas.setBackground(new Color(165, 227, 223));
		canvas.setSize(400, 400);
		
		// Read image and set icon.
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("src/images/octopus1.png"));
		} catch (IOException e) {
		}
		String os = System.getProperty("os.name");
		if(os.equals("Windows 10") || os.equals("Windows 11")) {
			frame.setIconImage(img);
		}
		else if(os.equals("Mac OS X")) {
			//Application.getApplication().setDockIconImage(img);
		}
				
		// Set layout of panel.
		GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);
		
		// Add components with constraints to panel.
		c = new GridBagConstraints();	
		c.gridx = 1;
		c.gridy = 2;
		c.ipady = 40;
		c.gridwidth = 2;
		panel.add(clickButton, c);
		c.gridx = 1;
		c.gridy = 1;
		c.ipady = 0;
		panel.add(noClicksLabel, c);	
		c.gridx = 1;
		c.gridy = 0;
		panel.add(responseLabel, c);
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 3;
		panel.add(canvas, c);
		
		// Add panel to frame, set frame bounds, and set constraints.
		frame.add(panel, BorderLayout.CENTER);	
		frame.update(panel.getGraphics());
		frame.pack();
		frame.setLocationRelativeTo(null);
        frame.setMinimumSize(frame.getSize());
        //frame.setAlwaysOnTop (true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}
	
	/**
	 * Main method to instantiate and run game.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Creates clickerLayout object to begin game.
		new clickerLayout();
	}
	
	/**
	 * Action performed method for clicking button.
	 * 
	 * @param e : ActionEvent from button clicked.
	 */
	public void actionPerformed(ActionEvent e) {
		// Increments count and displays number of clicks.
		count++;
		noClicksLabel.setText("Number of clicks: " + count);
		
		// Updates canvas to redraw images.
		canvas.update(canvas.getGraphics());
		
		// Updates text to show congratulations and milestones messages.
		if(count % goalSpacing == 0) {
			responseLabel.setText("Congrats on reaching " + count + " clicks!");
			congratsBool = true;
			removeCongrats = 0;
			nextGoal = count + goalSpacing;
		}
		else if(removeCongrats == 10 && congratsBool) {
			responseLabel.setText("Next milestone: " + nextGoal + " clicks.");
			congratsBool = false;
		}
		removeCongrats++;
	}
}