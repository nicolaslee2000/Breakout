package breakout;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Paddle {
	
	
	private final int PADDLE_WIDTH = 1000;
	private final int PADDLE_HEIGHT = 10;
	private final int INIT_X = Panel.FRAME_WIDTH/2-PADDLE_WIDTH/2;
	private final int INIT_Y = Panel.FRAME_HEIGHT-100;
	
	
	private int x;
	private int y;
	
	private int xdir;
	
	public Paddle() {
		
		initPaddle();
		
	}
	
	
	public int getXDir() {
		return xdir;
	}
	
	private void initPaddle() {
		move();
		initState();
	}
	
	public void move() {
		x += xdir;
		if (x <= 0) {

            x = 0;
        }

        if (x >= Panel.FRAME_WIDTH) {

            x = Panel.FRAME_WIDTH;
        }
		
	}
	
	private void initState() {
		x = INIT_X;
		y = INIT_Y;
		xdir = 0;
	}
	
	public void draw(Graphics2D g) {
		
		g.setPaint(Color.white);
		g.fillRect(x,y, PADDLE_WIDTH, PADDLE_HEIGHT);
	}

	public Rectangle getRect() {
		return new Rectangle(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
		
	}
}
