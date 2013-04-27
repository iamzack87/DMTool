package battleMap.screenItems.actors;

import game.DMToolGame;

import java.awt.Graphics2D;
import java.awt.Image;

import screenItems.ScreenItem;

public class Actor extends ScreenItem{
	private String mName;
	private int mInit, mCurrHP, mMaxHP, mAC, mTouchAC, mFlatAC;
	private boolean _onMap;
	
	public Actor(){
		mName = "";
		mInit = 0;
	}
	
	public Actor(String name, int init, int currHP, int maxHP, int AC, int touch, int flat, String imagePath){
		mName = name;
		mInit = init;
		mCurrHP = currHP;
		mMaxHP = maxHP;
		mAC = AC;
		mTouchAC = touch;
		mFlatAC = flat;
		managers.ImageManager.getInstance().loadOutsideImage(imagePath);
		mImage = managers.ImageManager.getInstance().getImage(imagePath);
		mWidth = 40;
		mHeight = 40;
		_onMap = false;
	}
	
	public void draw(Graphics2D g2d, DMToolGame window) {
		if(_onMap){
			g2d.drawImage(mImage, mX, mY, 40, 40, window);
		}
	}
	
	public void shift(int moveX, int moveY){
	}

	public String getName() {
		return mName;
	}

	public void setName(String mName) {
		this.mName = mName;
	}

	public int getInit() {
		return mInit;
	}

	public void setInit(int mInit) {
		this.mInit = mInit;
	}

	public int getCurrHP() {
		return mCurrHP;
	}

	public void setCurrHP(int mCurrHP) {
		this.mCurrHP = mCurrHP;
	}

	public int getMaxHP() {
		return mMaxHP;
	}

	public void setMaxHP(int mMaxHP) {
		this.mMaxHP = mMaxHP;
	}

	public int getAC() {
		return mAC;
	}

	public void setAC(int mAC) {
		this.mAC = mAC;
	}

	public int getTouchAC() {
		return mTouchAC;
	}

	public void setTouchAC(int mTouchAC) {
		this.mTouchAC = mTouchAC;
	}

	public int getFlatAC() {
		return mFlatAC;
	}

	public void setFlatAC(int mFlatAC) {
		this.mFlatAC = mFlatAC;
	}

	public Image getImage() {
		return mImage;
	}

	public void setImage(Image mImage) {
		this.mImage = mImage;
	}

	public int getmX() {
		return mX;
	}

	public void setmX(int mX) {
		this.mX = mX;
	}

	public int getmY() {
		return mY;
	}

	public void setmY(int mY) {
		this.mY = mY;
	}
	
	public int getWidth(){
		return mWidth;
	}
	
	public int getHeight(){
		return mHeight;
	}
	
	public boolean getOnMap() {
		return _onMap;
	}

	public void setOnMap(boolean x) {
		this._onMap = x;
	}
}
