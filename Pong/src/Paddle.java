import java.awt.Color;

public class Paddle extends Sprite {
	private final static int PADDLE_WIDTH = 10;
	private final static int PADDLE_HEIGHT = 100;
	private final static Color PADDLE_COLOR = Color.WHITE;
	private static final int DISTANCE_FROM_EDGE = 40;
	
	public Paddle (Player player, int panelWidth, int panelHeight) {
		setWidth(PADDLE_WIDTH);
		setHeight(PADDLE_HEIGHT);
		setColor(PADDLE_COLOR);
		
		int xPos;
        if(player == Player.One) {
            xPos = DISTANCE_FROM_EDGE;
        } else {
            xPos = panelWidth - DISTANCE_FROM_EDGE - getWidth();
        }
        
		setInitialPosition(xPos, panelHeight / 2 - (getHeight() / 2));
		resetToInitialPosition();
	}

}
