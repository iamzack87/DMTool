package database.dialogs;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import database.DatabaseMain;
import database.DatabaseMain.mXML;
import database.items.CreatureType;

public class AddType extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DatabaseMain mDB;
	private JTextField mName, mDesc, mSkillPoints;
	private JButton saveButton, cancelButton;
	private JComboBox mHD, mBAB, mFort, mRef, mWill;
	private String[] babStrings = { "Poor", "Average", "Good"};
	private String[] saveStrings = { "Poor", "Average", "Good"};
	private String[] HDStrings = { "4", "6", "8", "10", "12"};
	
	public AddType(DatabaseMain db){
		mDB = db;
		saveButton = new JButton("Save");
		cancelButton = new JButton("Cancel");
		mName = new JTextField();
		mName.setPreferredSize(new Dimension(80, 20));
		mDesc = new JTextField();
		mDesc.setPreferredSize(new Dimension(80, 20));
		mSkillPoints = new JTextField();
		mSkillPoints.setPreferredSize(new Dimension(80, 20));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
			
		c.gridx = 0;
		c.gridy = 0;
		this.add(new JLabel("Name: "), c);
		c.gridx = 1;
		this.add(mName, c);
		
		c.gridx = 0;
		c.gridy = 1;
		this.add(new JLabel("Desc: "), c);
		c.gridx = 1;
		this.add(mDesc, c);
		
		c.gridx = 0;
		c.gridy = 2;
		this.add(new JLabel("HD: "), c);
		c.gridx = 1;
		mHD = new JComboBox(HDStrings);
		mHD.setSelectedIndex(0);
		this.add(mHD, c);
		
		c.gridx = 0;
		c.gridy = 3;
		this.add(new JLabel("BAB: "), c);
		c.gridx = 1;
		mBAB = new JComboBox(babStrings);
		mBAB.setSelectedIndex(0);
		this.add(mBAB, c);
		
		c.gridx = 0;
		c.gridy = 4;
		this.add(new JLabel("Fort: "), c);
		c.gridx = 1;
		mFort = new JComboBox(saveStrings);
		mFort.setSelectedIndex(0);
		this.add(mFort, c);
		
		c.gridx = 0;
		c.gridy = 5;
		this.add(new JLabel("Ref: "), c);
		c.gridx = 1;
		mRef = new JComboBox(saveStrings);
		mRef.setSelectedIndex(0);
		this.add(mRef, c);
		
		c.gridx = 0;
		c.gridy = 6;
		this.add(new JLabel("Will: "), c);
		c.gridx = 1;
		mWill = new JComboBox(saveStrings);
		mWill.setSelectedIndex(0);
		this.add(mWill, c);
		
		c.gridx = 0;
		c.gridy = 7;
		this.add(new JLabel("Skill Points: "), c);
		c.gridx = 1;
		this.add(mSkillPoints, c);
		
		c.gridx = 0;
		c.gridy = 8;
		saveButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				  mDB.addTypeToDatabase(new CreatureType(mName.getText(), mDesc.getText(), Integer.parseInt(mHD.getSelectedItem().toString()), mBAB.getSelectedItem().toString(), mFort.getSelectedItem().toString(), mRef.getSelectedItem().toString(), mWill.getSelectedItem().toString(), Integer.parseInt(mSkillPoints.getText())));
				  try {
					save();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  }});
		this.add(saveButton, c);
		
		c.gridx = 1;
		c.gridy = 8;
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
		mDB.saveFile(mXML.Type);
	}
}
