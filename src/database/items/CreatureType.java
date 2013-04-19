package database.items;

import java.util.ArrayList;

public class CreatureType extends DatabaseObject{
	
	private String mName, mDesc, mBAB, mFort, mRef, mWill;
	private int mHD, mSkillPoints;
	private ArrayList<SpecialAbility> mSpecialAbility;
	
	public CreatureType(String mName, String mDesc, int mHD, String mBAB, String mFort,String mRef, String mWill, int mSkillPoints) {
		this.mName = mName;
		this.mDesc = mDesc;
		this.mHD = mHD;
		this.mBAB = mBAB;
		this.mFort = mFort;
		this.mRef = mRef;
		this.mWill = mWill;
		this.mSkillPoints = mSkillPoints;
		//this.mSpecialAbility = mSpecialAbility;
		
	}
	
	public CreatureType(ArrayList<String> readTags) {
		this.mName = readTags.get(0);
		this.mDesc = readTags.get(1);
		this.mHD = Integer.parseInt(readTags.get(2));
		this.mBAB = readTags.get(3);
		this.mFort = readTags.get(4);
		this.mRef = readTags.get(5);
		this.mWill = readTags.get(6);
		this.mSkillPoints = Integer.parseInt(readTags.get(7));
	}
	
	public ArrayList<String> getStringArray(){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(mName);
		temp.add(mDesc);
		temp.add(String.valueOf(mHD));
		temp.add(mBAB);
		temp.add(mFort);
		temp.add(mRef);
		temp.add(mWill);
		temp.add(String.valueOf(mSkillPoints));
		
		return temp;
	}

	public String getmName() {
		return mName;
	}

	public String getmDesc() {
		return mDesc;
	}

	public String getmBAB() {
		return mBAB;
	}

	public String getmFort() {
		return mFort;
	}

	public String getmRef() {
		return mRef;
	}

	public String getmWill() {
		return mWill;
	}

	public int getmHD() {
		return mHD;
	}

	public int getmSkillPoints() {
		return mSkillPoints;
	}

	public ArrayList<SpecialAbility> getmSpecialAbility() {
		return mSpecialAbility;
	}
}
