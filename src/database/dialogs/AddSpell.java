package database.dialogs;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import database.DatabaseMain;
import database.DatabaseMain.mXML;
import database.items.Spell;

public class AddSpell extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DatabaseMain mDB;
	private JTextField mName, mLevel, mComponents, mCastTime, mEffect, mDuration, mArcaneComponents, mDivineComponents, mXPCost;
	private JButton saveButton, cancelButton;
	private JTextPane mDescription;
	private JComboBox mSchool, mSubschool, mRange, mSave, mSR;
	private String[] mSchoolString = { "Abjuration", "Conjuration", "Divination", "Enchantment", "Evocation", "Illusion", "Necromancy", "Transmutation", "General"};
	private String[] mSubschoolString = { "-", "Scrying"};
	private String[] mYesNoString = {"Yes", "No"};
	private String[] mRangeString = {"Personal", "Touch", "Close", "Medium", "Long", "Unlimited"};
	
	public AddSpell(DatabaseMain db){
		mDB = db;
		saveButton = new JButton("Save");
		cancelButton = new JButton("Cancel");
		mName = new JTextField();
		mName.setPreferredSize(new Dimension(80, 20));
		mLevel = new JTextField();
		mLevel.setPreferredSize(new Dimension(80, 20));
		mComponents = new JTextField();
		mComponents.setPreferredSize(new Dimension(80, 20));
		mCastTime = new JTextField();
		mCastTime.setPreferredSize(new Dimension(80, 20));
		mEffect = new JTextField();
		mEffect.setPreferredSize(new Dimension(80, 20));
		mDuration = new JTextField();
		mDuration.setPreferredSize(new Dimension(80, 20));
		mArcaneComponents = new JTextField();
		mArcaneComponents.setPreferredSize(new Dimension(80, 20));
		mDivineComponents = new JTextField();
		mDivineComponents.setPreferredSize(new Dimension(80, 20));
		mXPCost = new JTextField();
		mXPCost.setPreferredSize(new Dimension(80, 20));
		mDescription = new JTextPane();
		mDescription.setPreferredSize(new Dimension(200, 80));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
			
		c.gridx = 0;
		c.gridy = 0;
		this.add(new JLabel("Name: "), c);
		c.gridx = 1;
		this.add(mName, c);
		
		c.gridx = 0;
		c.gridy = 1;
		this.add(new JLabel("School: "), c);
		c.gridx = 1;
		mSchool = new JComboBox(mSchoolString);
		mSchool.setSelectedIndex(0);
		this.add(mSchool, c);
		
		c.gridx = 0;
		c.gridy = 2;
		this.add(new JLabel("Subschool: "), c);
		c.gridx = 1;
		mSubschool = new JComboBox(mSubschoolString);
		mSubschool.setSelectedIndex(0);
		this.add(mSubschool, c);
		
		c.gridx = 0;
		c.gridy = 3;
		this.add(new JLabel("Level: "), c);
		c.gridx = 1;
		this.add(mLevel, c);
		
		c.gridx = 0;
		c.gridy = 4;
		this.add(new JLabel("Components: "), c);
		c.gridx = 1;
		this.add(mComponents, c);
		
		c.gridx = 0;
		c.gridy = 5;
		this.add(new JLabel("Casting Time: "), c);
		c.gridx = 1;
		this.add(mCastTime, c);
		
		c.gridx = 0;
		c.gridy = 6;
		this.add(new JLabel("Range: "), c);
		c.gridx = 1;
		mRange = new JComboBox(mRangeString);
		mRange.setSelectedIndex(0);
		this.add(mRange, c);
		
		c.gridx = 0;
		c.gridy = 7;
		this.add(new JLabel("Effect: "), c);
		c.gridx = 1;
		this.add(mEffect, c);
		
		c.gridx = 0;
		c.gridy = 8;
		this.add(new JLabel("Duration: "), c);
		c.gridx = 1;
		this.add(mDuration, c);
		
		c.gridx = 0;
		c.gridy = 9;
		this.add(new JLabel("Saving Throw: "), c);
		c.gridx = 1;
		mSave = new JComboBox(mYesNoString);
		mSave.setSelectedIndex(0);
		this.add(mSave, c);
		
		c.gridx = 0;
		c.gridy = 10;
		this.add(new JLabel("Spell Resistance: "), c);
		c.gridx = 1;
		mSR = new JComboBox(mYesNoString);
		mSR.setSelectedIndex(0);
		this.add(mSR, c);
		
		c.gridx = 0;
		c.gridy = 11;
		this.add(mDescription, c);
		
				
		c.gridx = 0;
		c.gridy = 12;
		saveButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				  mDB.addSpellToDatabase(new Spell(mName.getText(), mSchool.getSelectedItem().toString(), mSubschool.getSelectedItem().toString(), mLevel.getText(), mComponents.getText(),
						  mCastTime.getText(), mRange.getSelectedItem().toString(), mEffect.getText(), mDuration.getText(),
						  mSR.getSelectedItem().toString(), mSR.getSelectedItem().toString(), "\"" + mDescription.getText() + "\""));
				  try {
					save();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  }});
		this.add(saveButton, c);
		
		c.gridx = 1;
		c.gridy = 12;
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
		mDB.saveFile(mXML.Spell);
	}
}
