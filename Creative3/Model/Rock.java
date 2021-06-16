package Model;

public class Rock extends HandSign {
	
	public Rock(String name){
		super(name);
	}

	@Override
	public boolean beatsOpponent(String name) {
		if(name == "scissors"){
			return true;
		}else{
			return false;
		}
	}
}
