package snake.pattern.agent;

import java.util.ArrayList;

import snake.pattern.agent.strategie.SnakeStrategie;
import snake.pattern.utils.features.FeaturesSnake;
import snake.pattern.utils.features.Position;

public class FabriqueSnake implements Fabrique
{

    @Override
    public Agent créerAgent(FeaturesSnake features, SnakeStrategie strategie) 
    {

        //ArrayList test = new ArrayList<Position>(features.getPositions());
        
        return new Snake(strategie, new ArrayList<Position>(features.getPositions()));


        
    }
    
}
