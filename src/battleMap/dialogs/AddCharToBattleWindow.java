package battleMap.dialogs;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import battleMap.actors.Actor;


import screens.BattleScreen;

public class AddCharToBattleWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BattleScreen mScreen;
	private JTextField mName, mInit, mCurrHP, mMaxHP, mAC, mTouch, mFlat, mImage;
	private JButton saveButton, cancelButton;
	private JFileChooser mFileChooser = new JFileChooser();
	
	public AddCharToBattleWindow(BattleScreen screen){
		int posY = 0;
		mScreen = screen;
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
			
		c.gridx = 0;
		c.gridy = posY++;
		this.add(new JLabel("Name: "), c);
		c.gridx = 1;
		mName = new JTextField();
		mName.setPreferredSize(new Dimension(80, 20));
		this.add(mName, c);
		
		c.gridx = 0;
		c.gridy = posY++;
		this.add(new JLabel("Init: "), c);
		c.gridx = 1;
		mInit = new JTextField();
		mInit.setPreferredSize(new Dimension(80, 20));
		this.add(mInit, c);
		
		c.gridx = 0;
		c.gridy = posY++;
		this.add(new JLabel("Current HP:"), c);
		c.gridx = 1;
		mCurrHP = new JTextField();
		mCurrHP.setPreferredSize(new Dimension(80, 20));
		this.add(mCurrHP, c);
		
		c.gridx = 0;
		c.gridy = posY++;
		this.add(new JLabel("Max HP: "), c);
		c.gridx = 1;
		mMaxHP = new JTextField();
		mMaxHP.setPreferredSize(new Dimension(80, 20));
		this.add(mMaxHP, c);
		
		c.gridx = 0;
		c.gridy = posY++;
		this.add(new JLabel("AC: "), c);
		c.gridx = 1;
		mAC = new JTextField();
		mAC.setPreferredSize(new Dimension(80, 20));
		this.add(mAC, c);
		
		c.gridx = 0;
		c.gridy = posY++;
		this.add(new JLabel("Touch AC: "), c);
		c.gridx = 1;
		mTouch = new JTextField();
		mTouch.setPreferredSize(new Dimension(80, 20));
		this.add(mTouch, c);
		
		c.gridx = 0;
		c.gridy = posY++;
		this.add(new JLabel("Flat-Footed AC: "), c);
		c.gridx = 1;
		mFlat = new JTextField();
		mFlat.setPreferredSize(new Dimension(80, 20));
		this.add(mFlat, c);
		
		c.gridx = 0;
		c.gridy = posY++;
		c.gridwidth = 2;
		mImage = new JTextField();
		mImage.setText("F:\\Programming\\Eclipse\\workspace\\DMTool\\bin\\Bastian.png");
		mImage.setPreferredSize(new Dimension(80, 20));
		this.add(mImage, c);
		
		c.gridx = 0;
		c.gridy = posY;
		c.gridwidth = 1;
		saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				    mScreen.addParticipant(new Actor(mName.getText(), Integer.parseInt(mInit.getText()), Integer.parseInt(mCurrHP.getText()), Integer.parseInt(mMaxHP.getText()), Integer.parseInt(mAC.getText()), Integer.parseInt(mTouch.getText()), Integer.parseInt(mFlat.getText()), mImage.getText()));
				    close();
				  }});
		this.add(saveButton, c);
		
		c.gridx = 1;
		c.gridy = posY;
		cancelButton = new JButton("Cancel");
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
}
