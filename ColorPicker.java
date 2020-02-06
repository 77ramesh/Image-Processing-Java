package application;

import java.awt.ActiveEvent;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ColorPicker extends JFrame implements MouseListener{

	public ColorPicker() {
		
	}
	
	static Color black, purple, red, white, yellow, cyan, orange, green, l_green, blue, pink, d_green;
	static JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
	
	//static JFrame frame = new JFrame("Color Picker");
	static JFrame info;
	static MousePos mPos = new MousePos();
	static ColorPicker frame;
	
	private void l1ActionPerformad(java.awt.event.ActionEvent evt) {
		System.out.println("Black");
	}
	
	public static void main(String[] args) {
		
		frame = new ColorPicker();
		
		initColors();
	
		l1 = new JLabel();
		l1.setIcon(new ImageIcon(blackColor()));
		l1.addMouseListener(new ColorPicker());
		
		l2 = new JLabel();
		l2.setIcon(new ImageIcon(purpleColor()));
		
		l3 = new JLabel();
		l3.setIcon(new ImageIcon(redColor()));
		
		l4 = new JLabel();
		l4.setIcon(new ImageIcon(whiteColor()));
		
		l5 = new JLabel();
		l5.setIcon(new ImageIcon(yellowColor()));
		
		l6 = new JLabel();
		l6.setIcon(new ImageIcon(cyanColor()));
		
		l7 = new JLabel();
		l7.setIcon(new ImageIcon(orangeColor()));
		
		l8 = new JLabel();
		l8.setIcon(new ImageIcon(greenColor()));
		
		l9 = new JLabel();
		l9.setIcon(new ImageIcon(lGreenColor()));
		
		l10 = new JLabel();
		l10.setIcon(new ImageIcon(blueColor()));
		
		l11 = new JLabel();
		l11.setIcon(new ImageIcon(pinkColor()));
		
		l12 = new JLabel();
		l12.setIcon(new ImageIcon(dGreenColor()));
		
		
		frame.setSize(500, 500);
		frame.setLayout(new GridLayout(4, 4));
		
		frame.add(l1);frame.add(l2);frame.add(l3);frame.add(l4);frame.add(l5);
		frame.add(l6);frame.add(l7);frame.add(l8);frame.add(l9);frame.add(l10);
		frame.add(l11);frame.add(l12);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		
		mPos.printPos(frame);

	}

	private static void colorInfo(String colName) {
		
		JTextArea txt = new JTextArea(colName);
		
		info = new JFrame("Color info");
		info.setVisible(true);
		info.setSize(100, 100);
		info.setResizable(false);
		info.add(txt);
		info.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	private static void initColors() {
		
		black = new Color(0, 0, 0);
		purple = new Color(255, 0, 255);
		red = new Color(255, 0, 0);
		white = new Color(255, 255, 255);
		yellow = new Color(255, 255, 0);
		orange = new Color(255, 127, 0);
		cyan = new Color(0, 255, 255);
		green = new Color(0, 255, 0);
		l_green = new Color(0, 255, 127);
		blue = new Color(0, 0, 255);
		pink = new Color(255, 0, 127);
		d_green = new Color(0, 127, 255);
		
	}
	
	static BufferedImage blackColor() {
		
		BufferedImage img = new BufferedImage(30, 30, BufferedImage.TYPE_3BYTE_BGR);
		for(int x=0;x<30;x++) {
			for(int y=0;y<30;y++) {
				img.setRGB(x, y, black.getRGB());
			}
		}
		
		return img;
	}
	
	static BufferedImage purpleColor() {
		
		BufferedImage img = new BufferedImage(30, 30, BufferedImage.TYPE_3BYTE_BGR);
		for(int x=0;x<30;x++) {
			for(int y=0;y<30;y++) {
				img.setRGB(x, y, purple.getRGB());
			}
		}
		
		return img;
	}
	
	static BufferedImage redColor() {
		
		BufferedImage img = new BufferedImage(30, 30, BufferedImage.TYPE_3BYTE_BGR);
		for(int x=0;x<30;x++) {
			for(int y=0;y<30;y++) {
				img.setRGB(x, y, red.getRGB());
			}
		}
		
		return img;
	}
	
	static BufferedImage whiteColor() {
		
		BufferedImage img = new BufferedImage(30, 30, BufferedImage.TYPE_3BYTE_BGR);
		for(int x=0;x<30;x++) {
			for(int y=0;y<30;y++) {
				img.setRGB(x, y, white.getRGB());
			}
		}
		
		return img;
	}
	
	static BufferedImage yellowColor() {
		
		BufferedImage img = new BufferedImage(30, 30, BufferedImage.TYPE_3BYTE_BGR);
		for(int x=0;x<30;x++) {
			for(int y=0;y<30;y++) {
				img.setRGB(x, y, yellow.getRGB());
			}
		}
		
		return img;
	}
	
	static BufferedImage cyanColor() {
		
		BufferedImage img = new BufferedImage(30, 30, BufferedImage.TYPE_3BYTE_BGR);
		for(int x=0;x<30;x++) {
			for(int y=0;y<30;y++) {
				img.setRGB(x, y, cyan.getRGB());
			}
		}
		
		return img;
	}
	
	static BufferedImage orangeColor() {
		
		BufferedImage img = new BufferedImage(30, 30, BufferedImage.TYPE_3BYTE_BGR);
		for(int x=0;x<30;x++) {
			for(int y=0;y<30;y++) {
				img.setRGB(x, y, orange.getRGB());
			}
		}
		
		return img;
	}
	
	static BufferedImage greenColor() {
		
		BufferedImage img = new BufferedImage(30, 30, BufferedImage.TYPE_3BYTE_BGR);
		for(int x=0;x<30;x++) {
			for(int y=0;y<30;y++) {
				img.setRGB(x, y, green.getRGB());
			}
		}
		
		return img;
	}
	
	static BufferedImage lGreenColor() {
		
		BufferedImage img = new BufferedImage(30, 30, BufferedImage.TYPE_3BYTE_BGR);
		for(int x=0;x<30;x++) {
			for(int y=0;y<30;y++) {
				img.setRGB(x, y, l_green.getRGB());
			}
		}
		
		return img;
	}
	
	static BufferedImage blueColor() {
		
		BufferedImage img = new BufferedImage(30, 30, BufferedImage.TYPE_3BYTE_BGR);
		for(int x=0;x<30;x++) {
			for(int y=0;y<30;y++) {
				img.setRGB(x, y, blue.getRGB());
			}
		}
		
		return img;
	}
	
	static BufferedImage pinkColor() {
		
		BufferedImage img = new BufferedImage(30, 30, BufferedImage.TYPE_3BYTE_BGR);
		for(int x=0;x<30;x++) {
			for(int y=0;y<30;y++) {
				img.setRGB(x, y, pink.getRGB());
			}
		}
		
		return img;
	}
	
	static BufferedImage dGreenColor() {
		
		BufferedImage img = new BufferedImage(30, 30, BufferedImage.TYPE_3BYTE_BGR);
		for(int x=0;x<30;x++) {
			for(int y=0;y<30;y++) {
				img.setRGB(x, y, d_green.getRGB());
			}
		}
		
		return img;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == l1) {
			System.out.println("Black");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}


