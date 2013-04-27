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
	private JTextField mName, mLevel, mComponents, mCastTime, mEffect, mDuration, mSave, mArcaneComponents, mDivineComponents, mXPCost;
	private JButton saveButton, cancelButton;
	private JTextPane mDescription;
	private JComboBox<?> mSchool, mSubschool, mDescriptor, mRange, mSR;
	private String[] mSchoolString = { "Abjuration", "Conjuration", "Divination", "Enchantment", "Evocation", "Illusion", "Necromancy", "Transmutation", "General"};
	private String[] mSubschoolString = { "", "Calling", "Charm", "Compulsion", "Creation", "Figment", "Glamer", "Healing", "Pattern", "Phantasm", "Scrying", "Shadow", "Summoning", "Teleportation"};
	private String[] mDescriptorString = { "", "Air", "Chaotic", "Cold", "Darkness", "Death", "Earth", "Electricity", "Evil", "Fear", "Fire", "Force", "Good", "Language-Dependent", "Lawful", "Light", "Mind-Affecting", "Sonic", "Water"};
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
		mSave = new JTextField();
		mSave.setPreferredSize(new Dimension(80, 20));
		mArcaneComponents = new JTextField();
		mArcaneComponents.setPreferredSize(new Dimension(80, 20));
		mDivineComponents = new JTextField();
		mDivineComponents.setPreferredSize(new Dimension(80, 20));
		mXPCost = new JTextField();
		mXPCost.setPreferredSize(new Dimension(80, 20));
		mDescription = new JTextPane();
		mDescription.setPreferredSize(new Dimension(200, 80));
		
		this.setLayout(new GridBagLayout());
		int i=0;
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
			
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Name: "), c);
		c.gridx = 1;
		this.add(mName, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("School: "), c);
		c.gridx = 1;
		mSchool = new JComboBox(mSchoolString);
		mSchool.setSelectedIndex(0);
		this.add(mSchool, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Subschool: "), c);
		c.gridx = 1;
		mSubschool = new JComboBox(mSubschoolString);
		mSubschool.setSelectedIndex(0);
		this.add(mSubschool, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Descriptor: "), c);
		c.gridx = 1;
		mDescriptor = new JComboBox(mDescriptorString);
		mDescriptor.setSelectedIndex(0);
		this.add(mDescriptor, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Level: "), c);
		c.gridx = 1;
		this.add(mLevel, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Components: "), c);
		c.gridx = 1;
		this.add(mComponents, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Casting Time: "), c);
		c.gridx = 1;
		this.add(mCastTime, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Range: "), c);
		c.gridx = 1;
		mRange = new JComboBox(mRangeString);
		mRange.setSelectedIndex(0);
		this.add(mRange, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Effect: "), c);
		c.gridx = 1;
		this.add(mEffect, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Duration: "), c);
		c.gridx = 1;
		this.add(mDuration, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Saving Throw: "), c);
		c.gridx = 1;
		this.add(mSave, c);
		
		c.gridx = 0;
		c.gridy = i++;
		this.add(new JLabel("Spell Resistance: "), c);
		c.gridx = 1;
		mSR = new JComboBox(mYesNoString);
		mSR.setSelectedIndex(0);
		this.add(mSR, c);
		
		c.gridx = 0;
		c.weightx = 100;
		c.gridwidth = 2;
		c.gridy = i++;
		this.add(mDescription, c);
		
				
		c.gridx = 0;
		c.weightx = 50;
		c.gridwidth = 1;
		c.gridy = i;
		saveButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				  mDB.addSpellToDatabase(new Spell(mName.getText(), mSchool.getSelectedItem().toString(), mSubschool.getSelectedItem().toString(), mDescriptor.getSelectedItem().toString(), mLevel.getText(), mComponents.getText(),
						  mCastTime.getText(), mRange.getSelectedItem().toString(), mEffect.getText(), mDuration.getText(),
						  mSave.getText(), mSR.getSelectedItem().toString(), "\"" + mDescription.getText() + "\""));
				  try {
					save();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("===========================");
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
		mDB.saveFile(mXML.Spell);
	}
}
