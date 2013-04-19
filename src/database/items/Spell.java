package database.items;

import java.util.ArrayList;

public class Spell extends DatabaseObject{
	
	private String mName, mSchool, mSubschool, mLevel, mComponents, mCastTime, mRange, mEffect, mDuration, mSavingThrow, mSR, mDesc;
	
	public Spell(){
		
	}
	
	public Spell(String mName, String mSchool, String mSubschool,
			String mLevel, String mComponents, String mCastTime, String mRange,
			String mEffect, String mDuration, String mSavingThrow, String mSR,
			String mDesc) {
		this.mName = mName;
		this.mSchool = mSchool;
		this.mSubschool = mSubschool;
		this.mLevel = mLevel;
		this.mComponents = mComponents;
		this.mCastTime = mCastTime;
		this.mRange = mRange;
		this.mEffect = mEffect;
		this.mDuration = mDuration;
		this.mSavingThrow = mSavingThrow;
		this.mSR = mSR;
		this.mDesc = mDesc;
	}

	public Spell(ArrayList<String> readTags) {
		this.mName = readTags.get(0);
		this.mSchool = readTags.get(1);
		this.mSubschool = readTags.get(2);
		this.mLevel = readTags.get(3);
		this.mComponents = readTags.get(4);
		this.mCastTime = readTags.get(5);
		this.mRange = readTags.get(6);
		this.mEffect = readTags.get(7);
		this.mDuration = readTags.get(8);
		this.mSavingThrow = readTags.get(9);
		this.mSR = readTags.get(10);
		this.mDesc = readTags.get(11);
	}
	
	public ArrayList<String> getStringArray(){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(mName);
		temp.add(mSchool);
		temp.add(mSubschool);
		temp.add(mLevel);
		temp.add(mComponents);
		temp.add(mCastTime);
		temp.add(mRange);
		temp.add(mEffect);
		temp.add(mDuration);
		temp.add(mSavingThrow);
		temp.add(mSR);
		temp.add(mDesc);
		
		return temp;
	}

	public String getName() {
		return mName;
	}

	public String getSchool() {
		return mSchool;
	}

	public String getSubschool() {
		return mSubschool;
	}

	public String getLevel() {
		return mLevel;
	}

	public String getComponents() {
		return mComponents;
	}

	public String getCastTime() {
		return mCastTime;
	}

	public String getRange() {
		return mRange;
	}

	public String getEffect() {
		return mEffect;
	}

	public String getDuration() {
		return mDuration;
	}

	public String getSavingThrow() {
		return mSavingThrow;
	}

	public String getSR() {
		return mSR;
	}

	public String getDesc() {
		return mDesc;
	}
	
	

}
