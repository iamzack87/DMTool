package database.dialogs;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.*;

import database.DatabaseMain;
import database.DatabaseMain.mXML;
import database.items.CreatureType;
import database.items.Monster;

public class CreateMonster extends JFrame implements FocusListener, ActionListener{
	/**
	 * 
	 */
	
	/*
	 * private String mName,  mSize,  mInit,  mSpeed,  mAC,  mTouch,  mFlat,  mBAB,  mGrapple,  mAttack,
	 mFullAttack,  mSpace,  mReach,  mSpecialAttacks,  mSpecialQualities,  mFort,  mRef,  mWill,  mSkills,  mFeats,
	 mEnvironment,  mOrganization,  mCR,  mAlignment,  mAdvancement,  mLA, mDesc;
	private int mHD, mHP, mSkillPoints;
	 */
	private static final long serialVersionUID = 1L;
	private DatabaseMain mDB;
	private JTextField mName,  mHD, mHP, mSize,  mInit,  mSpeed,  mAC,  mTouch,  mFlat,  mBAB,  mGrapple,  mAttack,
						mFullAttack,  mSpace,  mReach,  mSpecialAttacks,  mSpecialQualities,  mFort,  mRef, 
						mWill,  mSkills,  mFeats, mEnvironment,  mOrganization,  mCR,  mAlignment,  mAdvancement,  mLA;
	private JButton saveButton, cancelButton;
	private JComboBox mType;
	
	private ArrayList<CreatureType> mTypes;
	private ArrayList<String> mTypeNames;
	
	private JTextPane mDescription;
	
	public CreateMonster(DatabaseMain db){
		mDB = db;
		mTypes = new ArrayList<CreatureType>();
		mTypeNames = new ArrayList<String>();
		
		saveButton = new JButton("Save");
		cancelButton = new JButton("Cancel");
		
		mTypes = db.getTypes();
		for(int i=0; i<mTypes.size(); i++){
			mTypeNames.add(mTypes.get(i).getName());
		}
		
		mDescription = new JTextPane();
		mDescription.setPreferredSize(new Dimension(200, 80));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		int i=0;
			
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Name: "), c);
		c.gridx = 1;
		mName = new JTextField();
		this.add(mName, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Type: "), c);
		c.gridx = 1;
		
		mType = new JComboBox(mTypeNames.toArray());
		mType.setSelectedIndex(0);
		mType.addActionListener(this);
		this.add(mType);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("HD: "), c);
		c.gridx = 1;
		mHD = new JTextField();
		mHD.addFocusListener(this);
		this.add(mHD, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("HP: "), c);
		c.gridx = 1;
		mHP = new JTextField();
		this.add(mHP, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Size: "), c);
		c.gridx = 1;
		mSize = new JTextField();
		this.add(mSize, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Initiative: "), c);
		c.gridx = 1;
		mInit = new JTextField();
		this.add(mInit, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Speed: "), c);
		c.gridx = 1;
		mSpeed = new JTextField();
		this.add(mSpeed, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("AC: "), c);
		c.gridx = 1;
		mAC = new JTextField();
		this.add(mAC, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Touch: "), c);
		c.gridx = 1;
		mTouch = new JTextField();
		this.add(mTouch, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Flat-Footed: "), c);
		c.gridx = 1;
		mFlat = new JTextField();
		this.add(mFlat, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("BAB: "), c);
		c.gridx = 1;
		mBAB = new JTextField();
		this.add(mBAB, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Grapple: "), c);
		c.gridx = 1;
		mGrapple = new JTextField();
		this.add(mGrapple, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Attack: "), c);
		c.gridx = 1;
		mAttack = new JTextField();
		this.add(mAttack, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Full Attack: "), c);
		c.gridx = 1;
		mFullAttack = new JTextField();
		this.add(mFullAttack, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Space: "), c);
		c.gridx = 1;
		mSpace = new JTextField();
		this.add(mSpace, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Reach: "), c);
		c.gridx = 1;
		mReach = new JTextField();
		this.add(mReach, c);

		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Special Attacks: "), c);
		c.gridx = 1;
		mSpecialAttacks = new JTextField();
		this.add(mSpecialAttacks, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Special Qualities: "), c);
		c.gridx = 1;
		mSpecialQualities = new JTextField();
		this.add(mSpecialQualities, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Fort: "), c);
		c.gridx = 1;
		mFort = new JTextField();
		this.add(mFort, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Ref: "), c);
		c.gridx = 1;
		mRef = new JTextField();
		this.add(mRef, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Will: "), c);
		c.gridx = 1;
		mWill = new JTextField();
		this.add(mWill, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Skills: "), c);
		c.gridx = 1;
		mSkills = new JTextField();
		this.add(mSkills, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Feats: "), c);
		c.gridx = 1;
		mFeats = new JTextField();
		this.add(mFeats, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Environment: "), c);
		c.gridx = 1;
		mEnvironment = new JTextField();
		this.add(mEnvironment, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Organization: "), c);
		c.gridx = 1;
		mOrganization = new JTextField();
		this.add(mOrganization, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("CR: "), c);
		c.gridx = 1;
		mCR = new JTextField();
		this.add(mCR, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Alignment: "), c);
		c.gridx = 1;
		mAlignment = new JTextField();
		this.add(mAlignment, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Advancement: "), c);
		c.gridx = 1;
		mAdvancement = new JTextField();
		this.add(mAdvancement, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("LA: "), c);
		c.gridx = 1;
		mLA = new JTextField();
		this.add(mLA, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(mDescription, c);
		
		c.gridx = 0;
		c.gridy = i;
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				mDB.addMonsterToDatabase(new Monster(mName.getText(), mType.getSelectedItem().toString(), mSize.getText(), mHD.getText(),
						mHP.getText(), mInit.getText(), mSpeed.getText(), mAC.getText(), mTouch.getText(), mFlat.getText(), mBAB.getText(), mGrapple.getText(),
					mAttack.getText(), mFullAttack.getText(), mSpace.getText(), mReach.getText(), mSpecialAttacks.getText(), mSpecialQualities.getText(),
					mFort.getText(), mRef.getText(), mWill.getText(), mSkills.getText(), mFeats.getText(), mEnvironment.getText(), mOrganization.getText(),
					mCR.getText(), mAlignment.getText(), mAdvancement.getText(), mLA.getText(),mDescription.getText()));
				  try {
					save();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  }});
		this.add(saveButton, c);
		
		c.gridx = 1;
		c.gridy = i;
		cancelButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				  close();
				  }});
		this.add(cancelButton, c);
		
		pack();
	}
	
	public void close(){
		this.dispose();
	}
	
	public void save() throws Exception{
		mDB.saveFile(mXML.Monster);
	}
	
		
	public void focusLost(FocusEvent arg0) {
		calculate();
	}
	
	public void focusGained(FocusEvent e) {}


	public void actionPerformed(ActionEvent arg0) {
		calculate();
		
	}
	
	public void calculate(){
		if(!mHD.getText().equals("")){
			
			//Base Attack Bonus Calculation
			if(mTypes.get(mType.getSelectedIndex()).getBAB().equals("Poor")){
				mBAB.setText(String.valueOf(Integer.parseInt(mHD.getText())/2));
			}
			else if(mTypes.get(mType.getSelectedIndex()).getBAB().equals("Average")){
				mBAB.setText(String.valueOf(Integer.parseInt(mHD.getText())*0.75));
			}
			else if(mTypes.get(mType.getSelectedIndex()).getBAB().equals("Good")){
				mBAB.setText(String.valueOf(Integer.parseInt(mHD.getText())));
			}
			
			//Fort Save Calculation
			if(mTypes.get(mType.getSelectedIndex()).getFort().equals("Poor")){
				mFort.setText(String.valueOf(Integer.parseInt(mHD.getText())/3));
			}
			else if(mTypes.get(mType.getSelectedIndex()).getFort().equals("Good")){
				mFort.setText(String.valueOf((Integer.parseInt(mHD.getText())/2)+2));
			}
			
			//Ref Save Calculation
			if(mTypes.get(mType.getSelectedIndex()).getRef().equals("Poor")){
				mRef.setText(String.valueOf(Integer.parseInt(mHD.getText())/3));
			}
			else if(mTypes.get(mType.getSelectedIndex()).getRef().equals("Good")){
				mRef.setText(String.valueOf((Integer.parseInt(mHD.getText())/2)+2));
			}
			
			//Will Save Calculation
			if(mTypes.get(mType.getSelectedIndex()).getWill().equals("Poor")){
				mWill.setText(String.valueOf(Integer.parseInt(mHD.getText())/3));
			}
			else if(mTypes.get(mType.getSelectedIndex()).getWill().equals("Good")){
				mWill.setText(String.valueOf((Integer.parseInt(mHD.getText())/2)+2));
			}
			
		}
	}
}
