
public class Sprite {
	private int xPosition;
	private int yPosition;
	private int xVelocity;
	private int yVelocity;
	private int initialXPosition;
	private int initialYPosition;
	private int width;
	private int height;
	
	public int getXPosition () {
		return xPosition;
	}
	
	public int getYPosition () {
		return yPosition;
	}
	
	public int getXVelocity () {
		return xVelocity;
	}
	
	public int getYVelocity () {
		return yVelocity;
	}
	
	public int getWidth () {
		return width;
	}
	
	public int getHeight () {
		return height;
	}
	
	public void setXPosition (int value, int panelWidth) {
		if (value < 0) {
			value = 0;
		}
		else if (xPosition + width > panelWidth) {
	           xPosition = panelWidth - width;
		}
		xPosition = value;
	}
	
	public void setYPosition (int value, int panelHeight) {
		if(yPosition < 0) {
	          value = 0;
	    }
		else if(value + height > panelHeight) {
	          value = panelHeight - height;
	    }
		yPosition = value;
	}
	public void setXPosition(int value) {
		xPosition = value;
	}
	
	public void setYPosition(int value) {
		yPosition = value;
	}
	
	public void setXVelocity (int value) {
		xVelocity = value;
	}
	
	public void setYVelocity (int value) {
		yVelocity = value;
	}
	
	public void setWidth (int value) {
		width = value;
	}
	
	public void setHeight (int value) {
		height = value;
	}
	
	public void setInitialPosition(newX, newY) {
		initialXPosition = newX;
		initialYPosition = newY;
	}
	
	public void resetToInitialPosition() {
		xPosition = initialXPosition;
		yPosition = initialYPosition;
	}
}
