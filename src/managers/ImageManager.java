package managers;

import java.awt.Image;
import java.util.HashMap;

import javax.swing.ImageIcon;

public class ImageManager {
	private static ImageManager mInstance = null;
	private static HashMap<String, Image> mImageMap;
	
	private ImageManager(){
		mImageMap = new HashMap<String, Image>();
		init();
	}
	
	public static ImageManager getInstance(){
		if(mInstance == null)
			mInstance = new ImageManager();
		return mInstance;
	}
	
	public void init(){
		loadImage("TitleScreen.png");
		loadImage("CampaignScreen.png");
		loadImage("Button.png");
		loadImage("grass0.png");
		loadImage("CharacterList.png");
		loadImage("CharacterPane.png");
		loadImage("CharacterPaneInactive.png");
		loadImage("CharacterPaneActive.png");
	}
	
	public void loadImage(String key){
		ImageIcon ii = new ImageIcon(this.getClass().getResource("/resources/" + key));
		mImageMap.put(key, ii.getImage());
	}
	
	public Image getImage(String key){
		return mImageMap.get(key);
	}
}
