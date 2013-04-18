package screenItems;

import game.DMToolGame;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Button extends ScreenItem {
	
	private String mString;
	
	public Button(String name, int x, int y){
		mString = name;
		mX = x;
		mY = y;
		mImage = managers.ImageManager.getInstance().getImage("Button.png");
		mRect = new Rectangle(x, y, mImage.getWidth(null), mImage.getHeight(null));
	}
	
	public void draw(Graphics2D g2d, DMToolGame window) {
		g2d.drawImage(mImage, mX, mY, window);
		
		g2d.drawString(mString, mX+40, mY+30);
	}
	
	public String getName(){
		return mString;
	}
	
	
}
