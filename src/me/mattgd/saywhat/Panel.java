package me.mattgd.saywhat;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private BufferedImage[] balls = new BufferedImage[5]; 
	private String[] colors = { "red", "green", "blue", "yellow", "magenta" };
	
	public Panel() {
		try {                
    	   for (int i = 0; i < balls.length; i++) {
    		   balls[i] = toBufferedImage(ImageIO.read(new File("res/" + colors[i] + ".png")).getScaledInstance(64, 64, 0));
   			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	    Font f = new Font("SansSerif", Font.BOLD, 14);
	    FontMetrics fm = g.getFontMetrics(f);
	    
	    int cx = 250;
	    int cy = 30;
	    
	    g.setFont(f);
	    g.drawString("Say What!", cx, cy);
	    
	    cx += fm.stringWidth("Say What!");
	    
	    int i = 10;
	    for (BufferedImage ball : balls) {
	    	g.drawImage(ball, i, 50, null);
	    	i += 100;
	    }
	}
	
	public BufferedImage toBufferedImage(Image img) {
	    if (img instanceof BufferedImage)
	    	return (BufferedImage) img;

	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

	    // Draw the image on to the buffered image
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();

	    // Return the buffered image
	    return bimage;
	}

}
