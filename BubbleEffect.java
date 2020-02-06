package application;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class BubbleEffect extends JComponent implements Runnable{

	static JFrame frame = new JFrame("Bubble effect");
	static Color color;
	static Random xRand = new Random();
	static BufferedImage original, copy;
	
	static int maxHeight, maxWidth;
	
	public static void main(String[] args) throws IOException{
		
		original = ImageIO.read(new File("C:\\Users\\Ramesh\\Desktop\\opencv\\cute.jpg"));
		maxHeight = original.getHeight();
		maxWidth = original.getWidth();
		
		copy = new BufferedImage(maxWidth, maxHeight, original.getType());
		
		Thread t = new Thread(new BubbleEffect());
		t.start();
		
		initFrame();

	}
	
	private static void initFrame() {
		frame.setSize(maxWidth, maxHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().add(new BubbleEffect());
	}

	@Override
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
			for(int i=0;i<30000;i++) {
				
				int CXPos = xRand.nextInt(maxWidth), CYPos = xRand.nextInt(maxHeight);
				color = new Color(copy.getRGB(CXPos, CYPos));
				g2.setPaint(color);
				g2.fill(new Ellipse2D.Double(CXPos, CYPos, 10, 10));
			}
				
		}


	@Override
	public void run() {
		for(int y=0;y<maxHeight;y++) {
			for(int x=0;x<maxWidth;x++) {
				copy.setRGB(x, y, original.getRGB(x, y));
			}
		}
		
	}
	
}
