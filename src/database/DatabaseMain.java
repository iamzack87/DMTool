package database;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import database.items.CreatureType;
import database.items.DatabaseObject;
import database.items.Spell;

public class DatabaseMain extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<CreatureType> mTypes;
	private ArrayList<Spell> mSpells;
	public enum mXML{Type, Spell};
	private String[] mTypeTags = new String[] { "Types", "Type", "Name", "Desc", "HD", "BAB", "Fort", "Ref", "Will", "SkillPoints"};
	private String[] mSpellTags = new String[] { "Spells", "Spell", "Name", "School", "Subschool", "Level", "Components", "CastingTime", "Range", "Effect", "Duration", "SavingThrow", "SpellResistance", "Description"};
	private String mTypeXML = "F:\\Programming\\Eclipse\\workspace\\DMTool\\src\\resources\\Types.xml";
	private String mSpellXML = "F:\\Programming\\Eclipse\\workspace\\DMTool\\src\\resources\\Spells.xml";
	
	public DatabaseMain(int width, int height){
		setSize(width, height);
		
		mTypes = new ArrayList<CreatureType>();
		mSpells = new ArrayList<Spell>();
		
		
		//Menu items
		JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
 
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
				    openAddType();
				  }});
        submenu.add(menuItem);
        
        menuItem = new JMenuItem("Spell");
        menuItem.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent evt) {
				    openAddSpell();
				  }});
        submenu.add(menuItem);
        menu.add(submenu);   
        
        setJMenuBar(menuBar);
		
		
		//Tabs
        JTabbedPane tabbedPane = new JTabbedPane();
         
        JComponent panel1 = makeTextPanel("Panel #1");
        tabbedPane.addTab("Types and Subtypes", null, panel1,
                "Does nothing");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
         
        JComponent panel2 = makeTextPanel("Panel #2");
        tabbedPane.addTab("Tab 2", null, panel2,
                "Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
         
        JComponent panel3 = makeTextPanel("Panel #3");
        tabbedPane.addTab("Tab 3", null, panel3,
                "Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
         
        JComponent panel4 = makeTextPanel(
                "Panel #4 (has a preferred size of 410 x 50).");
        panel4.setPreferredSize(new Dimension(410, 50));
        tabbedPane.addTab("Tab 4", null, panel4,
                "Does nothing at all");
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
         
        //Add the tabbed pane to this panel.
        add(tabbedPane);
         
        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        
        readDatabase();
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
	}
	
	public void readXMLFile(String file, mXML type){
		try {
			String[] tags = null;
			ArrayList<String> readTags = new ArrayList<String>();
			
			switch(type){
			case Type:
				tags = mTypeTags;
				break;
			case Spell:
				tags = mSpellTags;
				break;	
			default:
				break;
			}
			
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse (new File(file));

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
	        			readTags.add(((Node)textList.item(0)).getNodeValue().trim());
	        			
	        			System.out.println(((Node)textList.item(0)).getNodeValue().trim());
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
				default:
					break;
				}
	        }

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addTypeToDatabase(CreatureType x){
		mTypes.add(x);
	}
	
	public void addSpellToDatabase(Spell x){
		mSpells.add(x);
	}
	
	public void openAddType(){
		AddType dialog = new AddType(this);
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}
	
	public void openAddSpell(){
		AddSpell dialog = new AddSpell(this);
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}
	
	public void saveFile(mXML type) throws Exception{
		String file = null;
		String[] tags = null;
		ArrayList<? extends DatabaseObject> list = null;
		
		switch(type){
		case Type:
			file = mTypeXML;
			tags = mTypeTags;
			list = mTypes;
			break;
		case Spell:
			file = mSpellXML;
			tags = mSpellTags;
			list = mSpells;
			break;	
		default:
			break;
		}
		
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
}
