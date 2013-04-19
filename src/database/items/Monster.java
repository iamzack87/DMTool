package database.items;

import java.util.ArrayList;

public class Monster implements DatabaseObject{
	
	private String mName,  mType, mSize,  mInit,  mSpeed,  mAC,  mTouch,  mFlat,  mBAB,  mGrapple,  mAttack,
	 mFullAttack,  mSpace,  mReach,  mSpecialAttacks,  mSpecialQualities,  mFort,  mRef,  mWill,  mSkills,  mFeats,
	 mEnvironment,  mOrganization,  mCR,  mAlignment,  mAdvancement,  mLA, mDesc;
	private int mHD, mHP, mSkillPoints;
	private ArrayList<SpecialAbility> mSpecialAbility;
	
	 
	
	public Monster(String name, String type, String size, String hd, String hp, String init, String speed, String ac, String touch, String flat, String bab, String grapple, String attack,
			String fullAttack, String space, String reach, String specialAttacks, String specialQualities, String fort, String ref, String will, String skills, String feats,
			String environment, String organization, String cr, String alignment, String advancement, String la, String desc) {
		this.mName = name;
		this.mType = type;
		this.mSize = size;
		this.mHD = Integer.parseInt(hd);
		this.mHP = Integer.parseInt(hp);
		this.mInit = init;
		this.mSpeed = speed;
		this.mAC = ac;
		this.mTouch = touch;
		this.mFlat = flat;
		this.mBAB = bab;
		this.mGrapple = grapple;
		this.mAttack = attack;
		this.mFullAttack = fullAttack;
		this.mSpace = space;
		this.mReach = reach;
		this.mSpecialAttacks = specialAttacks;
		this.mSpecialQualities = specialQualities;
		this.mFort = fort;
		this.mRef = ref;
		this.mWill = will;
		this.mSkills = skills;
		this.mFeats = feats;
		this.mEnvironment = environment;
		this.mOrganization = organization;
		this.mCR = cr;
		this.mAlignment = alignment;
		this.mAdvancement = advancement;
		this.mLA = la;
		this.mDesc = desc;
	}
	
	public Monster(ArrayList<String> readTags) {
		int i=0;
		this.mName = readTags.get(i++);
		this.mType = readTags.get(i++);
		this.mSize = readTags.get(i++);
		this.mHD = Integer.parseInt(readTags.get(i++));
		this.mHP = Integer.parseInt(readTags.get(i++));
		this.mInit = readTags.get(i++);
		this.mSpeed = readTags.get(i++);
		this.mAC = readTags.get(i++);
		this.mTouch = readTags.get(i++);
		this.mFlat = readTags.get(i++);
		this.mBAB = readTags.get(i++);
		this.mGrapple = readTags.get(i++);
		this.mAttack = readTags.get(i++);
		this.mFullAttack = readTags.get(i++);
		this.mSpace = readTags.get(i++);
		this.mReach = readTags.get(i++);
		this.mSpecialAttacks = readTags.get(i++);
		this.mSpecialQualities = readTags.get(i++);
		this.mFort = readTags.get(i++);
		this.mRef = readTags.get(i++);
		this.mWill = readTags.get(i++);
		this.mSkills = readTags.get(i++);
		this.mFeats = readTags.get(i++);
		this.mEnvironment = readTags.get(i++);
		this.mOrganization = readTags.get(i++);
		this.mCR = readTags.get(i++);
		this.mAlignment = readTags.get(i++);
		this.mAdvancement = readTags.get(i++);
		this.mLA = readTags.get(i++);
		this.mDesc = readTags.get(i++);
	}
	
	public ArrayList<String> getStringArray(){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add(mName);
		temp.add(mType);
		temp.add(mSize);
		temp.add(String.valueOf(mHD));
		temp.add(String.valueOf(mHP));
		temp.add(mInit);
		temp.add(mSpeed);
		temp.add(mAC);
		temp.add(mTouch);
		temp.add(mFlat);
		temp.add(mBAB);
		temp.add(mGrapple);
		temp.add(mAttack);
		temp.add(mFullAttack);
		temp.add(mSpace);
		temp.add(mReach);
		temp.add(mSpecialAttacks);
		temp.add(mSpecialQualities);
		temp.add(mFort);
		temp.add(mRef);
		temp.add(mWill);
		temp.add(mSkills);
		temp.add(mFeats);
		temp.add(mEnvironment);
		temp.add(mOrganization);
		temp.add(mCR);
		temp.add(mAlignment);
		temp.add(mAdvancement);
		temp.add(mLA);
		temp.add(mDesc);
		
		return temp;
	}

	public String getName() {
		return mName;
	}

	public String getSize() {
		return mSize;
	}

	public String getInit() {
		return mInit;
	}

	public String getSpeed() {
		return mSpeed;
	}

	public String getAC() {
		return mAC;
	}

	public String getTouch() {
		return mTouch;
	}

	public String getFlat() {
		return mFlat;
	}

	public String getBAB() {
		return mBAB;
	}

	public String getGrapple() {
		return mGrapple;
	}

	public String getAttack() {
		return mAttack;
	}

	public String getFullAttack() {
		return mFullAttack;
	}

	public String getSpace() {
		return mSpace;
	}

	public String getReach() {
		return mReach;
	}

	public String getSpecialAttacks() {
		return mSpecialAttacks;
	}

	public String getSpecialQualities() {
		return mSpecialQualities;
	}

	public String getFort() {
		return mFort;
	}

	public String getRef() {
		return mRef;
	}

	public String getWill() {
		return mWill;
	}

	public String getSkills() {
		return mSkills;
	}

	public String getFeats() {
		return mFeats;
	}

	public String getEnvironment() {
		return mEnvironment;
	}

	public String getOrganization() {
		return mOrganization;
	}

	public String getCR() {
		return mCR;
	}

	public String getAlignment() {
		return mAlignment;
	}

	public String getAdvancement() {
		return mAdvancement;
	}

	public String getLA() {
		return mLA;
	}

	public String getDesc() {
		return mDesc;
	}

	public int getHD() {
		return mHD;
	}

	public int getHP() {
		return mHP;
	}

	public int getSkillPoints() {
		return mSkillPoints;
	}

	public ArrayList<SpecialAbility> getmSpecialAbility() {
		return mSpecialAbility;
	}
}
