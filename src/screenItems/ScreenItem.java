package screenItems;

import game.DMToolGame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class ScreenItem {
	protected Image mImage;
	protected Rectangle mRect; 
	protected int mX, mY;
	
	public void draw(Graphics2D g2d, DMToolGame window) {
		g2d.drawImage(mImage, mX, mY, window);
	}
	
	public String getName(){
		return null;
	}
	
	public boolean contains(Point p){
		if(p.x > mX && p.x < mX + mImage.getWidth(null) && p.y > mY && p.y < mY + mImage.getHeight(null)){
			return true;
		}
		return false;
	}
}
