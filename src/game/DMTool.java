package game;

import javax.swing.JFrame;

public class DMTool extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private final int SCREEN_WIDTH = 866;
	private final int SCREEN_HEIGHT = 748;

	public DMTool(){
		add(new DMToolGame(SCREEN_WIDTH, SCREEN_HEIGHT));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setLocationRelativeTo(null);
		setTitle("DMTool!");
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args){
		new DMTool();
	}
}
