package src;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RecursiveTriangle {
	public static int SIZE = 700;

	JFrame frame;
	JPanel panel;

	private Scanner console;

	@SuppressWarnings("serial")
	public void display() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel() {
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				paintSierpinskiTriangle(g, getSize());
			}
		};
		panel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				panel.repaint();
			}
		});
		frame.setLayout(new BorderLayout());
		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setSize(SIZE, SIZE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		RecursiveTriangle triangle = new RecursiveTriangle();
		triangle.display();
	}

	public void paintSierpinskiTriangle(Graphics g, Dimension size) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.white);
		g2.clearRect(0, 0, size.width, size.height);
        console = new Scanner(System.in);
	    System.out.print("Enter number of levels: ");
	    int level = console.nextInt();
	    int top = (int) (abs((size.height) - (sqrt(3) / 2) * size.width));
		Point p1 = new Point(size.width/2, top);
		Point p2 = new Point(0, size.height);
		Point p3 = new Point(size.width, size.height);
		//drawTriangle(g, p1, p2, p3);
		drawSierpinskiTriangle(level, g, p1, p2, p3 );
	}

	  public void drawTriangle(Graphics g, Point p1, Point p2, Point p3) {
	  		g.drawLine(p1.x, p1.y, p2.x, p2.y);
	  		g.drawLine(p2.x, p2.y, p3.x, p3.y);
	  		g.drawLine(p3.x, p3.y, p1.x, p1.y);
	  	}	
		  
	  public void drawSierpinskiTriangle(int level, Graphics g, Point p1, Point p2, Point p3) {
				
				Point mid1 = midpoint(p1, p2);
				Point mid2 = midpoint(p2, p3);
				Point mid3 = midpoint(p3, p1);
				
				g.setColor(Color.black);
				drawTriangle(g, p1, mid1, mid3);
				drawTriangle(g, mid1, p2, mid2);
				drawTriangle(g, mid3, mid2, p3);

				int[] xCoo = new int[] {mid1.x, mid2.x, mid3.x};
				int[] yCoo = new int[] {mid1.y, mid2.y, mid3.y};

				Polygon middle = new Polygon(xCoo, yCoo, 3);
				
				if (level == 1) {
				g.setColor(Color.green);
				}
				else if (level == 2) {
					g.setColor(Color.blue);
					}
				else if (level == 3) {
					g.setColor(Color.red);
					}
				else if (level == 4) {
					g.setColor(Color.yellow);
					}
				else if (level == 5) {
					g.setColor(Color.orange);
					}
				else if (level == 6) {
					g.setColor(Color.white);
					}
				
				//g.setColor(Color.black);
				g.fillPolygon(middle);

				level--;
				
				if (level > 0) {

					drawSierpinskiTriangle(level, g, p1, mid1, mid3);
					drawSierpinskiTriangle(level, g, mid1, p2, mid2);
					drawSierpinskiTriangle(level, g, mid3, mid2, p3);

					return;
				}
			}
			
			public Point midpoint(Point p1, Point p2) {
				int x = (p1.x + p2.x) / 2;
				int y = (p1.y + p2.y) / 2;

				return new Point(x, y);
			}
			
	
}