package battleMap.actors;

import java.awt.Image;

public class Actor {
	private String mName;
	private int mInit, mCurrHP, mMaxHP, mAC, mTouchAC, mFlatAC;
	private Image mImage;
	
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

}
