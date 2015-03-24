import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Rajmani Arya
 * @see www.thenewboston.com
 */
public class Ball {

	private int x;
	private int y;
	private double dx=0;
	private double dy=0;
	private int radius=20;
	private double gravity = 15;
	private double energyloss = 1;
	private double xFriction = .9;
	private double dt = .2;
	private double gameDy = -75;
	
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void update(StartingPoint sp){
		if( x+dx > sp.getWidth()-radius-1){
			x = sp.getWidth()-radius-1;
			dx = -dx;
		} else if( x + dx < 0+radius){
			x = 0+radius;
			dx = -dx;
		} else 
			x += dx;
		if( y == sp.getHeight()-radius-1){
			dx *= xFriction;
			if( dx < 1)
				dx = 0;
		}
		if( y > sp.getHeight()-radius-1){
			y = sp.getHeight()-radius-1;
			dy *= energyloss;
			dy = -dy;
		} else {
			//velocity formula
			dy += gravity*dt;
			//position formula
			y += dy*dt + .5*gravity*dt*dt;
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x-radius, y-radius, radius*2, radius*2);
	}
	public void moveLeft(){
		if(dx-1 > -20)
			dx -= 1;
	}
	public void moveRight(){
		if(dx+1 < 20)
			dx += 1;
	}
	public void setDy(double dy){
		this.dy = dy;
	}
	public double getDy() {
		return dy;
	}
	public void setX(int x){
		this.x = x;
	}
	public int getX(){
		return x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getY(){
		return y;
	}
	public void setRadius(int radius){
		this.radius = radius;
	}
	public int getRadius(){
		return radius;
	}

	public double getGameDy() {
		return gameDy;
	}

	public void setGameDy(double gameDy) {
		this.gameDy = gameDy;
	}
}
