package breakout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	
	static final int BALL_DIAMETER = 10;
	private final int INIT_X = Panel.FRAME_WIDTH/2-BALL_DIAMETER/2;
	private final int INIT_Y = Panel.FRAME_HEIGHT/2-BALL_DIAMETER/2;
	
	private int x;
	private int y;
	private int xdir=2;
	private int ydir=-3;
	
	Ball(){
		initBall();
	}
	
	
	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	private void initBall(){
		initState();
		move();
		
	}
	
	public void draw (Graphics2D g) {
		g.setColor(Color.white);
		g.fillOval(x, y, BALL_DIAMETER, BALL_DIAMETER);
		
	}
	
	public void move() {
		x += xdir;
		y += ydir;
		checkCollisionWithWall();
	}
	
	private void checkCollisionWithWall() {
		if(x<=0||x>=Panel.FRAME_WIDTH-BALL_DIAMETER) {
			reverseXDir();
		}
		if (y <= 0) {
			reverseYDir();
			
		}
	}
	
	private void initState() {
		x = INIT_X;
		y = INIT_Y;
	}
	
	public void reverseXDir() {
		xdir *= -1;
	}
	public void reverseYDir() {
		ydir *= -1;
	}
	
	public Rectangle getRect() {
		return new Rectangle(x,y,BALL_DIAMETER,BALL_DIAMETER);
		
	}
	
}
