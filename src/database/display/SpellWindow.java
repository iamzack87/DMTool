package database.display;

import javax.swing.JLabel;

import java.awt.*;

import javax.swing.*;

import database.DatabaseMain;
import database.DatabaseMain.mXML;
import database.items.Spell;

public class SpellWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DatabaseMain mDB;
	private JTextPane mDescription;
	private Spell mSpell;
	
	public SpellWindow(DatabaseMain db, Spell x){
		mDB = db;
		mSpell = x;
		mDescription = new JTextPane();
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.ipadx = 2;
		c.ipady = 2;
		c.gridx = 1;
		c.gridy = 1;
			
		c.gridx = 0;
		c.gridy = 0;
		this.add(new JLabel("Name: "), c);
		c.gridx = 1;
		this.add(new JLabel(mSpell.getName()), c);
		
		c.gridx = 0;
		c.gridy = 1;
		this.add(new JLabel("School: "), c);
		c.gridx = 1;
		this.add(new JLabel(mSpell.getSchool()), c);
		
		c.gridx = 0;
		c.gridy = 2;
		this.add(new JLabel("Subschool: "), c);
		c.gridx = 1;
		this.add(new JLabel(mSpell.getSubschool()), c);
		
		c.gridx = 0;
		c.gridy = 3;
		this.add(new JLabel("Level: "), c);
		c.gridx = 1;
		this.add(new JLabel(mSpell.getLevel()), c);
		
		c.gridx = 0;
		c.gridy = 4;
		this.add(new JLabel("Components: "), c);
		c.gridx = 1;
		this.add(new JLabel(mSpell.getComponents()), c);
		
		c.gridx = 0;
		c.gridy = 5;
		this.add(new JLabel("Casting Time: "), c);
		c.gridx = 1;
		this.add(new JLabel(mSpell.getCastTime()), c);
		
		c.gridx = 0;
		c.gridy = 6;
		this.add(new JLabel("Range: "), c);
		c.gridx = 1;
		this.add(new JLabel(mSpell.getRange()), c);
		
		c.gridx = 0;
		c.gridy = 7;
		this.add(new JLabel("Effect: "), c);
		c.gridx = 1;
		this.add(new JLabel(mSpell.getEffect()), c);
		
		c.gridx = 0;
		c.gridy = 8;
		this.add(new JLabel("Duration: "), c);
		c.gridx = 1;
		this.add(new JLabel(mSpell.getDuration()), c);
		
		c.gridx = 0;
		c.gridy = 9;
		this.add(new JLabel("Saving Throw: "), c);
		c.gridx = 1;
		this.add(new JLabel(mSpell.getSavingThrow() ), c);
		
		c.gridx = 0;
		c.gridy = 10;
		this.add(new JLabel("Spell Resistance: "), c);
		c.gridx = 1;
		this.add(new JLabel(mSpell.getSR()), c);
		
		c.gridx = 0;
		c.gridy = 11;
		c.weightx = 2;
		c.weighty = 2;
		mDescription.setText(mSpell.getDesc());
		mDescription.setEditable(false);
		this.add(mDescription, c);
		
		pack();
	}
	
	public void close(){
		this.dispose();
	}
	
	public void save() throws Exception{
		mDB.saveFile(mXML.Spell);
	}
}
