package Model;

import java.util.ArrayList;

public class QuestionBank {

	public static final ArrayList<Question> database =  new ArrayList<>();

	static {
		database.add(new Question(
			"Who is the inventor of Java language?", 
			"James Gosling"
		));
		database.add(new Question(
			"In what city is UCO located?",
			"Edmond"
		));
		var c1 = new ChoiceQuestion(
			"What is the capitol city of Oklahoma?",
			 "2"
		);
		c1.addChoices("Norman");
		c1.addChoices("Oklahoma City");
		c1.addChoices("Edmond");
		c1.addChoices("Tulsa");
		database.add(c1);
		var c2 = new ChoiceQuestion(
			"WHich of the following is not a Java keyword?",
			 "4"
		);
		c2.addChoices("int");
		c2.addChoices("for");
		c2.addChoices("instanceof");
		c2.addChoices("String");
		database.add(c2);
	}
	
}
