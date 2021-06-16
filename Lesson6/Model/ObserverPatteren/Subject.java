package Model.ObserverPatteren;

import Model.Snake;

public interface Subject {

	void addSnakeListener(Observer o);
	void removeSnakeListener(Observer o);
	void notifyObservers(Snake.Event event);
	
}
