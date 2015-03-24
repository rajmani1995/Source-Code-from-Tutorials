import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Platform {
	private int x;
	private int y;
	private int width;
	private int height;
	private int dx;
	
	public Platform() {
		dx = -1;
		x = 300;
		y = 300;
		width = 120;
		height = 40;
	}
	
	public Platform(int x, int y) {
		dx = -1;
		this.x = x;
		this.y = y;
		width = 120;
		height = 40;
	}
	
	public void update(StartingPoint sp, Ball b) {
		x += dx;
		checkForCollision(b);
		if(x < 0-width) {
			Random r = new Random();
			x = sp.getWidth()+r.nextInt(300);
		}
	}
	
	void checkForCollision(Ball b){
		int ballX = b.getX();
		int ballY = b.getY();
		int radius = b.getRadius();
		if( ballY+radius>y && ballY+radius<y+height ) {
			if(ballX > x && ballX < x + width) {
				double newDy = b.getGameDy();
				b.setY(y-radius);
				b.setDy(newDy);
			}
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getDx() {
		return dx;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}

}
