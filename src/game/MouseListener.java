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
	
	public void mouseDragged(MouseEvent e){
		mCurrentScreen = mTool.getCurrentScreen();
		mCurrentScreen.MouseDragged(e);
	}
	
	public void mouseReleased(MouseEvent e){
		mCurrentScreen = mTool.getCurrentScreen();
		mCurrentScreen.MouseReleased(e);
	}
}
