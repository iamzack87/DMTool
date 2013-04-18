package screenItems;

import game.DMToolGame;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class CharacterList extends ScreenItem{
	
	private ArrayList<CharacterPane> mCharacters;
	private int mCurrentTurn;

	public CharacterList(){
		mX = 720;
		mY = 0;
		mImage = managers.ImageManager.getInstance().getImage("CharacterList.png");
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
		g2d.drawImage(mImage, mX, mY, window);
		
		for(int i=0; i<10; i++){
			if(i < mCharacters.size()){
				mCharacters.get(i).draw(g2d, window, mX, mY+(i*70));
			}
			else{
				g2d.drawImage(managers.ImageManager.getInstance().getImage("CharacterPaneInactive.png"), mX, mY+(i*70), window);
			}
		}
	}
	
	
	public void AddCharacter(CharacterPane character){
		mCharacters.add(character);
		CharacterPane[] temp = sortByName(mCharacters); 
		
		mCharacters.clear();
		for(int i =0; i< temp.length; i++){
			mCharacters.add(temp[i]);
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
}
