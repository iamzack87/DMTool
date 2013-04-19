package database.display;

import javax.swing.JLabel;

import java.awt.*;

import javax.swing.*;

import database.DatabaseMain;
import database.DatabaseMain.mXML;
import database.items.CreatureType;

public class TypeWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DatabaseMain mDB;
	private CreatureType mCreature;
	
	public TypeWindow(DatabaseMain db, CreatureType x){
		mDB = db;
		mCreature = x;
		
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
		this.add(new JLabel(mCreature.getmName()), c);
		
		c.gridx = 0;
		c.gridy = 1;
		this.add(new JLabel("Desc: "), c);
		c.gridx = 1;
		this.add(new JLabel(mCreature.getmDesc()), c);
		
		c.gridx = 0;
		c.gridy = 2;
		this.add(new JLabel("HD: "), c);
		c.gridx = 1;
		this.add(new JLabel("D" + mCreature.getmHD()), c);
		
		c.gridx = 0;
		c.gridy = 3;
		this.add(new JLabel("BAB: "), c);
		c.gridx = 1;
		this.add(new JLabel(mCreature.getmBAB()), c);
		
		c.gridx = 0;
		c.gridy = 4;
		this.add(new JLabel("Fort: "), c);
		c.gridx = 1;
		this.add(new JLabel(mCreature.getmFort()), c);
		
		c.gridx = 0;
		c.gridy = 5;
		this.add(new JLabel("Ref: "), c);
		c.gridx = 1;
		this.add(new JLabel(mCreature.getmRef()), c);
		
		c.gridx = 0;
		c.gridy = 6;
		this.add(new JLabel("Will: "), c);
		c.gridx = 1;
		this.add(new JLabel(mCreature.getmWill()), c);
		
		c.gridx = 0;
		c.gridy = 7;
		this.add(new JLabel("Skill Points: "), c);
		c.gridx = 1;
		this.add(new JLabel(String.valueOf(mCreature.getmSkillPoints())), c);
		
		pack();
	}
	
	public void close(){
		this.dispose();
	}
	
	public void save() throws Exception{
		mDB.saveFile(mXML.Spell);
	}
}
