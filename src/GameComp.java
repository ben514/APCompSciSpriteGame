import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

// Platform: Hero jumps through the platform, but it does not fall through when it is on top of it
// Make the egg jump
// 

public class GameComp extends GameDriver{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Hero chicken;
	private int dx = 5, dy = 5;
	
	private int power = 50;
	private double gravity = 1.0;
	
	private int eggX, eggY;
	
	private double x = 100, y = 100, vel = 0.2, angle = 90;
	private ArrayList<PlatForm> plats;
	private int platTimer, platDelay = 7;
	private Rectangle startBg = new Rectangle(0,0,500,2000);
	private BufferedImage arrow, egg, background, platform;
	private BufferedImage[] eggs = new BufferedImage[3];
	
	private int camera;
	
	private int eggIndex = 0; private boolean eggReverse = false; private int eggDelay = 5, eggTimer = 0;
	
	private boolean spacePressed = false,leftPressed = false, rightPressed = false, startGame = false;
	public GameComp(){
		reset();
		for (int i =0; i < 50; i++){
			plats.add(new PlatForm());
			plats.get(i).setLocation((int)(Math.random()*400)+1, i * ( (int)(Math.random()+1)*50) );
			
		}
		arrow = this.addImage("arrow.png");
		egg = this.addImage("eggSprite.png");
		background = this.addImage("Background.png");
		platform = this.addImage("platform.png");
		int eggW = egg.getWidth();
		int eggH = egg.getHeight();
		
		for (int i = 0; i <3; i++){
			eggs[i] = egg.getSubimage(i*eggW/3, 0, eggW/3, eggH);
		}
		eggX = 250;
		eggY = 620;
		
		camera = -background.getHeight() + 700;
	}
	
	public void reset() {
		chicken = new Hero();
		plats = new ArrayList<PlatForm>();
	}

	@Override
	public void draw(Graphics2D win) {
		
		if(startGame == false){
			win.setColor(Color.BLACK);
//			win.setFont(f2);
            win.drawString("CHICKEN", 100, 150);
            win.drawString("JUMPt", 100, 250);
            win.drawString("Press D to move the paddle to the right", 100, 300);
            win.drawString("Press SPACEBAR to BEGIN", 300,400);
            if(spacePressed)
            startGame = true; 
            return;
		} else {
		
		for (int i =0; i < plats.size(); i++){
			plats.get(i).setLocation((int)plats.get(i).getX()+camera,(int)plats.get(i).getY( ));
		}
		
//		if (spacePressed){
//			if (power != 0){
//				eggX = 10;
//				eggY += power;
//				power -= gravity;
//			}
//		}
		// TODO Auto-generated method stub
		//clear each slide
		win.setColor(Color.WHITE);
		win.fill(startBg);
		win.setColor(Color.BLUE);
		//move and draw and delete
		
		if (leftPressed){
//			chicken.translate(-dx, 0);
		} else if (rightPressed){
//			chicken.translate(dx, 0);
		}
//		chicken.moveAndDraw(win);
		
		
		

		
		/*
		for(int i = 0; i < plats.size(); i++){
			PlatForm p1 =plats.get(i);
			p1.moveAndDraw(win);
			if (p1.getX() < -50){
				plats.remove(i);
				i--;
			}
		}
		*/
//		PlatForm p1 =plats.get(0);
//		p1.moveAndDraw(win);
//		platGen();
//		PlatForm p2 = plats.get(1);
//		p2.setLocation(100, 400);
//		p2.moveAndDraw(win);
//	if (leftPressed){
//		
//
//	}
		
	win.drawImage(background, null, 0, -background.getHeight()+700);
	for (int i = 0; i < 50; i++){
		plats.get(i).moveAndDraw(win, platform);
	}
	win.drawImage(arrow,null ,eggX+egg.getWidth()/2,eggY-150);
	win.drawImage(eggs[eggIndex], null, eggX, eggY);

	if (eggTimer == eggDelay){
		if (!eggReverse){
			eggIndex++;
		} else {
			eggIndex--;
		}
		if (eggIndex == 0){
			eggReverse = false;
		} else if (eggIndex == 2){
			eggReverse = true;
		}
		eggTimer = 0;
	}
	
	eggTimer++;

	
	
	}
	}
	
	public void keyPressed(KeyEvent e){
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE){
			spacePressed = true;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT){
			leftPressed = true;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			rightPressed = true;
		}
	}
	
		public void keyReleased (KeyEvent e){
		
		
			if (e.getKeyCode() == KeyEvent.VK_SPACE){
				spacePressed = false;
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT){
				leftPressed = false;
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
				rightPressed = false;
			}
	
	}
	
	public void platGen() {
		
		platTimer++;
		if (platTimer > platDelay){
			plats.add(new PlatForm());
			platTimer = 0;
		}
	}

}
