package dialogs;

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
	private JTextField mName, mInit;
	private JButton saveButton, cancelButton;
	
	public AddCharToBattleWindow(BattleScreen screen){
		System.out.println("mar");
		saveButton = new JButton("Save");
		cancelButton = new JButton("Cancel");
		mName = new JTextField();
		mName.setPreferredSize(new Dimension(80, 20));
		mInit = new JTextField();
		mInit.setPreferredSize(new Dimension(80, 20));
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
			
		c.gridx = 0;
		c.gridy = 0;
		this.add(new JLabel("Name: "), c);
		c.gridx = 1;
		this.add(mName, c);
		
		c.gridx = 0;
		c.gridy = 1;
		this.add(new JLabel("Init: "), c);
		c.gridx = 1;
		this.add(mInit, c);
		
		c.gridx = 0;
		c.gridy = 2;
		saveButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				    mScreen.addParticipant(new Actor(mName.getText(), Integer.parseInt(mInit.getText())));
				    close();
				  }});
		this.add(saveButton, c);
		
		c.gridx = 1;
		c.gridy = 2;
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
