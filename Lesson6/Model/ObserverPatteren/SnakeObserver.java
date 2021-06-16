package Model.ObserverPatteren;

import Model.Snake;
import Model.StrategyPattern.SnakeMoveDeadStrategy;
import Model.StrategyPattern.SnakeRenderDeadStrategy;
import View.GameBoard;
import View.Text;

public class SnakeObserver implements Observer{

	private GameBoard gameBoard;

	public SnakeObserver(GameBoard gameBoard){
		this.gameBoard = gameBoard;
	}

	@Override
	public void snakeAtefood() {
		int score = gameBoard.getScore();
		score++;
		gameBoard.setScore(score);
		gameBoard.getScoreDisplay().setText("" + score);
	}

	@Override
	public void snakeAtePoision() {
	}

	@Override
	public void snakeLeftScene() {
		gameBoard.getCanvas().getFigures().add(new Text("Game Over - Out of Bound", 100 ,200));
		Snake snake = gameBoard.getSnake();
		snake.setMoveStrategy(new SnakeMoveDeadStrategy(snake));
		snake.setRenderStrategy(new SnakeRenderDeadStrategy(snake));
	}

	@Override
	public void snakeSelfCollision() {
		gameBoard.getCanvas().getFigures().add(new Text("Game Over - Self COllision", 100 ,200));
		Snake snake = gameBoard.getSnake();
		snake.setMoveStrategy(new SnakeMoveDeadStrategy(snake));
		snake.setRenderStrategy(new SnakeRenderDeadStrategy(snake));
	}
	
}
