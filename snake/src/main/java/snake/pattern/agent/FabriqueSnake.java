package snake.pattern.agent;

import snake.pattern.agent.strategie.SnakeStrategie;
import snake.pattern.utils.features.FeaturesSnake;

public class FabriqueSnake implements Fabrique
{

    @Override
    public Agent créerAgent(FeaturesSnake features, SnakeStrategie strategie) 
    {
        return new Snake(features.getPositions(), features.getLastAction(), features.getColorSnake(), features.isInvincible(), features.isSick(), strategie);
    }
    
}
