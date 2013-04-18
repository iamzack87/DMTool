package screens;

import game.DMToolGame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;

import database.DatabaseMain;

import screenItems.Button;
import screenItems.ScreenItem;

public class TitleScreen extends Screen{
	private Image mBackground;
	private Button mLoadCampaignButton, mDatabase;

	public TitleScreen(DMToolGame base){
		mBase = base;
		mBackground = managers.ImageManager.getInstance().getImage("TitleScreen.png");
		mLoadCampaignButton = new Button("Load Campaign", 100, 100);
		mDatabase = new Button("Database", 100, 200);
		 
		mItems.add(mLoadCampaignButton);
		mItems.add(mDatabase);
	}
	
	public void draw(Graphics2D g2d, DMToolGame window) {
		g2d.drawImage(mBackground, 0, 0, window);
		super.draw(g2d, window);
	}
	
	public void ButtonClicked(MouseEvent e){
		Point p = e.getPoint();
		  
		ScreenItem intersectObject = objectIntersects(p);
		if(intersectObject != null){
			if(intersectObject.equals(mLoadCampaignButton)){
				mBase.setCurrentScreen(new CampaignScreen(mBase));
			}
			else if(intersectObject.equals(mDatabase)){
				DatabaseMain db = new DatabaseMain(1000, 300);
				db.setVisible(true);
			}
		}
	}
}
