package snake.pattern.agent;

import java.util.ArrayList;

import snake.pattern.agent.strategie.SnakeStrategie;
import snake.pattern.utils.enumTypes.AgentAction;
import snake.pattern.utils.enumTypes.ColorSnake;
import snake.pattern.utils.features.FeaturesSnake;
import snake.pattern.utils.features.Position;

public class Snake extends Agent
{
    SnakeStrategie strategie;

    FeaturesSnake featuresSnake;
	
	public Snake(ArrayList<Position> positions, AgentAction lastAction, ColorSnake colorSnake, boolean isInvincible, boolean isSick, SnakeStrategie strategie) {
		super(strategie);
		
        featuresSnake = new FeaturesSnake(positions, lastAction, colorSnake, isInvincible, isSick);
		
	}

	public SnakeStrategie getStrategie() {
		return strategie;
	}

	public void setStrategie(SnakeStrategie strategie) {
		this.strategie = strategie;
	}

	public FeaturesSnake getFeaturesSnake() {
		return featuresSnake;
	}

	public void setFeaturesSnake(FeaturesSnake featuresSnake) {
		this.featuresSnake = featuresSnake;
	}

	@Override
	public AgentAction getLastAction() 
	{
		return featuresSnake.getLastAction();
	}
		
    
	
	
}
