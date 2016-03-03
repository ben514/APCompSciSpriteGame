import javax.swing.JFrame;


public class GameWindow {
	
	
	public static void main(String[] args){
		JFrame j1 = new JFrame();
		j1.setSize(500, 700);
		j1.setTitle("hue");
		j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j1.add(new GameComp());
		j1.setVisible(true);
	}
}
