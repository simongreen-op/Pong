import java.awt.Color;

public class Ball extends Sprite {
	private final static int BALL_WIDTH = 25;
	private final static int BALL_HEIGHT = 25;
	private final static Color BALL_COLOR = Color.WHITE;
	
	public Ball (int panelWidth, int panelHeight) {
		setWidth(BALL_WIDTH);
		setHeight(BALL_HEIGHT);
		setColor(BALL_COLOR);
		setInitialPosition(panelWidth / 2 - (getWidth() / 2), panelHeight / 2 - (getHeight() / 2));
		resetToInitialPosition();
	}
	
	public void checkWallBounce(int panelWidth, int panelHeight) {
	      if(xPosition <= 0) {
	          // Hit left side of screen
	          xVelocity = -xVelocity;
	    	  resetToInitialPosition();
	      } else if(xPosition >= panelWidth - width) {
	          // Hit right side of screen
	          xVelocity = -xVelocity;
	    	  resetToInitialPosition();
	      }
	      if(yPosition <= 0 || yPosition >= panelHeight - height) {
	          // Hit top or bottom of screen
	          yVelocity = -yVelocity;
	      }
	 }
}
