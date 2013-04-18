package screens;

import game.DMToolGame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;

import screenItems.Button;
import screenItems.ScreenItem;

public class CampaignScreen extends Screen{
	private Image mBackground;
	private Button mBattleButton;

	public CampaignScreen(DMToolGame base){
		mBase = base;
		mBackground = managers.ImageManager.getInstance().getImage("CampaignScreen.png");
		mBattleButton = new Button("Battle", 100, 100);
		
		mItems.add(mBattleButton);
	}

	public void draw(Graphics2D g2d, DMToolGame window) {
		g2d.drawImage(mBackground, 0, 0, window);
		super.draw(g2d, window);
	}
	
	public void ButtonClicked(MouseEvent e){
		Point p = e.getPoint();
		  
		ScreenItem intersectObject = objectIntersects(p);
		if(intersectObject != null){
			if(intersectObject.equals(mBattleButton)){
				mBase.setCurrentScreen(new BattleScreen(mBase));
			}
		}	
	}
}
