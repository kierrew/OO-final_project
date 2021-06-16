package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Model.Food;
import Model.GameElement;
import Model.Snake;
import Model.SnakeBody;
import Model.Snake.Event;
import View.GameBoard;

public class TimerListener implements ActionListener {

	private GameBoard gameBoard;

	public TimerListener(GameBoard gameBoard){
		this.gameBoard = gameBoard;
	}

	//Game loop
	@Override
	public void actionPerformed(ActionEvent e) {
		for(var f: gameBoard.getCanvas().getFigures()){
			f.move();
		}
		if(!gameBoard.isGameOver())
			detectCollision();

		gameBoard.getCanvas().repaint();
	}

	private void detectCollision(){
		var figures = gameBoard.getCanvas().getFigures();
		//find snake 
		Snake snake = null;
		for(var f: figures){
			if (f instanceof Snake){
				snake = (Snake) f;
				break;
			}
		}
		if (snake == null) return;

		// left game scene?
		if(snake.x < 0 || snake.x >= gameBoard.WIDTH || snake.y < 0 || snake.y >= gameBoard.HEIGHT){
			snake.notifyObservers(Event.LeftScene);
			gameBoard.setGameOver(true);
		}

			//self collision: head collides with any part of the body
			if(snake.selfCollision()){
				snake.notifyObservers(Event.SelfCollision);
				gameBoard.setGameOver(true);
			}

		// snake vs food
		var removeFoods = new ArrayList<GameElement>();
		for(var f:figures){
			if(f instanceof Snake) continue;
			if(snake.collideWith(f)){
				if(f instanceof Food){
					removeFoods.add(f);
					snake.getComposite().add(new SnakeBody(-100, -100));
					snake.notifyObservers(Event.AteFood);
				}
			}
		}

		if(removeFoods.size() > 0) {
			figures.removeAll(removeFoods);
			gameBoard.createFood();
		}
	}
	
}
