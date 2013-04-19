package screenItems;

import game.DMToolGame;

import java.awt.Graphics2D;

import battleMap.actors.Actor;


public class CharacterPane extends ScreenItem{
	
	private Actor mCharacter;
	private int mInitiative;
	private String mName;
	
	public CharacterPane(){
		mImage = managers.ImageManager.getInstance().getImage("CharacterPane.png");
		mName = "Empty";
		mInitiative = -99;
	}
	
	public CharacterPane(String actor, int init){
		mName = actor;
		mInitiative = init;
	}
	
	public CharacterPane(Actor actor){
		mName = actor.getmName();
		mInitiative = actor.getmInit();
	}
	
	public void setActive(boolean value){
		if(value)
			mImage = managers.ImageManager.getInstance().getImage("CharacterPaneActive.png");
		else
			mImage = managers.ImageManager.getInstance().getImage("CharacterPane.png");
	}
	
	public void draw(Graphics2D g2d, DMToolGame window, int x, int y) {
		g2d.drawImage(mImage, x, y, window);
		g2d.drawString(mName, x+40, y+40);
	}
	
	public String getmName(){
		return mName;
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
