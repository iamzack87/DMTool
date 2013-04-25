package screens;

import game.DMToolGame;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import battleMap.dialogs.AddCharToBattleWindow;
import battleMap.screenItems.CharacterList;
import battleMap.screenItems.CharacterPane;

import battleMap.NodeMap;
import battleMap.actors.Actor;

import screenItems.Button;
import screenItems.ScreenItem;

public class BattleScreen extends Screen{
	private final int NODE_DIM = 40;
	private final int MAP_WIDTH = 50;
	private final int MAP_HEIGHT = 50;
	private NodeMap mMap;
	private CharacterList mList;
	private Button mNextTurn, mAddCharacter;

	public BattleScreen(DMToolGame base){
		mBase = base;
		mMap = new NodeMap(MAP_WIDTH, MAP_HEIGHT, NODE_DIM);
		mList = new CharacterList();
		mNextTurn = new Button("Next Turn", 600, 600);
		mAddCharacter = new Button("Add Character", 400, 600);
		
		mItems.add(mNextTurn);
		mItems.add(mAddCharacter);
	}
	
	public void draw(Graphics2D g2d, DMToolGame window) {
		mMap.draw(g2d, window);
		mList.draw(g2d, window);
		super.draw(g2d, window);
	}
	
	public void NextTurn(){
		mList.NextTurn();
	}
	
	public void addParticipant(Actor x){
		mList.AddCharacter(x);
	}
	
	public void openCharacterDialog(Actor x){
		AddCharToBattleWindow dialog = new AddCharToBattleWindow(this);
		dialog.setResizable(true);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}
	
	public void ButtonClicked(MouseEvent e){
		Point p = e.getPoint();
		  
		ScreenItem intersectObject = objectIntersects(p);
		if(intersectObject != null){
			if(intersectObject != null){
				if(intersectObject.equals(mNextTurn)){
					NextTurn();
				}
				else if(intersectObject.equals(mAddCharacter)){
					openCharacterDialog(new Actor());
				}
			}
		}	
	}
}