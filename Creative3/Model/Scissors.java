package Model;

public class Scissors extends HandSign{

	public Scissors(String name){
		super(name);
	}

	@Override
	public boolean beatsOpponent(String name) {
		if(name == "paper"){
			return true;
		}else{
			return false;
		}
	}
}
