package Model;

public abstract class HandSign {

	private String name;
	
	public HandSign(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public abstract boolean beatsOpponent(String name);
	
}
