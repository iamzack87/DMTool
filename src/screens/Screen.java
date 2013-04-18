package screens;

import game.DMToolGame;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import screenItems.ScreenItem;

public abstract class Screen{
	protected ArrayList<ScreenItem> mItems;
	protected DMToolGame mBase;
	
	public Screen(){
		mItems = new ArrayList<ScreenItem>();
	}
	
	public void draw(Graphics2D g2d, DMToolGame window) {
		for(int i=0; i<mItems.size(); i++){
			mItems.get(i).draw(g2d,  window);
		}
	}
	
	public ScreenItem objectIntersects(Point p){
		for(int i=0; i<mItems.size(); i++){
			if(mItems.get(i).contains(p)){
				return mItems.get(i);
			}
		}
		return null;
	}
	
	public void ButtonClicked(MouseEvent e){
	}
}