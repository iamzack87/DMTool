package battleMap.screenItems;

import game.DMToolGame;

import java.awt.Graphics2D;
import java.awt.Point;

import battleMap.screenItems.actors.Actor;

import screenItems.ScreenItem;



public class CharacterPane extends ScreenItem{
	
	private Actor mCharacter;
	private int mInitiative;
	
	public CharacterPane(){
		System.out.println("mar");
		mImage = managers.ImageManager.getInstance().getImage("CharacterPaneInactive.png");
		mWidth = mImage.getWidth(null);
		mHeight = mImage.getHeight(null);
		mCharacter = null;
		mInitiative = -99;
	}
	
	public CharacterPane(Actor actor, int x, int y){
		mCharacter = actor;
		mX = x;
		mY = y;
		mInitiative = actor.getInit();
		mImage = managers.ImageManager.getInstance().getImage("CharacterPane.png");
		mWidth = mImage.getWidth(null);
		mHeight = mImage.getHeight(null);
	}
	
	public void setActive(boolean value){
		if(value)
			mImage = managers.ImageManager.getInstance().getImage("CharacterPaneActive.png");
		else
			mImage = managers.ImageManager.getInstance().getImage("CharacterPane.png");
	}
	
	public void draw(Graphics2D g2d, DMToolGame window) {
		g2d.drawImage(mImage, mX, mY, window);
		if(mCharacter != null){
			mCharacter.draw(g2d, window);
			g2d.drawString(mCharacter.getName(), mX+40, mY+40);
			g2d.drawString(mCharacter.getCurrHP() + "/" + mCharacter.getMaxHP(), mX+40, mY+60);
			g2d.drawImage(mCharacter.getImage(), mX+5, mY+5, window);
		}
	}
	
	public boolean contains(Point p){
		if(!super.contains(p)){
			if((p.x > mCharacter.getmX() && p.x < mCharacter.getmX() + mCharacter.getWidth() && p.y > mCharacter.getmY() && p.y < mCharacter.getmX() + mCharacter.getHeight())){
				return true;
			}
		}
		else{
			return true;
		}
		return false;
	}

	public Actor getmCharacter() {
		return mCharacter;
	}

	public int getmInitiative() {
		return mInitiative;
	}

	public void setmInitiative(int mInitiative) {
		this.mInitiative = mInitiative;
	}
}
