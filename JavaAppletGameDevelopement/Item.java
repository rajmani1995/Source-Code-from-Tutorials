import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Item {

	private int x, y, dx, radius;
	
	public Item(int x) {
		this.x = x;
		Random r= new Random();
		y = r.nextInt(400)+radius;
		radius = 10;
		dx = -2;
	}

	public void update(StartingPoint sp, Ball b) {
		x += dx;
		checkForCollision(b);
		if(x < 0-radius) {
			Random r = new Random();
			y = sp.getHeight() -40- r.nextInt(400);
			x = sp.getWidth()+2000+r.nextInt(300);
		}
	}
	
	void checkForCollision(Ball b){
		int ballX = b.getX();
		int ballY = b.getY();
		int radius = b.getRadius();
		
		int a = x - ballX;
		int b1 = y - ballY;
		int collide = radius+ballX;
		//distance between objects centre
		double c = Math.sqrt((double) a*a + (double) b1*b1);
		
		if( c < collide) {
			performAction();
			x=0;
			y=0;
		}
	}
	
	private void performAction() {
		
		
	}

	public void paint(Graphics g) {
		g.setColor(Color.green);
		g.fillOval(x-radius, y-radius, radius*2, radius*2);
	}
}
