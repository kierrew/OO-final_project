package Model;

import java.util.ArrayList;
import java.util.Random;

public class GuessingGame {

	ArrayList<String> wordBank = new ArrayList<>();	
	String keyWord;
	Random rand = new Random();
	int wrongGuesses = 0;

	public GuessingGame(){
		wordBank.add("communication");
		wordBank.add("science");
		wordBank.add("programming");
		wordBank.add("language");
		wordBank.add("difficulty");
		wordBank.add("artificial");
		wordBank.add("intelligence");
		wordBank.add("attempts");
		wordBank.add("screenshot");
		wordBank.add("baseball");
		wordBank.add("windows");
		wordBank.add("learning");
		wordBank.add("electronics");
		wordBank.add("beautiful");
		wordBank.add("internet");
		wordBank.add("database");
		wordBank.add("organization");
		wordBank.add("application");
		wordBank.add("network");
		wordBank.add("friendly");
		wordBank.add("validation");
		wordBank.add("attempts");
		wordBank.add("statistics");
		wordBank.add("physics");
		wordBank.add("chemistry");
		wordBank.add("engineering");
		wordBank.add("school");
		wordBank.add("industry");
		wordBank.add("revolution");
		wordBank.add("progress");
		wordBank.add("characters");
		wordBank.add("heavily");
		wordBank.add("graphics");
		int x = rand.nextInt(33);
		keyWord = wordBank.get(x);
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

	public String getNewWord(){
		int x = rand.nextInt(33);
		keyWord = wordBank.get(x);
		return keyWord; 
	}
	
}
