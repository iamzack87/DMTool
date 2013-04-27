package screenItems;

import game.DMToolGame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

public abstract class ScreenItem {
	protected Image mImage;
	protected int mX, mY, mWidth, mHeight;
	
	public void draw(Graphics2D g2d, DMToolGame window) {
		g2d.drawImage(mImage, mX, mY, window);
	}
	
	public String getName(){
		return null;
	}
	
	public boolean contains(Point p){
		if(p.x > mX && p.x < mX + mWidth && p.y > mY && p.y < mY + mHeight){
			return true;
		}
		return false;
	}
}
