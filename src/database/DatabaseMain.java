package database;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.NoSuchFileException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.util.ArrayList;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import database.dialogs.AddSpell;
import database.dialogs.AddType;
import database.dialogs.CreateMonster;
import database.display.SpellWindow;
import database.display.TypeWindow;
import database.items.CreatureType;
import database.items.DatabaseObject;
import database.items.Monster;
import database.items.Spell;

public class DatabaseMain extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public enum mXML{Type, Spell, Monster};
	
	private ArrayList<ArrayList<? extends DatabaseObject>> mDBList;
	private ArrayList<CreatureType> mTypes;
	private ArrayList<Spell> mSpells;
	private ArrayList<Monster> mMonsters;
	
	private ArrayList<String[]> mTagList;
	private String[] mTypeTags = new String[] { "Types", "Type", "Name", "Desc", "HD", "BAB", "Fort", "Ref", "Will", "SkillPoints"};
	private String[] mSpellTags = new String[] { "Spells", "Spell", "Name", "School", "Subschool", "Descriptor", "Level", "Components", "CastingTime", "Range", "Effect", "Duration", "SavingThrow", "SpellResistance", "Description"};
	private String[] mMonsterTags = new String[] { "Monsters", "Monster", "Name", "Type", "Size", "HD", "HP", "Init", "Speed", "AC", "Touch", "Flat", "BAB", "Grapple", "Attack", "FullAttack", "Space", "Reach", "SpecialAttacks", "SpecialQualities", "Fort", "Ref", "Will", "Skills", "Feats", "Environment", "Organization", "CR", "Alignment", "Advancement", "LA", "Description"};
	
	private ArrayList<String> mXMLList;
	private String mTypeXML = "./xml/Types.xml";
	private String mSpellXML = "./xml/Spells.xml";
	private String mMonsterXML = "./xml/Monsters.xml";
	
	private JMenuBar menuBar;
	private JMenu menu, submenu;
	private JMenuItem menuItem;
	
	private JPanel mTypePanel, mSpellPanel, mMonsterPanel;
	private JTabbedPane mTabbedPane;

	private JList<String> mSpellList, mTypeList, mMonsterList;
	private DefaultListModel<String> mSpellModel, mTypeModel, mMonsterModel;
	
	
	public DatabaseMain(int width, int height){
		setSize(width, height);
		
		mDBList = new ArrayList<>();
		mTypes = new ArrayList<CreatureType>();
		mSpells = new ArrayList<Spell>();
		mMonsters = new ArrayList<Monster>();
		
		mDBList.add(mTypes);
		mDBList.add(mSpells);
		mDBList.add(mMonsters);
		
		mTagList = new ArrayList<String[]>();
		mTagList.add(mTypeTags);
		mTagList.add(mSpellTags);
		mTagList.add(mMonsterTags);
		
		mXMLList = new ArrayList<String>();
		mXMLList.add(mTypeXML);
		mXMLList.add(mSpellXML);
		mXMLList.add(mMonsterXML);
		
		readDatabase();
 
        //Create the menu bar.
        menuBar = new JMenuBar();
 
        //Build the first menu.
        menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_M);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        menuBar.add(menu);
 
        //a submenu
        submenu = new JMenu("Add");
        submenu.setMnemonic(KeyEvent.VK_S);
 
        menuItem = new JMenuItem("Type");
        menuItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				    openAddWindow(mXML.Type);
				  }});
        submenu.add(menuItem);
        
        menuItem = new JMenuItem("Spell");
        menuItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				    openAddWindow(mXML.Spell);
				  }});
        submenu.add(menuItem);
        menu.add(submenu);
        
        //CREATE MONSTER
        menuItem = new JMenuItem("Create Monster");
        menuItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				    createMonster();
				  }});
        menu.add(menuItem);
        
        setJMenuBar(menuBar);
        
		//Tabs
        mTabbedPane = new JTabbedPane();
         
        
        //Types
        mTypePanel = new JPanel();
        mTypeModel = new DefaultListModel<String>();
        for(int i=0; i<mTypes.size(); i++){
        	mTypeModel.addElement(mTypes.get(i).getName());
        }
        
        mTypeList = new JList<String>(mTypeModel);
        mTypeList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	openDataWindow(mXML.Type);
            }
          });
        mTypePanel.add(mTypeList);
        mTabbedPane.addTab("Types", null, mTypePanel, null);
        
        
        //Spells
        mSpellPanel = new JPanel();
        mSpellModel = new DefaultListModel<String>();
        for(int i=0; i<mSpells.size(); i++){
        	mSpellModel.addElement(mSpells.get(i).getName());
        }
        
        mSpellList = new JList<String>(mSpellModel);
        mSpellList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	openDataWindow(mXML.Spell);
            }
          });
        mSpellPanel.add(mSpellList);
        mTabbedPane.addTab("Spells", null, mSpellPanel, null);
        
       //Monsters
        mMonsterPanel = new JPanel();
        mMonsterModel = new DefaultListModel<String>();
        for(int i=0; i<mMonsters.size(); i++){
        	mMonsterModel.addElement(mMonsters.get(i).getName());
        }
        
        mMonsterList = new JList<String>(mMonsterModel);
        mMonsterList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	openDataWindow(mXML.Monster);
            }
          });
        mMonsterPanel.add(mMonsterList);
        mTabbedPane.addTab("Monsters", null, mMonsterPanel, null);
         
        //Add the tabbed pane to this panel.
        add(mTabbedPane);
         
        //The following line enables to use scrolling tabs.
        mTabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}
	
	protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
	
	public void readDatabase(){
		readXMLFile(mTypeXML, mXML.Type);
		readXMLFile(mSpellXML, mXML.Spell);
		readXMLFile(mMonsterXML, mXML.Monster);
	}
	
	public void readXMLFile(String file, mXML type){
		try {
			String[] tags = mTagList.get(type.ordinal());
			ArrayList<String> readTags = new ArrayList<String>();
			
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			
			File f = new File(file);
			Document doc = null;
			try{
				doc = docBuilder.parse (f);
			}
			catch(java.io.FileNotFoundException e ){
				Files.createFile(Paths.get(file));
				
				// Create a XMLOutputFactory
			    XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
			    // Create XMLEventWriter
			    XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(file));
			    // Create a EventFactory
			    XMLEventFactory eventFactory = XMLEventFactory.newInstance();
			    XMLEvent end = eventFactory.createDTD("\n");

			    // Create config open tag
			    StartElement configStartElement = eventFactory.createStartElement("", "", tags[0]);
			    eventWriter.add(configStartElement);
			    eventWriter.add(end);
			    
			    eventWriter.add(eventFactory.createEndElement("", "",  tags[0]));
				eventWriter.add(end);
			    eventWriter.close();
			    
				return;
			}

	        // normalize text representation
	        doc.getDocumentElement ().normalize ();

	        NodeList listOfPersons = doc.getElementsByTagName(tags[1]);

	        for(int j=0; j<listOfPersons.getLength() ; j++){
	        	for(int i=2; i<tags.length; i++){
	        		Node node = listOfPersons.item(j);
	        		if(node.getNodeType() == Node.ELEMENT_NODE){
	        			Element element = (Element)node;

	        			NodeList tagList = element.getElementsByTagName(tags[i]);
	        			Element firstNameElement = (Element)tagList.item(0);

	        			NodeList textList = firstNameElement.getChildNodes();
	        			if(textList.item(0) != null){
	        				readTags.add(((Node)textList.item(0)).getNodeValue().trim());
	        			}
	        			else{
	        				readTags.add("");
	        			}
	        		}
	        	}
	        	
	        	switch(type){
				case Type:
					CreatureType newType = new CreatureType(readTags);
					mTypes.add(newType);
					readTags.clear();
					break;
				case Spell:
					Spell newSpell = new Spell(readTags);
					mSpells.add(newSpell);
					readTags.clear();
					break;
				case Monster:
					Monster newMonster = new Monster(readTags);
					mMonsters.add(newMonster);
					readTags.clear();
					break;
				default:
					break;
				}
	        }			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addTypeToDatabase(CreatureType x){
		boolean exists = false;
		for(int i=0; i<mTypes.size(); i++){
			if(mTypes.get(i).getName().equals(x.getName())){
				exists = true;
			}
		}
		if(!exists){
			mTypes.add(x);
			mTypeModel.addElement(x.getName());
		}
		else{
			System.out.println("Already Exists");
		}
	}
	
	public void addMonsterToDatabase(Monster x){
		mMonsters.add(x);
		mMonsterModel.addElement(x.getName());
	}
	
	public void addSpellToDatabase(Spell x){
		mSpells.add(x);
		mSpellModel.addElement(x.getName());
	}
	
	public void openAddWindow(mXML type){
		JFrame window;
		switch(type){
		case Type:
			window = new AddType(this);
			break;
		case Spell:
			window = new AddSpell(this);
			break;
		default:
			window = null;
			break;
		}
		if(window != null){
			window.setResizable(false);
			window.setLocationRelativeTo(null);
			window.setVisible(true);
		}
	}
	
	public void createMonster(){
		CreateMonster window = new CreateMonster(this);
		//window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	public void openDataWindow(mXML type){
		JFrame window;
		switch(type){
		case Type:
			window = new TypeWindow(this, mTypes.get(mTypeList.getSelectedIndex()));
			break;
		case Spell:
			window = new SpellWindow(this, mSpells.get(mSpellList.getSelectedIndex()));
			break;
		default:
			window = null;
			break;
		}
		if(window != null){
			window.setResizable(false);
			window.setLocationRelativeTo(null);
			window.setVisible(true);
		}
	}

	
	public void saveFile(mXML type) throws Exception{
		String file = mXMLList.get(type.ordinal());
		String[] tags = mTagList.get(type.ordinal());
		ArrayList<? extends DatabaseObject> list = mDBList.get(type.ordinal());
		
		// Create a XMLOutputFactory
	    XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
	    // Create XMLEventWriter
	    XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(file));
	    // Create a EventFactory
	    XMLEventFactory eventFactory = XMLEventFactory.newInstance();
	    XMLEvent end = eventFactory.createDTD("\n");
	    XMLEvent tab = eventFactory.createDTD("  ");

	    // Create config open tag
	    StartElement configStartElement = eventFactory.createStartElement("", "", tags[0]);
	    eventWriter.add(configStartElement);
	    eventWriter.add(end);
	    
	    // Write the different nodes
	    for(int i=0; i< list.size(); i++){
	    	eventWriter.add(tab);
	    	eventWriter.add(eventFactory.createStartElement("", "", tags[1]));
	    	eventWriter.add(end);
	    	for(int j=2; j<tags.length; j++){
	    		createNode(eventWriter, tags[j], list.get(i).getStringArray().get(j-2));
	    	}
	    	eventWriter.add(tab);
		    eventWriter.add(eventFactory.createEndElement("", "", tags[1]));
		    eventWriter.add(end);
	    }
	
		eventWriter.add(eventFactory.createEndElement("", "",  tags[0]));
		eventWriter.add(end);
	    eventWriter.close();
	}

	  private void createNode(XMLEventWriter eventWriter, String name, String value) throws XMLStreamException {
		  XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		  XMLEvent end = eventFactory.createDTD("\n");
		  XMLEvent tab = eventFactory.createDTD("  ");
		  eventWriter.add(tab);
		  // Create Start node
		  StartElement sElement = eventFactory.createStartElement("", "", name);
		  eventWriter.add(tab);
		  eventWriter.add(sElement);
		  // Create Content
		  Characters characters = eventFactory.createCharacters(value);
		  eventWriter.add(characters);
		  // Create End node
		  EndElement eElement = eventFactory.createEndElement("", "", name);
		  eventWriter.add(eElement);
		  eventWriter.add(end);
	  }
	  
	  public ArrayList<CreatureType> getTypes(){
		  return mTypes;
	  }
}
