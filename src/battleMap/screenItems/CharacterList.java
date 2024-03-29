package battleMap.screenItems;

import game.DMToolGame;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import battleMap.screenItems.actors.Actor;

import screenItems.ScreenItem;

public class CharacterList extends ScreenItem{
	
	private ArrayList<CharacterPane> mCharacters;
	private int mCurrentTurn, mLastY;

	public CharacterList(){
		mX = 720;
		mY = 0;
		mLastY = 0;
		
		mImage = managers.ImageManager.getInstance().getImage("CharacterList.png");
		mWidth = mImage.getWidth(null);
		mHeight = mImage.getHeight(null);
		
		mCharacters = new ArrayList<CharacterPane>();
		
		mCurrentTurn = -1;
	}
	
	public void NextTurn(){
		if(mCharacters.size() > 0){
			if(mCurrentTurn == -1){
				mCurrentTurn = 0;
			}
			else{
				mCharacters.get(mCurrentTurn).setActive(false);
				if(mCurrentTurn <= mCharacters.size() -2)
					mCurrentTurn++;
				else
					mCurrentTurn = 0;
			}
			mCharacters.get(mCurrentTurn).setActive(true);
		}
	}
	
	public void draw(Graphics2D g2d, DMToolGame window) {
		for(int i=0; i<10; i++){
			if(i < mCharacters.size()){
				mCharacters.get(i).draw(g2d, window);
			}
			else{
				g2d.drawImage(managers.ImageManager.getInstance().getImage("CharacterPaneInactive.png"), mX, i*70, window);
			}
		}
	}
	
	
	public void AddCharacter(Actor character){
		CharacterPane newPane = new CharacterPane(character, mX, mLastY);
		mCharacters.add(newPane);
		CharacterPane[] temp = sortByName(mCharacters);	
		
		mCharacters.clear();
		for(int i =0; i< temp.length; i++){
			mCharacters.add(temp[i]);
		}
		
		mLastY += 70;
		if(mLastY == 700){
			mLastY = 0;
		}
	}
	
	public CharacterPane[] sortByName(ArrayList<CharacterPane> arrayList){
		CharacterPane[] tempArray = new CharacterPane[arrayList.size()];
		arrayList.toArray(tempArray);
		
		boolean flag = true;

		while (flag){
			flag = false;
			for(int i=0; i< tempArray.length -1; i++){
				if(tempArray[i].getmInitiative() < tempArray[i+1].getmInitiative()){
					
					CharacterPane temp = tempArray[i];
					tempArray[i] = tempArray[i+1];
					tempArray[i+1] = temp;
					flag = true;
				}
			}
		}
		return tempArray;
	}
	
	public CharacterPane getIntersect(Point p){
		for(int i=0; i<mCharacters.size(); i++){
			if(mCharacters.get(i).contains(p)){
				return mCharacters.get(i);
			}
		}
		return null;
	}
}
