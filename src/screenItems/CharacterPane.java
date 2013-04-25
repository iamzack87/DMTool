package screenItems;

import game.DMToolGame;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import battleMap.actors.Actor;


public class CharacterPane extends ScreenItem implements MouseListener{
	
	private Actor mCharacter;
	private int mInitiative, mX, mY;
	
	public CharacterPane(){
		System.out.println("mar");
		mImage = managers.ImageManager.getInstance().getImage("CharacterPaneInactive.png");
		mCharacter = null;
		mInitiative = -99;
	}
	
	public CharacterPane(Actor actor, int x, int y){
		mCharacter = actor;
		mX = x;
		mY = y;
		mInitiative = actor.getInit();
		mImage = managers.ImageManager.getInstance().getImage("CharacterPane.png");
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
			g2d.drawString(mCharacter.getName(), mX+40, mY+40);
			g2d.drawString(mCharacter.getCurrHP() + "/" + mCharacter.getMaxHP(), mX+40, mY+60);
			g2d.drawImage(mCharacter.getImage(), mX+5, mY+5, window);
		}
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

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
