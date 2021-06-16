package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Model.Snake;
import View.GameBoard;

public class KeyController implements KeyListener {

	private GameBoard gameboard;
	private Snake snake;

	public KeyController(GameBoard gameBoard){
		this.gameboard = gameBoard;
		this.snake = gameBoard.getSnake();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key){
			case KeyEvent.VK_LEFT:
				snake.direction = Snake.Direction.LEFT;
				break;
			case KeyEvent.VK_RIGHT:
			snake.direction = Snake.Direction.RIGHT;
			break;
			case KeyEvent.VK_UP:
			snake.direction = Snake.Direction.UP;
			break;
			case KeyEvent.VK_DOWN:
			snake.direction = Snake.Direction.DOWN;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {	}

	@Override
	public void keyReleased(KeyEvent e) {	}
	
}
