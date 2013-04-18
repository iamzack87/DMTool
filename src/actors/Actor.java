package actors;

public class Actor {
	private String mName;
	private int mInit;
	
	public Actor(){
		mName = "";
		mInit = 0;
	}
	
	public Actor(String name, int init){
		mName = name;
		mInit = init;
	}
	
	public void shift(int moveX, int moveY){
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public int getmInit() {
		return mInit;
	}

	public void setmInit(int mInit) {
		this.mInit = mInit;
	}
}
