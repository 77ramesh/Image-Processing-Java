package application;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class MatchImg {

	static int n0, n1, n2, n3, n4, n5, n6, n7, n8;;
	
	public static void main(String[] args) throws IOException {
		
		File image = new File("C:\\Users\\Ramesh\\Desktop\\oooo.jpg");
		BufferedImage src = ImageIO.read(image);
		
		ImageIO.write(highlight(src), "jpg", new File("C:\\Users\\Ramesh\\Desktop\\star2.jpg"));
	}
	
	static BufferedImage highlight(BufferedImage src) {
		
		List<Point> points = new ArrayList<Point>();
		
		int _x = 0;
		int _y = 0;
		
		BufferedImage edge = edges(src);
		
		for(int y=0;y<src.getHeight();y++) {
			for(int x=0;x<src.getWidth();x++) {
				
				if(edge.getRGB(x, y) > edge.getRGB(_x, _y))
					points.add(new Point(x, y));
				
			}
		}
		
		return draw(points, src);
	}
	
	static BufferedImage draw(List<Point> points, BufferedImage src) {
		
		BufferedImage out = new BufferedImage(src.getWidth(), src.getHeight(), src.getType());
		
		Color blue = new Color(0, 0, 0);
		
		int index = 0;
		for(int y=0;y<src.getHeight();y++) {
			for(int x=0;x<src.getWidth();x++) {
				
				if((index != points.size() - 1) && (x == points.get(index).x) && (y == points.get(index).y)) {
					out.setRGB(x, y,  blue.getRGB());
					points.remove(index);
					index++;
				}
				else
					out.setRGB(x, y, src.getRGB(x, y));
				
			}
		}
		
		return out;
	}
	
	static BufferedImage edges(BufferedImage src) {
		
		BufferedImage out = new BufferedImage(src.getWidth(), src.getHeight(), src.getType());
		
		for(int y=1;y<src.getHeight() - 1;y++) {
			for(int x=1;x<src.getWidth() - 1;x++) {
				
				//n0 = parent
				n0 = src.getRGB(x, y) * 4;
				n1 = src.getRGB(x, y+1) * (-1);
				n2 = src.getRGB(x-1, y+1) * 0;//0
				n3 = src.getRGB(x-1, y) * (-1);
				n4 = src.getRGB(x-1, y-1) * 0;//0
				n5 = src.getRGB(x, y-1) * (-1);
				n6 = src.getRGB(x+1, y-1) * 0;//0
				n7 = src.getRGB(x+1, y) * (-1);
				n8 = src.getRGB(x+1, y+1) * 0;//0
				
				out.setRGB(x, y, calcAvrg());
			}
		}
		
		return out;
	}
	
	static int calcAvrg() {
		return (n0+n1+n2+n3+n4+n5+n6+n7+n8)/9;
	}

}
