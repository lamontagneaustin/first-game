package GUI;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

// Test Comment To See if I can push from home.

public class clickerLayout implements ActionListener{
	
	int count = 0;
	JFrame frame;
	JPanel panel;
	JButton button;
	JLabel label;
	Canvas canvas;
	GridBagConstraints c;
	
	public clickerLayout() throws IOException{
		
		frame = new JFrame("Our GUI");
		panel = new JPanel();
		button = new JButton("Click me");
		label = new JLabel("Number of clicks: 0");
		canvas = new Drawing();
		canvas.setSize(400, 400);
		
		//String imagePath = "/Users/u1243865/git/first-game/first-game/src/GUI/icon.png";
		//BufferedImage myPicture = ImageIO.read(new File (imagePath));
		ImageIcon img = loadIcon("src/image.png");
		frame.setIconImage(img.getImage());
		
		button.addActionListener(this);		
		
		//GridLayout layout = new GridLayout(0, 2);
		//SpringLayout layout = new SpringLayout();
		GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);
		
		
		c = new GridBagConstraints();	
		c.gridx = 0;
		c.gridy = 0;
		panel.add(button, c);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(label, c);		
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		panel.add(canvas, c);
		
		
		//panel.add(button);
		//panel.add(label);
		//panel.add(canvas);
		
		// layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, button, 5, SpringLayout.HORIZONTAL_CENTER, panel);
		//layout.putConstraint(SpringLayout.EAST, button, 50 ,SpringLayout.HORIZONTAL_CENTER , panel);
		//layout.putConstraint(SpringLayout.WEST, label, 50 ,SpringLayout.HORIZONTAL_CENTER , panel);
		
		//layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, canvas, 10, SpringLayout.VERTICAL_CENTER, panel);
	
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setBounds(0, 0, 1000, 1000);
		
		frame.update(panel.getGraphics());
		//frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}
	
	public static void main(String[] args) throws IOException {
		new clickerLayout();
	}
	
	public ImageIcon loadIcon(String iconName) throws IOException {
	    ClassLoader loader = this.getClass().getClassLoader();
	    BufferedImage icon = ImageIO.read(loader.getResourceAsStream(iconName));
	    return new ImageIcon(icon);
	}
	
	public void actionPerformed(ActionEvent e) {
		count++;
		label.setText("Number of clicks: " + count);
		canvas.update(canvas.getGraphics());
	}

}


