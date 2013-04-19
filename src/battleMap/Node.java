package battleMap;

import java.awt.Image;
import java.util.ArrayList;

import battleMap.actors.Actor;
import battleMap.battleObjects.GameObject;
import managers.ImageManager;

public class Node {
	private static ImageManager mImageManager = ImageManager.getInstance();
	private int x, y, c_X, c_Y, indexX, indexY, offsetX, offsetY;
	private double f, g, h;
	private Node top, right, left, down, tl, tr, dl, dr;
	private Node parent;
	private ArrayList<Node> neighbours;
	private Actor actor;
	private Image mTerrainImage;
	private GameObject mObject;
	
	private final int SIZE = 20;
	
	public Node(int x, int y, Image image){
		neighbours = new ArrayList<Node>();
		mTerrainImage = image;
		this.x = x;
		this.y = y;
		actor = null;
		f = 0;
		g = 0;
		h = 0;
		offsetX = 0;
		offsetY = 0;
		
		c_X = x + SIZE/2;
		c_Y = y + SIZE/2;
		indexX = x / SIZE;
		indexY = y / SIZE;
	}
	
	public Actor getActor(){
		return actor;
	}
	
	public void setActor(Actor x){
		actor = x;
	}
	public int getX(){
		return (x + offsetX);
	}
	
	public int getY(){
		return (y + offsetY);
	}
	
	public int getCentreX(){
		return (c_X + offsetX);
	}
	
	public int getCentreY(){
		return (c_Y + offsetY);
	}
	
	public Image getImage(){
		return mTerrainImage;
	}
	
	public void addNeighbour(Node newNode){
		neighbours.add(newNode);
	}
	
	public ArrayList<Node> getNeighbours(){
		return neighbours;
	}
	
	public Node getTop() {
		return top;
	}

	public void setTop(Node top) {
		this.top = top;
		neighbours.add(top);
		top.setDown(this);
		if(top.getLeft() != null){
			setTl(top.getLeft());
			top.getLeft().setDr(this);
		}
		if(top.getRight() != null){
			setTr(top.getRight());
			top.getRight().setDl(this);
		}
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
		neighbours.add(right);
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
		neighbours.add(left);
		left.setRight(this);
	}

	public Node getDown() {
		return down;
	}

	public void setDown(Node down) {
		this.down = down;
		neighbours.add(down);
	}

	public Node getTl() {
		return tl;
	}

	public void setTl(Node tl) {
		this.tl = tl;
		neighbours.add(tl);
	}

	public Node getTr() {
		return tr;
	}

	public void setTr(Node tr) {
		this.tr = tr;
		neighbours.add(tr);
	}

	public Node getDl() {
		return dl;
	}

	public void setDl(Node dl) {
		this.dl = dl;
		neighbours.add(dl);
	}

	public Node getDr() {
		return dr;
	}

	public void setDr(Node dr) {
		this.dr = dr;
		neighbours.add(dr);
	}
	
	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	public double getF() {
		return f;
	}

	public void setF(double f) {
		this.f = f;
	}

	public double getG() {
		return g;
	}

	public void setG(double g) {
		this.g = g;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}
	
	public float getMovement(){
		return SIZE;
	}
	
	public float getDiag(){
		return SIZE*2;
	}
	
	public int getIndexX(){
		return indexX;
	}
	
	public int getIndexY(){
		return indexY;
	}
	
	public double getDistance(Node aNode){
		return Math.abs(Math.sqrt(((this.getCentreX() - aNode.getCentreX()) * (this.getCentreX() - aNode.getCentreX())) + ((this.getCentreY() - aNode.getCentreY()) * (this.getCentreY() - aNode.getCentreY()))));
	}
	
	public void shift(int moveX, int moveY){
		offsetX = (moveX*20);
		offsetY = (moveY*20);
		
		//System.out.println("node OffsetX: " + offsetX);
		
/*		x += moveX;
		y += moveY;
		
		c_X = x + SIZE/2;
		c_Y = y + SIZE/2;*/
		
		if(actor != null)
			actor.shift(moveX, moveY);
	}
	
	public String getName(){
		return ("[" + indexX + ", " + indexY + "]");
	}
	
	public boolean contains(double a, double b){
		/*System.out.println("-----");
		System.out.println("A: " + a);
		System.out.println("B: " + b);
		System.out.println("X + Size: " + x + SIZE);
		System.out.println("Y + Size: " + y + SIZE);*/
		if(a <= x+SIZE+offsetX && a >= x+offsetX && b <= y+SIZE+offsetY && b >= y+offsetY)
			return true;
		return false;
	}
	
	public void setObject(GameObject x){
		mObject = x;
	}
	
	public GameObject getObject(){
		return mObject;
	}
}
