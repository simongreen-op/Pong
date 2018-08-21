import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.BasicStroke;
import javax.swing.JPanel;
import javax.swing.Timer;
  
public class PongPanel extends JPanel implements ActionListener, KeyListener {
	private final static Color BACKGROUND_COLOR = Color.BLACK;
	private final static int TIMER_DELAY = 5;
	private final static int BALL_MOVEMENT_SPEED = 2;

	GameState gameState = GameState.Initialising;
	Ball ball;
	Paddle paddle1;
	Paddle paddle2;
    
	public PongPanel() {
	    setBackground(BACKGROUND_COLOR);
	    Timer timer = new Timer(TIMER_DELAY, this);
	    timer.start();
	}
	       
	public void createObjects() {
	    ball = new Ball(getWidth(), getHeight());
	    paddle1 = new Paddle(Player.One, getWidth(), getHeight());
	    paddle2 = new Paddle(Player.Two, getWidth(), getHeight());
	}
	  
	private void update() {
		switch(gameState) {
        	case Initialising: {
            	createObjects();
            	gameState = GameState.Playing;
            	ball.setXVelocity(BALL_MOVEMENT_SPEED);
                ball.setYVelocity(BALL_MOVEMENT_SPEED);
            	break;
        	}
        	case Playing: {
        		ball.moveObject();            // Move ball
                ball.checkWallBounce(getWidth(), getHeight());
            	break;
        	}
        	case GameOver: {
            	break;
        	}
        }
	}

	private void paintSprite(Graphics g, Sprite sprite) {
	    g.setColor(sprite.getColor());
	    g.fillRect(sprite.getXPosition(), sprite.getYPosition(), sprite.getWidth(), sprite.getHeight());
	}
	
	private void paintDottedLine(Graphics g) {
	    Graphics2D g2d = (Graphics2D) g.create();
	    Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
	    g2d.setStroke(dashed);
	    g2d.setPaint(Color.WHITE);
	    g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
	    g2d.dispose();
	}

	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		update();
		repaint();
		
	}
 
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        paintDottedLine(g);
        if(gameState != GameState.Initialising) {
            paintSprite(g, ball);
            paintSprite(g, paddle1);
            paintSprite(g, paddle2);
        }
	}
 }