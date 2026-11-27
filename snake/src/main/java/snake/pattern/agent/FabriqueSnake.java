package snake.pattern.agent;

import java.util.ArrayList;

import snake.pattern.agent.strategie.SnakeStrategie;
import snake.pattern.utils.features.FeaturesSnake;
import snake.pattern.utils.features.Position;

/**
 * Fabrique Concrète pour les Snake
 * FabriqueSnake
 */
public class FabriqueSnake implements Fabrique
{

    @Override
    public Agent créerAgent(FeaturesSnake features, SnakeStrategie strategie) 
    {        
        return new Snake(strategie, new ArrayList<Position>(features.getPositions()));
    }
    
}
