package database.items;

import java.util.ArrayList;

public class Spell implements DatabaseObject{
	
	private String mName, mSchool, mSubschool, mDescriptor, mLevel, mComponents, mCastTime, mRange, mEffect, mDuration, mSavingThrow, mSR, mDesc;
	
	public Spell(){
		
	}
	
	public Spell(String mName, String mSchool, String mSubschool, String mDescriptor,
			String mLevel, String mComponents, String mCastTime, String mRange,
			String mEffect, String mDuration, String mSavingThrow, String mSR,
			String mDesc) {
		this.mName = mName;
		this.mSchool = mSchool;
		this.mSubschool = mSubschool;
		this.mDescriptor = mDescriptor;
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
		int i=0;
		this.mName = readTags.get(i++);
		this.mSchool = readTags.get(i++);
		this.mSubschool = readTags.get(i++);
		this.mDescriptor = readTags.get(i++);
		this.mLevel = readTags.get(i++);
		this.mComponents = readTags.get(i++);
		this.mCastTime = readTags.get(i++);
		this.mRange = readTags.get(i++);
		this.mEffect = readTags.get(i++);
		this.mDuration = readTags.get(i++);
		this.mSavingThrow = readTags.get(i++);
		this.mSR = readTags.get(i++);
		this.mDesc = readTags.get(i++);
	}
	
	public ArrayList<String> getStringArray(){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(mName);
		temp.add(mSchool);
		temp.add(mSubschool);
		temp.add(mDescriptor);
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
	
	public String getDescriptor() {
		return mDescriptor;
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
