package Model.StrategyPattern;
import java.awt.Graphics2D;

import Model.Snake;

public class SnakeRenderAliveStrategy implements SnakeRenderStrategy{

	private Snake snake;

	public SnakeRenderAliveStrategy(Snake snake){
		this.snake = snake;
	}

	@Override
	public void renderAlgorithm(Graphics2D g2) {
		var composite = snake.getComposite();
		boolean filled = true;
		for(var s: composite){
			s.filled = filled;
			filled = !filled;
			s.render(g2);

		}
	}
	
}
