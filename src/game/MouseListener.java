package game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import screens.Screen;

public class MouseListener extends MouseAdapter{
	private DMToolGame mTool;
	private Screen mCurrentScreen;
	
	public MouseListener(DMToolGame tool){
		mTool = tool;
		mCurrentScreen = mTool.getCurrentScreen();
	}
		
	public void mousePressed(MouseEvent e){
		mCurrentScreen = mTool.getCurrentScreen();
		mCurrentScreen.ButtonClicked(e);
	}
}
