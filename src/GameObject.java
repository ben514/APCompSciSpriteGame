import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class GameObject extends Rectangle{
	double dx, dy;
	Color c1;
	public static double gravity = 1.2;
	
	public GameObject() {
		
		super(0,0,0,0);
		dx = 0;
		dy = 0; 
		c1 = Color.CYAN;
		
	}
	
	public GameObject(double dx, double dy){
		this();
		this.dx = dx;
		this.dy = dy;
	}
	
	//You could set color here
	public GameObject(int x, int y, int width, int height, double dx, double dy){
		super(x, y, width, height);
		this.dx = dx;
		this.dy = dy;
		
	}
	
	public Color getColor() {
		return c1;
	}
	
	public void setColor(Color col){
		c1 = col;
	}
	
	public double getDx() {
		return dx;
	}
	
	public void setDx(double value) {
		dx = value;
	}
	
	public double getDy() {
		return dy;
	}
	
	public void setDy(double value){
		dy = value;
	}
	
	public void moveAndDraw(Graphics2D win, BufferedImage image) {
//		this.translate((int)this.dx, (int)dy);
//		win.setColor(c1);
		win.drawImage(image, null,(int) this.getX(),(int) this.getY());
//		win.fill(this);
	}
}
