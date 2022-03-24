package breakout;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Brick {
	private boolean destroyed;
	private int x;
	private int y;
	static final int BRICK_WIDTH = 50;
	static final int BRICK_HEIGHT = 15;
	private final int BRICK_DISTANCE = 2;


	public Brick(int x, int y) {
		
		initBrick(x,y);
	}
	
	public boolean isDestroyed() {
		return destroyed;
	}
	public void setDestroyed() {
		destroyed = true;
	}
	
	private void initBrick(int x, int y) {
		this.x = x;
		this.y = y;
		
		destroyed = false;
		
		
	}
	
	
	
	public void draw(Graphics2D g) {
		g.setPaint(Color.black);
		g.setStroke(new BasicStroke(3));
		g.drawRect(x, y, BRICK_WIDTH-BRICK_DISTANCE, BRICK_HEIGHT-BRICK_DISTANCE);
		g.setColor(Color.cyan);
		g.fillRect(x, y, BRICK_WIDTH-BRICK_DISTANCE, BRICK_HEIGHT-BRICK_DISTANCE);
		
		
	}
	
	public Rectangle getRect() {
		return new Rectangle(x,y,BRICK_WIDTH,BRICK_HEIGHT);
		
	}
}
