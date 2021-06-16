package Model;

public class Paper extends HandSign {

	public Paper(String name){
		super(name);
	}

	@Override
	public boolean beatsOpponent(String name) {
		if(name == "rock"){
			return true;
		}else{
			return false;
		}
	}
}
