import java.awt.Color;
import java.awt.Graphics;


public class GravUp extends Item {

	public GravUp(int x) {
		super(x);
	}
	@Override
	public void paint(Graphics g){
		g.setColor(Color.red);
		super.paint(g);
	}
}
