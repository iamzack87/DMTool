package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import screens.*;

public class DMToolGame extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3711700171154644204L;	
	private Screen mCurrentScreen;
	private MouseListener mListener;
	private KeyListener mKeyListener;
	private double mCurrentFrame, mLastFrame;
	private Timer mTimer;
	private String mDisplay;

	public DMToolGame(int width, int height){
		//Screen setup
		setFocusable(true);
		setDoubleBuffered(true);
		
		init();
	}
	
	public void init(){
		mCurrentScreen = new TitleScreen(this);
		mListener = new MouseListener(this);
		mKeyListener = new mKeyListener();
		
		mLastFrame = 0;
		mCurrentFrame = 0;
		
		mDisplay = "";
		
		mTimer = new Timer(5, this);
		mTimer.start();
		
		addMouseListener(mListener);
		addKeyListener(mKeyListener);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		mCurrentScreen.draw(g2d, this);
		g2d.drawString(mDisplay, 300, 300);
		
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	
	public void actionPerformed(ActionEvent e){
		mCurrentFrame = System.currentTimeMillis();
		if(mCurrentFrame - mLastFrame >= 33){
			mLastFrame = mCurrentFrame;
			repaint();
		}
	}
	
	public void update(){
	}
	
	public Screen getCurrentScreen(){
		return mCurrentScreen;
	}

	public void setCurrentScreen(Screen screen) {
		mCurrentScreen = screen;
	}
	
	private class mKeyListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			mDisplay = mDisplay.concat((String.valueOf(keyCode)));
			System.out.println("nlip");
			
			/*int keyCode = e.getKeyCode();
			switch(keyCode) { 
			case KeyEvent.VK_UP:
				if(mCurrentScreen.getClass().equals(BattleScreen.class)){
					(BattleScreen)mCurrentScreen
					if(offsetY-1 >= 0){
						offsetY--;
						shiftNodes();
					}
					break;
				case KeyEvent.VK_DOWN:
					if(offsetY+1 <= MAP_HEIGHT-32){
						offsetY++;
						shiftNodes();
					}
					break;
				case KeyEvent.VK_LEFT:
					if(offsetX-1 >= 0){
						offsetX--;
						shiftNodes();
					}
					break;
				case KeyEvent.VK_RIGHT :
					if(offsetX+1 <= MAP_WIDTH-33){
						offsetX++;
						shiftNodes();
					}
					break;
				}
			}*/
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

}
