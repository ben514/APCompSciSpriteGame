import java.awt.Color;


public class PlatForm extends GameObject {

	private int state = 1;
	public PlatForm() {
		
		super(300,(int)( Math.random()*300)+100, 80, 20, 0, 0 );
		this.setColor(Color.CYAN);
		
		
	}
	
}
