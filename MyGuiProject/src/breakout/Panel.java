package breakout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Panel extends JPanel {
	
	static final int FRAME_WIDTH = 600;
	static final int FRAME_HEIGHT = 600;
	static final int DELAY = 10;
	static final int N_BRICKS = 120;
	
	
	private Timer timer;
	private Ball ball;
	private Paddle paddle;
	private Brick[] bricks;
	private boolean ingame = true;
	private int nDestroyedBricks;
	
	Panel(){
		initBoard();
	}
	
	private void initBoard() {
		setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
		setFocusable(true);
		setBackground(Color.black);
		initGame();
	}
	
	private void initGame() {
		ball = new Ball();
		paddle = new Paddle();
		
		bricks = new Brick[N_BRICKS];
		
		nDestroyedBricks = 0;
		int nOfRow = FRAME_WIDTH/Brick.BRICK_WIDTH;
		
		int k = 0;
		for (int i = 0; i <= N_BRICKS/nOfRow; i++ ) {
			for(int j = 0; j < nOfRow; j++) {
				
				if(bricks[N_BRICKS-1]!=null)break;
				
				bricks[k] = new Brick(j*Brick.BRICK_WIDTH,i*Brick.BRICK_HEIGHT);
				k++;
			}
			
		}
		
		timer = new Timer(DELAY, new GameCycle());
		timer.start();
		
		
	}
	
	
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
//		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                RenderingHints.VALUE_ANTIALIAS_ON);
//
//        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
//                RenderingHints.VALUE_RENDER_QUALITY);
		
		if(ingame) {
			inGame(g2d);
		}
		else {
			gameOver(g2d);
		}
		
	}
	
	private void inGame(Graphics2D g) {
		ball.draw(g);
		paddle.draw(g);
		for(Brick i : bricks) {
			if(i.isDestroyed())continue;
			i.draw(g);
		}
		
		
	}
	
	private void gameOver(Graphics2D g) {
		this.setBackground(Color.pink);
		
		timer.stop();
	}
	
	private void checkCollision() {
		
		//ball left to bottom
		if(ball.getY()>FRAME_HEIGHT) {
			ingame = false;
		}
		
		Point ballTop = new Point(ball.getX(), (int) ball.getRect().getMinY());
		Point ballBottom = new Point(ball.getX(), (int) ball.getRect().getMaxY());
		Point ballLeft = new Point((int)ball.getRect().getMinX(), ball.getY());
		Point ballRight = new Point((int)ball.getRect().getMaxX(), ball.getY());
		
		//ball collides with brick
		for (Brick i : bricks) {
			if (i.isDestroyed())
				nDestroyedBricks += 1;
			
			if(ball.getRect().intersects(i.getRect())) {
				i.setDestroyed();
				if(i.getRect().contains(ballTop)||i.getRect().contains(ballBottom))
					ball.reverseYDir();
				if(i.getRect().contains(ballRight)||i.getRect().contains(ballLeft))
					ball.reverseXDir();
			}
		}
		//ball collides with paddle
		if(ball.getRect().intersects(paddle.getRect())) {
			ball.reverseYDir();
		}
		
	}
	
	
	private class GameCycle implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ball.move();
			paddle.move();
			checkCollision();
			
			repaint();
			
		}
		
		
		
	}
	
}
