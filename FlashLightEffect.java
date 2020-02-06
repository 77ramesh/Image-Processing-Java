package application;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlashLightEffect {
	
	static BufferedImage src, src2;
	static File file;
	static Point mousePos;
	static int mouseX, mouseY;
	static JFrame frame;
	static BufferedImage srcOut;
	static JLabel label = new JLabel();
	static JFrame dFrame = new JFrame("Flash");
	static BufferedImage out;

	public static void main(String[] args) throws IOException{
		
		System.out.println("Hello, image processing");
		
		frame = new JFrame("Mix images");
		
		label.setIcon(new ImageIcon(mix()));
		label.setSize(500, 500);
		
		frame.add(label);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setResizable(false);
		
		printPos();
	}

	
	private static BufferedImage mix() throws IOException{
		
		file = new File("C:\\Users\\Ramesh\\Desktop\\opencv\\img_test.jpg");
		src = ImageIO.read(file);
		src2 = ImageIO.read(new File("C:\\\\Users\\\\Ramesh\\\\Desktop\\\\opencv\\\\img_test.jpg"));
		
		srcOut = new BufferedImage(500, 500, BufferedImage.TYPE_3BYTE_BGR);
		
		for(int x=0;x<500;x++) {
			for(int y=0;y<500;y++) {
				srcOut.setRGB(x, y, (int) (src.getRGB(x, y)));
			}
		}
		
		return srcOut;
	}

	private static void printPos() {
		
		out = blackColor();
		
		while(true) {
			
			mousePos = MouseInfo.getPointerInfo().getLocation();
			mouseX = mousePos.x - frame.getLocationOnScreen().x;
            mouseY = mousePos.y - frame.getLocationOnScreen().y;
            
			try {
				TimeUnit.SECONDS.sleep(1 / 2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if ((mouseX > 0 && mouseX < 500 ) && (mouseY > 0 && mouseY < 500)) {
                if (mouseX != MouseInfo.getPointerInfo().getLocation().x && mouseY != MouseInfo.getPointerInfo().getLocation().y) {
                   
                    int x = mouseX, y = mouseY;
                    
                    try {
	                	for(int posX=x;posX<x+100;posX++) {
	                		for(int posY=y;posY<y+100;posY++) {
	                			
	                			Color color = new Color(srcOut.getRGB(posX, posY));
	                			
	                			int R = (int) (color.getRed() * 0.3);
	                			int G = (int) (color.getGreen() * 0.3);
	                			int B = (int) (color.getBlue() * 0.3);
	                			
	                			Color newColor = new Color(R+G+B,R+G+B,R+G+B);
	                			
	                			out.setRGB(posX, posY, newColor.getRGB());
	                		}
	                	}
                	doFlash(out);
                    } catch(ArrayIndexOutOfBoundsException ex) {
                    	System.out.println("Move cursor to center!");
                    }
                	
//                    System.out.println("Mouse Pos: " + mouseX + " " + mouseY);
//                    System.out.println("RGB: " + srcOut.getRGB(x, y));
                    
                    mouseX = mousePos.x;
                    mouseY = mousePos.y;
                }
            }
		}
	}
	
	private static JFrame doFlash(BufferedImage img) {
		JLabel label = new JLabel(new ImageIcon(out));
		
		dFrame.setSize(500, 500);
		dFrame.setResizable(false);
		dFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dFrame.setVisible(true);
		dFrame.setLocation(600, 200);
		
		dFrame.add(label);
		
		return dFrame;
	}
	
	static BufferedImage blackColor() {
		
		Color color = new Color(0, 0, 0);
		
		BufferedImage img = new BufferedImage(500, 500, BufferedImage.TYPE_3BYTE_BGR);
		for(int x=0;x<500;x++) {
			for(int y=0;y<500;y++) {
				img.setRGB(x, y, color.getRGB());
			}
		}
		return img;
	}
}
