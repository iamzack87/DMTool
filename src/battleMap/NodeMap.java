/*///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
* Class: NodeMap
* Description: This object is the template for all of the levels that the game has, either town or dungeon levels.
* 
* 				nodeMap - the two-dimensional array of nodes that represents the grid that the game takes place on.
* 				player - an instance of the player class which is used to access the characters.
* 				npcs and playerSummons - the arrays of npcs and summoned minions that exist on the level.
* 				current - this is the npc who's turn it currently is. Used so that not all npcs move at the same time.
* 				currentIndex - counter to cycle through the array that we are currently moving npcs from.
* 			    timeout - timeout counter used to prevent the game locking on an npc which cannot move. 
* 			    size - the size of the nodes in pixels.
* 
* Concerns: Is size required here?
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
package battleMap;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;



import battleMap.Node;
import battleMap.actors.Actor;

public class NodeMap {
	protected Node[][] mNodeMap;
	protected Random random;
	protected int size, width, height;
	protected ArrayList<Actor> npcs, playerSummons;
	protected Actor current;
	protected int currentIndex, timeout;
	ArrayList<Node> innerShell;
	
	public NodeMap(){
	}
	
	public NodeMap(int width, int height, int size){
		this.size = size;
		this.width = width;
		this.height = height;
		mNodeMap = new Node[width][height];
		random = new Random();
		npcs = new ArrayList<Actor>();
		playerSummons = new ArrayList<Actor>();
		innerShell = new ArrayList<Node>();
		currentIndex = 0;
		
		for(int i = 0; i<width; i++){
			for(int j=0; j<height; j++){
				mNodeMap[i][j] = new Node(i * size, j * size, managers.ImageManager.getInstance().getImage("grass0.png"));

				if(j != 0){
					mNodeMap[i][j].setLeft(mNodeMap[i][j-1]);
				}
				if(i != 0){
					mNodeMap[i][j].setTop(mNodeMap[i-1][j]);
				}
			}
		}
	}
	
	/*///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	* Method: findValid
	* Parameters: x1, y1, x2, y2 - two points which form the square to be searched.
	* Description: Finds and returns a single passable node that is randomly selected from the square defined by the two
	* 			   parameter points.
	* 
	* 			   The first thing that happens is we ensure that the parameters are bounded between 0 and the max
	* 			   axis value to avoid grabbing nonexistant nodes.
	*			   Then, in a do-while loop, we use random to get a random node from nodeMap. Choose another if not passable. 
	* Concerns: What if the square contains no passable nodes?
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
	public Node findValid(int x1, int y1, int x2, int y2){		
		x1 = Math.max(x1, 0);
		x1 = Math.min(x1, width-1);
		
		y1 = Math.max(y1, 0);
		y1 = Math.min(y1, height-1);
		
		x2 = Math.max(x2, 0);
		x2 = Math.min(x2, width-1);
		
		y2 = Math.max(y2, 0);
		y2 = Math.min(y2, height-1);
		
		Node temp;
		do{
			temp = mNodeMap[random.nextInt(x2-(x1-1))+x1][random.nextInt(y2-(y1-1))+y1];
		}while(temp.getObject() != null);
		
		return temp;
	}
	
	/*///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	* Method: inBounds
	* Parameters: int x, y
	* Description: Returns the node[x][y] assuming it exists, if not, returns null.
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
	public Node inBounds(int x, int y){
		if(x >= 0 && x <= width-1 && y >= 0 && y <= height-1)
			return mNodeMap[x][y];
		else 
			return null;
	}
	
	/*///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	* Method: draw
	* Parameters: Graphics2D g2d, game.Window window
	* Description: Aggregate function to initialize first the map levels, then the characters, and then start the UI.
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
	public void draw(Graphics2D g2d, game.DMToolGame window){
		for(int i = 0; i<width; i++){
			for(int j=0; j<height; j++){
				Node n = mNodeMap[i][j];
				g2d.drawImage(n.getImage(), n.getX(), n.getY(), window);	
			}
		}
	}
	
	/*///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	* Method: shift
	* Parameters: int x, y - the distance to shift the nodeMap
	* Description: Iterates over every node in the nodeMap and calls shift with x and y
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
	public void shift(int x, int y){
		for(int i= 0; i< width; i++){
			for(int j= 0; j< width; j++){
				mNodeMap[i][j].shift(x, y);
			}
		}
	}
	
	/*///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	* Method: getNode
	* Parameters: int x, y
	* Description: Returns the node indicated byt he coordinates x, y
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
	public Node getNode(int x, int y){
		return mNodeMap[x][y];
	}
	
	public Node[][] getMap(){
		return mNodeMap;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	/*///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	* Method: update
	* Parameters: None
	* Description: The update method for the nodeMap. First call deathCheck on both the npc array and playerSummons array
	* 			   to determine in any of the Actors in the array are dead and need to be removed.
	* 			   If the player has finished moving, and the npcs aren't done yet. Check the timeout counter and call 
	* 			   updateNPCs with the npcs parameter. Repeat, for the summons if npcs and players are done and summons are not.
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
	public void update(){

	}
	
	/*///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	* Method: contains
	* Parameters: Actor actor
	* Description: Returns whether or not the actor in question exists in the npcs ArrayList.
	* Concerns: Should this not also test for summoned units?
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
	public boolean contains(Actor actor) {
		return npcs.contains(actor);
	}
}
