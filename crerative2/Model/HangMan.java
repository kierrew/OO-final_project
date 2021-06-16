package Model;

import java.util.Random;

public class HangMan {

	String[] wordBank = new String[] {"exemption", "mystery", "steam", "grandfather", "original", "introduce", "lecture",
	 "willpower", "aquarium", "offspring", "goalkeeper", "suitcase"};
	String keyWord;
	Random rand = new Random();
	int wrongGuesses = 0;

	public HangMan(){
		int x = rand.nextInt(12);
		keyWord = wordBank[x];
	}

	public int getKeywordLength(){
		return keyWord.length();
	}

	public String getKeyword(){
		return keyWord;
	}
	
	public int getWrongGuesses(){
		return wrongGuesses;
	}
	
	public void addToWrongGuesses(){
		wrongGuesses++;
	}
}
