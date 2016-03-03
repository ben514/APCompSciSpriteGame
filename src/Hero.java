import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Hero extends GameObject {
	
	private int lives =3;
	
	public Hero() {
		super(100, 100, 100, 100, 3, 3);
		this.setColor(Color.GRAY);
	}
	
	public void moveAndDraw(Graphics2D win, BufferedImage image){;
		super.moveAndDraw(win, image);
	}
}
